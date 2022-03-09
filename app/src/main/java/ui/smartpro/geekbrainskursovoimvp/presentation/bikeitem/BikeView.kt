package ui.smartpro.geekbrainskursovoimvp.presentation.bikeitem

import moxy.viewstate.strategy.alias.SingleState
import ui.smartpro.geekbrainskursovoimvp.data.NetworkEntity
import ui.smartpro.geekbrainskursovoimvp.presentation.ScreenView

interface BikeView : ScreenView {

    /**
     * Показывает список байков.
     * @param bikes список пользователей
     */
    @SingleState
    fun showBike(bikeId: List<NetworkEntity>)
}