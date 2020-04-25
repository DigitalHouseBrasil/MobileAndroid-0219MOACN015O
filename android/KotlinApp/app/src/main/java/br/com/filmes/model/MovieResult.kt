package br.com.filmes.model

import java.io.Serializable

data class MovieResult(
    val backdrops_url: List<String>,
    val cover_url: String,
    val duration: String,
    val id: String,
    val overview: String,
    val release_year: String,
    val title: String
) : Serializable