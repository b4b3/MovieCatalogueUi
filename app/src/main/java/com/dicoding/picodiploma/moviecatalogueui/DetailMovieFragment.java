package com.dicoding.picodiploma.moviecatalogueui;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailMovieFragment extends Fragment {
    public static String EXTRA_MOVIE = "extra_movie";
    private TextView detailFilm;
    private TextView detailJudul;
    private ImageView detailPhoto;
    Movie mMovie;

    public DetailMovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_detail_movie, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        detailFilm=view.findViewById(R.id.judul_detail);
        detailJudul=view.findViewById(R.id.film_detail);
        detailPhoto=view.findViewById(R.id.photo_detail);

        Bundle bundle = this.getArguments();

        if (bundle != null) {
            mMovie = bundle.getParcelable(MovieFragment.EXTRA_MOVIE);
        }

        Movie mMovie = new Movie();
        String textJudul=mMovie.getName();
        detailJudul.setText(textJudul);
        String textFilm = mMovie.getFrom();
        detailFilm.setText(textFilm);
        int imageResource = mMovie.getPhoto();
        detailPhoto.setImageResource(imageResource);

    }


}
