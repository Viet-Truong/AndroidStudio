package com.example.firebase;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class CongAnAdapter extends ArrayAdapter<CongAn> {
    private Activity activity;
    private int resource;
    private List<CongAn> objects;
    public CongAnAdapter(@NonNull Activity activity, int resource, @NonNull List<CongAn> objects) {
        super(activity, resource, objects);
        this.activity = activity;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.activity.getLayoutInflater();
        View view = layoutInflater.inflate(this.resource, null);
        TextView ten = view.findViewById(R.id.tenCongAn);
        TextView capBac = view.findViewById(R.id.capBac);
        TextView quocGia = view.findViewById(R.id.quocGia);
        TextView noiCongTac = view.findViewById(R.id.noiCongTac);
        TextView soSao = view.findViewById(R.id.capBac);
        RoundedImageView hinhAnh = view.findViewById(R.id.policeIMG);

        CongAn congAn = this.objects.get(position);
        ten.setText(String.format("%s", congAn.ten));
        capBac.setText(String.format("%s", congAn.capBac));
        noiCongTac.setText(String.format("%s", congAn.noiCongTac));
        quocGia.setText(String.format("%s", congAn.quocGia));
        soSao.setText(String.format("%s Sao", congAn.sao));
        hinhAnh.setImageResource(Integer.parseInt(String.format("%d", congAn.hinhAnh)));

        return view;
    }

}
