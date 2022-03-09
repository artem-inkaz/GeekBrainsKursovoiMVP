package ui.smartpro.geekbrainskursovoimvp.presentation.citybikes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ui.smartpro.geekbrainskursovoimvp.R.layout.bike_detail
import ui.smartpro.geekbrainskursovoimvp.data.NetworkEntity

class BikeAdapter(private val delegate: Delegate?) : ListAdapter<NetworkEntity, BikeItemViewHolder>(
        BikeItemDiff
) {

    interface Delegate {

        /**
         * Событие наступает при выборе
         * записи из списка.
         * @param bike пользователь
         */
        fun onItemPicked(bike: NetworkEntity)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BikeItemViewHolder =
            BikeItemViewHolder(
                    LayoutInflater
                            .from(parent.context)
                            .inflate(bike_detail, parent, false)
            )

    override fun onBindViewHolder(holder: BikeItemViewHolder, position: Int) =
            holder.bind(getItem(position), delegate)

}