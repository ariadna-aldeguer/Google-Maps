package com.example.googlemaps.Slider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.googlemaps.R;

import java.util.ArrayList;

public class SliderActivity extends AppCompatActivity {
    ArrayList<String> images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        images = getIntent().getExtras().getStringArrayList("images");

        ViewPager viewPager = findViewById(R.id.vpager);
        SlidingAdapter slidingAdapter = new SlidingAdapter(getApplicationContext(), images);
        viewPager.setAdapter(slidingAdapter);

        /*RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, dbHelper, db, array_travel);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((getContext())));*/

    }
}