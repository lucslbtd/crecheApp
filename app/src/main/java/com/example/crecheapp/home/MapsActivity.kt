package com.example.crecheapp.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.crecheapp.R
import com.example.crecheapp.chat.ChatActivity
import com.example.crecheapp.databinding.ActivityHomeMainBinding
import com.example.crecheapp.followup.FollowUpActivity
import com.example.crecheapp.home.model.LocationObject
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
        binding.toolbar.searchIcon.setOnClickListener {
            openItersFilter()
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val locationsCreche = listOf(
            LocationObject("Creche1", "Creche", LatLng(-7.9934779, -34.8402871)),
            LocationObject("Creche2", "Creche", LatLng(-7.9879758, -34.8388384))
        )

        val locationsMaes = listOf(
            LocationObject("Mother1", "Mother", LatLng(-7.9812184, -34.836993)),
            LocationObject("Mother2", "Mother", LatLng(-8.0023402, -34.8411129))
        )

        val myLocation = LatLng(-7.9994928, -34.8396673)

        val markerCreche = BitmapDescriptorFactory.fromResource(R.drawable.creche_icon)
        val markerMae = BitmapDescriptorFactory.fromResource(R.drawable.mae_crecheira_icon)

        for (location in locationsCreche) {
            mMap.addMarker(
                MarkerOptions()
                    .position(location.latLng)
                    .icon(markerCreche)
            )
        }

        for (location in locationsMaes) {
            mMap.addMarker(
                MarkerOptions()
                    .position(location.latLng)
                    .icon(markerMae)
            )
        }

        val zoom = CameraUpdateFactory.newLatLngZoom(myLocation, 15.0F)
        mMap.addMarker(MarkerOptions().position(myLocation))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation))
        mMap.animateCamera(zoom)
        validateMarker(locationsCreche, locationsMaes)
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
                R.id.child -> {
                    val intent = Intent(this@MapsActivity, FollowUpActivity::class.java)
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

    private fun openItersFilter() = with(binding) {
        val ittersFragment = IttersFragment()
        binding.navigationBar.visibility = View.GONE
        binding.toolbar.root.visibility = View.GONE

        ittersFragment.setOnDataListener(object : OnDataListener {
            override fun onDataReceived(data: String) {
                binding.navigationBar.visibility = View.VISIBLE
                binding.toolbar.root.visibility = View.VISIBLE
                Toast.makeText(context, data, Toast.LENGTH_SHORT).show()
                // Log.d("MainActivity", "Dados recebidos: $data")
            }
        })

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_itters, ittersFragment)
            .addToBackStack(null)
            .commit()
    }

    private fun validateMarker(listCreche: List<LocationObject>, listMother: List<LocationObject>) {
        val crecheFragment = CrecheFragment()
        mMap.setOnMapClickListener {
            for (local in listCreche) {
                if (local.type == "Creche") {
                   // binding.navigationBar.visibility = View.GONE
                    binding.toolbar.root.visibility = View.GONE
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_creche, crecheFragment)
                        .addToBackStack(null)
                        .commit()
                }
            }
            for (local in listCreche) {
                if (local.type == "Mother") {
                    binding.navigationBar.visibility = View.GONE
                    binding.toolbar.root.visibility = View.GONE
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_creche, crecheFragment)
                        .addToBackStack(null)
                        .commit()
                }
            }
        }
    }

}
