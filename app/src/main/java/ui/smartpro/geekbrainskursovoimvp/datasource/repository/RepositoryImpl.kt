package ui.smartpro.geekbrainskursovoimvp.datasource.repository

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import ui.smartpro.geekbrainskursovoimvp.data.*
import ui.smartpro.geekbrainskursovoimvp.datasource.datafromapi.DataFromApi
import ui.smartpro.geekbrainskursovoimvp.datasource.datafromcash.CashData
import javax.inject.Inject

class RepositoryImpl  @Inject constructor(
        private val api: DataFromApi,
        private val cache: CashData
):Repository  {
    override fun getCityBikes(): Observable<List<NetworksItemEntity>> =
           Observable.merge(
                   cache.getAllItems(),
                    api
                        .getCityBikes()
//                        .map { it.networks }
//                        .map { users -> users.map(NetworksItemEntity.Mapper::map) }
//                        .map { response -> response.networks.map(CityBike.Mapper::map) }
                       .map { response -> NetworksItemEntity.Mapper::map.let { response.networks!!.map(it) } }
//                       .flatMapObservable (cache::rewriteItemsListIntoDB)
                       .flatMap(cache::rewriteItemsListIntoDB)
//                        .flatMap { items ->
//                            cache.rewriteItemsListIntoDB(items)
//                        }
                       .toObservable()
           )

    ////                        .map { it.networks }
    ////                        .map { users -> users.map(CityBike.Mapper::map) }
    //                        .map { response -> response.networks!!.map(CityBike.Mapper::map) }


    override fun getCityBikeId(id: String): Single<List<NetworkEntity>> =
//           Observable.merge(
//               cache
//                   .getItemById(id),
               api
                   .getCityBikeId(id)
                   .map { it.network }
//                        .map { response ->response.network!!.stations!!.map(NetworkEntity.Mapper.map) }
                   .map { response -> NetworkEntity.Mapper::map.let { response.stations!!.map(it) } }
//                   .flatMapObservable { items -> cache.rewriteItemsStationsIntoDB(id,items)}
//                            .map { it.network }
//                            .map { response -> NetworkEntity.Mapper::map}
//                          .map { NetworkEntity.Mapper::map }}
//                            .flatMap {cache::rewriteItemsStationsIntoDB}
//                        .toObservable()
//          )



    /** converter items */
//    private fun toItemEntity(networksItem: NetworksItem) = NetworksItemEntity(
//        id = networksItem.id!!,
//        name = networksItem.name,
//        company = "",
//        country = networksItem.location!!.country,
//        city = networksItem.location.city,
//        latitude = networksItem.location.latitude,
//        longitude = networksItem.location.longitude,
//        source = networksItem.source,
//        href = networksItem.href,
//    )

    /** converter item by id StationsItem */
    private fun toItemIdEntity(itemId: String,network: StationsItem) = NetworkEntity(
        id = network.id!!,
        stationId = network.id!!,
//        name = network.name,
        freeBikes = network.freeBikes,
        emptySlots = network.emptySlots,
        timestamp = network.timestamp,
        normalBikes = network.extra!!.normalBikes,
        ebikes = network.extra!!.ebikes,
        slots = network.extra!!.slots,
        shrefId = itemId
    )

    /** converter item by id */
//    private fun toItemIdEntity(network: Network,itemId: String) = NetworkEntity(
//        id = network.id!!,
//        name = network.name,
//        stations = network.stations,
//        shrefId = itemId
//    )
}

