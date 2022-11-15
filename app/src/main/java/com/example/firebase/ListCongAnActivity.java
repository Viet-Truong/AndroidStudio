package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListCongAnActivity extends AppCompatActivity {

    private ArrayList<CongAn> congAnArrayList;
    private ListView lvCongAn;
    private CongAnAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cong_an);
        lvCongAn = findViewById(R.id.listview);

        congAnArrayList = new ArrayList<>();
        congAnArrayList.add(new CongAn("1","Bùi Viết Trường", "Đại tá","VN", "Đà Nẵng", R.drawable.congannam, 5));
        congAnArrayList.add(new CongAn("2","Cong An 1", "Thiếu úy","VN", "Huế", R.drawable.congannam, 4));
        congAnArrayList.add(new CongAn("3","Cong An 2", "Thiếu úy","VN", "Hà Nội", R.drawable.congannu, 4));
        congAnArrayList.add(new CongAn("4","Cong An 3", "Thiếu úy","VN", "Hồ Chí Minh", R.drawable.congannu2, 4));

        adapter = new CongAnAdapter(this,R.layout.activity_list_cong_an,congAnArrayList);

        lvCongAn.setAdapter(adapter);
    }
}