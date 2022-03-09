package ui.smartpro.geekbrainskursovoimvp.presentation.citybikes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ui.smartpro.geekbrainskursovoimvp.data.model.CityBike
import ui.smartpro.geekbrainskursovoimvp.R.layout.item_bike

class BikesAdapter(private val delegate: Delegate?) : ListAdapter<CityBike, BikeViewHolder>(
        BikeDiff
) {

    interface Delegate {

        /**
         * Событие наступает при выборе
         * записи из списка.
         * @param bike пользователь
         */
        fun onItemPicked(bike: CityBike)

        fun onSourcePicked(bike: CityBike)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BikeViewHolder =
            BikeViewHolder(
                    LayoutInflater
                            .from(parent.context)
                            .inflate(item_bike, parent, false)
            )

    override fun onBindViewHolder(holder: BikeViewHolder, position: Int) =
            holder.bind(getItem(position), delegate)

}