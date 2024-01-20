package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.donate

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Project
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.repository.KawaRepository
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.donate.state.ProjectState
import com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.donate.state.ProjectStateMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DonateViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val kawaRepository: KawaRepository,
    private val savedStateHandle: SavedStateHandle,
    private val projectStateMapper: ProjectStateMapper
) : ViewModel() {

    private val mutableEntered = MutableStateFlow(0)
    val entered: StateFlow<Int> = mutableEntered

    private val _project = MutableStateFlow<ProjectState>(ProjectState.Loading)
    val project: StateFlow<ProjectState> = _project

    init {
       loadPage()
    }

    fun loadPage() {
        viewModelScope.launch {
            savedStateHandle.getStateFlow("project_name", "")
                .collectLatest { id ->
                    fetchProject(id)
                }
        }
    }

    fun updateEntered(amount: Int) {
        mutableEntered.value = amount
    }

    private suspend fun fetchProject(id: String) {
        _project.value = ProjectState.Loading

        kawaRepository.getProject(id)
            .onSuccess { _project.value = projectStateMapper.map(it) }
            .getOrElse {
                _project.value = ProjectState.Error(
                    it.message ?: context.getString(R.string.error_message)
                )
            }
    }

}