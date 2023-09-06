package com.example.moviebuddy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class EditMovieFragment extends Fragment {

    private EditText movieIdInput, movieTitleInput, movieDirectorsInput, movieCastsInput, movieReleaseDateInput;
    private Button updateButton, deleteButton;
    private Movie selectedMovie;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_movie, container, false);

        // Initialize fields
        movieIdInput = view.findViewById(R.id.edit_movie_id);
        movieTitleInput = view.findViewById(R.id.edit_movie_title);
        movieDirectorsInput = view.findViewById(R.id.edit_movie_directors);
        movieCastsInput = view.findViewById(R.id.edit_movie_casts);
        movieReleaseDateInput = view.findViewById(R.id.edit_movie_release_date);
        updateButton = view.findViewById(R.id.button_update_movie);
        deleteButton = view.findViewById(R.id.button_delete_movie);

        Bundle arguments = getArguments();
        if(arguments != null) {
            // Get the selected movie passed from previous fragment
            selectedMovie = (Movie) arguments.getSerializable("selectedMovie");

            // Populate the fields with selected movie details
            movieIdInput.setText(String.valueOf(selectedMovie.getId()));
            movieTitleInput.setText(selectedMovie.getTitle());
            movieDirectorsInput.setText(selectedMovie.getDirectors());
            movieCastsInput.setText(selectedMovie.getCasts());
            movieReleaseDateInput.setText(selectedMovie.getReleaseDate());
        }

        // Set update button listener
        updateButton.setOnClickListener(v -> {
            if(selectedMovie != null) {
                // Update the selected movie details
                selectedMovie.setId(Integer.parseInt(movieIdInput.getText().toString()));
                selectedMovie.setTitle(movieTitleInput.getText().toString());
                selectedMovie.setDirectors(movieDirectorsInput.getText().toString());
                selectedMovie.setCasts(movieCastsInput.getText().toString());
                selectedMovie.setReleaseDate(movieReleaseDateInput.getText().toString());
            }

            // Return to previous fragment
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new ViewMoviesFragment());
            transaction.commit();
        });

        // Set delete button listener
        deleteButton.setOnClickListener(v -> {
            if(selectedMovie != null) {
                // Remove the selected movie from the list
                DataStore.moviesList.remove(selectedMovie);
            }

            // Return to previous fragment
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new ViewMoviesFragment());
            transaction.commit();
        });

        return view;
    }
}
