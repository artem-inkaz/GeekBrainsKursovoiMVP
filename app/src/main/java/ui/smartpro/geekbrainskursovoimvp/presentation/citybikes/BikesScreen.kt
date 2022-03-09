package ui.smartpro.geekbrainskursovoimvp.presentation.citybikes

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

object BikesScreen : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
            CityBikesFragment.newInstance()
}