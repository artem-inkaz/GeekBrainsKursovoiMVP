package ui.smartpro.geekbrainskursovoimvp.source

import android.content.Context
import android.content.Intent
import android.net.Uri
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.MainThreadDisposable
import java.util.concurrent.Executors

class OpenSource(
        private val context: Context,
        private val uri: String,
) : Single<String>() {

    override fun subscribeActual(observer: SingleObserver<in String>) {
        val listener = SourceListener(context, uri, observer)
        observer.onSubscribe(listener)
        listener.convert()
    }

    class SourceListener(
            private val context: Context,
            private val uri: String,
            private val observer: SingleObserver<in String>,
    ) : MainThreadDisposable(), Runnable {

        private val openSourceTask by lazy {
            Executors
                    .newSingleThreadExecutor()
                    .submit(this)
        }

        fun convert() {
            openSourceTask
        }

        override fun run() {
            try {
                context.startActivity(Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse(uri)
                })

                openSourceTask
                        ?.takeIf { !isDisposed }
                        ?.takeIf { task -> !task.isDone }
                        ?.takeIf { task -> !task.isCancelled }
                        ?.let { observer.onSuccess(uri) }
            } catch (error: Throwable) {
                observer.onError(error)
            } finally {

            }
        }

        override fun onDispose() {
            openSourceTask
                    ?.takeIf { !isDisposed }
                    ?.takeIf { task -> !task.isDone }
                    ?.takeIf { task -> !task.isCancelled }
                    ?.cancel(true)
        }

    }
}