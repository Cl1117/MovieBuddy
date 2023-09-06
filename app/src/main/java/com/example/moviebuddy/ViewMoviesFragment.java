package com.example.moviebuddy;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


public class ViewMoviesFragment extends Fragment {

    private ListView movieListView;
    private ArrayAdapter<Movie> movieAdapter;

    public void refreshMovieList() {
        if (movieAdapter != null) {
            movieAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_movies, container, false);

        movieListView = view.findViewById(R.id.listView_movies);

        // Populate the ListView with movie data
        movieAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, DataStore.moviesList);
        movieListView.setAdapter(movieAdapter);

        // Set an item click listener to edit the movie
        movieListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie selectedMovie = DataStore.moviesList.get(position);
                // Navigate to EditMovieFragment, passing the selected movie's data
                // ... (fragment transaction code here)
            }
        });

        // Set a long item click listener to delete the movie
        movieListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                DataStore.moviesList.remove(position);  // Remove the movie from the data list
                movieAdapter.notifyDataSetChanged();    // Refresh the ListView
                return true;
            }
        });

        Button returnMainButton = view.findViewById(R.id.button_return_main_from_view);
        Button previousPageButton = view.findViewById(R.id.button_back_previous_from_view);

        returnMainButton.setOnClickListener(v -> {
            // Navigate to the main fragment or activity
            getParentFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        });

        previousPageButton.setOnClickListener(v -> {
            // Navigate back to the previous fragment or activity
            getParentFragmentManager().popBackStack();
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Log for debugging
        Log.d("ViewMoviesFragment", "Number of movies: " + DataStore.moviesList.size());

        // Refresh the list view
        if (movieAdapter != null) {
            movieAdapter.notifyDataSetChanged();
        }
    }

}
