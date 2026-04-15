package com.example.ujjawalpractical.presentation.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ujjawalpractical.databinding.ItemMovieBinding
import com.example.ujjawalpractical.domain.model.Movie
import com.example.ujjawalpractical.presentation.detail.DetailActivity

class MoviePagingAdapter :
    PagingDataAdapter<Movie, MoviePagingAdapter.MovieViewHolder>(DiffCallback) {

    inner class MovieViewHolder(
        private val binding: ItemMovieBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {

            binding.tvMovieTitle.text = movie.title
            binding.tvYear.text = movie.year ?: "N/A"
            binding.tvRating.text = "⭐ ${movie.rating}"

            val imageUrl = "https://image.tmdb.org/t/p/w500${movie.posterUrl}"

            binding.imgPoster.load(imageUrl) {
                crossfade(true)
            }

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra("movie_id", movie.id)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Movie>() {

            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }
}