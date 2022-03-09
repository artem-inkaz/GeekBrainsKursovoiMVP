package ui.smartpro.geekbrainskursovoimvp.presentation.abs

import android.os.Bundle
import android.widget.Toast
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import ui.smartpro.geekbrainskursovoimvp.R
import ui.smartpro.geekbrainskursovoimvp.network.NetworkState
import ui.smartpro.geekbrainskursovoimvp.presentation.citybikes.BikesScreen
import uui.smartpro.geekbrainskursovoimvp.network.NetworkStateObservable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MainActivity : AbsActivity() {

    private val navigator = AppNavigator(this, android.R.id.content)

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: Router

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        savedInstanceState ?: router.newRootScreen(BikesScreen)

        val connect =
            NetworkStateObservable(this)
                .doOnNext { onNext(0, it) }
                .publish()

        connect.connect()

        disposables +=
            connect.delay(20L, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .subscribe { onNext(1, it) }
    }

    private fun onNext(no: Int, state: NetworkState) {
        Toast.makeText(this, "$no: NetworkState: $state", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}