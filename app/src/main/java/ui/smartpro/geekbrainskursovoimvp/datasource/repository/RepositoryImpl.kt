package ui.smartpro.geekbrainskursovoimvp.datasource.repository

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.rxkotlin.cast
import ui.smartpro.geekbrainskursovoimvp.data.NetworkEntity
import ui.smartpro.geekbrainskursovoimvp.data.NetworksItemEntity
import ui.smartpro.geekbrainskursovoimvp.datasource.datafromapi.DataFromApi
import ui.smartpro.geekbrainskursovoimvp.datasource.datafromcash.CashData
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
        private val api: DataFromApi,
        private val cache: CashData,
) : Repository {
    override fun getCityBikes(): Observable<List<NetworksItemEntity>> =
            Observable.merge(
                    cache.getAllItems(),
                    api
                            .getCityBikes()
                            .map { response -> NetworksItemEntity.Mapper::map.let { response.networks!!.map(it) } }
                            .flatMap(cache::rewriteItemsListIntoDB)
                            .toObservable()
            )

    ////                        .map { it.networks }
    ////                        .map { users -> users.map(CityBike.Mapper::map) }
    //                        .map { response -> response.networks!!.map(CityBike.Mapper::map) }


    override fun getCityBikeId(id: String): Single<List<NetworkEntity>> =
            api
                    .getCityBikeId(id)
                    .map { it.network }
                    .map { response -> NetworkEntity.Mapper::map.let { response.stations!!.map(it) } }

    override fun filterSource(): Observable<List<NetworksItemEntity>> =
            Observable.merge(
                    cache.getAllItems(),
                    api
                            .getCityBikes()
                            .map { response -> NetworksItemEntity.Mapper::filter.let { response.networks!!.map(it) } }
                            .filter { response -> response[7].equals(null) }
                            .cast<List<NetworksItemEntity>>()
                            .toObservable()
            )
}



