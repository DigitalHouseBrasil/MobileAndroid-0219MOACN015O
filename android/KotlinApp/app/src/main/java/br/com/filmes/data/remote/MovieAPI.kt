package br.com.filmes.data.remote

import br.com.filmes.model.MovieResult
import io.reactivex.Observable
import retrofit2.http.GET

interface MovieAPI {

    @GET("Movies")
    fun getAllMovies() : Observable<List<MovieResult>>
}