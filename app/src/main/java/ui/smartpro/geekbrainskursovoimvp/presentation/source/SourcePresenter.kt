package ui.smartpro.geekbrainskursovoimvp.source

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import moxy.MvpPresenter
import ui.smartpro.geekbrainskursovoimvp.scheduler.Schedulers

class SourcePresenter(
        private val source: Source,
        private val schedulers: Schedulers,
) : MvpPresenter<SourceView>() {

    private val disposables = CompositeDisposable()

    fun sourceOpen(uri: String) {

        disposables +=
                source
                        .sourceString(uri)
                        .observeOn(schedulers.main())
                        .subscribeOn(schedulers.background())
                        .subscribe(
                                viewState::showContent,
                                viewState::showError
                        )
    }

    fun cancel() {
        viewState.showContent(null)
        disposables.clear()
    }

    override fun onDestroy() = disposables.clear()
}