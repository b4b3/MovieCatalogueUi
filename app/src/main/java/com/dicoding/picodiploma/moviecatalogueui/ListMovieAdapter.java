package com.dicoding.picodiploma.moviecatalogueui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Movie> listMovie;

    public ArrayList<Movie> getListMovie() {
        return listMovie;
    }

    public void setListMovie(ArrayList<Movie> listMovie) {
        this.listMovie = listMovie;
    }

    public ListMovieAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_movie, parent, false);
        return new CategoryViewHolder(itemRow);

    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.tvName.setText(getListMovie().get(position).getName());
        holder.tvFrom.setText(getListMovie().get(position).getFrom());
        Glide.with(context)
                .load(getListMovie().get(position).getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListMovie().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvFrom;
        ImageView imgPhoto;

        CategoryViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvFrom = itemView.findViewById(R.id.tv_item_from);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
