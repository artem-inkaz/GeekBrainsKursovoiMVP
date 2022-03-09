package ui.smartpro.geekbrainskursovoimvp.cicerone

import android.util.Log
import com.github.terrakok.cicerone.Cicerone
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.reactivex.functions.Consumer
import io.reactivex.plugins.RxJavaPlugins
import ui.smartpro.geekbrainskursovoimvp.di.DaggerApplicationComponent
import ui.smartpro.geekbrainskursovoimvp.scheduler.DefaultSchedulers


class App:DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<App> =
        DaggerApplicationComponent
            .builder()
            .withContext(applicationContext)
            .apply {
                val cicerone = Cicerone.create()
                withNavigationHolder(cicerone.getNavigatorHolder())
                withRouter(cicerone.router)
                withSchedulers(DefaultSchedulers())
            }
            .build()

    override fun onCreate() {
        super.onCreate()
        RxJavaPlugins.setErrorHandler {
            Log.d("RxJava Error", it.toString())
        }
    }

}