package ui.smartpro.geekbrainskursovoimvp.presentation.bikeitem

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import moxy.MvpPresenter
import ui.smartpro.geekbrainskursovoimvp.data.model.CityBike
import ui.smartpro.geekbrainskursovoimvp.data.model.CityBikeId
import ui.smartpro.geekbrainskursovoimvp.datasource.repository.Repository
import ui.smartpro.geekbrainskursovoimvp.scheduler.Schedulers

class BikePresenter(
        private val bikeId: String,
        private val repository: Repository,
        private val schedulers: Schedulers,
) : MvpPresenter<BikeView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables +=
                repository
                        .getCityBikeId(bikeId)
                        .observeOn(schedulers.background())
                        .observeOn(schedulers.main())
                        .subscribeOn(schedulers.background())
                        .subscribe(
                                viewState::showBike,
                                viewState::showError
                        )

    }

    override fun onDestroy() {
        disposables.clear()
    }
}