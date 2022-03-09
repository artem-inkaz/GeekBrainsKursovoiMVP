package ui.smartpro.geekbrainskursovoimvp.datasource.datafromcash

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import ui.smartpro.geekbrainskursovoimvp.data.Network
import ui.smartpro.geekbrainskursovoimvp.data.NetworkEntity
import ui.smartpro.geekbrainskursovoimvp.data.NetworksItem
import ui.smartpro.geekbrainskursovoimvp.data.NetworksItemEntity

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

    fun rewriteItemsListIntoDB(networksItem: List<NetworksItem>): Observable<List<NetworksItemEntity>>

    /**
     *  request item Id from db
     */
    fun getItemById(id: String): Maybe<NetworkEntity>

    /**
     * @Insert Item Id
     */
    fun writeItemIdIntoDB(network: Network, itemId: String): Completable
}