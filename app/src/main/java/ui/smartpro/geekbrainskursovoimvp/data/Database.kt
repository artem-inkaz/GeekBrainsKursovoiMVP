package ui.smartpro.geekbrainskursovoimvp.data

import androidx.room.RoomDatabase
import ui.smartpro.geekbrainskursovoimvp.data.dao.AllIdDao
import ui.smartpro.geekbrainskursovoimvp.data.dao.BikeIdDao
import ui.smartpro.geekbrainskursovoimvp.data.dao.CityBikeDao
import ui.smartpro.geekbrainskursovoimvp.data.entities.AllIdEntity

/**
 * Перечисляем сущности в аннотации, наследуемся от RoomDatabase и перечисляем DAO
 * в виде абстрактных полей. Остальной код — для временного Singletone, пока в проект не добавится DI.
 */
@androidx.room.Database(
        exportSchema = false,
        entities = [NetworksItemEntity::class, NetworkEntity::class, AllIdEntity::class],
        version = 1)
abstract class Database : RoomDatabase() {
    abstract val cityBikeDao: CityBikeDao
    abstract val bikeIdDao: BikeIdDao
    abstract val allIdDao: AllIdDao
}