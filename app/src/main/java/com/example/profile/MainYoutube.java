package com.example.profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainYoutube extends AppCompatActivity {

    RecyclerView recyclerView;
    String s1[], s2[], s3[], s4[], s5[], s6[];
    int images[] = {
            R.drawable.headclouds,
            R.drawable.heatwaves,
            R.drawable.justadream,
            R.drawable.heartbreaker,
            R.drawable.ilikeyou,
            R.drawable.toogoodatgoodbye,
            R.drawable.duskstilldawn,
            R.drawable.marie2002,
            R.drawable.everlastingego,
            R.drawable.doubletake,
    };
    int author[] = {
            R.drawable.hayd,
            R.drawable.glassanimals,
            R.drawable.nelly,
            R.drawable.giveon,
            R.drawable.postmalone,
            R.drawable.stansmith,
            R.drawable.zayn,
            R.drawable.marie,
            R.drawable.lvly,
            R.drawable.dhruv
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_youtube);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);

        bottomNavigationView.setSelectedItemId(R.id.youtube);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.infoActivity:
                        startActivity(new Intent(getApplicationContext(),InfoActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home2:
                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.youtube:
                        return true;
                }
                return false;
            }
        });

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.title);
        s4 = getResources().getStringArray(R.array.name_song);
        s5 = getResources().getStringArray(R.array.author);
        s2 = getResources().getStringArray(R.array.description);
        s6 = getResources().getStringArray(R.array.sub);
        s3 = getResources().getStringArray(R.array.idVideo);


        Adapter adapter = new Adapter(this, s1, s2, s3, s4, s5, s6, images, author);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}