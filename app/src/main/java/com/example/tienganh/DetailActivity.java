package com.example.tienganh;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    String type;
    EditText vdu;
    TextView congthuc, tense;
    Button save;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        type = getIntent().getStringExtra("type");
        save = findViewById(R.id.save);
        vdu = findViewById(R.id.ketqua);
        congthuc = findViewById(R.id.congthuc);
        tense = (TextView) findViewById(R.id.tense);
//        switch (type) {
//            case "hientaidon":
//                tense.setText("Simple Present tens");
//                congthuc.setText("S + V(s/es) + O");
//                break;
//            case "hientaitiepdien":
//                tense.setText("Present Continuous tens");
//                congthuc.setText("S + am/is/are + V_ing");
//                break;
//            case "hientaihoanthanh":
//                tense.setText("Present Perfect tens");
//                congthuc.setText("S + have/has + V3/ed + O");
//                break;
//            case "quakhudon":
//                tense.setText("Simple Past tens");
//                congthuc.setText("S + V2/ed + O");
//                break;
//            case "quakhutiepdien":
//                tense.setText("Past Continuous tens");
//                congthuc.setText("S + was/were + V_ing + O");
//                break;
//            case "quakhuhoanthanh":
//                tense.setText("Past Perfect tens");
//                congthuc.setText("S + had + V3/ed + O");
//                break;
//            case "tuonglaidon":
//                tense.setText("Simple Future tens");
//                congthuc.setText("S + will/shall/ + V_inf + O");
//                break;
//        }

//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }
}