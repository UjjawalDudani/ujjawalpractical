package com.example.ujjawalpractical.presentation.watchlist

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ujjawalpractical.databinding.ActivityWatchlistBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WatchlistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWatchlistBinding
    private val viewModel: WatchlistViewModel by viewModels()
    private lateinit var adapter: WatchlistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWatchlistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        observeWatchlist()
    }

    private fun setupRecyclerView() {
        adapter = WatchlistAdapter { movie ->
            viewModel.removeMovie(movie)
        }

        binding.rvWatchlist.layoutManager = LinearLayoutManager(this)
        binding.rvWatchlist.adapter = adapter
    }

    private fun observeWatchlist() {
        lifecycleScope.launch {
            viewModel.getWatchlist().collect {
                adapter.submitList(it)
            }
        }
    }
}