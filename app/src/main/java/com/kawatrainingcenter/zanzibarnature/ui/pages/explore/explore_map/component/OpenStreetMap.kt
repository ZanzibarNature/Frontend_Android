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

@Composable
fun OpenStreetMap(
    locations: List<Location>
) {
    val context = LocalContext.current
    val mapView = rememberMapView(context)
    
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { mapView }
    )
    SideEffect {
        updateMapView(mapView, locations, context)
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

fun updateMapView(mapView: MapView, locations: List<Location>, context: Context) {
    mapView.overlays.clear()
    locations.forEach { location ->
        val marker = Marker(mapView)
        marker.apply {
            position = GeoPoint(location.coords[0], location.coords[1])
            icon = ResourcesCompat.getDrawable(context.resources, R.drawable.pin_green, null )
            title = location.title
            setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        }
        mapView.overlays.add(marker)
    }
    mapView.invalidate()
}