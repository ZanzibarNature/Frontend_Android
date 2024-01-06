package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_list.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Location

@Composable
fun LocationList (
    locations: List<Location>,
    onLocationClick: (Int) -> Unit,
    favorites: Set<Int>
){
    Box {
        LazyColumn {
            items(locations.count()) {
                val item = locations[it]
                LocationCard(
                    location = item,
                    onClick = { onLocationClick(item.id) },
                    isFavourite = favorites.contains(item.id)
                )
            }
        }
    }
}