package com.example.ujjawalpractical.domain.usecase

import com.example.ujjawalpractical.data.local.entity.WatchlistEntity
import com.example.ujjawalpractical.domain.repository.WatchlistRepository
import javax.inject.Inject

class RemoveFromWatchlistUseCase @Inject constructor(
    private val repository: WatchlistRepository
) {
    suspend operator fun invoke(movie: WatchlistEntity) {
        repository.removeFromWatchlist(movie)
    }
}