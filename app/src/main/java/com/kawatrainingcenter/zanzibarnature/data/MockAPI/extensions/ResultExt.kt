package com.kawatrainingcenter.zanzibarnature.data.MockAPI.extensions

fun <T> Result<Result<T>>.flatten(): Result<T> {
    return runCatching {
        getOrThrow().getOrThrow()
    }
}