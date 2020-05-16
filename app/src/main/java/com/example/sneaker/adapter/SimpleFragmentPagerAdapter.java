package com.example.sneaker.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.sneaker.fragment.AdidasFragment;
import com.example.sneaker.fragment.JordanFragment;
import com.example.sneaker.fragment.NikeFragment;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new JordanFragment();
            case 1:
                return new NikeFragment();
            case 2:
                return new AdidasFragment();
            default:
                return new  JordanFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                //
                return "Jordan";
            case 1:
                //
                return "Nike ";
            case 2:
                return "Adidas";
            default:
                return null;
        }
    }
}
