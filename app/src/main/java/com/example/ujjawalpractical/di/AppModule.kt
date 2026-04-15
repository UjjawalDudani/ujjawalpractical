package com.example.ujjawalpractical.di

import com.example.ujjawalpractical.data.remote.api.MovieApiService
import com.example.ujjawalpractical.data.repository.MovieRepositoryImpl
import com.example.ujjawalpractical.domain.repository.MovieRepository
import com.example.ujjawalpractical.domain.usecase.GetPopularMoviesUseCase
import com.example.ujjawalpractical.data.remote.ApiConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRepository(api: MovieApiService): MovieRepository {
        return MovieRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetPopularMoviesUseCase(
        repo: MovieRepository
    ): GetPopularMoviesUseCase {
        return GetPopularMoviesUseCase(repo)
    }
}