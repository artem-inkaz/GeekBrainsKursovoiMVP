package ui.smartpro.geekbrainskursovoimvp.presentation.citybikes

import com.github.terrakok.cicerone.Router
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.cast
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
                        .map { users -> users.map(CityBike.Mapper::map) }
                        .observeOn(schedulers.main())
                        .subscribeOn(schedulers.background())
                        .subscribe(
                                viewState::showBikes,
                                viewState::showError
                        )
    }

    fun filterSource() {
        disposables +=
                bikeRepository
                        .filterSource()
                        .observeOn(schedulers.background())
                        .map { users -> users.map(CityBike.Mapper::filter) }
                        .filter { items -> items.get(6).equals(null) }
                        .cast<List<CityBike>>()
                        .observeOn(schedulers.main())
                        .subscribeOn(schedulers.background())
                        .subscribe(
                                viewState::showSourceBikes,
                                viewState::showError
                        )
    }


    fun displayItemBike(bike: CityBike) {
        router.navigateTo(BikeScreen(bike.id!!))
    }

    fun displayItemIdBike(id: String,bike: CityBike) {
            bike.id =id
        router.navigateTo(BikeScreen(bike.id!!))
    }

    override fun onDestroy() {
        disposables.dispose()
    }
}