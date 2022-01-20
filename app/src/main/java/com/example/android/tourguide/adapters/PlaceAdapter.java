package com.example.android.tourguide.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tourguide.activities.DetailsActivity;
import com.example.android.tourguide.models.Place;
import com.example.android.tourguide.R;

import java.util.ArrayList;

/**
 * Created by Abdul mateen 01/01/2020 for my final year project.
 */

public class PlaceAdapter extends ArrayAdapter<Place> {

    private Context context = getContext();

    public PlaceAdapter(Activity context, ArrayList<Place> places) {
        super(context, 0, places);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Place currentPlace = getItem(position);

        String name = currentPlace.getNameOfPlace();
        String shortAddress = currentPlace.getShortAddress();
        String longAddress = currentPlace.getLongAddress();
        String description = currentPlace.getDescription();
        String workingHoursOrPrice = currentPlace.getWorkingHoursOrPrice();
        String phone = currentPlace.getPhone();
        String webPage = currentPlace.getWebPage();
        double longitude = currentPlace.getLongitude();
        double latitude = currentPlace.getLatitude();
        int imageID = currentPlace.getImageResourceId();

        //Set texts and image to the list item:

        TextView placeName = listItemView.findViewById(R.id.place_name);
        placeName.setText(name);

        TextView placeAddress = listItemView.findViewById(R.id.place_address);
        placeAddress.setText(shortAddress);

        ImageView image = listItemView.findViewById(R.id.image);
        image.setImageResource(imageID);

        //Create an implicit intent to Details Activity which contains INFORMATION and MAP fragments:

        final Intent detailsIntent = new Intent(context, DetailsActivity.class);

        Bundle bun = new Bundle();

        bun.putString("NAME", name);
        bun.putString("LONG_ADDRESS", longAddress);
        bun.putString("SHORT_ADDRESS", shortAddress);
        bun.putString("DESCRIPTION", description);
        bun.putInt("IMAGE_ID", imageID);
        bun.putString("WORK_HOURS_OR_PRICE", workingHoursOrPrice);
        bun.putString("PHONE", phone);
        bun.putString("WEBPAGE", webPage);
        bun.putDouble("LONGITUDE", longitude);
        bun.putDouble("LATITUDE", latitude);

        detailsIntent.putExtras(bun);

        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                context.startActivity(detailsIntent);
            }
        });

        return listItemView;


    }


}
