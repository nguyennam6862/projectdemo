package com.example.sneaker.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sneaker.R;
import com.example.sneaker.activity.DetailShoeActivity;
import com.example.sneaker.adapter.ShoesAdapter;
import com.example.sneaker.model.Shoes;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NikeFragment extends Fragment {
    private static final String PATH_DB = "shoes/Atwt3L6a7FflRLW3RQMA/data";
    private List<Shoes> listShoes = new ArrayList<>();
    private ShoesAdapter adapter;
    private RecyclerView recyclerView;
    public NikeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nike, container, false);

        recyclerView = view.findViewById(R.id.recycleView);

        setUpData();

        fetchData();

        return view;
    }
    private void setUpData() {
        adapter = new ShoesAdapter(listShoes, new ShoesAdapter.OnClickShoesItem() {
            @Override
            public void onClick(Shoes shoes) {
                Intent intent = new Intent(getContext(), DetailShoeActivity.class);
                intent.putExtra("KEY_DATA", shoes);
                startActivity(intent);
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    private void fetchData() {
        // init instance firebase
        DatabaseReference mDatabaseReference = FirebaseDatabase.getInstance().getReference();

        DatabaseReference ref = mDatabaseReference.child(PATH_DB);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    Shoes shoes = new Shoes();
                    String name = ds.child("name").getValue(String.class);
                    shoes.setName(name);

                    String avatar = ds.child("avatar").getValue(String.class);
                    shoes.setAvatar(avatar);

                    Long price = ds.child("price").getValue(Long.class);
                    shoes.setPrice(price);

                    List<String> listColor = new ArrayList<>();
                    DataSnapshot colorDataSnapshot = ds.child("colors");
                    for(DataSnapshot item : colorDataSnapshot.getChildren()){
                        listColor.add(item.child("color").getValue(String.class));
                    }
                    shoes.setColors(listColor);

                    List<String> listCategory = new ArrayList<>();
                    DataSnapshot categoryDataSnapshot = ds.child("categoires");
                    for(DataSnapshot item : categoryDataSnapshot.getChildren()){
                        listCategory.add(item.child("name").getValue(String.class));
                    }
                    shoes.setCategories(listCategory);

                    List<Long> listSize = new ArrayList<>();
                    DataSnapshot sizeDataSnapshot = ds.child("size");
                    for(DataSnapshot item : categoryDataSnapshot.getChildren()){
                        listSize.add(item.child("value").getValue(Long.class));
                    }

                    listShoes.add(shoes);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
