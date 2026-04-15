package com.example.ujjawalpractical.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.ujjawalpractical.domain.model.Movie
import com.example.ujjawalpractical.domain.usecase.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: GetPopularMoviesUseCase
) : ViewModel() {

    val movies = useCase()
        .cachedIn(viewModelScope)
}