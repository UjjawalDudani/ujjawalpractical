package com.example.ujjawalpractical.domain.repository

import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.example.ujjawalpractical.domain.model.Movie
import com.example.ujjawalpractical.domain.model.MovieDetail
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getPopularMovies(): Flow<PagingData<Movie>>

    suspend fun getMovieDetails(movieId: Int): MovieDetail
}