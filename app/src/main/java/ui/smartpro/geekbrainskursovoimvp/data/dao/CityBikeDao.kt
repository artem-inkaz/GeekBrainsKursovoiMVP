package ui.smartpro.geekbrainskursovoimvp.data.dao

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import ui.smartpro.geekbrainskursovoimvp.data.NetworksItemEntity

@Dao
interface CityBikeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(network: NetworksItemEntity): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(networks: List<NetworksItemEntity>): Completable

    @Delete
    fun delete(network: NetworksItemEntity): Completable

    @Delete
    fun deleteAll(networks: List<NetworksItemEntity>): Completable

    @Query("DELETE FROM city_bike")
    fun deleteAll(): Completable

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(network: NetworksItemEntity): Completable

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateAll(networks: List<NetworksItemEntity>): Completable

    @Query("SELECT * FROM city_bike")
    fun fetchCityBikeItems(): Observable<List<NetworksItemEntity>>
}