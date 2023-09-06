package com.example.moviebuddy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import android.widget.ArrayAdapter;

public class ViewMoviesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_movies, container, false);

        ListView movieListView = view.findViewById(R.id.listView_movies);
        // For simplicity, we'll use an ArrayAdapter to populate the ListView
        // In a real-world scenario, you'd probably use a custom adapter to display more details
        ArrayAdapter<Movie> movieAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, DataStore.moviesList);
        movieListView.setAdapter(movieAdapter);

        return view;
    }
}
