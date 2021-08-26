package ui.smartpro.geekbrainskursovoimvp.presentation.citybikes.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import ui.smartpro.geekbrainskursovoimvp.data.model.CityBike

object BikeDiff : DiffUtil.ItemCallback<CityBike>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: CityBike, newItem: CityBike): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: CityBike, newItem: CityBike): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: CityBike, newItem: CityBike) = payload

}

