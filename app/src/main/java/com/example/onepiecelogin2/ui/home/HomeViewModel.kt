package com.example.onepiecelogin2.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onepiecelogin2.Repository
import com.example.onepiecelogin2.data.remote.response.IndodaxResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel(private val repository: Repository): ViewModel() {
    private val getMovies = MutableLiveData<Response<IndodaxResponse>>()
    val observeMovie: LiveData<Response<IndodaxResponse>> = getMovies

    fun getMovies(){
        viewModelScope.launch {
            try{
                val result = repository.getMovies()
                Log.d("viewModel", "getMovies: $result")
                getMovies.postValue(result)
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}