package com.example.ujjawalpractical.presentation.watchlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ujjawalpractical.data.local.entity.WatchlistEntity
import com.example.ujjawalpractical.domain.usecase.GetWatchlistUseCase
import com.example.ujjawalpractical.domain.usecase.RemoveFromWatchlistUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WatchlistViewModel @Inject constructor(
    private val getWatchlistUseCase: GetWatchlistUseCase,
    private val removeFromWatchlistUseCase: RemoveFromWatchlistUseCase
) : ViewModel() {

    fun getWatchlist(): Flow<List<WatchlistEntity>> {
        return getWatchlistUseCase()
    }

    fun removeMovie(movie: WatchlistEntity) {
        viewModelScope.launch {
            removeFromWatchlistUseCase(movie)
        }
    }
}