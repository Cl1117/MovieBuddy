package com.example.moviebuddy;

// Import necessary packages at the top

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import androidx.fragment.app.Fragment;

import com.example.moviebuddy.R;


public class MovieDetailsEditFragment extends Fragment {

    private ListView moviesListView;
    private ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_details_edit, container, false);

        moviesListView = view.findViewById(R.id.lv_movies_list);

        // Dummy data for movies. Replace with actual data source.
        String[] movies = {"Movie 1", "Movie 2", "Movie 3"};
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, movies);
        moviesListView.setAdapter(adapter);

        // Handle click event to edit movie
        moviesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedMovie = adapter.getItem(position);
                // Start edit movie activity or fragment
                // TODO: Implement edit movie logic here
            }
        });

        // Handle long click event to delete movie
        moviesListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedMovie = adapter.getItem(position);
                // TODO: Show confirmation dialog and handle delete logic
                return true; // return true to indicate that the event is consumed
            }
        });

        return view;
    }
}
