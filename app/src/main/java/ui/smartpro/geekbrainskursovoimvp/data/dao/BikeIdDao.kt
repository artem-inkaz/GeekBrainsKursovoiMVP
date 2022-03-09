package ui.smartpro.geekbrainskursovoimvp.data.dao

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import ui.smartpro.geekbrainskursovoimvp.data.NetworkEntity
import ui.smartpro.geekbrainskursovoimvp.data.StationsItem

@Dao
interface BikeIdDao {

    @Query("SELECT * FROM bike_id WHERE shref_Id LIKE  :shrefId")
    fun getBikeId(shrefId: String): Observable<List<NetworkEntity>>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(bike: NetworkEntity): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(bike: NetworkEntity): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(networks: List<NetworkEntity>): Completable

    @Delete
    fun delete(bike: NetworkEntity): Completable

}