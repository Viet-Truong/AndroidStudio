package com.example.tienganh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{
    Context context;
    ArrayList<englist> list;

    public Adapter(Context context, ArrayList<englist> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row,parent,false);
        return new MyViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        englist englist = list.get(position);
        holder.vidu.setText(englist.getVidu());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView vidu;


        @SuppressLint("ResourceType")
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            vidu = itemView.findViewById(R.id.vd);
        }
    }
}
