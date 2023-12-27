package com.kawatrainingcenter.zanzibarnature.ui.navigation

sealed class NavigationType {
    data class Top(val onClick: () -> Unit): NavigationType()
    data class Back(val onClick: () -> Unit): NavigationType()
}