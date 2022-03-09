package ui.smartpro.geekbrainskursovoimvp.data.model

import ui.smartpro.geekbrainskursovoimvp.data.NetworksItemEntity

data class CityBike (
    val id: String? = null,
    val name: String? = null,
//    val company: List<String?>? = null,
    val country: String? = null,
    val city: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val source: String? = null,
    val href: String? = null
) {

    object Mapper {

        fun map(networksItem: NetworksItemEntity?) =
            CityBike(
                networksItem!!.id,
                networksItem.name,
//                networksItem.company,
                networksItem.country,
                networksItem.city,
                networksItem.latitude,
                networksItem.longitude,
                networksItem.source,
                networksItem.href
            )
    }

//    object Mapper {
//
//        fun map(networksItem: NetworksItemEntity?) =
//                CityBike(
//                        networksItem!!.id,
//                        networksItem.name,
////                networksItem.company,
//                        networksItem.location!!.country,
//                        networksItem.location.city,
//                        networksItem.location.latitude,
//                        networksItem.location.longitude,
//                        networksItem.source,
//                        networksItem.href
//                )
//    }

//    private fun encode(){
//        val str: String
//        str.
//    }


}
