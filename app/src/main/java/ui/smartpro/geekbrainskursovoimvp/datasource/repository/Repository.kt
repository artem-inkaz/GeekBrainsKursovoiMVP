package ui.smartpro.geekbrainskursovoimvp.datasource.repository

import io.reactivex.Observable
import io.reactivex.Single
import ui.smartpro.geekbrainskursovoimvp.data.NetworkEntity
import ui.smartpro.geekbrainskursovoimvp.data.NetworksItemEntity

interface Repository {

    fun getCityBikes(): Observable<List<NetworksItemEntity>>
    fun getCityBikeId(id: String): Single<List<NetworkEntity>>
    fun filterSource():Observable<List<NetworksItemEntity>>
}