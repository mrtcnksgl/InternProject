package com.innova.authenticationfirebase.maps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions
import com.innova.authenticationfirebase.R
import com.innova.authenticationfirebase.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private val locationDataService = LocationDataService() // LocationDataService örneği oluştur

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // LocationDataService'den konumları al
        val locations = locationDataService.locations

        // Her konum için bir işaretçi (marker) oluştur ve haritaya ekle
        for (location in locations) {
            mMap.addMarker(MarkerOptions().position(location.coordinates).title(location.name))
        }

        // Harita görünümünü ilk konumun yakınına taşı
        if (locations.isNotEmpty()) {
            val firstLocation = locations[0]
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(firstLocation.coordinates, 15f))
        }
    }
}
