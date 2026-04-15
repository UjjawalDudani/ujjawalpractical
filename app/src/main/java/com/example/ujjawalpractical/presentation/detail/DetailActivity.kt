package com.example.ujjawalpractical.presentation.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import coil.load
import com.example.ujjawalpractical.R
import com.example.ujjawalpractical.data.local.entity.WatchlistEntity
import com.example.ujjawalpractical.databinding.ActivityDetailBinding
import com.example.ujjawalpractical.presentation.watchlist.WatchlistActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val viewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Popular Movies"

        val movieId = intent.getIntExtra("movie_id", -1)

        observeState()

        if (movieId != -1) {
            viewModel.loadMovie(movieId)
        }
    }

    private fun observeState() {

        lifecycleScope.launch {
            viewModel.uiState.collect { state ->

                when {
                    state.isLoading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }

                    state.error != null -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tvTitle.text = state.error
                    }

                    state.data != null -> {
                        binding.progressBar.visibility = View.GONE
                        bindData(state.data)
                    }
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun bindData(movie: com.example.ujjawalpractical.domain.model.MovieDetail) {

        val imageUrl = "https://image.tmdb.org/t/p/w500${movie.posterPath}"

        binding.ivPoster.load(imageUrl) {
            crossfade(true)
        }

        binding.tvTitle.text = movie.title
        binding.tvOverview.text = movie.overview
        binding.tvRating.text = "Rating : ⭐ ${movie.rating}"
        binding.tvRuntime.text = formatRuntime(movie.runtime)
        binding.tvGenres.text = movie.genres.joinToString(", ")

        binding.btnWatchlist.setOnClickListener {
            val movie = WatchlistEntity(
                id = movie.id,
                title = movie.title ?: "",
                posterUrl = movie.posterPath,
                rating = movie.rating ?: 0.0
            )

            viewModel.toggleWatchlist(movie)
            viewModel.observeWatchlistStatus(movie.id)
        }

        lifecycleScope.launch {
            viewModel.isSaved.collect { isSaved ->

                binding.btnWatchlist.text =
                    if (isSaved) "Remove from Watchlist"
                    else "Add to Watchlist"
            }
        }
            }

    fun formatRuntime(minutes: Int): String {
        val hours = minutes / 60
        val mins = minutes % 60
        val secs = 0

        return String.format("%02d:%02d:%02d", hours, mins, secs)
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