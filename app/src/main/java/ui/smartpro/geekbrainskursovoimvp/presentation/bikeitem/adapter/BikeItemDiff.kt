package ui.smartpro.geekbrainskursovoimvp.presentation.citybikes.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import ui.smartpro.geekbrainskursovoimvp.data.NetworkEntity
import ui.smartpro.geekbrainskursovoimvp.data.model.CityBike

object BikeItemDiff : DiffUtil.ItemCallback<NetworkEntity>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: NetworkEntity, newItem: NetworkEntity): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: NetworkEntity, newItem: NetworkEntity): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: NetworkEntity, newItem: NetworkEntity) = payload

}

