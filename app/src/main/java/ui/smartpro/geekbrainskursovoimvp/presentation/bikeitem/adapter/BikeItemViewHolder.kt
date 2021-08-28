package ui.smartpro.geekbrainskursovoimvp.presentation.citybikes.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.kirich1409.viewbindingdelegate.viewBinding
import ui.smartpro.geekbrainskursovoimvp.data.NetworkEntity
import ui.smartpro.geekbrainskursovoimvp.databinding.BikeDetailBinding
import ui.smartpro.geekbrainskursovoimvp.ext.click

class BikeItemViewHolder(view: View) : ViewHolder(view) {

    private val viewBinding: BikeDetailBinding by viewBinding()

    fun bind(bike: NetworkEntity, delegate: BikeAdapter.Delegate?) {
        with(viewBinding) {
            idTV.text = bike.id
            if (bike.freeBikes == null) {
                freeBikesTV.text = "Все занято"
            } else {
                freeBikesTV.text = bike.freeBikes.toString()
            }
            if (bike.emptySlots == null) {
                emptySlotsTV.text = "Все занято"
            } else {
                emptySlotsTV.text = bike.emptySlots.toString()
            }
            timestampTV.text = bike.timestamp
            if (bike.normalBikes == null) {
                normalBikesTV.text = "Все занято"
            } else {
                normalBikesTV.text = bike.normalBikes.toString()
            }
            if (bike.ebikes == null) {
                ebikesTV.text = "Все занято"
            } else {
                ebikesTV.text = bike.ebikes.toString()
            }
            slotsTV.text = bike.slots.toString()

            detailContainer.click { delegate?.onItemPicked(bike) }
        }
    }
}