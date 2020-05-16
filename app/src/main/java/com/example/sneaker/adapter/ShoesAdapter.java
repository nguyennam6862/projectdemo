package com.example.sneaker.adapter;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sneaker.R;
import com.example.sneaker.model.Shoes;

import java.util.List;

public class ShoesAdapter extends RecyclerView.Adapter<ShoesAdapter.ShoesViewHolder>{
    private OnClickShoesItem listener;
    private List<Shoes> shoesList;
    public ShoesAdapter(List<Shoes> shoesList, OnClickShoesItem listener) {
        this.shoesList = shoesList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ShoesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shoe_item, parent, false);
        return new ShoesViewHolder(view);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull ShoesViewHolder holder, int position) {
        Shoes shoes = shoesList.get(position);
        holder.textViewName.setText(String.format("Name: %s", shoes.getName()));
        holder.textViewPrice.setText(String.format("Price: %d $", shoes.getPrice()));
        holder.textViewCategory.setText(String.format("Category: %s", TextUtils.join(",", shoes.getCategories())));
        Glide.with(holder.itemView.getContext()).load(shoes.getAvatar()).centerCrop().circleCrop().into(holder.imageViewAvatar);
        holder.bind(shoes, listener);
    }

    @Override
    public int getItemCount() {
        return shoesList.size();
    }

    static class ShoesViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewAvatar;
        private TextView textViewName;
        private TextView textViewCategory;
        private TextView textViewPrice;
        ShoesViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewAvatar = itemView.findViewById(R.id.imageViewAvatar);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewCategory = itemView.findViewById(R.id.textViewCategories);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
        }
        public void bind(final Shoes shoes, final OnClickShoesItem listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(shoes);
                }
            });
        }
    }
    public interface OnClickShoesItem{
        void onClick(Shoes shoes);
    }
}
