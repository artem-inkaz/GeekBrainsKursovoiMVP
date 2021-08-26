package ui.smartpro.geekbrainskursovoimvp.datasource.repository

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import ui.smartpro.geekbrainskursovoimvp.data.*

interface Repository {

    fun getCityBikes(): Observable<Response>

    fun getCityBikeId(id: String): Single<Network>

    fun writeItemIntoDB(networksItemEntity: NetworksItemEntity):Completable
    fun rewriteItemsIntoDB(networksItemEntity: List<NetworksItemEntity>):Completable
}