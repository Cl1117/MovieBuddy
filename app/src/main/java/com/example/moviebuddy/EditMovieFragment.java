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

    private EditText titleEditText, directorEditText; // Add other EditText fields as needed
    private Button updateButton;
    private Movie selectedMovie;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_movie, container, false);

        // Initialize the fields
        titleEditText = view.findViewById(R.id.editText_movie_title);
        directorEditText = view.findViewById(R.id.editText_movie_director);
        updateButton = view.findViewById(R.id.button_update_movie);

        Bundle arguments = getArguments();
        if(arguments != null) {
            selectedMovie = (Movie) arguments.getSerializable("selectedMovie");
            if(selectedMovie != null) {
                titleEditText.setText(selectedMovie.getTitle());
                directorEditText.setText(selectedMovie.getDirectors());
                // Populate other fields as needed
            }
        }

        updateButton.setOnClickListener(v -> {
            if(selectedMovie != null) {
                selectedMovie.setTitle(titleEditText.getText().toString());
                selectedMovie.setDirectors(directorEditText.getText().toString());
                // Update other movie details as needed

                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, new ViewMoviesFragment());
                transaction.commit();
            }
        });

        return view;
    }
}