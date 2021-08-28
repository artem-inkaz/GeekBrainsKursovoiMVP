package ui.smartpro.geekbrainskursovoimvp.source

import moxy.viewstate.strategy.alias.AddToEndSingle
import ui.smartpro.geekbrainskursovoimvp.presentation.ScreenView

interface SourceView : ScreenView {

    @AddToEndSingle
    fun showContent(uri: String?)

}