package ui.smartpro.geekbrainskursovoimvp.datasource.datafromapi

import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import ui.smartpro.geekbrainskursovoimvp.data.Network
import ui.smartpro.geekbrainskursovoimvp.data.NetworksItem
import ui.smartpro.geekbrainskursovoimvp.data.Response

interface DataFromApi {

    fun getCityBikes(): Single<Response>
    fun getCityBikeId(userId: String): Maybe<Network>
}