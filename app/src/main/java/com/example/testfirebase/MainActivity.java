package com.example.testfirebase;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private  ArrayList<CongAn> congAnArrayList;
    private ListView lvCongAn;
    private CongAnAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCongAn = findViewById(R.id.lvCongAn);

        congAnArrayList = new ArrayList<>();

        congAnArrayList.add(new CongAn("1","Bùi Viết Trường", "Đại tá","VN", "Đà Nẵng", R.drawable.congannam, 5));
        congAnArrayList.add(new CongAn("2","Bùi Viết Trường", "Thiếu úy","VN", "Đà Nẵng", R.drawable.congannam, 4));
        congAnArrayList.add(new CongAn("3","Bùi Viết Trường", "Thiếu úy","VN", "Đà Nẵng", R.drawable.congannu, 4));
        congAnArrayList.add(new CongAn("4","Bùi Viết Trường", "Thiếu úy","VN", "Đà Nẵng", R.drawable.congannu3, 4));
        adapter = new CongAnAdapter(this,R.layout.activity_police_list,congAnArrayList);

        lvCongAn.setAdapter(adapter);



    }


}