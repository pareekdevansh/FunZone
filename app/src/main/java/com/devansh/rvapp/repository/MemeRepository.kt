package com.devansh.rvapp.repository

import com.devansh.rvapp.api.RetrofitBuilder

class MemeRepository constructor(private val retrofitBuilder: RetrofitBuilder) {
    suspend fun getMemes() = retrofitBuilder.getMemeApiInterface().getMemes()
}