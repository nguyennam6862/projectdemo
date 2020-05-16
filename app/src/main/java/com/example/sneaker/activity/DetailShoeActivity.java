package com.example.sneaker.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sneaker.R;
import com.example.sneaker.adapter.SlideAdapter;
import com.example.sneaker.model.Shoes;
import com.example.sneaker.model.SliderItem;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class DetailShoeActivity extends AppCompatActivity {
    private TextView textViewName;
    private TextView textViewPrice;
    private TextView textViewCategories;
    private TextView textViewSize;
    private TextView textViewColor;
    private ImageView imageViewAvatar;
    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_shoe);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        initView();

        Intent intent = getIntent();

        if(intent != null){
            Shoes shoes = (Shoes) intent.getSerializableExtra("KEY_DATA");
            if (shoes != null) {
                Glide.with(this).load(shoes.getAvatar()).into(imageViewAvatar);
                textViewName.setText( shoes.getName());
                 textViewSize.setText(String.format("Size: %d / %d / %d", 10, 9, 8));
                // textViewCategories.setText(String.format("category: %s", TextUtils.join(" / ", shoes.getCategories())));
                textViewColor.setText(String.format("Color: %s", TextUtils.join(" / ", shoes.getColors())));
                textViewPrice.setText(String.format("Price: %s", shoes.getPrice()));
            }
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) // Press Back Icon
        {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
    private void initView() {
        textViewName = findViewById(R.id.textViewName);
        imageViewAvatar = findViewById(R.id.imageViewAvatar);
        textViewPrice = findViewById(R.id.textViewPrice);
        textViewCategories = findViewById(R.id.textViewCategories);
        textViewSize = findViewById(R.id.textViewSize);
        textViewColor = findViewById(R.id.textViewColor);
    }
}
