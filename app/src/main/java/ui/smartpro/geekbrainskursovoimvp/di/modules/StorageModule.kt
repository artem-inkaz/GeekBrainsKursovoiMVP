package ui.smartpro.geekbrainskursovoimvp.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ui.smartpro.geekbrainskursovoimvp.data.Database
import javax.inject.Singleton

@Module
class StorageModule {

    @Singleton
    @Persisted
    @Provides
    fun provideDatabaseStorage(context: Context): Database =
            Room.databaseBuilder(context, Database::class.java, "citybikes.db")
                    .build()

    @Singleton
    @InMemory
    @Provides
    fun provideInMemoryStorage(context: Context): Database =
            Room.inMemoryDatabaseBuilder(context, Database::class.java)
                    .fallbackToDestructiveMigration()
                    .build()
}