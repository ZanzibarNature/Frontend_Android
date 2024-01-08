package com.kawatrainingcenter.zanzibarnature.ui.helper

import com.kawatrainingcenter.zanzibarnature.R


data class TouristActivities(
    val icons: List<IconType> = listOf(
        IconType.Hiking,
        IconType.Swim,
        IconType.Photo,
        IconType.Monkey,
        IconType.Tour,
        IconType.Kawa)
)

sealed class IconType(
    val name: String,
    val icon: Int,
) {
    object Hiking : IconType(
        name = "hiking",
        icon = R.drawable.hiking
    )

    object Swim : IconType(
        name = "swimming",
        icon = R.drawable.swim
    )

    object Photo : IconType(
        name = "photo",
        icon = R.drawable.camera
    )

    object Monkey : IconType(
        name = "wildlife",
        icon = R.drawable.monkey
    )

    object Tour : IconType(
        name = "guided tour",
        icon = R.drawable.baseline_attach_money_24
    )

    object Kawa : IconType(
        name = "project",
        icon = R.drawable.kawalogoabstract
    )

}