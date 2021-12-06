package com.ghost.moviedb.model.videos


import com.google.gson.annotations.SerializedName

data class VideoModelApi(
    @SerializedName("id")
    val id: Int,
    @SerializedName("results")
    val results: List<Result>
)