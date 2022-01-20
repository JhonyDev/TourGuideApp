package com.example.android.tourguide.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.android.tourguide.models.Place;
import com.example.android.tourguide.adapters.PlaceAdapter;
import com.example.android.tourguide.R;

import java.util.ArrayList;

public class BrtBusFragment extends Fragment {
    private int[]image={R.drawable.brt};

    public BrtBusFragment(){}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.list,container,false);
        Toolbar toolbar =rootView.findViewById(R.id.toolbar);
        toolbar.setTitle("BRT Peshawar");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        Resources res = getResources();

        final String[] name = res.getStringArray(R.array.brt_name);
        final String[] shortAddress = res.getStringArray(R.array.brt_short_address);
        final String[] longAddress = res.getStringArray(R.array.brt_long_address);
        final String[] phone = res.getStringArray(R.array.brt_phone);
        final String[] workHours = res.getStringArray(R.array.brt_working_hours);
        final String[] webpage = res.getStringArray(R.array.brt_webpage);
        final String[] description = res.getStringArray(R.array.brt_description);
        final String[] lat = res.getStringArray(R.array.brt_latitude);
        final String[] lng = res.getStringArray(R.array.brt_longitude);

        //Convert string-array to double-array for latitude:
        double[] latitude = new double[lat.length];
        for(int i=0; i<lat.length; i++)
        {
            latitude[i] = Double.parseDouble(lat[i]);
        }
        //Convert string-array to double-array for longitude:
        double[] longitude = new double[lng.length];
        for(int i=0; i<lng.length; i++)
        {
            longitude[i] = Double.parseDouble(lng[i]);
        }

        final ArrayList<Place> places = new ArrayList<>();

        for (int i = 0; i < name.length; i++) {
            places.add(new Place(name[i], shortAddress[i], description[i],
                    longAddress[i], workHours[i], longitude[i], latitude[i],
                    phone[i], webpage[i], image[i]));
        }

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }
}











