package ui.smartpro.geekbrainskursovoimvp.presentation.citybikes

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.Router
import moxy.ktx.moxyPresenter
import ui.smartpro.geekbrainskursovoimvp.R.layout.fragment_city_bikes
import ui.smartpro.geekbrainskursovoimvp.data.model.CityBike
import ui.smartpro.geekbrainskursovoimvp.databinding.FragmentCityBikesBinding
import ui.smartpro.geekbrainskursovoimvp.datasource.repository.Repository
import ui.smartpro.geekbrainskursovoimvp.presentation.abs.AbsFragment
import ui.smartpro.geekbrainskursovoimvp.presentation.citybikes.adapter.BikesAdapter
import ui.smartpro.geekbrainskursovoimvp.scheduler.Schedulers
import ui.smartpro.geekbrainskursovoimvp.source.Source
import ui.smartpro.geekbrainskursovoimvp.source.SourcePresenter
import ui.smartpro.geekbrainskursovoimvp.source.SourceView
import javax.inject.Inject

class CityBikesFragment : AbsFragment(fragment_city_bikes), BikesView, BikesAdapter.Delegate, SourceView {

    companion object {
        @JvmStatic
        fun newInstance() =
                CityBikesFragment().apply {
                    arguments = Bundle().apply {
                    }
                }
    }

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var schedulers: Schedulers

    @Inject
    lateinit var repository: Repository

    @Inject
    lateinit var source: Source

    private val presenter: BikesPresenter by moxyPresenter {
        BikesPresenter(
                bikeRepository = repository,
                router = router,
                schedulers = schedulers
        )
    }

    private val presenterSource: SourcePresenter by moxyPresenter {
        SourcePresenter(
                source = source,
                schedulers = schedulers
        )
    }

    private val viewBinding: FragmentCityBikesBinding by viewBinding()
    private val bikesAdapter = BikesAdapter(delegate = this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.cityBikes.adapter = bikesAdapter

        viewBinding.filterBtn.setOnClickListener {
            presenter.filterSource()

        }
    }

    override fun showBikes(bikes: List<CityBike>) {
        bikesAdapter.submitList(bikes)
    }

    override fun showSourceBikes(bikes: List<CityBike>) {
        bikesAdapter.submitList(bikes)
    }

    override fun showContent(uri: String?) {
        startActivity(Intent(Intent.ACTION_VIEW).apply {
            try {
                data = Uri.parse(uri)
            } catch (e: Throwable) {
                Toast.makeText(requireContext(), "${e}", Toast.LENGTH_LONG).show()
            }

        })
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
    }

    override fun onItemPicked(bike: CityBike) {
        presenter.displayItemBike(bike)
    }

    override fun onSourcePicked(bike: CityBike) {
        presenterSource.sourceOpen(bike.source.toString())
    }
}