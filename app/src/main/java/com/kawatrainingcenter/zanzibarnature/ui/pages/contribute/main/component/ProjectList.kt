package com.kawatrainingcenter.zanzibarnature.ui.pages.contribute.main.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Project
import com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.component.LocationCard

@Composable
fun ProjectList(
    projects: List<Project>,
    onProjectClick: (String) -> Unit
) {
    Box(modifier = Modifier.padding(top = 8.dp)) {
        LazyColumn {
            items(projects.count()) {
                val item = projects[it]
                ProjectCard(
                    project = item,
                    onClick = { onProjectClick(item.name) }
                )
            }
        }
    }
}