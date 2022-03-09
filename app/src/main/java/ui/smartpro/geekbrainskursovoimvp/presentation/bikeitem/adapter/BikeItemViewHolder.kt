package ui.smartpro.geekbrainskursovoimvp.presentation.citybikes.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.kirich1409.viewbindingdelegate.viewBinding
import ui.smartpro.geekbrainskursovoimvp.data.NetworkEntity
import ui.smartpro.geekbrainskursovoimvp.databinding.BikeDetailBinding
import ui.smartpro.geekbrainskursovoimvp.ext.click

class BikeItemViewHolder(view: View): ViewHolder(view) {

    private val viewBinding: BikeDetailBinding by viewBinding()

    fun bind(bike: NetworkEntity, delegate: BikeAdapter.Delegate?) {
        with(viewBinding) {
            normalBikesTV.text=bike.normalBikes.toString()
            ebikesTV.text = bike.ebikes.toString()
            detailContainer.click { delegate?.onItemPicked(bike) }
        }
    }
}