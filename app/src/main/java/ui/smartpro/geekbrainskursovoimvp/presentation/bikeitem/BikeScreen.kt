package ui.smartpro.geekbrainskursovoimvp.presentation.bikeitem

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class BikeScreen(private val bikeId: String) : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
            BikeItemFragment.newInstance(bikeId)
}