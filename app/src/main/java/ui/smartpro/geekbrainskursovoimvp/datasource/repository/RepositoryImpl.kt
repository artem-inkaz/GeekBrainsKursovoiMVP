package ui.smartpro.geekbrainskursovoimvp.datasource.repository

import io.reactivex.Completable
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
    override fun getCityBikes(): Observable<Response> =
 //           Observable.merge(
 //                   cache.getAllItems(),
                    api
                        .getCityBikes()
//                        .flatMap { items ->
//                            cache.rewriteItemsListIntoDB(items)
//                        }
                        .toObservable()
//            )

    override fun getCityBikeId(id: String): Single<Network> {
        TODO("Not yet implemented")
    }

    override fun writeItemIntoDB(networksItemEntity: NetworksItemEntity): Completable {
        TODO("Not yet implemented")
    }

    override fun rewriteItemsIntoDB(networksItemEntity: List<NetworksItemEntity>): Completable {
        TODO("Not yet implemented")
    }

    /** converter items */
    private fun toItemEntity(networksItem: NetworksItem) = NetworksItemEntity(
        id = networksItem.id!!,
        name = networksItem.name,
        company = "",
        country = networksItem.location!!.country,
        city = networksItem.location.city,
        latitude = networksItem.location.latitude,
        longitude = networksItem.location.longitude,
        source = networksItem.source,
        href = networksItem.href,
    )

    /** converter item by id */
    private fun toItemIdEntity(network: Network,itemId: String) = NetworkEntity(
        id = network.id!!,
        stationId = network.stations!![4]!!.id!!,
        name = network.name,
        freeBikes = network.stations[0]!!.freeBikes,
        emptySlots = network.stations[5]!!.emptySlots,
        timestamp = network.stations[7]!!.timestamp,
        normalBikes = network.stations[1]!!.extra!!.normalBikes,
        ebikes = network.stations[1]!!.extra!!.ebikes,
        slots = network.stations[1]!!.extra!!.slots,
        shrefId = itemId
    )
}

