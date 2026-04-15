package com.example.ujjawalpractical.data.repository

import com.example.ujjawalpractical.data.local.dao.WatchlistDao
import com.example.ujjawalpractical.data.local.entity.WatchlistEntity
import com.example.ujjawalpractical.domain.repository.WatchlistRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WatchlistRepositoryImpl @Inject constructor(
    private val dao: WatchlistDao
) : WatchlistRepository {

    override suspend fun addToWatchlist(movie: WatchlistEntity) {
        dao.insert(movie)
    }

    override suspend fun removeFromWatchlist(movie: WatchlistEntity) {
        dao.delete(movie)
    }

    override fun getWatchlist(): Flow<List<WatchlistEntity>> {
        return dao.getAllWatchlist()
    }

    override fun isInWatchlist(id: Int): Flow<Boolean> {
        return dao.isSaved(id)
    }
}