package com.example.moviebuddy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

public class MovieDetailsEditFragment extends Fragment {

    private EditText titleEditText;
    private EditText releaseDateEditText;
    private Button updateButton;
    private Button deleteButton;
    private Movie selectedMovie;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_details_edit, container, false);

        // Retrieve the selected movie from the arguments using Bundle class methods
        Bundle arguments = getArguments();
        if (arguments != null) {
            selectedMovie = (Movie) arguments.get("selectedMovie");
        }

        // Initialize the UI elements
        titleEditText = view.findViewById(R.id.edit_movie_title);
        releaseDateEditText = view.findViewById(R.id.edit_movie_release_date);
        updateButton = view.findViewById(R.id.btn_update_movie);
        deleteButton = view.findViewById(R.id.btn_delete_movie);

        // Check if the selected movie is not null
        if (selectedMovie != null) {
            // Set the current details of the selected movie to the UI elements
            titleEditText.setText(selectedMovie.getTitle());
            releaseDateEditText.setText(selectedMovie.getReleaseDate());
        }

        // Set listener for the update button
        updateButton.setOnClickListener(v -> {
            // Update the details of the selected movie
            selectedMovie.setTitle(titleEditText.getText().toString());
            selectedMovie.setReleaseDate(releaseDateEditText.getText().toString());
            // Here, you can add code to update the movie in your data source, e.g., database
        });

        // Set listener for the delete button
        deleteButton.setOnClickListener(v -> {
            // Remove the selected movie from the list
            DataStore.moviesList.remove(selectedMovie);
            // Here, you can add code to remove the movie from your data source, e.g., database
        });

        return view;
    }
}
