package com.example.ujjawalpractical.domain.usecase

import androidx.paging.PagingData
import com.example.ujjawalpractical.domain.model.Movie
import com.example.ujjawalpractical.domain.repository.MovieRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetPopularMoviesUseCaseTest {

    private val repository: MovieRepository = mockk()

    private lateinit var useCase: GetPopularMoviesUseCase

    private val fakePagingData = PagingData.from(
        listOf(
            Movie(id = 1, title = "Movie 1","",0.0,""),
            Movie(id = 2, title = "Movie 2","",1.0,"")
        )
    )

    @Before
    fun setup() {
        every { repository.getPopularMovies() } returns flowOf(fakePagingData)

        useCase = GetPopularMoviesUseCase(repository)
    }

    @Test
    fun `invoke should return paging data from repository`() = runTest {
        // WHEN
        val resultFlow = useCase()

        // THEN
        val emitted = resultFlow.first()

        assertEquals(fakePagingData, emitted)

        verify(exactly = 1) { repository.getPopularMovies() }
    }
}