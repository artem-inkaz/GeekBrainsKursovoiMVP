package ui.smartpro.geekbrainskursovoimvp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Observable
import ui.smartpro.geekbrainskursovoimvp.data.entities.AllIdEntity

@Dao
interface AllIdDao {

    @Query("SELECT * FROM city_bike")
    fun fetchAllIdItems(): Observable<List<AllIdEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(networks: List<AllIdEntity>): Completable
}