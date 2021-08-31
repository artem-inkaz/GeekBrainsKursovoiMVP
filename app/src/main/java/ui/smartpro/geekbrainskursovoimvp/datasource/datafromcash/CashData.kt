package ui.smartpro.geekbrainskursovoimvp.datasource.datafromcash

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import ui.smartpro.geekbrainskursovoimvp.data.NetworkEntity
import ui.smartpro.geekbrainskursovoimvp.data.NetworksItem
import ui.smartpro.geekbrainskursovoimvp.data.NetworksItemEntity
import ui.smartpro.geekbrainskursovoimvp.data.StationsItem
import ui.smartpro.geekbrainskursovoimvp.data.entities.AllIdEntity

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
    fun getItemById(id: String): Observable<List<NetworkEntity>>

    /**
     * @Insert Item Id
     */
    fun rewriteItemsStationsIntoDB(id: String, networkEntity: List<StationsItem>): Single<List<NetworkEntity>>?

    /**
     *  request all items Id from db
     */
    fun getAllIdItems(): Observable<List<AllIdEntity>>

    /**
     * @Delete and @Insert Items
     */

    fun rewriteAllListIntoDB(networksItem: List<AllIdEntity>): Single<List<AllIdEntity>>?
}