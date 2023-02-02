package com.devansh.rvapp.api

import com.devansh.rvapp.util.Constants.Companion.ACTIVITY_BASE_URL
import com.devansh.rvapp.util.Constants.Companion.JOKE_BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    fun getJokesApiInterface(): JokeInterface {
        return Retrofit.Builder().baseUrl(JOKE_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JokeInterface::class.java)
    }
    fun getActivityApiInterface() : ActivityInterface {
        return Retrofit.Builder().baseUrl(ACTIVITY_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ActivityInterface::class.java)
    }
}
