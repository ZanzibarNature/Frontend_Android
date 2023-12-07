package com.kawatrainingcenter.zanzibarnature.data.MockAPI.mapper

import android.util.Log
import retrofit2.Response
import javax.inject.Inject

class ResponseMapper @Inject constructor() {
    fun <T> map(response: Response<T>): Result<T> {
        return when {
            response.isSuccessful -> Result.success(
                response.body() ?: return Result.failure(IllegalStateException("Empty body"))
            )
            else -> {
                Log.e(
                    "ResponseMapper",
                    "map: ${response.errorBody()?.string() ?: "Code: ${response.code()}"}"
                )
                Result.failure(
                    IllegalStateException(response.errorBody()?.string() ?: "Unknown error")
                )
            }
        }
    }
}