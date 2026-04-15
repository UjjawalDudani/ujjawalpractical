package com.example.ujjawalpractical.presentation.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ujjawalpractical.R
import com.example.ujjawalpractical.databinding.ActivityHomeBinding
import com.example.ujjawalpractical.presentation.watchlist.WatchlistActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var adapter: MoviePagingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Popular Movies"

        setupRecyclerView()
        observeMovies()
    }

    private fun setupRecyclerView() {
        adapter = MoviePagingAdapter()

        binding.rvMovies.layoutManager = LinearLayoutManager(this)
        binding.rvMovies.adapter = adapter

        adapter.addLoadStateListener { loadState ->
            val isLoading = loadState.source.refresh is LoadState.Loading
            val isError = loadState.source.refresh is LoadState.Error

            binding.progressBar.isVisible = isLoading
            binding.tvError.isVisible = isError
            binding.rvMovies.isVisible = !isLoading && !isError
        }
    }

    private fun observeMovies() {
        lifecycleScope.launch {
            viewModel.movies.collectLatest { pagingData ->
                adapter.submitData(pagingData)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.menu_watchlist -> {
                startActivity(Intent(this, WatchlistActivity::class.java))
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}