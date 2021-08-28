package ui.smartpro.geekbrainskursovoimvp.presentation.citybikes

import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.SingleState
import ui.smartpro.geekbrainskursovoimvp.data.model.CityBike
import ui.smartpro.geekbrainskursovoimvp.presentation.ScreenView

interface BikesView : ScreenView {

    /**
     * Показывает список байков.
     * @param bikes список пользователей
     */
    @SingleState
    fun showBikes(bikes: List<CityBike>)

    @AddToEndSingle
    fun showSourceBikes(bikes: List<CityBike>)

}