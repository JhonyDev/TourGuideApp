package com.example.android.tourguide.fragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.tourguide.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback {

    //This fragment is to create a map for a given location:

    private String name;
    private double longitude;
    private double latitude;
    private GoogleMap mMap;

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_map, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        Bundle bundle = getActivity().getIntent().getExtras();

        name = bundle.getString("NAME");

        Log.i("name", "name: "+name);


        longitude = bundle.getDouble("LONGITUDE");
        Log.i("longitude", "onCreateView: "+longitude);
        latitude = bundle.getDouble("LATITUDE");
        Log.i("latitude", "LATITUDE: "+latitude);

        return rootView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in place and move the camera
        LatLng mPlace = new LatLng(latitude, longitude);
        float zoomLevel = 13.0f;
        mMap.addMarker(new MarkerOptions().position(mPlace).title(name));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mPlace, zoomLevel));

    }

}






