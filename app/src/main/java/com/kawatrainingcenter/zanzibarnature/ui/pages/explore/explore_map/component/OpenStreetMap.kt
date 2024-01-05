package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_map.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.res.ResourcesCompat
import coil.ImageLoader
import coil.request.ImageRequest
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Location
import com.kawatrainingcenter.zanzibarnature.ui.theme.ZanzibarNatureTheme
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.infowindow.MarkerInfoWindow

@Composable
fun OpenStreetMap(
    locations: List<Location>
) {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            val mapView = MapView(context)
            mapView.setTileSource(TileSourceFactory.MAPNIK)
            mapView.setMultiTouchControls(true)
            mapView.setBuiltInZoomControls(false)

            //zoom level
            mapView.controller.setZoom(11.5)

            //initial location of map (Zanzibar island)
            val geoPoint = GeoPoint(-6.1105, 39.329)
            mapView.controller.setCenter(geoPoint)

            locations.forEach { location ->
                val marker = Marker(mapView)

//                val imageLoader = ImageLoader(context)
//                val request = ImageRequest.Builder(context)
//                    .data(location.images[0])
//                    .target { drawable ->
//                        marker.image = drawable
//                    }
//                    .build()
//                imageLoader.enqueue(request)

                marker.apply {
                    position = GeoPoint(location.coords[0], location.coords[1])
                    icon = ResourcesCompat.getDrawable(context.resources, R.drawable.pin_green, null )
                    title = location.title
                    setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)

                    //infoWindow = CustomInfoWindow(location = location, mapView = mapView)
                }

                mapView.overlays.add(marker)
            }

            mapView.invalidate()

            mapView
        }
    )
}