package com.devansh.rvapp.api

import com.devansh.rvapp.model.MemeResponse
import retrofit2.Response
import retrofit2.http.GET

interface MemeInterface {

    @GET("get_memes")
    suspend fun getMemes() : Response<MemeResponse>
}