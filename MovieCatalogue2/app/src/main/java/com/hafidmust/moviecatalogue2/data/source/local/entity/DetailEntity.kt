package com.hafidmust.moviecatalogue2.data.source.local.entity

import com.google.gson.annotations.SerializedName


data class DetailEntity(
    @field:SerializedName("id")
    val idEntity: Int,
    @field:SerializedName("original_title")
    val originalTitle: String,
    @field:SerializedName("overview")
    val overview: String,
    @field:SerializedName("release_date")
    val releaseDate: String,
    @field:SerializedName("vote_average")
    val voteAverage: Double,
    @field:SerializedName("poster_path")
    val posterPath: String,
)
