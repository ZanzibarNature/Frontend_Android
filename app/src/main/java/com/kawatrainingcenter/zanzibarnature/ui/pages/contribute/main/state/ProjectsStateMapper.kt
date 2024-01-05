package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.main.state


import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Project
import javax.inject.Inject

class ProjectsStateMapper @Inject constructor() {
    fun map(
        projects: List<Project>
    ): ProjectsState {
        return ProjectsState.Success(
            projects
        )
    }
}