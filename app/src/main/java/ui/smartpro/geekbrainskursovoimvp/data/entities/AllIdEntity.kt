package ui.smartpro.geekbrainskursovoimvp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import ui.smartpro.geekbrainskursovoimvp.data.response.NetworksItem

@Entity(tableName = "all_bike")
data class AllIdEntity(
        @PrimaryKey
        @SerializedName("id")
        var id: String,
) {
        object Mapper {
                fun map(networks: NetworksItem?) =
                        AllIdEntity(
                                networks!!.id!!
                        )
        }
}
