package ui.smartpro.geekbrainskursovoimvp.data.model

import ui.smartpro.geekbrainskursovoimvp.data.NetworkEntity

data class CityBikeId(
        val id: String? = null,
        val freeBikes: Int? = null,
        val emptySlots: Int? = null,
        val timestamp: String? = null,
        val normalBikes: Int? = null,
        val ebikes: Int? = null,
        val slots: Int? = null,
) {

    object Mapper {

        fun map(network: NetworkEntity?) {
            CityBikeId(
                    network!!.id,
                    network.freeBikes!!,
                    network.emptySlots!!,
                    network.timestamp!!,
                    network.normalBikes,
                    network.ebikes,
                    network.slots
            )
        }
    }
}

