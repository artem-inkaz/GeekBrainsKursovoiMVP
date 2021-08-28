package ui.smartpro.geekbrainskursovoimvp.data

import com.google.gson.annotations.SerializedName

data class Response(

		@SerializedName("networks")
		val networks: List<NetworksItem?>? = null,
)

data class NetworksItem(

		@SerializedName("name")
		val name: String? = null,

//	@SerializedName("company")
//	val company: List<String?>? = null,

		@SerializedName("location")
		val location: Location? = null,

		@SerializedName("href")
		val href: String? = null,

		@SerializedName("id")
		val id: String? = null,

		@SerializedName("source")
		val source: String? = null,
)

data class Location(

		@SerializedName("country")
		val country: String? = null,

		@SerializedName("city")
		val city: String? = null,

		@SerializedName("latitude")
		val latitude: Double? = null,

		@SerializedName("longitude")
		val longitude: Double? = null,
)
//{
//		val latLng: LatLng
//		get() = LatLng(latitude, longitude)
//}
