package com.example.ujjawalpractical.data.remote.api

import com.example.ujjawalpractical.data.remote.dto.MovieDetailDto
import com.example.ujjawalpractical.data.remote.dto.MovieResponseDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Header("Authorization") apiKey: String,
        @Query("page") page: Int
    ): MovieResponseDto

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Header("Authorization") apiKey: String,
        @Path("movie_id") movieId: Int
    ): MovieDetailDto

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("api_key") apiKey: String,
        @Query("query") query: String,
        @Query("page") page: Int
    ): MovieResponseDto
}