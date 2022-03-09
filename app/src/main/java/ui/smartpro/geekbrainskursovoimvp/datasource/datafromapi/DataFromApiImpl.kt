package ui.smartpro.geekbrainskursovoimvp.datasource.datafromapi

import io.reactivex.Single
import ui.smartpro.geekbrainskursovoimvp.api.Api
import ui.smartpro.geekbrainskursovoimvp.data.BikeIdResponse
import ui.smartpro.geekbrainskursovoimvp.data.Response
import ui.smartpro.geekbrainskursovoimvp.data.response.AllIdResponse
import javax.inject.Inject

class DataFromApiImpl @Inject constructor(
        private val api: Api,
) : DataFromApi {
    override fun getCityBikes(): Single<Response> =
            api
                    .geCityBikes()

    override fun getCityBikeId(bikeId: String): Single<BikeIdResponse> =
            api
                    .getCityBikeId(bikeId)

    override fun getAllId(): Single<AllIdResponse> =
        api
                .geAllBikesId()


}