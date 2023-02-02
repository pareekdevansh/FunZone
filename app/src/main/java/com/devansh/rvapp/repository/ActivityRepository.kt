package com.devansh.rvapp.repository

import com.devansh.rvapp.api.RetrofitBuilder

class ActivityRepository constructor(private val retrofitBuilder: RetrofitBuilder) {
    suspend fun getActivity() = retrofitBuilder.getActivityApiInterface().getActivity()
}