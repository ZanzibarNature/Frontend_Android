package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_map.component

import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.res.ResourcesCompat
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Location
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.infowindow.InfoWindow
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay

@Composable
fun OpenStreetMap(
    locations: List<Location>,
    onClick: (String) -> Unit
) {
    val context = LocalContext.current
    val mapView = rememberMapView(context)

    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { mapView }
    )
    SideEffect {
        mapView.overlays.clear()
        updateGpsLocation(mapView, context)
        updateMapView(mapView, locations, context, onClick = {id -> onClick(id)})
    }
}

@Composable
fun rememberMapView(context: Context): MapView {
    return remember {
        val mapView = MapView(context)
        mapView.setTileSource(TileSourceFactory.MAPNIK)
        mapView.setMultiTouchControls(true)
        mapView.setBuiltInZoomControls(false)
        mapView.controller.setZoom(11.5)
        mapView.controller.setCenter(GeoPoint(-6.1105, 39.329))
        mapView
    }
}

fun updateMapView(
    mapView: MapView,
    locations: List<Location>,
    context: Context,
    onClick: (String) -> Unit
) {
    locations.forEach { location ->
        val marker = Marker(mapView)

        marker.infoWindow =
            CustomInfoWindow(mapView, location, context, onClick = { onClick(location.id) })

        marker.apply {
            position = GeoPoint(location.latitude, location.longitude)
            icon = ResourcesCompat.getDrawable(context.resources, R.drawable.pin_green, null)
            title = location.title
            setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        }

        mapView.overlays.add(marker)
    }
    mapView.invalidate()
}
fun updateGpsLocation(
    mapView: MapView,
    context: Context
) {
    val myLocationOverlay = MyLocationNewOverlay(GpsMyLocationProvider(context), mapView)
    myLocationOverlay.enableMyLocation()
    mapView.overlays.add(myLocationOverlay)
}