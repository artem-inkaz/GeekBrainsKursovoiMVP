package ui.smartpro.geekbrainskursovoimvp.datasource.datafromcash

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
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
    override fun rewriteItemsListIntoDB(networksItem: List<NetworksItem>): Observable<List<NetworksItemEntity>> =
//        database.cityBikeDao.deleteAll()
        database
                .cityBikeDao
                .insertAll(networksItem.map { toItemEntity(it) })
                .toObservable()

    /** request items by item id */
    override fun getItemById(id: String): Maybe<NetworkEntity> =
        database
                .bikeIdDao
                .getBikeId(id).toMaybe()

    /** add item by id data into db, include converter*/
    override fun writeItemIdIntoDB(network: Network,itemId: String): Completable=
        database
                .bikeIdDao
                .insert(toItemIdEntity(network,itemId))

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

//    private fun toNetworksItemDomain(networksItemEntity: NetworksItemEntity) = NetworksItem(
//        id = networksItemEntity.id.toInt(),
//        stations[4].id = networksItemEntity.title,
//        overview = networksItemEntity.overview,
//        poster = networksItemEntity.poster,
//        backdrop = networksItemEntity.backdrop,
//        ratings = networksItemEntity.ratings,
//        adult = networksItemEntity.adult,
//        runtime = networksItemEntity.runtime,
//        reviews = networksItemEntity.reviews,
//        genres = networksItemEntity.genres.split(",").map { it.trim() },
//        like = networksItemEntity.like
//    )
}

//            network.id,
//            network.stations!![4]!!.id,
//            network.name,
//            network.stations[0]!!.freeBikes,
//            network.stations[5]!!.emptySlots,
//            network.stations[7]!!.timestamp,
//            network.stations[1]!!.extra!!.normalBikes,
//            network.stations[1]!!.extra!!.ebikes,
//            network.stations[1]!!.extra!!.slots

//    val id: String? = null,
//    val id_station: String? = null,
//    val name: String? = null,
//    val freeBikes: Int? = null,
//    val emptySlots: Int? = null,
//    val timestamp: String? = null,
//    val normalBikes: Int? = null,
//    val ebikes: Int? = null,
//    val slots: Int? = null

//	val id: String,
//	val name: String? = null,
//	val company: String,
//	val country: String? = null,
//	val city: String? = null,
//	val latitude: Double? = null,
//	val longitude: Double? = null,
//	val source: String? = null,
//	val href: String? = null