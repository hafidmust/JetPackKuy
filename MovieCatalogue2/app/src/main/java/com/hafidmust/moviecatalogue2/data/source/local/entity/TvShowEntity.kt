package com.hafidmust.moviecatalogue2.data.source.local.entity

import com.google.gson.annotations.SerializedName

data class TvShowEntity(
    @SerializedName("id")
    val id: Int,
    @SerializedName("poster_path")
    val posterPath: String,
)
