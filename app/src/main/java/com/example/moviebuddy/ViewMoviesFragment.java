package com.example.moviebuddy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.fragment.app.Fragment;

public class ViewMoviesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_movies, container, false);

        ListView movieListView = view.findViewById(R.id.listView_movies);
        // Populate listView with movies from data store (e.g. ArrayList)
        // Set up item click listeners for editing or deleting movies

        return view;
    }
}
