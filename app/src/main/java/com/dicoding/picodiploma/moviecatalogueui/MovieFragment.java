package com.dicoding.picodiploma.moviecatalogueui;



import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieFragment extends Fragment {
    private String[] arrayTitle;
    private String[] arrayDesc;
    private TypedArray dataPhoto;
    private ListMovieAdapter movieAdapter;
    private ArrayList<Movie> listMovie;

    public MovieFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listMovie);
        recyclerView.setHasFixedSize(true);

        movieAdapter = new ListMovieAdapter(getContext());
        recyclerView.setAdapter(movieAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        addItem();

        return view;
    }

    private void addItem() {
        listMovie = new ArrayList<>();
        listMovie.addAll(MoviesData.getListData());
        movieAdapter.setListMovie(listMovie);
    }


}
