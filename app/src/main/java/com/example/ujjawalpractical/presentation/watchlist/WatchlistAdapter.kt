package com.example.ujjawalpractical.presentation.watchlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ujjawalpractical.data.local.entity.WatchlistEntity
import com.example.ujjawalpractical.databinding.ItemWatchlistBinding
class WatchlistAdapter(
    private val onDeleteClick: (WatchlistEntity) -> Unit
) : ListAdapter<WatchlistEntity, WatchlistAdapter.ViewHolder>(DiffCallback()) {

    inner class ViewHolder(
        private val binding: ItemWatchlistBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: WatchlistEntity) {

            binding.tvTitle.text = movie.title
            binding.tvRating.text = movie.rating.toString()

            val imageUrl = "https://image.tmdb.org/t/p/w500${movie.posterUrl}"

            binding.ivPoster.load(imageUrl) {
                crossfade(true)
            }

            binding.btnDelete.setOnClickListener {
                onDeleteClick(movie)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemWatchlistBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DiffCallback : DiffUtil.ItemCallback<WatchlistEntity>() {
        override fun areItemsTheSame(
            oldItem: WatchlistEntity,
            newItem: WatchlistEntity
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: WatchlistEntity,
            newItem: WatchlistEntity
        ): Boolean {
            return oldItem == newItem
        }
    }
}