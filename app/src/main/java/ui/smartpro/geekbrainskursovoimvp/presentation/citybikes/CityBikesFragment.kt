package ui.smartpro.geekbrainskursovoimvp.presentation.citybikes

import android.R
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.Router
import moxy.ktx.moxyPresenter
import ui.smartpro.geekbrainskursovoimvp.R.layout.fragment_city_bikes
import ui.smartpro.geekbrainskursovoimvp.data.entities.AllIdEntity
import ui.smartpro.geekbrainskursovoimvp.data.model.CityBike
import ui.smartpro.geekbrainskursovoimvp.databinding.FragmentCityBikesBinding
import ui.smartpro.geekbrainskursovoimvp.datasource.repository.Repository
import ui.smartpro.geekbrainskursovoimvp.presentation.abs.AbsFragment
import ui.smartpro.geekbrainskursovoimvp.presentation.citybikes.adapter.BikesAdapter
import ui.smartpro.geekbrainskursovoimvp.presentation.spinner.SpinnerPresenter
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

    var idSpinner: String? =null

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

    private val presenterSpinner: SpinnerPresenter by moxyPresenter {
        SpinnerPresenter(
                repository = repository,
                router = router,
                schedulers = schedulers
        )
    }

    private val viewBinding: FragmentCityBikesBinding by viewBinding()
    private val bikesAdapter = BikesAdapter(delegate = this)

   private var k = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.cityBikes.adapter = bikesAdapter

        viewBinding.filterBtn.setOnClickListener {
            presenter.filterSource()
        }

        viewBinding.appcompatSpinner.setSelection(0)
//        viewBinding.appcompatSpinner.onItemSelectedListener.
//         Set an on item selected listener for spinner object
            viewBinding.appcompatSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long){
                    // Display the selected item text on text view
                    idSpinner = parent.getItemAtPosition(position) as String?
                    if (k ) {
                        idSpinner = parent.getItemAtPosition(position) as String?
                        presenterSpinner.displayItemIdBike(idSpinner!!)
                        Toast.makeText(requireContext(), "Spinner selected : ${parent.getItemAtPosition(position)}", Toast.LENGTH_LONG).show()
                        k = false
                    }
                    else {
                        k = true
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>){
                    // Another interface callback
                }
            }
    }

    override fun showBikes(bikes: List<CityBike>) {
        bikesAdapter.submitList(bikes)
    }

    override fun showAllIdBikes(bikes: List<AllIdEntity>) {

        //String array to store all the id company names
        val items = arrayOfNulls<String>(bikes.size)
        //Traversing through the whole list to get all the id
        for (i in bikes.indices) {
            //Storing names to string array
            items[i] = bikes.get(i).id
        }
        //Spinner spinner = (Spinner) findViewById(R.id.appcompatSpinner);
        val aa: ArrayAdapter<String?>
        // Create an ArrayAdapter using a simple spinner layout and id company array
        aa = ArrayAdapter(requireContext(), R.layout.simple_spinner_item, items)
        // Set layout to use when the list of choices appear
        aa.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        viewBinding.appcompatSpinner.setAdapter(aa)
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