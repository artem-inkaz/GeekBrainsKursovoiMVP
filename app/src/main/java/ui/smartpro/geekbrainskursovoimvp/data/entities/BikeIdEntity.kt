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

//	@ColumnInfo(name = "name")
//	var name: String? = null,

	@PrimaryKey
	var id: String,

//	@Embedded
//	@SerializedName("stations")
//	@ColumnInfo(name = "stations")
	//@SerializedName("stations")
//	var stations: List<StationsItem?>? = null,

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
					network.id
				)
	}


//	object Mapper {
//
//		fun map(network: Network?) =
//				NetworkEntity(
//						network!!.id!!,
//						network.stations!![4]!!.id!!,
//						network.name,
//						network.stations[0]!!.freeBikes,
//						network.stations[5]!!.emptySlots,
//						network.stations[7]!!.timestamp,
//						network.stations[1]!!.extra!!.normalBikes,
//						network.stations[1]!!.extra!!.ebikes,
//						network.stations[1]!!.extra!!.slots,
//						""
//				)
//	}
}

//data class NetworkEntity(
//	@PrimaryKey
//	@SerializedName("id")
//	val id: String,
//
//	@SerializedName("name")
//	@ColumnInfo(name = "name")
//	val name: String? = null,
//
//	@Embedded
////	@SerializedName("stations")
////	@ColumnInfo(name = "stations")
//	val stations: List<StationsItem?>? = null,
//
//	@ColumnInfo(name = "shref_Id")
//	@SerializedName("shref_Id")
//	var shrefId: String
//)
//{
//
//		constructor() : this("0", "", listOf(), "", )
//
//
//	object Mapper {
//
//		fun map(network: Network) =
//				NetworkEntity(
//						network.id!!,
////						network.stations!![4]!!.id!!,
//						network.name,
//						network.stations,
//						""
//				)
//	}
//}
//data class StationsItemEntity(
//
//	@SerializedName("free_bikes")
//	val freeBikes: Int? = null,
//
//	@Embedded
//	@ColumnInfo(name = "extra")
//	@SerializedName("extra")
//	val extra: ExtraEntity? = null,
//
//	@ColumnInfo(name = "id")
//	@SerializedName("id")
//	val id: String? = null,
//
//	@ColumnInfo(name = "empty_slots")
//	@SerializedName("empty_slots")
//	val emptySlots: Int? = null,
//
//	@ColumnInfo(name = "timestamp")
//	@SerializedName("timestamp")
//	val timestamp: String? = null
//)
//
//data class ExtraEntity(
//	@ColumnInfo(name = "normal_bikes")
//	@SerializedName("normal_bikes")
//	val normalBikes: Int? = null,
//
//	@ColumnInfo(name = "uid")
//	@SerializedName("uid")
//	val uid: String? = null,
//
//	@ColumnInfo(name = "ebikes")
//	@SerializedName("ebikes")
//	val ebikes: Int? = null,
//
//	@ColumnInfo(name = "slots")
//	@SerializedName("slots")
//	val slots: Int? = null,
//)


