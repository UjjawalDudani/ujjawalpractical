package com.example.ujjawalpractical.domain.usecase

import com.example.ujjawalpractical.domain.repository.WatchlistRepository
import javax.inject.Inject

class GetWatchlistUseCase @Inject constructor(
    private val repository: WatchlistRepository
) {
    operator fun invoke() = repository.getWatchlist()
}