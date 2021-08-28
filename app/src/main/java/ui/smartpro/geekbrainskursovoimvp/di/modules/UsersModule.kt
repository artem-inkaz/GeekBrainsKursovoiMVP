package ui.smartpro.geekbrainskursovoimvp.di.modules

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import ui.smartpro.geekbrainskursovoimvp.datasource.datafromapi.DataFromApi
import ui.smartpro.geekbrainskursovoimvp.datasource.datafromapi.DataFromApiImpl
import ui.smartpro.geekbrainskursovoimvp.datasource.datafromcash.CashData
import ui.smartpro.geekbrainskursovoimvp.datasource.datafromcash.CashDataImpl
import ui.smartpro.geekbrainskursovoimvp.datasource.repository.Repository
import ui.smartpro.geekbrainskursovoimvp.datasource.repository.RepositoryImpl
import ui.smartpro.geekbrainskursovoimvp.presentation.abs.MainActivity
import ui.smartpro.geekbrainskursovoimvp.presentation.bikeitem.BikeItemFragment
import ui.smartpro.geekbrainskursovoimvp.presentation.citybikes.CityBikesFragment
import ui.smartpro.geekbrainskursovoimvp.source.Source
import ui.smartpro.geekbrainskursovoimvp.source.SourceImpl
import javax.inject.Singleton

@Module
interface UsersModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindCityBikesFragment(): CityBikesFragment

    @ContributesAndroidInjector
    fun bindBikeItemFragment(): BikeItemFragment

    @Singleton
    @Binds
    fun bindRepository(repository: RepositoryImpl): Repository
    @Binds
    fun bindDataFromApi(dataSource: DataFromApiImpl): DataFromApi
    @Binds
    fun bindCashData(cashUserDataSource: CashDataImpl):CashData

    @Binds
    fun bindSource(cashUserDataSource: SourceImpl): Source
}