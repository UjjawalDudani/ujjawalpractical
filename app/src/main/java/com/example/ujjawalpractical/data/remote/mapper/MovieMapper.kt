package com.example.ujjawalpractical.data.remote.mapper

import com.example.ujjawalpractical.data.remote.dto.MovieDetailDto
import com.example.ujjawalpractical.data.remote.dto.MovieDto
import com.example.ujjawalpractical.domain.model.Movie
import com.example.ujjawalpractical.domain.model.MovieDetail

fun MovieDto.toDomain(): Movie {
    return Movie(
        id = id,
        title = title,
        posterUrl = "https://image.tmdb.org/t/p/w500$poster_path",
        year = release_date?.take(4) ?: "N/A",
        rating = vote_average
    )
}

fun MovieDetailDto.toDomain(): MovieDetail {
    return MovieDetail(
        id = id,
        title = title,
        overview = overview ?: "",
        posterPath = posterPath ?: "",
        rating = rating ?: 0.0,
        releaseDate = releaseDate ?: "",
        runtime = runtime ?: 0,
        genres = genres?.map { it.name } ?: emptyList()
    )
}