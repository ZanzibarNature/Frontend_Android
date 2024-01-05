package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.main

import android.content.Context
import androidx.lifecycle.ViewModel
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.repository.KawaRepository
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.main.state.ProjectsState
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.main.state.ProjectsStateMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ContributeViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val kawaRepository: KawaRepository,
    private val projectsStateMapper: ProjectsStateMapper
) : ViewModel() {

    private val _projects = MutableStateFlow<ProjectsState>(ProjectsState.Loading)
    val projects: StateFlow<ProjectsState> = _projects

    init {
        fetchProjects()
    }

    private fun fetchProjects() {
        _projects.value = ProjectsState.Loading

        kawaRepository.getProjects()
            .onSuccess { _projects.value = projectsStateMapper.map(it.projects) }
            .getOrElse {
                _projects.value = ProjectsState.Error(
                    it.message ?: context.getString(R.string.error_message)
                )
            }
    }


}