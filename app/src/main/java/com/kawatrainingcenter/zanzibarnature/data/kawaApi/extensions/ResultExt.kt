package com.kawatrainingcenter.zanzibarnature.data.kawaApi.extensions

fun <T> Result<Result<T>>.flatten(): Result<T> {
    return runCatching {
        getOrThrow().getOrThrow()
    }
}