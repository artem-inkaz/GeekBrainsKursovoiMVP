package ui.smartpro.geekbrainskursovoimvp.datasource.datafromcash

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import ui.smartpro.geekbrainskursovoimvp.data.*

interface CashData {

    /**
     *  request items from db
     */
    fun getAllItems(): Observable<List<NetworksItemEntity>>

    /**
     * @Insert Item
     */
    fun writeItemsIntoDB(networksItem: NetworksItem): Completable

    /**
    * @Delete and @Insert Items
    */

    fun rewriteItemsListIntoDB(networksItem: List<NetworksItemEntity>): Single<List<NetworksItemEntity>>?

    /**
     *  request item Id from db
     */
//    fun getItemById(id: String): Maybe<NetworkEntity>
    fun getItemById(id: String): Observable<List<NetworkEntity>>

    /**
     * @Insert Item Id
     */
//    fun writeItemIdIntoDB(network: Network, itemId: String): Completable

    fun rewriteItemsStationsIntoDB(id: String,networkEntity: List<StationsItem>): Single<List<NetworkEntity>>?
}