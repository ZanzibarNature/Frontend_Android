package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.main.state

import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Project

sealed class ProjectsState {
    data class Success(
        val projects: List<Project>
    ): ProjectsState()

    object Loading: ProjectsState()

    data class Error(val message: String): ProjectsState()
}