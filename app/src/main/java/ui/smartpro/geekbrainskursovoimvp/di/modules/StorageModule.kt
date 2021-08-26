package ui.smartpro.geekbrainskursovoimvp.di.modules

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import dagger.Module
import dagger.Provides

@Module
class StorageModule {

    @Persisted
    @Provides
    fun provideDatabaseStorage(context: Context): ui.smartpro.geekbrainskursovoimvp.data.Database =
        Room.databaseBuilder(context, ui.smartpro.geekbrainskursovoimvp.data.Database::class.java, "citybikes.db")
//            .addMigrations(GitHub1to2Migration, GitHub2to3Migration)
            .build()

    @InMemory
    @Provides
    fun provideInMemoryStorage(context: Context): ui.smartpro.geekbrainskursovoimvp.data.Database =
        Room.inMemoryDatabaseBuilder(context, ui.smartpro.geekbrainskursovoimvp.data.Database::class.java)
            .fallbackToDestructiveMigration()
            .build()
}