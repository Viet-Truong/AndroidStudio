package com.example.profile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{
    String data1[], data2[], data3[], data4[], data5[], data6[];
    int images[], authorImage[];
    Context context;

    public Adapter(Context ct, String s1[], String s2[], String s3[], String s4[], String s5[], String s6[], int img[], int authorImg[]){
        context = ct;
        data1 = s1;
        data2 = s2;
        data3 = s3;
        data4 = s4;
        data5 = s5;
        data6 = s6;
        images = img;
        authorImage = authorImg;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.name_song.setText(data4[position]);
        holder.author.setText(data5[position]);
        holder.imageView.setImageResource(images[position]);
        holder.authorImage.setImageResource(authorImage[position]);
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailYoutube.class);
                intent.putExtra("title", data1[position]);
                intent.putExtra("description", data2[position]);
                intent.putExtra("id", data3[position]);
                intent.putExtra("img", authorImage[position]);
                intent.putExtra("author", data5[position]);
                intent.putExtra("sub", data6[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name_song, author;
        ImageView imageView, authorImage;
        ConstraintLayout mainLayout;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            name_song = itemView.findViewById((R.id.name_song));
            author = itemView.findViewById(R.id.author);
            imageView = itemView.findViewById(R.id.imageView);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            authorImage = itemView.findViewById(R.id.authorImg);
        }
    }
}
