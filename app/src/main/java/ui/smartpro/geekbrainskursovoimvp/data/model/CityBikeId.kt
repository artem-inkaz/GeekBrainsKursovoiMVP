package ui.smartpro.geekbrainskursovoimvp.data.model

import ui.smartpro.geekbrainskursovoimvp.data.NetworkEntity

//data class CityBikeId (
//    val id: String? = null,
//    val id_station: String? = null,
//    val name: String? = null,
//    val freeBikes: Int? = null,
//    val emptySlots: Int? = null,
//    val timestamp: String? = null,
//    val normalBikes: Int? = null,
//    val ebikes: Int? = null,
//    val slots: Int? = null
//) {

data class CityBikeId (
    val id: String? = null,
//    val name: String? = null,
    val freeBikes: Int? = null,
    val emptySlots: Int? = null,
    val timestamp: String? = null,
    val normalBikes: Int? = null,
    val ebikes: Int? = null,
    val slots: Int? = null
) {

object Mapper {

    fun map(network: NetworkEntity?){
        CityBikeId(
            network!!.id,
//            network.name,
            network.freeBikes!!,
            network.emptySlots!!,
            network.timestamp!!,
            network.normalBikes,
            network.ebikes,
            network.slots
        )
    }

    //    fun map(network: NetworkEntity){
    //        CityBikeId(
    //            network.id,
    //            network.stationId,
    //            network.name,
    //            network.freeBikes,
    //            network.emptySlots,
    //            network.timestamp,
    //            network.normalBikes,
    //            network.ebikes,
    //            network.slots
    //        )
    //    }
}
}

//    fun map(network: NetworkEntity){
//        CityBikeId(
//            network.id,
//            network.stations!![4]!!.id,
//            network.name,
//            network.stations[0]!!.freeBikes,
//            network.stations[5]!!.emptySlots,
//            network.stations[7]!!.timestamp,
//            network.stations[1]!!.extra!!.normalBikes,
//            network.stations[1]!!.extra!!.ebikes,
//            network.stations[1]!!.extra!!.slots
//        )
//    }