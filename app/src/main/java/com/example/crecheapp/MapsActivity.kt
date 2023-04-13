package com.example.crecheapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.crecheapp.chat.ChatActivity
import com.example.crecheapp.databinding.ActivityHomeMainBinding
import com.example.crecheapp.profile.ProfileActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityHomeMainBinding
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        binding.navigationBar.selectedItemId = R.id.home

        navigationBar()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val locationsCreche = listOf(
            LatLng(-7.9934779, -34.8402871),
            LatLng(-7.9879758, -34.8388384)
        )

        val locationsMaes = listOf(
            LatLng(-7.9812184, -34.836993),
            LatLng(-8.0023402, -34.8411129)
        )

        val myLocation = LatLng(-7.9994928, -34.8396673)

        val markerCreche = BitmapDescriptorFactory.fromResource(R.drawable.icon_creche)
        val markerMae = BitmapDescriptorFactory.fromResource(R.drawable.icon_crecheira)

        for (location in locationsCreche) {
            mMap.addMarker(
                MarkerOptions()
                    .position(location)
                    .icon(markerCreche)
            )
        }

        for (location in locationsMaes) {
            mMap.addMarker(
                MarkerOptions()
                    .position(location)
                    .icon(markerMae)
            )
        }

        val zoom = CameraUpdateFactory.newLatLngZoom(myLocation, 15.0F)
        mMap.addMarker(MarkerOptions().position(myLocation))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation))
        mMap.animateCamera(zoom)
    }

    private fun navigationBar() = with(binding) {
        navigationBar.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    true
                }
                R.id.chat -> {
                    val intent = Intent(this@MapsActivity, ChatActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.profile -> {
                    val intent = Intent(this@MapsActivity, ProfileActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }
}
