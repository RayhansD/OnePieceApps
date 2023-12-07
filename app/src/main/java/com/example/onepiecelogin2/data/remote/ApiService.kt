package com.example.onepiecelogin2.data.remote

import com.example.onepiecelogin2.data.remote.response.IndodaxResponse

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("/pairs")
    suspend fun getMovies(
    ) : Response<IndodaxResponse>
}