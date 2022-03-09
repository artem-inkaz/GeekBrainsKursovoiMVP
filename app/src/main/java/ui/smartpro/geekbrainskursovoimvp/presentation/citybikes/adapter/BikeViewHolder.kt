package ui.smartpro.geekbrainskursovoimvp.presentation.citybikes.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.kirich1409.viewbindingdelegate.viewBinding
import ui.smartpro.geekbrainskursovoimvp.data.model.CityBike
import ui.smartpro.geekbrainskursovoimvp.databinding.ItemBikeBinding
import ui.smartpro.geekbrainskursovoimvp.ext.click

class BikeViewHolder(view: View) : ViewHolder(view) {

    private val viewBinding: ItemBikeBinding by viewBinding()

    fun bind(bike: CityBike, delegate: BikesAdapter.Delegate?) {
        with(viewBinding) {
            idTV.text = bike.id
            nameTV.text = bike.name
            companyTV.text = "В разработке"
            countryTV.text = bike.country
            cityTV.text = bike.city
            coordinatTV.text = "${bike.longitude} " + "," + "${bike.latitude}"
            if (bike.source != null) sourceBtn.visibility = View.VISIBLE
            sourceBtn.click { delegate?.onSourcePicked(bike) }
            itemContainer.click { delegate?.onItemPicked(bike) }
        }
    }
}