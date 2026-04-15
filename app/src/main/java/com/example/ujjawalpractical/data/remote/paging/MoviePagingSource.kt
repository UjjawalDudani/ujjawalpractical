package com.example.ujjawalpractical.data.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.ujjawalpractical.data.remote.ApiConstants
import com.example.ujjawalpractical.data.remote.api.MovieApiService
import com.example.ujjawalpractical.data.remote.mapper.toDomain
import com.example.ujjawalpractical.domain.model.Movie

class MoviePagingSource(
    private val api: MovieApiService
) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {

            val page = params.key ?: 1

            val response = api.getPopularMovies(apiKey = "Bearer " + ApiConstants.API_KEY, page = page)
            Log.d("ujjawal", "load: "+response)
            val movies = response.results?.map { dto ->
                dto.toDomain()
            } ?: emptyList()

            LoadResult.Page(
                data = movies,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (movies.isEmpty()) null else page + 1
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { position ->
            val page = state.closestPageToPosition(position)
            page?.prevKey?.plus(1) ?: page?.nextKey?.minus(1)
        }
    }
}