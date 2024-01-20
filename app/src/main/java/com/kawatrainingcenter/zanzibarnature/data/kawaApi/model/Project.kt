package com.kawatrainingcenter.zanzibarnature.data.kawaApi.model

data class Project(
    val id: String,
    val name: String,
    val description: String,
    val image: String
)

data class Projects(
    val projects: List<Project>
)