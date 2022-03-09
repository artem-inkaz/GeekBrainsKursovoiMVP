package ui.smartpro.geekbrainskursovoimvp.source

import io.reactivex.Single

interface Source {

    /**
     *
     */
    fun sourceString(uri: String): Single<String>
}