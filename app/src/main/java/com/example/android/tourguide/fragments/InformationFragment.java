package com.example.android.tourguide.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.android.tourguide.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InformationFragment extends Fragment {

    private String name;
    private String longAddress;
    private String description;
    private int imageID;
    private String workHoursOrPrice;
    private String phone;
    private String webpage;


    public InformationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_information, container, false);

        Bundle bundle = getActivity().getIntent().getExtras();

        name = bundle.getString("NAME");
        longAddress = bundle.getString("LONG_ADDRESS");
        description = bundle.getString("DESCRIPTION");
        imageID = bundle.getInt("IMAGE_ID", imageID);
        workHoursOrPrice = bundle.getString("WORK_HOURS_OR_PRICE");
        phone = bundle.getString("PHONE");
        webpage = bundle.getString("WEBPAGE");

        ImageView IV = rootView.findViewById(R.id.image);
        TextView nameTV = rootView.findViewById(R.id.name);
        TextView descriptionTV = rootView.findViewById((R.id.description));
        TextView longAddressTV = rootView.findViewById(R.id.long_address);
        TextView workHoursOrPriceTV = rootView.findViewById(R.id.work_hours_or_price);
        TextView textView = rootView.findViewById(R.id.tv_review);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initReview();
            }
        });
        final TextView phoneTV = rootView.findViewById(R.id.phone);
        final TextView webpageTV = rootView.findViewById(R.id.webpage);
        ImageView phoneIV = rootView.findViewById(R.id.phone_iv);
        ImageView webIV = rootView.findViewById(R.id.web_iv);
        ImageView addressIV = rootView.findViewById(R.id.address_iv);
        nameTV.setText(name);
        longAddressTV.setText(longAddress);
        descriptionTV.setText(description);
        workHoursOrPriceTV.setText(workHoursOrPrice);
        phoneTV.setText(phone);

        phoneTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobileNumber = phoneTV.getText().toString();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL); // Action for what intent called for
                intent.setData(Uri.parse("tel: " + mobileNumber)); // Data with intent respective action on intent
                startActivity(intent);
            }
        });

        webpageTV.setText(webpage);

        webpageTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = webpageTV.getText().toString();
                if (!url.startsWith("https://") && !url.startsWith("http://")) {
                    url = "http://" + url;
                }
                Intent openUrlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(openUrlIntent);

            }
        });

        IV.setImageResource(imageID);

        //Some data can be missing, such as description or phone, so these codes are for removing related views in null cases:

        if (description == null) {

            descriptionTV.setVisibility(View.GONE);
        }

        if (phone == null || phone.equals("")) {
            phoneTV.setVisibility(View.GONE);
            phoneIV.setVisibility(View.GONE);
        }

        if (workHoursOrPrice == null || workHoursOrPrice.equals(" ")) {
            workHoursOrPriceTV.setVisibility(View.GONE);
        } else if (workHoursOrPrice.contains("PKR")) {
            workHoursOrPriceTV.setText("Price:   " + workHoursOrPrice);
        } else {
            workHoursOrPriceTV.setText("Working Hours: " + workHoursOrPrice);
        }


        if (webpage == null || webpage.equals("")) {
            webpageTV.setVisibility(View.GONE);
            webIV.setVisibility(View.GONE);
        }

        return rootView;
    }

    private void initReview() {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse(webpage));
        startActivity(intent);
    }

}
