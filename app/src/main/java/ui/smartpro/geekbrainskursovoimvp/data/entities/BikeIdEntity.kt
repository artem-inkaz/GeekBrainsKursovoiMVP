package ui.smartpro.geekbrainskursovoimvp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(
	tableName = "bike_id",
	foreignKeys = [ForeignKey(
		entity = NetworksItemEntity::class,
		parentColumns = ["id"],
		childColumns = ["shref_Id"],
		onDelete = ForeignKey.CASCADE
	)]
)

data class NetworkEntity(
	@PrimaryKey
	val id: String,

	val stationId: String,

	@ColumnInfo(name = "name")
	val name: String? = null,

	@ColumnInfo(name = "free_bikes")
	val freeBikes: Int? = null,

	@ColumnInfo(name = "empty_slots")
	val emptySlots: Int? = null,

	@ColumnInfo(name = "timestamp")
	val timestamp: String? = null,

	@ColumnInfo(name = "normal_bikes")
	val normalBikes: Int? = null,

	@ColumnInfo(name = "ebikes")
	val ebikes: Int? = null,

	@ColumnInfo(name = "slots")
	val slots: Int? = null,

	@ColumnInfo(name = "shref_Id")
	var shrefId: String

)





