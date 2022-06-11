package com.example.rs_wirabuana_palu;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import com.example.rs_wirabuana_palu.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng RS_Wirabuana = new LatLng(-0.88491, 119.89054);
        mMap.addMarker(new MarkerOptions().position(RS_Wirabuana).title("Marker in RS_Wirabuana"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(RS_Wirabuana));

        LatLng kantorpos=new LatLng(-0.9066092,119.8889233);
        mMap.addMarker(new MarkerOptions().position(kantorpos).title("Marker in Kantorpos"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kantorpos));

        mMap.addPolyline(new PolylineOptions().add(
                RS_Wirabuana,
                new LatLng(-0.8433296,119.8854953),
                new LatLng(-0.8430571,119.8843143),
                new LatLng(-0.8429825,119.8837894),
                new LatLng(-0.84288,119.8832453),
                new LatLng(-0.8430706,119.8830127),
                new LatLng(-0.8433291,119.8828888),
                new LatLng(-0.8451091,119.8825007),
                kantorpos
        ).width(10)
        .color(Color.BLACK));
    }
}
