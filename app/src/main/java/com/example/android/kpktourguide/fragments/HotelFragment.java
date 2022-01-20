package com.example.android.kpktourguide.fragments;


import android.content.res.Resources;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.kpktourguide.R;
import com.example.android.kpktourguide.adapters.PlaceAdapter;
import com.example.android.kpktourguide.models.Place;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelFragment extends Fragment {

    private int[] image = {

            R.drawable.amin_hotel,
            R.drawable.fort_continental_hotel,
            R.drawable.pearl_continental_hotel_peshawar,
            R.drawable.shelton_guest_house,
            R.drawable.shelton_hotel_peshawar,
            R.drawable.vip_house
};

    public HotelFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);
        Toolbar toolbar = rootView.findViewById(R.id.toolbar);
        toolbar.setTitle("Hotel");

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        Resources res = getResources();
        final String[] name = res.getStringArray(R.array.hotel_name);
        final String[] shortAddress = res.getStringArray(R.array.hotel_short_address);
        final String[] longAddress = res.getStringArray(R.array.hotel_long_address);
        final String[] phone = res.getStringArray(R.array.hotel_phone);
        final String[] price = res.getStringArray(R.array.hotel_price);
        final String[] webpage = res.getStringArray(R.array.hotel_webpage);
        final String[] lat = res.getStringArray(R.array.hotel_latitude);
        final String[] lng = res.getStringArray(R.array.hotel_longitude);


        //Convert string-array to double-array for latitude:
        double[] latitude = new double[lat.length];
        for (int i = 0; i < lat.length; i++) {
            latitude[i] = Double.parseDouble(lat[i]);
        }
        //Convert string-array to double-array for longitude:
        double[] longitude = new double[lng.length];
        for (int i = 0; i < lng.length; i++) {
            longitude[i] = Double.parseDouble(lng[i]);
        }

        final ArrayList<Place> places = new ArrayList<>();

        for (int i = 0; i < name.length; i++) {


            places.add(new Place(name[i], shortAddress[i],
                    longAddress[i], price[i], longitude[i], latitude[i],
                    phone[i], webpage[i], image[i]));
        }

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;


    }
}
