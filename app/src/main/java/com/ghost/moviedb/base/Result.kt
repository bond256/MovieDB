package com.ghost.moviedb.base

import java.lang.Exception

sealed class Result<T> {
    data class onLoading<T>(val res: T? = null) : Result<T>()
    data class onSuccess<T>(val data: T) : Result<T>()
    data class onFailure<T>(val exception: Exception) : Result<T>()
}
