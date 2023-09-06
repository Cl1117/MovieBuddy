package com.example.moviebuddy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class EditMovieFragment extends Fragment {

    private ListView moviesListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_movie_list, container, false);

        // Initialize ListView
        moviesListView = view.findViewById(R.id.movies_list_view);

        // Create an array of movie titles from the movies list
        String[] movieTitles = new String[DataStore.moviesList.size()];
        for (int i = 0; i < DataStore.moviesList.size(); i++) {
            movieTitles[i] = DataStore.moviesList.get(i).getTitle();
        }

        // Set the adapter for the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, movieTitles);
        moviesListView.setAdapter(adapter);

        // Set item click listener for the ListView
        moviesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie selectedMovie = DataStore.moviesList.get(position);

                // Create a new fragment to edit the selected movie details and pass the selected movie to it
                MovieDetailsEditFragment movieDetailsEditFragment = new MovieDetailsEditFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("selectedMovie", selectedMovie);
                movieDetailsEditFragment.setArguments(bundle);

                // Replace the current fragment with the new one
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, movieDetailsEditFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }
}

