package ui.smartpro.geekbrainskursovoimvp.data.model

import ui.smartpro.geekbrainskursovoimvp.data.response.NetworksItem

data class AllId(
        val id: String? = null,
) {
    object Mapper {

        fun map(networksItem: NetworksItem)=
                AllId(
                        networksItem.id
                )

    }

}
