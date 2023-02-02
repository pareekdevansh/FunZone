package com.devansh.rvapp.model

data class ActivityResponse(
    val accessibility: Int,
    val activity: String,
    val key: String,
    val link: String,
    val participants: Int,
    val price: Int,
    val type: String
)