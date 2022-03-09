package ui.smartpro.geekbrainskursovoimvp.data.model

import ui.smartpro.geekbrainskursovoimvp.data.NetworksItemEntity

data class CityBike(
        var id: String? = null,
        val name: String? = null,
        val country: String? = null,
        val city: String? = null,
        val latitude: Double? = null,
        val longitude: Double? = null,
        val source: String? = null,
        val href: String? = null,
) {

    object Mapper {

        fun map(networksItem: NetworksItemEntity?) =
                CityBike(
                        networksItem!!.id,
                        networksItem.name,
                        networksItem.country,
                        networksItem.city,
                        networksItem.latitude,
                        networksItem.longitude,
                        networksItem.source,
                        networksItem.href
                )

        fun filter(networksItem: NetworksItemEntity?) {
            if (networksItem!!.source!!.isNotEmpty()) {
                CityBike(
                        networksItem.id,
                        networksItem.name,
                        networksItem.country,
                        networksItem.city,
                        networksItem.latitude,
                        networksItem.longitude,
                        networksItem.source,
                        networksItem.href
                )
            } else {
                CityBike(
                        "networksItem.id",
                        "networksItem.name",
                        "networksItem.country",
                        "networksItem.city",
                        0.0,
                        0.0,
                        "networksItem.source",
                        "networksItem.href"
                )
            }
        }
    }
}
