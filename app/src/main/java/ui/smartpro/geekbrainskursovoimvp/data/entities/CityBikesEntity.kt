package ui.smartpro.geekbrainskursovoimvp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
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
	val href: String? = null
)
//{
//		val latLng: LatLng
//		get() = LatLng(latitude, longitude)
//}

