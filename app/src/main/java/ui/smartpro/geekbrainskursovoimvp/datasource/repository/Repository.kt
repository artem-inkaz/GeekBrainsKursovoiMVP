package ui.smartpro.geekbrainskursovoimvp.datasource.repository

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import ui.smartpro.geekbrainskursovoimvp.data.NetworkEntity
import ui.smartpro.geekbrainskursovoimvp.data.NetworksItemEntity
import ui.smartpro.geekbrainskursovoimvp.data.StationsItem

interface Repository {

    fun getCityBikes(): Observable<List<NetworksItemEntity>>

//    fun getCityBikeId(id: String): Maybe<Network>
    fun getCityBikeId(id: String): Single<List<NetworkEntity>>

//    fun writeItemIntoDB(networksItemEntity: NetworksItemEntity):Completable
//    fun rewriteItemsIntoDB(networksItemEntity: List<NetworksItemEntity>):Completable
}