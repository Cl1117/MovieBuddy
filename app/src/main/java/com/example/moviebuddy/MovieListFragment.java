package com.example.moviebuddy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;

public class MovieListFragment extends Fragment {

    // Sample data for movies. Replace this with your data retrieval method.
    private String[] sampleMovies = {
            "Movie 1",
            "Movie 2",
            "Movie 3",
            "Movie 4"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);

        // Set up the ListView to display the list of movies
        ListView movieListView = view.findViewById(R.id.movie_list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, sampleMovies);
        movieListView.setAdapter(adapter);

        return view;
    }
}
