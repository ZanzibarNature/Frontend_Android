package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.donate.state

import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Project

sealed class ProjectState {
    data class Success(
        val project: Project
    ): ProjectState()

    object Loading: ProjectState()

    data class Error(val message: String): ProjectState()
}