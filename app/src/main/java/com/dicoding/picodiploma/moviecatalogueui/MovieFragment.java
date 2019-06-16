package com.dicoding.picodiploma.moviecatalogueui;



import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import android.widget.Toast;

import java.util.ArrayList;

public class MovieFragment extends Fragment implements ListMovieAdapter.OnItemClickListener{
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
    public static String EXTRA_MOVIE = "extra_movie";


    public MovieFragment() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_movie, container, false);


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
        listMovieAdapter.setOnItemClickListener(MovieFragment.this);


    }

    @Override
    public void onItemClick(int position) {
        Movie mMovie = new Movie();
        mMovie.setName(dataName[position]);
        mMovie.setFrom(dataDescription[position]);
        mMovie.setPhoto(dataPhoto.getResourceId(position, -1));

        DetailMovieFragment mDetailMovieFragment = new DetailMovieFragment();

        Bundle bundle = new Bundle();
        bundle.putParcelable(EXTRA_MOVIE, mMovie);

        getActivity().getSupportFragmentManager();

        DetailMovieFragment fragment = new DetailMovieFragment();
        fragment.setArguments(bundle);


        FragmentManager mFragmentManager = getFragmentManager();
        if (mFragmentManager != null) {
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.container_layout, mDetailMovieFragment, DetailMovieFragment.class.getSimpleName());
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        }

    }

}
