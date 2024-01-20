package com.kawatrainingcenter.zanzibarnature.data.kawaApi.entity

import kotlinx.serialization.Serializable

@Serializable
data class ImageUrls(
    val BannerImage: String,
    val AdditionalImage1: String,
    val AdditionalImage2: String
)