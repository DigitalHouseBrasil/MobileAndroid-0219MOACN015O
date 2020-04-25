package br.com.filmes.repository

import br.com.filmes.data.remote.RetrofitService
import br.com.filmes.model.MovieResult
import io.reactivex.Observable

class MovieRepository {
    fun getMovies(): Observable<List<MovieResult>>{
        return RetrofitService.service.getAllMovies()
    }
}