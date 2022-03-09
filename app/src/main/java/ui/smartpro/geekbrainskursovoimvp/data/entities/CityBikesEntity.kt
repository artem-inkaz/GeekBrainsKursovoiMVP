package ui.smartpro.geekbrainskursovoimvp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "city_bike")
data class NetworksItemEntity(
	@PrimaryKey
	val id: String,

	@ColumnInfo(name = "name")
	val name: String? = null,

	@ColumnInfo(name = "company")
	val company: String,

	@ColumnInfo(name = "country")
	val country: String? = null,

	@ColumnInfo(name = "city")
	val city: String? = null,

	@ColumnInfo(name = "latitude")
	val latitude: Double? = null,

	@ColumnInfo(name = "longitude")
	val longitude: Double? = null,

	@ColumnInfo(name = "source")
	val source: String? = null,

	@ColumnInfo(name = "href")
	val href: String? = null
)
//{
//		val latLng: LatLng
//		get() = LatLng(latitude, longitude)
//}

