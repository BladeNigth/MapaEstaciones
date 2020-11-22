package com.example.mapaestaciones;

import androidx.fragment.app.FragmentActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    GasolineraController gc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        gc = new GasolineraController(this);

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
        mMap.getUiSettings().setZoomControlsEnabled(true);
        /*
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        */

        /*
        Cursor Vista = gc.allContadores();
        if( Vista != null){
            Vista.moveToFirst();
            Toast.makeText(this, Vista.getString(0), Toast.LENGTH_SHORT).show();
        }
         */
            gasolineras(googleMap);
    }
    public void gasolineras(GoogleMap googleMap){
        mMap = googleMap;
        Cursor Vista = gc.allContadores();
        if( Vista != null){
            Vista.moveToFirst();
            LatLng latitudes = new LatLng(Double.parseDouble(Vista.getString(5)), Double.parseDouble(Vista.getString(4)));
            mMap.addMarker(new MarkerOptions()
                            .position(latitudes)
                            .title(Vista.getString(0)+","+  Vista.getString(1))
                            .snippet(Vista.getString(2)+", "+ Vista.getString(3))
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latitudes,6));
            //CameraUpdateFactory.zoomIn();
        }
    }
}