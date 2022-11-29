package com.example.tienganh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button hientaidon, hientaitiepdien, hientaihoanthanh, quakhudon, quakhutiepdien, quakhuhoanthanh, tuonglaidon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hientaidon = findViewById(R.id.hientaidon);
        hientaihoanthanh = findViewById(R.id.hientaihoanthanh);
        hientaitiepdien = findViewById(R.id.hientaitiepdien);
        quakhudon = findViewById(R.id.quakhudon);
        quakhutiepdien = findViewById(R.id.quakhutiepdien);
        quakhuhoanthanh = findViewById(R.id.quakhuhoanthanh);
        tuonglaidon = findViewById(R.id.tuonglaidon);

        hientaidon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent("hientaidon");
            }
        });
        hientaihoanthanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent("hientaihoanthanh");
            }
        });
        hientaitiepdien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent("hientaitiepdien");
            }
        });
        quakhudon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent("quakhudon");
            }
        });
        quakhutiepdien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent("quakhutiepdien");
            }
        });
        quakhuhoanthanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent("quakhuhoanthanh");
            }
        });
        tuonglaidon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent("tuonglaidon");
            }
        });
    }

    public void Intent(String type) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("type", type);
    }
}