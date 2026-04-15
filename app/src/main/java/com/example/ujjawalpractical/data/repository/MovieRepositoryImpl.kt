package com.example.ujjawalpractical.data.repository

import android.provider.SyncStateContract
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.ujjawalpractical.data.paging.MoviePagingSource
import com.example.ujjawalpractical.data.remote.ApiConstants
import com.example.ujjawalpractical.data.remote.api.MovieApiService
import com.example.ujjawalpractical.data.remote.mapper.toDomain
import com.example.ujjawalpractical.domain.model.Movie
import com.example.ujjawalpractical.domain.model.MovieDetail
import com.example.ujjawalpractical.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MovieApiService
) : MovieRepository {

    override fun getPopularMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                MoviePagingSource(api)
            }
        ).flow
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetail {
        return api.getMovieDetails(
            apiKey = "Bearer " + ApiConstants.API_KEY,
            movieId = movieId,
        ).toDomain()
    }
}