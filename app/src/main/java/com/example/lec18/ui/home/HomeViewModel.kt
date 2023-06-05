package com.example.lec18.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lec18.TMDBApp
import com.example.lec18.data.AppDatabase
import com.example.lec18.data.models.Movie
import com.example.lec18.data.repository.MovieRepository
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {



    val movies: LiveData<List<Movie>> = TMDBApp.db.movieDao().getMovies()

    init {
        viewModelScope.launch {
            TMDBApp.movieRepository.refreshMovies()
        }
    }
}