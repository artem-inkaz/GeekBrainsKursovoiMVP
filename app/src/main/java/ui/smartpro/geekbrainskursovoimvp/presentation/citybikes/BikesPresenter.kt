package ui.smartpro.geekbrainskursovoimvp.presentation.citybikes

import com.github.terrakok.cicerone.Router
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import moxy.MvpPresenter
import ui.smartpro.geekbrainskursovoimvp.data.model.CityBike
import ui.smartpro.geekbrainskursovoimvp.datasource.repository.Repository
import ui.smartpro.geekbrainskursovoimvp.presentation.bikeitem.BikeScreen
import ui.smartpro.geekbrainskursovoimvp.scheduler.Schedulers

class BikesPresenter(
        private val bikeRepository: Repository,
        private val router: Router,
        private val schedulers: Schedulers,
) : MvpPresenter<BikesView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables +=
                bikeRepository
                        .getCityBikes()
                        .observeOn(schedulers.background())
//                        .map { it.networks }
                        .map { users -> users.map(CityBike.Mapper::map) }
//                        .map { response -> response.networks!!.map(CityBike.Mapper::map) }
                        .observeOn(schedulers.main())
                        .subscribeOn(schedulers.background())
                        .subscribe(
                                viewState::showBikes,
                                viewState::showError
                        )
    }

    fun displayItemBike(bike: CityBike) {
      router.navigateTo(BikeScreen(bike.id!!))
    }

    override fun onDestroy() {
        disposables.dispose()
    }
}