package com.example.ujjawalpractical.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ujjawalpractical.data.local.entity.WatchlistEntity
import com.example.ujjawalpractical.domain.usecase.AddToWatchlistUseCase
import com.example.ujjawalpractical.domain.usecase.GetMovieDetailUseCase
import com.example.ujjawalpractical.domain.usecase.IsMovieInWatchlistUseCase
import com.example.ujjawalpractical.domain.usecase.RemoveFromWatchlistUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val addToWatchlistUseCase: AddToWatchlistUseCase,
    private val removeFromWatchlistUseCase: RemoveFromWatchlistUseCase,
    private val isMovieInWatchlistUseCase: IsMovieInWatchlistUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState: StateFlow<DetailUiState> = _uiState

    private val _isSaved = MutableStateFlow(false)
    val isSaved: StateFlow<Boolean> = _isSaved

    fun loadMovie(movieId: Int) {
        viewModelScope.launch {
            _uiState.value = DetailUiState(isLoading = true)

            try {
                val result = getMovieDetailUseCase(movieId)
                _uiState.value = DetailUiState(data = result)

                checkWatchlist(movieId)

            } catch (e: Exception) {
                _uiState.value = DetailUiState(error = e.message ?: "Something went wrong")
            }
        }
    }

    private fun checkWatchlist(movieId: Int) {
        viewModelScope.launch {
            isMovieInWatchlistUseCase(movieId).collect {
                _isSaved.value = it
            }
        }
    }

    fun observeWatchlistStatus(movieId: Int) {
        viewModelScope.launch {
            isMovieInWatchlistUseCase(movieId).collect {
                _isSaved    .value = it
            }
        }
    }
    fun toggleWatchlist(movie: WatchlistEntity) {
        viewModelScope.launch {

            val isSaved = _isSaved.value

            if (isSaved) {
                removeFromWatchlistUseCase(movie)
            } else {
                addToWatchlistUseCase(movie)
            }

            // IMPORTANT: re-check after update
            isMovieInWatchlistUseCase(movie.id).collect {
                _isSaved.value = it
            }
        }
    }
}