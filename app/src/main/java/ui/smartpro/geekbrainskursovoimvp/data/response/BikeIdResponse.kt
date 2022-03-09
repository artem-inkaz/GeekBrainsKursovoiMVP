package ui.smartpro.geekbrainskursovoimvp.data

import com.google.gson.annotations.SerializedName

data class BikeIdResponse(

		@SerializedName("network")
		val network: Network? = null,
)

data class Network(

		@SerializedName("name")
		val name: String? = null,

		@SerializedName("company")
		val company: List<String?>? = null,

		@SerializedName("location")
		val location: Location? = null,

		@SerializedName("href")
		val href: String? = null,

		@SerializedName("id")
		val id: String? = null,

		@SerializedName("stations")
		val stations: List<StationsItem?>? = null,
)

data class StationsItem(

		@SerializedName("free_bikes")
		val freeBikes: Int? = null,

		@SerializedName("extra")
		val extra: Extra? = null,

		@SerializedName("id")
		val id: String? = null,

		@SerializedName("empty_slots")
		val emptySlots: Int? = null,

		@SerializedName("timestamp")
		val timestamp: String? = null,
)

data class Extra(

		@SerializedName("normal_bikes")
		val normalBikes: Int? = null,

		@SerializedName("uid")
		val uid: String? = null,

		@SerializedName("ebikes")
		val ebikes: Int? = null,

		@SerializedName("slots")
		val slots: Int? = null,
)




