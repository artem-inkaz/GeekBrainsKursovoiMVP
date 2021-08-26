package ui.smartpro.geekbrainskursovoimvp.datasource.datafromapi

import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import ui.smartpro.geekbrainskursovoimvp.api.Api
import ui.smartpro.geekbrainskursovoimvp.data.Network
import ui.smartpro.geekbrainskursovoimvp.data.NetworksItem
import ui.smartpro.geekbrainskursovoimvp.data.Response
import javax.inject.Inject

class DataFromApiImpl @Inject constructor(
    private val api: Api,
):DataFromApi {
    override fun getCityBikes(): Single<Response> =
        api
            .geCityBikes()
 //           .toObservable()

    override fun getCityBikeId(userId: String): Maybe<Network> =
        api
            .getBikeShref(userId)
            .toMaybe()
}