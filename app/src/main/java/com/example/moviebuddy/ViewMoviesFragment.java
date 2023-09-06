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

    // Declare variables for the ListView and the ArrayAdapter
    private ListView movieListView;
    private ArrayAdapter<Movie> movieAdapter;

    // Function to refresh the movie list
    public void refreshMovieList() {
        if (movieAdapter != null) {
            movieAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_movies, container, false);

        // Initialize the ListView
        movieListView = view.findViewById(R.id.listView_movies);

        // Set the ArrayAdapter for the ListView
        movieAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, DataStore.moviesList);
        movieListView.setAdapter(movieAdapter);

        // Set an item click listener to navigate to EditMovieFragment
        movieListView.setOnItemClickListener((parent, v, position, id) -> {
            Movie selectedMovie = DataStore.moviesList.get(position);

            EditMovieFragment editFragment = new EditMovieFragment();
            Bundle args = new Bundle();
            args.putSerializable("selectedMovie", selectedMovie);
            editFragment.setArguments(args);

            // Use the fragment manager to replace the current fragment with the EditMovieFragment
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, editFragment)
                    .addToBackStack(null)
                    .commit();
        });

        // Set a long click listener to delete a movie
        movieListView.setOnItemLongClickListener((parent, view1, position, id) -> {
            DataStore.moviesList.remove(position);
            movieAdapter.notifyDataSetChanged();
            return true;
        });

        // Initialize the buttons for navigation
        Button returnMainButton = view.findViewById(R.id.button_return_main_from_view);
        Button previousPageButton = view.findViewById(R.id.button_back_previous_from_view);

        // Set click listeners for the buttons to navigate between fragments
        returnMainButton.setOnClickListener(v -> getParentFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE));
        previousPageButton.setOnClickListener(v -> getParentFragmentManager().popBackStack());

        return view;
    }

    // When the fragment resumes, refresh the movie list
    @Override
    public void onResume() {
        super.onResume();
        Log.d("ViewMoviesFragment", "Number of movies: " + DataStore.moviesList.size());

        if (movieAdapter != null) {
            movieAdapter.notifyDataSetChanged();
        }
    }
}
