package com.example.ujjawalpractical.domain.repository

import com.example.ujjawalpractical.data.local.entity.WatchlistEntity
import kotlinx.coroutines.flow.Flow

interface WatchlistRepository {

    suspend fun addToWatchlist(movie: WatchlistEntity)

    suspend fun removeFromWatchlist(movie: WatchlistEntity)

    fun getWatchlist(): Flow<List<WatchlistEntity>>

    fun isInWatchlist(id: Int): Flow<Boolean>
}