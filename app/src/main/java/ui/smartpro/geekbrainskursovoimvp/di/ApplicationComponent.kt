package ui.smartpro.geekbrainskursovoimvp.di

import android.content.Context
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ui.smartpro.geekbrainskursovoimvp.cicerone.App
import ui.smartpro.geekbrainskursovoimvp.di.modules.ApiModule
import ui.smartpro.geekbrainskursovoimvp.di.modules.StorageModule
import ui.smartpro.geekbrainskursovoimvp.di.modules.UsersModule
import ui.smartpro.geekbrainskursovoimvp.scheduler.Schedulers
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, ApiModule::class, StorageModule::class, UsersModule::class])
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withRouter(router: Router): Builder

        @BindsInstance
        fun withNavigationHolder(navigatorHolder: NavigatorHolder): Builder

        @BindsInstance
        fun withSchedulers(schedulers: Schedulers): Builder

        fun build(): ApplicationComponent
    }
}