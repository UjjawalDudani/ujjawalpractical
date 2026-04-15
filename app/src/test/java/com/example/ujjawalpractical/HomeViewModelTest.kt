package com.example.ujjawalpractical

import com.example.ujjawalpractical.domain.usecase.GetPopularMoviesUseCase
import com.example.ujjawalpractical.presentation.home.HomeViewModel
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {

    private val useCase: GetPopularMoviesUseCase = mockk()

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setup() {
        every { useCase.invoke() } returns flowOf(mockk())
        viewModel = HomeViewModel(useCase)
    }

    @Test
    fun `movies flow should not be null`() = runTest {
        // WHEN
        val result = viewModel.movies

        // THEN
        assertNotNull(result)
    }
}