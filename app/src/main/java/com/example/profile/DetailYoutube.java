package com.example.profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class DetailYoutube extends AppCompatActivity {

    YouTubePlayerView youTubePlayerView;
    TextView title, description, author, sub;
    String data1, data2, id, author_ref, sub_ref;
    int img;
    ImageView authorImage;

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
        getLifecycle().addObserver(youTubePlayerView);
        getData();
        setData();
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
}