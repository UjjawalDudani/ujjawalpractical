package com.example.ujjawalpractical.domain.usecase

import com.example.ujjawalpractical.domain.repository.MovieRepository
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke() =
        repository.getPopularMovies()
}