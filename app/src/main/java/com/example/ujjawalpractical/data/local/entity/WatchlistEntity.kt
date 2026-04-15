package com.example.ujjawalpractical.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "watchlist")
data class WatchlistEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val posterUrl: String,
    val rating: Double
)