package com.kawatrainingcenter.zanzibarnature.data.kawaApi.entity

data class ProjectEntity (
    val title: String,
    val subtitle: String?,
    val mainText: String,
    val partitionKey: String,
    val rowKey: String,
    val timestamp: String,
    val serializedImageURLs: String
)
data class ProjectsEntity (
    val item1: String?,
    val item2: List<ProjectEntity>
)
