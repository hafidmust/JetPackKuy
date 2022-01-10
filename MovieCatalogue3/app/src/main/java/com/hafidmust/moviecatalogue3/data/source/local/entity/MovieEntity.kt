package com.hafidmust.moviecatalogue3.data.source.local.entity

import com.google.gson.annotations.SerializedName

data class MovieEntity(
    @SerializedName("id")
    val id: Int,
    @SerializedName("poster_path")
    val posterPath: String,
)
