package ui.smartpro.geekbrainskursovoimvp.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import ui.smartpro.geekbrainskursovoimvp.data.dao.BikeIdDao
import ui.smartpro.geekbrainskursovoimvp.data.dao.CityBikeDao

/**
 * Перечисляем сущности в аннотации, наследуемся от RoomDatabase и перечисляем DAO
 * в виде абстрактных полей. Остальной код — для временного Singletone, пока в проект не добавится DI.
 */
@androidx.room.Database(
    exportSchema = false,
    entities = [NetworksItemEntity::class, NetworkEntity::class,],
    version = 1)
abstract class Database : RoomDatabase() {
    abstract val cityBikeDao:CityBikeDao
    abstract val bikeIdDao: BikeIdDao

    companion object {
        private const val DB_NAME = "database.db"
        private var instance: Database? = null
        fun getInstance() = instance ?: throw RuntimeException("Database has not been created. Please call create(context)")

        fun create(context: Context?) {
            if (instance == null) {
                instance = Room.databaseBuilder(context!!, Database::class.java, DB_NAME)
                    .build()
            }
        }
    }
}