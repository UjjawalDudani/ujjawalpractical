package com.example.ujjawalpractical.domain.usecase

import com.example.ujjawalpractical.domain.model.MovieDetail
import com.example.ujjawalpractical.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    suspend operator fun invoke(movieId: Int): MovieDetail {
        return repository.getMovieDetails(movieId)
    }
}