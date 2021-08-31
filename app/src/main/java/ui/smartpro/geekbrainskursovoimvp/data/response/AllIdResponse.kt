package ui.smartpro.geekbrainskursovoimvp.data.response

import com.google.gson.annotations.SerializedName

data class AllIdResponse(

	@field:SerializedName("networks")
	val networks: List<NetworksItem?>? = null
)

data class NetworksItem(

	@field:SerializedName("id")
	val id: String? = null
)
