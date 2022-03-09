package ui.smartpro.geekbrainskursovoimvp.datasource.datafromapi

import io.reactivex.Single
import ui.smartpro.geekbrainskursovoimvp.data.BikeIdResponse
import ui.smartpro.geekbrainskursovoimvp.data.Response

interface DataFromApi {

    fun getCityBikes(): Single<Response>
    fun getCityBikeId(userId: String): Single<BikeIdResponse>
}