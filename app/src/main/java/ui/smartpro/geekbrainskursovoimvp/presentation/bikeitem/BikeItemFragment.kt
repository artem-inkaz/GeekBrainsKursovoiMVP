package ui.smartpro.geekbrainskursovoimvp.presentation.bikeitem

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import moxy.ktx.moxyPresenter
import ui.smartpro.geekbrainskursovoimvp.R.layout.fragment_bike_item
import ui.smartpro.geekbrainskursovoimvp.data.NetworkEntity
import ui.smartpro.geekbrainskursovoimvp.databinding.FragmentBikeItemBinding
import ui.smartpro.geekbrainskursovoimvp.datasource.repository.Repository
import ui.smartpro.geekbrainskursovoimvp.ext.arguments
import ui.smartpro.geekbrainskursovoimvp.presentation.abs.AbsFragment
import ui.smartpro.geekbrainskursovoimvp.presentation.citybikes.adapter.BikeAdapter
import ui.smartpro.geekbrainskursovoimvp.scheduler.Schedulers
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

class BikeItemFragment : AbsFragment(fragment_bike_item), BikeView, BikeAdapter.Delegate {

    companion object Factory {
        private const val ARG_BIKE_ID = "arg_bike_id"

        @JvmStatic
        fun newInstance(param1: String): Fragment =
                BikeItemFragment()
                        .arguments(ARG_BIKE_ID to param1)
    }

    private val bikeId: String by lazy {
        arguments?.getString(ARG_BIKE_ID).orEmpty()
    }

    @Inject
    lateinit var schedulers: Schedulers

    @Inject
    lateinit var repository: Repository

    @Suppress("unused")
    private val presenter: BikePresenter by moxyPresenter {
        BikePresenter(
                bikeId = bikeId,
                repository = repository,
                schedulers = schedulers
        )
    }

    private val viewBinding: FragmentBikeItemBinding by viewBinding()
    private val bikeAdapter = BikeAdapter(delegate = this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.cityBikeDetail.adapter = bikeAdapter
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun convertLongToTime(time: String): String {
        val inputFormatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
        val outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyy", Locale.ENGLISH)
        val date = LocalDate.parse(time, inputFormatter)
        val formattedDate = outputFormatter.format(date)
        return formattedDate // prints 10-04-2018
    }

    override fun showBike(bikeId: List<NetworkEntity>) {
        bikeAdapter.submitList(bikeId)
        viewBinding.idTV.text = bikeId[0].id
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), "User Fragment", Toast.LENGTH_LONG).show()
    }

    override fun onItemPicked(bike: NetworkEntity) {
        Toast.makeText(requireContext(), "Функция в разработке", Toast.LENGTH_LONG).show()
    }
}