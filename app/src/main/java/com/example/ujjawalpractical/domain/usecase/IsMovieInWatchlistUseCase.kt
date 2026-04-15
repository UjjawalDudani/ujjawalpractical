package com.example.ujjawalpractical.domain.usecase

import com.example.ujjawalpractical.domain.repository.WatchlistRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class IsMovieInWatchlistUseCase @Inject constructor(
    private val repository: WatchlistRepository
) {
    operator fun invoke(movieId: Int): Flow<Boolean> {
        return repository.isInWatchlist(movieId)
    }
}