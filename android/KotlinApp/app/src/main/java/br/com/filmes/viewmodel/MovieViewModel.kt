package br.com.filmes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.filmes.model.MovieResult
import br.com.filmes.repository.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MovieViewModel : ViewModel() {
    private val disposable = CompositeDisposable()
    private val movieList: MutableLiveData<List<MovieResult>> = MutableLiveData()
    val movieListResult: LiveData<List<MovieResult>> = movieList
    private val loading: MutableLiveData<Boolean> = MutableLiveData()
    val loadingResult: LiveData<Boolean> = loading
    private val error: MutableLiveData<String> = MutableLiveData()
    val errorResult: LiveData<String> = error
    private val repository = MovieRepository()

    fun getAllMovies() {
        disposable.add(
            repository.getMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { loading.value = true }
                .doAfterTerminate { loading.value = false }
                .subscribe({
                    movieList.value = it
                }, { e ->
                    error.value = e.message
                })

        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}