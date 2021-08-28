package ui.smartpro.geekbrainskursovoimvp.data

import androidx.room.*

@Entity(
		tableName = "bike_id",
		foreignKeys = [ForeignKey(
				entity = NetworksItemEntity::class,
				parentColumns = ["id"],
				childColumns = ["shref_Id"],
				onDelete = ForeignKey.CASCADE
		)],
		indices = [Index(value = ["shref_Id"])]
)

data class NetworkEntity(
		@PrimaryKey
		var id: String,

		val stationId: String,

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
		var shrefId: String,

		) {

	object Mapper {
		fun map(network: StationsItem?) =
				NetworkEntity(
//					network.,
						network!!.id!!,
						network.id!!,
						network.freeBikes,
						network.emptySlots,
						network.timestamp,
						network.extra!!.normalBikes,
						network.extra!!.ebikes,
						network.extra!!.slots,
						network.id!!
				)
	}
}



