package com.kawatrainingcenter.zanzibarnature.ui.pages.explore_list.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kawatrainingcenter.zanzibarnature.data.model.Location

@Composable
fun LocationList (
    locations: List<Location>
){
    Box {
        LazyColumn(modifier = Modifier.padding(bottom = 8.dp, top = 8.dp)) {
            items(locations.count()) {
                val item = locations[it]
                LocationCard(location = item)
            }
        }
    }
}