package com.example.android.tourguide.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.FrameLayout;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.tourguide.R;
import com.example.android.tourguide.adapters.RecyclerViewAdapter;
import com.example.android.tourguide.models.Card;
import com.example.android.tourguide.utils.Utility;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private static final String ITEM_ID = "selected";
    private static final String FIRST_TIME = "first_time";
    List<Card> recyclerList;
    private int mSelectedId;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;
    private NavigationView mDrawer;
    private boolean mDrawerIsSeen = false;
    private boolean isStartup = true;

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt(ITEM_ID, mSelectedId);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mDrawer = findViewById(R.id.main_drawer);

        mDrawerLayout = findViewById(R.id.drawerLayout);
//        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
//
//
//        mDrawerLayout.addDrawerListener(mToggle);
//        mToggle.syncState();

        //in order to save instance state in case of orientation change:
        if (savedInstanceState != null) {

            savedInstanceState.getInt(ITEM_ID, mSelectedId);

            if (!isStartup) {
                ((FrameLayout) findViewById(R.id.container)).removeAllViews();
            }
            isStartup = true;
        }

        if (!drawerSeen()) {

            showDrawer();

        } else {

            hideDrawer();
        }


        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerList = new ArrayList<>();

        initList();

        int mNoOfColumns = Utility.calculateNoOfColumns(getApplicationContext());
        RecyclerView recyclerView = findViewById(R.id.recyler_view);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, recyclerList);

        //Shuffle the cardView positions:
        //(for the next two lines of code, credit goes to: https://stackoverflow.com/questions/38708377/select-random-item-in-cardview)
        long seed = System.nanoTime();
        Collections.shuffle(recyclerList, new Random(seed));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, mNoOfColumns);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(recyclerViewAdapter);

    }

    private void initList() {

        recyclerList.add(new Card(
                        getString(R.string.kashmir1),
                        getString(R.string.kashmir_hook1),
                        getString(R.string.kashmir_short_address1),
                        R.drawable.kashmir1,
                        getString(R.string.kashmir_description1),
                        getString(R.string.kashmir_long_address1),
                        getString(R.string.kashmir_working_hours1),
                        34.8321223519075, 74.06179902860066,
                        getString(R.string.kashmir_phone1),
                        getString(R.string.kashmir_web1)
                )
        );
        recyclerList.add(new Card(
                        getString(R.string.kashmir2),
                        getString(R.string.kashmir_hook2),
                        getString(R.string.kashmir_short_address2),
                        R.drawable.kashmir2,
                        getString(R.string.kashmir_description2),
                        getString(R.string.kashmir_long_address2),
                        getString(R.string.kashmir_working_hours2),
                        34.390605454625714, 73.54794887096162,
                        getString(R.string.kashmir_phone2),
                        getString(R.string.kashmir_web2)
                )
        );
        recyclerList.add(new Card(
                        getString(R.string.kashmir3),
                        getString(R.string.kashmir_hook3),
                        getString(R.string.kashmir_short_address3),
                        R.drawable.kashmir3,
                        getString(R.string.kashmir_description3),
                        getString(R.string.kashmir_long_address3),
                        getString(R.string.kashmir_working_hours3),
                        33.97685136488015, 73.76063107081534,
                        getString(R.string.kashmir_phone3),
                        getString(R.string.kashmir_web3)
                )
        );
        recyclerList.add(new Card(
                        getString(R.string.kashmir4),
                        getString(R.string.kashmir_hook4),
                        getString(R.string.kashmir_short_address4),
                        R.drawable.kashmir4,
                        getString(R.string.kashmir_description4),
                        getString(R.string.kashmir_long_address4),
                        getString(R.string.kashmir_working_hours4),
                        33.80997484187904, 73.81626594148022,
                        getString(R.string.kashmir_phone4),
                        getString(R.string.kashmir_web4)
                )
        );
        recyclerList.add(new Card(
                        getString(R.string.kashmir5),
                        getString(R.string.kashmir_hook5),
                        getString(R.string.kashmir_short_address5),
                        R.drawable.kashmir5,
                        getString(R.string.kashmir_description5),
                        getString(R.string.kashmir_long_address5),
                        getString(R.string.kashmir_working_hours5),
                        33.832866372645384, 73.7334500395361,
                        getString(R.string.kashmir_phone5),
                        getString(R.string.kashmir_web5)
                )
        );
        recyclerList.add(new Card(
                        getString(R.string.kashmir6),
                        getString(R.string.kashmir_hook6),
                        getString(R.string.kashmir_short_address6),
                        R.drawable.kashmir6,
                        getString(R.string.kashmir_description6),
                        getString(R.string.kashmir_long_address6),
                        getString(R.string.kashmir_working_hours6),
                        34.36076057258816, 73.47128313598638,
                        getString(R.string.kashmir_phone6),
                        getString(R.string.kashmir_web6)
                )
        );
        recyclerList.add(new Card(
                        getString(R.string.kashmir7),
                        getString(R.string.kashmir_hook7),
                        getString(R.string.kashmir_short_address7),
                        R.drawable.kashmir7,
                        getString(R.string.kashmir_description7),
                        getString(R.string.kashmir_long_address7),
                        getString(R.string.kashmir_working_hours7),
                        33.084950871195744, 73.76056528524495,
                        getString(R.string.kashmir_phone7),
                        getString(R.string.kashmir_web7)
                )
        );
        recyclerList.add(new Card(
                        getString(R.string.kashmir8),
                        getString(R.string.kashmir_hook8),
                        getString(R.string.kashmir_short_address8),
                        R.drawable.kashmir8,
                        getString(R.string.kashmir_description8),
                        getString(R.string.kashmir_long_address8),
                        getString(R.string.kashmir_working_hours8),
                        34.80647274774672, 74.34617743034583,
                        getString(R.string.kashmir_phone8),
                        getString(R.string.kashmir_web8)
                )
        );
        recyclerList.add(new Card(
                        getString(R.string.kashmir9),
                        getString(R.string.kashmir_hook9),
                        getString(R.string.kashmir_short_address9),
                        R.drawable.kashmir9,
                        getString(R.string.kashmir_description9),
                        getString(R.string.kashmir_long_address9),
                        getString(R.string.kashmir_working_hours9),
                        34.601864932667205, 73.90609438146676,
                        getString(R.string.kashmir_phone9),
                        getString(R.string.kashmir_web9)
                )
        );
        recyclerList.add(new Card(
                        getString(R.string.kashmir10),
                        getString(R.string.kashmir_hook10),
                        getString(R.string.kashmir_short_address10),
                        R.drawable.kashmir10,
                        getString(R.string.kashmir_description10),
                        getString(R.string.kashmir_long_address10),
                        getString(R.string.kashmir_working_hours10),
                         33.88690543152479, 73.91936914749594,
                        getString(R.string.kashmir_phone10),
                        getString(R.string.kashmir_web10)
                )
        );
        recyclerList.add(new Card(
                        getString(R.string.kashmir11),
                        getString(R.string.kashmir_hook11),
                        getString(R.string.kashmir_short_address11),
                        R.drawable.kashmir11,
                        getString(R.string.kashmir_description11),
                        getString(R.string.kashmir_long_address11),
                        getString(R.string.kashmir_working_hours11),
                         33.11424430515184, 73.86493968578652,
                        getString(R.string.kashmir_phone11),
                        getString(R.string.kashmir_web11)
                )
        );
        recyclerList.add(new Card(
                        getString(R.string.kashmir12),
                        getString(R.string.kashmir_hook12),
                        getString(R.string.kashmir_short_address12),
                        R.drawable.kashmir12,
                        getString(R.string.kashmir_description12),
                        getString(R.string.kashmir_long_address12),
                        getString(R.string.kashmir_working_hours12),
                         34.097347525959535, 73.49906286293178,
                        getString(R.string.kashmir_phone12),
                        getString(R.string.kashmir_web12)
                )
        );
        recyclerList.add(new Card(
                        getString(R.string.kashmir13),
                        getString(R.string.kashmir_hook13),
                        getString(R.string.kashmir_short_address13),
                        R.drawable.kashmir13,
                        getString(R.string.kashmir_description13),
                        getString(R.string.kashmir_long_address13),
                        getString(R.string.kashmir_working_hours13),
                         33.15282192621633, 73.74301542389829,
                        getString(R.string.kashmir_phone13),
                        getString(R.string.kashmir_web13)
                )
        );
        recyclerList.add(new Card(
                        getString(R.string.kashmir14),
                        getString(R.string.kashmir_hook14),
                        getString(R.string.kashmir_short_address14),
                        R.drawable.kashmir14,
                        getString(R.string.kashmir_description14),
                        getString(R.string.kashmir_long_address14),
                        getString(R.string.kashmir_working_hours14),
                         34.42476138391218, 73.69099211704443,
                        getString(R.string.kashmir_phone14),
                        getString(R.string.kashmir_web14)
                )
        );
        recyclerList.add(new Card(
                        getString(R.string.kashmir15),
                        getString(R.string.kashmir_hook15),
                        getString(R.string.kashmir_short_address15),
                        R.drawable.kashmir15,
                        getString(R.string.kashmir_description15),
                        getString(R.string.kashmir_long_address15),
                        getString(R.string.kashmir_working_hours15),
                         33.22418750079771, 73.64200162392882,
                        getString(R.string.kashmir_phone15),
                        getString(R.string.kashmir_web15)
                )
        );
    }

    private boolean drawerSeen() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        mDrawerIsSeen = sharedPreferences.getBoolean(FIRST_TIME, false);
        return mDrawerIsSeen;
    }

    private void markIfDrawerIsSeen() {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mDrawerIsSeen = true;
        sharedPreferences.edit().putBoolean(FIRST_TIME, mDrawerIsSeen).apply();

    }

    private void showDrawer() {

        mDrawerLayout.openDrawer(GravityCompat.START);
        markIfDrawerIsSeen();
    }

    private void hideDrawer() {

        mDrawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {

            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {

            do {
                if (!isStartup) {

                    //recreate after removeAllFiles command:
                    startActivity(new Intent(this, MainActivity.class));
                    super.onBackPressed();
                    isStartup = true;


                } else {

                    super.onBackPressed();
                    isStartup = false;

                }
            } while (isStartup);

        }
    }

}

