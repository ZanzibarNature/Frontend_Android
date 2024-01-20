package com.kawatrainingcenter.zanzibarnature.ui.pages.explore.explore_map.component

import android.content.Context
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.kawatrainingcenter.zanzibarnature.R
import com.kawatrainingcenter.zanzibarnature.data.kawaApi.model.Location
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.infowindow.InfoWindow

class CustomInfoWindow(
    private val mapView: MapView,
    val location: Location,
    val context: Context,
    val onClick: () -> Unit
): InfoWindow(R.drawable.info_window, mapView) {

    private lateinit var windowTitle:TextView
    private lateinit var windowPlaceImage:ImageView
    private lateinit var windowCloseButton: ImageButton

    override fun onOpen(item: Any?) {

        mView.apply {
            windowTitle = findViewById(R.id.titleText)
            windowPlaceImage = findViewById(R.id.placeImage)
            windowCloseButton = findViewById(R.id.closeButton)
        }

        windowTitle.text = location.title

        Glide.with(context)
            .load(location.images[0])
            .into((windowPlaceImage))

        windowCloseButton.setOnClickListener {
            this.close()
        }

        mView.setOnClickListener {
           onClick()
        }

    }
    override fun onClose() {
        this.close()
    }
}