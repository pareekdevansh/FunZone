package com.devansh.rvapp.api

import com.devansh.rvapp.model.JokeResponse
import retrofit2.Response
import retrofit2.http.GET

interface JokeInterface {
    @GET("Any")
    suspend fun getJoke() : Response<JokeResponse>
}