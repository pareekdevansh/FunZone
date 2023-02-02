package com.devansh.rvapp.repository

import com.devansh.rvapp.api.RetrofitBuilder

class JokesRepository constructor(private val retrofitBuilder: RetrofitBuilder){
    suspend fun getJoke()  = retrofitBuilder.getJokesApiInterface().getJoke()
}