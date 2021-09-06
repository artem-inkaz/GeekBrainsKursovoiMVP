package ui.smartpro.geekbrainskursovoimvp.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url
import ui.smartpro.geekbrainskursovoimvp.data.*
import ui.smartpro.geekbrainskursovoimvp.data.response.AllIdResponse

interface Api {

    /**
     * http://api.citybik.es/v2/
     */

    /** http://api.citybik.es/v2/networks */

    @GET("v2/networks")
    fun geCityBikes(): Single<Response>

    /** https://api.citybik.es/v2/networks/velobike-moscow */

    @GET("v2/networks/{network_id}")
    fun getCityBikeId(@Path("network_id") id: String): Single<BikeIdResponse>

    /** https://api.citybik.es/v2/networks?fields=id */

    @GET("v2/networks?fields=id")
    fun geAllBikesId(): Single<AllIdResponse>
}