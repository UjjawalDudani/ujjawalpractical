package com.example.ujjawalpractical.presentation.detail

import com.example.ujjawalpractical.domain.model.MovieDetail

data class DetailUiState(
    val isLoading: Boolean = false,
    val data: MovieDetail? = null,
    val error: String? = null
)