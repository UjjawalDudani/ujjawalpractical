package com.example.ujjawalpractical.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieDetailDto(

    val id: Int,

    val title: String,

    @SerializedName("overview")
    val overview: String?,

    @SerializedName("poster_path")
    val posterPath: String?,

    @SerializedName("vote_average")
    val rating: Double?,

    @SerializedName("release_date")
    val releaseDate: String?,

    @SerializedName("runtime")
    val runtime: Int?,

    @SerializedName("genres")
    val genres: List<GenreDto>?
)

data class GenreDto(
    val id: Int,
    val name: String
)