package ui.smartpro.geekbrainskursovoimvp.source

import android.content.Context
import io.reactivex.Single
import javax.inject.Inject

class SourceImpl @Inject constructor
(private val context: Context) : Source {
    override fun sourceString(uri: String): Single<String> =
            OpenSource(context, uri)
}