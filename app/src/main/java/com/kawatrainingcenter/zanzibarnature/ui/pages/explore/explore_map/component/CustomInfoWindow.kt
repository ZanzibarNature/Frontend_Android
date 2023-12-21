package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_map.component

import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Location
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.infowindow.InfoWindow

class CustomInfoWindow(
    private val mapView: MapView,
    val location: Location
): InfoWindow() {
}