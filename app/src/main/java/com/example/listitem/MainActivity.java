package com.example.listitem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Product> listProduct;
    Adapter productListViewAdapter;
    ListView listViewProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // add product thong qua constructor
        listProduct = new ArrayList<>();
        listProduct.add(new Product(1, "Iphone 14", 500, R.drawable.ip14));
        listProduct.add(new Product(2, "Iphone 13", 700, R.drawable.ip13));
        listProduct.add(new Product(3, "Sony", 800, R.drawable.sony));
        listProduct.add(new Product(4, "Samsung Galaxy Fold", 900, R.drawable.galaxyfold));

        //khoi tao object Adapter va` truyen listProduct vao`
        productListViewAdapter = new Adapter(listProduct);
        listViewProduct = findViewById(R.id.listProduct);
        listViewProduct.setAdapter(productListViewAdapter);
        listViewProduct.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = (Product) productListViewAdapter.getItem(position);
                //Làm gì đó khi chọn sản phẩm (ví dụ tạo một Activity hiện thị chi tiết, biên tập ..)
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Ban co muon xoa san pham nay k");
                builder.setMessage("Are you sure?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // remove item voi position item
                        listProduct.remove(position);
                        // set lai listViewProduct
                        listViewProduct.setAdapter(productListViewAdapter);
                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
                return true;
            }
        });

        listViewProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });
    }
}