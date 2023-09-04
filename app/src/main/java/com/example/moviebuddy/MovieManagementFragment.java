package com.example.moviebuddy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MovieManagementFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_management, container, false);

        // Setup button to add a new movie
        Button addMovieButton = view.findViewById(R.id.btn_add_movie);
        addMovieButton.setOnClickListener(v -> {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new AddMovieFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        });

        // Setup button to view movie records
        Button viewMoviesButton = view.findViewById(R.id.btn_view_movies);
        viewMoviesButton.setOnClickListener(v -> {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new ViewMoviesFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        });

        // Setup button to edit a movie record
        Button editMovieButton = view.findViewById(R.id.btn_edit_movie);
        editMovieButton.setOnClickListener(v -> {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new EditMovieFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        });

        return view;
    }
}

