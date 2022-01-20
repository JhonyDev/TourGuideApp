package com.example.android.tourguide.activities;
import android.content.Intent;

import com.example.android.tourguide.R;
import com.example.android.tourguide.adapters.SimpleFragmentPagerAdapter;
import com.example.android.tourguide.fragments.InformationFragment;
import com.example.android.tourguide.fragments.MapFragment;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
public class DetailsActivity extends AppCompatActivity {

    //Details Activity holds two child fragments: Information and Map.

    private String name;
    private String longAddress;
    private String shortAddress;
    private String description;
    private int imageID;
    private String workHoursOrPrice;
    private String phone;
    private String webpage;
    private double longitude;
    private double latitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle bun = getIntent().getExtras();

        name = bun.getString("NAME");
        longAddress = bun.getString("LONG_ADDRESS");
        shortAddress = bun.getString("SHORT_ADDRESS");
        description = bun.getString("DESCRIPTION");
        imageID = bun.getInt("IMAGE_ID", imageID);
        workHoursOrPrice = bun.getString("WORK_HOURS_OR_PRICE");
        phone = bun.getString("PHONE");
        webpage = bun.getString("WEBPAGE");
        longitude = bun.getDouble("LONGITUDE");
        latitude = bun.getDouble("LATITUDE");

        final Intent infoIntent = new Intent(DetailsActivity.this, InformationFragment.class);
        final Intent mapIntent = new Intent(DetailsActivity.this, MapFragment.class);

        Bundle bundle = new Bundle();

        bundle.putString("NAME", name);
        bundle.putString("LONG_ADDRESS", longAddress);
        bundle.putString("SHORT_ADDRESS", shortAddress);
        bundle.putString("DESCRIPTION", description);
        bundle.putInt("IMAGE_ID", imageID);
        bundle.putString("WORK_HOURS_OR_PRICE", workHoursOrPrice);
        bundle.putString("PHONE", phone);
        bundle.putString("WEBPAGE", webpage);
        bundle.putDouble("LONGITUDE", longitude);
        bundle.putDouble("LATITUDE", latitude);

        infoIntent.putExtras(bundle);
        mapIntent.putExtras(bundle);

        ViewPager viewPager = findViewById(R.id.viewpager);

        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
