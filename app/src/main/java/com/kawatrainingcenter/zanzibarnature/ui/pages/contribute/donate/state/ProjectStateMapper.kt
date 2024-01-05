package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.donate.state


import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Project
import javax.inject.Inject

class ProjectStateMapper @Inject constructor() {
    fun map(
        project: Project
    ): ProjectState {
        return ProjectState.Success(
            project
        )
    }
}