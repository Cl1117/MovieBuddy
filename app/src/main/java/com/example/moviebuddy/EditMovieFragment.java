package com.example.moviebuddy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class EditMovieFragment extends Fragment {

    private Button updateButton;  // "Delete movie" button reference removed
    private Movie selectedMovie;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_movie, container, false);

        // Initialize the "Update movie" button
        updateButton = view.findViewById(R.id.button_update_movie);

        Bundle arguments = getArguments();
        if(arguments != null) {
            // Get the selected movie passed from previous fragment
            selectedMovie = (Movie) arguments.getSerializable("selectedMovie");
        }

        // Set update button listener
        updateButton.setOnClickListener(v -> {
            if(selectedMovie != null) {
                // TODO: Update the selected movie details with new values
            }

            // Return to previous fragment
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new ViewMoviesFragment());
            transaction.commit();
        });

        return view;
    }
}
