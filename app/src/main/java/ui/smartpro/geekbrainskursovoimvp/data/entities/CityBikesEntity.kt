package ui.smartpro.geekbrainskursovoimvp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "city_bike")
data class NetworksItemEntity(
	@PrimaryKey
	@SerializedName("id")
	val id: String,
	@ColumnInfo(name = "name")
	@SerializedName("name")
	val name: String? = null,
	@ColumnInfo(name = "company")
	@SerializedName("company")
	val company: String,
	@ColumnInfo(name = "country")
	@SerializedName("country")
	val country: String? = null,
	@ColumnInfo(name = "city")
	@SerializedName("city")
	val city: String? = null,
	@ColumnInfo(name = "latitude")
	@SerializedName("latitude")
	val latitude: Double? = null,
	@ColumnInfo(name = "longitude")
	@SerializedName("longitude")
	val longitude: Double? = null,
	@ColumnInfo(name = "source")
	@SerializedName("source")
	val source: String? = null,
	@ColumnInfo(name = "href")
	@SerializedName("href")
	val href: String? = null,
) {
	object Mapper {

		fun map(networksItem: NetworksItem?) =
			NetworksItemEntity(
				networksItem!!.id!!,
				networksItem.name,
				"",
				networksItem.location!!.country!!,
				networksItem.location.city,
				networksItem.location.latitude,
				networksItem.location.longitude,
				networksItem.source,
				networksItem.href
			)

		fun filter(networksItem: NetworksItem?) =
			if (networksItem!!.source != null) {
				NetworksItemEntity(
					networksItem.id!!,
					networksItem.name,
					"",
					networksItem.location!!.country!!,
					networksItem.location.city,
					networksItem.location.latitude,
					networksItem.location.longitude,
					networksItem.source,
					networksItem.href

				) as Any
			} else {}
	}
}
