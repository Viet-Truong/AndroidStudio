package com.example.profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class DetailYoutube extends AppCompatActivity {
    Button btn, addList;
    YouTubePlayerView youTubePlayerView;
    TextView title, description, author, sub;
    String data1, data2, id, author_ref, sub_ref;
    int img;
    ImageView authorImage, favourite;
    int color = R.color.yellow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_youtube);

        youTubePlayerView = findViewById(R.id.video);
        getLifecycle().addObserver(youTubePlayerView);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        author = findViewById(R.id.author);
        sub = findViewById(R.id.sub);
        authorImage = findViewById(R.id.roundedImageView);
        btn = findViewById(R.id.btnSub);
        addList = findViewById(R.id.btnAddList);
        favourite = findViewById(R.id.favourite);
        getLifecycle().addObserver(youTubePlayerView);
        getData();
        setData();
        handleListener(btn, addList, favourite);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = id;
                youTubePlayer.loadVideo(id, 0);
            }
        });
    }

    private void getData() {
        if(getIntent().hasExtra("id") &&
                getIntent().hasExtra("title") &&
                getIntent().hasExtra("description") &&
                getIntent().hasExtra("img") &&
                getIntent().hasExtra("author") &&
                getIntent().hasExtra("sub")){
            data1 = getIntent().getStringExtra("title");
            data2 = getIntent().getStringExtra("description");
            id = getIntent().getStringExtra("id");
            author_ref = getIntent().getStringExtra("author");
            sub_ref = getIntent().getStringExtra("sub");
            img = getIntent().getIntExtra( "img", 0);
        }else{
            Toast.makeText(this, "no data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {
        title.setText(data1);
        description.setText(data2);
        author.setText(author_ref);
        sub.setText(sub_ref);
        authorImage.setImageResource(img);
    }

    private void handleListener(Button btn, Button addList, ImageView favourite) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    btn.setBackgroundResource(R.drawable.background_btn_sub_addlist);
                }
            });

        addList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addList.setBackgroundResource(R.drawable.background_btn_sub_addlist);
            }
        });

        favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                favourite.setColorFilter(getResources().getColor(R.color.yellow));
            }
        });
    }
}