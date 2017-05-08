package com.example.ferra.ebdapp.Activity;

import android.content.Context;
import android.location.Criteria;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.ferra.ebdapp.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ComoChegarActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private LocationManager locationManager;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_como_chegar);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager ()
                .findFragmentById (R.id.map);
        mapFragment.getMapAsync (this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady (GoogleMap googleMap) {
        locationManager = (LocationManager) getApplication ().getSystemService (Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria ();

        String provider = locationManager.getBestProvider (criteria, true);

        mMap = googleMap;


        mMap.getUiSettings ().setZoomControlsEnabled (true);

//        mMap.setMyLocationEnabled (true);

        // Coordenadas para Assembléia de Deus 38K
        LatLng sydney = new LatLng (-15.84736523, -47.97024876);
        mMap.addMarker (new MarkerOptions ().position (sydney).title ("Assembléia de Deus 38K"));
        mMap.moveCamera (CameraUpdateFactory.newLatLng (sydney));
    }
}
