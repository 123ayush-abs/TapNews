package com.example.mynews;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SportsFragment extends Fragment {

    String api="849dabfe54e44bd1b48905bf52f139c1";
    ArrayList<Model> modelArrayList;
    Adapter adapter;
    String country="in";
    private RecyclerView recyclerViewsports;
    private String category="sports";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.sportsf,null);

        recyclerViewsports= view.findViewById(R.id.sportsrecycview);
        modelArrayList=new ArrayList<>();
        recyclerViewsports.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new Adapter(getContext(),modelArrayList);
        recyclerViewsports.setAdapter(adapter);
        findnews();




        return view;
    }

    private void findnews() {

        Apiutility.getAPI().getCategoryNews(country,category,100,api).enqueue(new Callback<mainnews>() {
            @Override
            public void onResponse(Call<mainnews> call, Response<mainnews> response) {
                if(response.isSuccessful())
                {
                    modelArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainnews> call, Throwable t) {

            }
        });
    }

}
