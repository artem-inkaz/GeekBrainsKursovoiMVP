package ui.smartpro.geekbrainskursovoimvp.presentation.spinner

import com.github.terrakok.cicerone.Router
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import moxy.MvpPresenter
import ui.smartpro.geekbrainskursovoimvp.data.entities.AllIdEntity
import ui.smartpro.geekbrainskursovoimvp.datasource.repository.Repository
import ui.smartpro.geekbrainskursovoimvp.presentation.bikeitem.BikeScreen
import ui.smartpro.geekbrainskursovoimvp.presentation.citybikes.BikesView
import ui.smartpro.geekbrainskursovoimvp.scheduler.Schedulers

class SpinnerPresenter (
        private val repository: Repository,
        private val router: Router,
        private val schedulers: Schedulers,
) : MvpPresenter<BikesView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables +=
                repository
                        .getAllIdBikes()
                        .observeOn(schedulers.background())
                        .observeOn(schedulers.main())
                        .subscribeOn(schedulers.background())
                        .subscribe(
                                viewState::showAllIdBikes,
                                viewState::showError
                        )
    }

    fun displayItemIdBike(id: String) {
        router.navigateTo(BikeScreen(id))
    }

    override fun onDestroy() {
        disposables.dispose()
    }
}