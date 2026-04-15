package com.example.ujjawalpractical.data.local.dao

import androidx.room.*
import com.example.ujjawalpractical.data.local.entity.WatchlistEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WatchlistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: WatchlistEntity)

    @Delete
    suspend fun delete(movie: WatchlistEntity)

    @Query("SELECT * FROM watchlist")
    fun getAllWatchlist(): Flow<List<WatchlistEntity>>

    @Query("SELECT EXISTS(SELECT 1 FROM watchlist WHERE id = :id)")
    fun isSaved(id: Int): Flow<Boolean>
}