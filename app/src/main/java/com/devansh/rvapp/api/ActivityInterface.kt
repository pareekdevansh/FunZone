package com.devansh.rvapp.api

import com.devansh.rvapp.model.ActivityResponse
import retrofit2.Response
import retrofit2.http.GET

interface ActivityInterface {
    @GET("activity")
    suspend fun getTasks(): Response<ActivityResponse>
}