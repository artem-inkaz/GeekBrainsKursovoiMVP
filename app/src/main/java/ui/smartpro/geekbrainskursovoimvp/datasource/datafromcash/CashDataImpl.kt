package ui.smartpro.geekbrainskursovoimvp.datasource.datafromcash

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import ui.smartpro.geekbrainskursovoimvp.data.*
import ui.smartpro.geekbrainskursovoimvp.di.modules.InMemory
import javax.inject.Inject

class CashDataImpl @Inject constructor(
    @InMemory private val database: Database
):CashData {

    /** request items from db */
    override fun getAllItems(): Observable<List<NetworksItemEntity>> =
        database
                .cityBikeDao
                .fetchCityBikeItems()

    /** add items data into db, include converter*/
    override fun writeItemsIntoDB(networksItem: NetworksItem): Completable =
        database
                .cityBikeDao
                .insert(toItemEntity(networksItem))
//                .andThen(getAllItems().firstOrError())

    /** del items and write new items data set again, include converter */
    override fun rewriteItemsListIntoDB(networksItem: List<NetworksItemEntity>): Single<List<NetworksItemEntity>>? =
//        database.cityBikeDao.deleteAll()
        database
                .cityBikeDao
//                .insertAll(networksItem.map { toItemEntity(it) })
                .insertAll(networksItem)
//                .toObservable()
                .andThen(getAllItems().firstOrError())

    /** request items by item id */
//    override fun getItemById(id: String): Maybe<NetworkEntity> =
//        database
//                .bikeIdDao
//                .getBikeId(id).toMaybe()
    override fun getItemById(id: String): Observable<List<NetworkEntity>> =
            database
                    .bikeIdDao
                    .getBikeId(id)
 //                   .toMaybe()


    /** add item by id data into db, include converter*/
//    override fun writeItemIdIntoDB(network: Network,itemId: String): Completable=
//        database
//                .bikeIdDao
 //               .insert(toItemIdEntity(network,itemId))

    override fun rewriteItemsStationsIntoDB(id: String,networkEntity: List<StationsItem>)
    : Single<List<NetworkEntity>>? =
        database
                .bikeIdDao
                .insertAll(networkEntity.map { toItemIdEntity(id,it)})
//                .insertAll(networksItem)
//                .toObservable()
                 .andThen(getItemById(id).firstOrError())
 //               .andThen(Single.just(networksItem))
//                  .andThen(Single.just(networksItem))

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
    private fun toItemIdEntity(itemId: String, network: StationsItem) = NetworkEntity(
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

}

