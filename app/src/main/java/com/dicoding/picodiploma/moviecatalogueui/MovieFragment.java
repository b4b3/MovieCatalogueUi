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
    /*
    private String[] arrayTitle;
    private String[] arrayDesc;
    private TypedArray dataPhoto;
    private ListMovieAdapter movieAdapter;
    private ArrayList<Movie> listMovie;
    View v;
    */
    private RecyclerView rvCategory;
    private ArrayList<Movie> listMovie = new ArrayList<>();
    private static String[] dataName;
    private static String[] dataDescription;
    private static TypedArray dataPhoto;
    View v;


    public MovieFragment() {

    }


    /*

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

    */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_movie, container, false);

        //balada onclick recyler-fragment
        /*Bundle bundle=getArguments();
        if(bundle!=null){
            Person mPerson=bundle.getParcelable("key");
            mPerson.setName(dataName[i]);
            mPerson.setDetail(dataDescription[i]);
            mPerson.setPhoto(dataPhoto.getResourceId(i, -1));


        }*/

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        //memilih rv_category sebagai id untuk rvCategory
        rvCategory = view.findViewById(R.id.listMovie);
        rvCategory.setHasFixedSize(true);

        dataName=getResources().getStringArray(R.array.data_name);
        dataDescription=getResources().getStringArray(R.array.data_description);
        dataPhoto=getResources().obtainTypedArray(R.array.data_photo);

        //membuat loop untuk memanggil item dari dataname
        for (int i = 0; i < dataName.length;i++){
            Movie movie = new Movie();
            movie.setPhoto(dataPhoto.getResourceId(i,-1));
            movie.setName(dataName[i]);
            movie.setFrom(dataDescription[i]);
            listMovie.add(movie);
        }
        showRecyclerList();



    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        ListMovieAdapter listMovieAdapter = new ListMovieAdapter(getContext());
        listMovieAdapter.setListMovie(listMovie);
        rvCategory.setAdapter(listMovieAdapter);

        //implementasi onClick
        //listHeroAdapter.setOnItemClickListener(MovieFragment.this);


    }
}
