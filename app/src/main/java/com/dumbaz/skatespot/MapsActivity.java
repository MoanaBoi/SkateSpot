package com.dumbaz.skatespot;

import android.Manifest;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    GPSTracker g;
    Location l;
    private LatLng me;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        final Button bAddMarker = (Button) findViewById(R.id.addSpotButton);
        ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 123);
        bAddMarker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addMarker();
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        g = new GPSTracker(getApplicationContext());
        l = g.getLocation();
        me = new LatLng(l.getLatitude(), l.getLongitude());
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(me, 14, 45, 0)));
        mMap.setPadding(0, 0, 0, 1720);
    }

    public void addMarker() {
        mMap.addMarker(new MarkerOptions().position(me).draggable(true));
    }
}
