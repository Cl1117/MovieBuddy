package com.example.moviebuddy;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class EditMovieFragment extends Fragment {

    // Declare UI elements
    private EditText editTextMovieId;
    private EditText editTextMovieTitle;
    private EditText editTextMovieDirectors;
    private EditText editTextMovieCasts;
    private EditText editTextMovieReleaseDate;
    private Button buttonEditMovie;
    private Button buttonReturnMain;
    private Button buttonBackPrevious;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_movie, container, false);

        // Initialize UI elements
        editTextMovieId = view.findViewById(R.id.editText_movie_id);
        editTextMovieTitle = view.findViewById(R.id.editText_movie_title);
        editTextMovieDirectors = view.findViewById(R.id.editText_movie_directors);
        editTextMovieCasts = view.findViewById(R.id.editText_movie_casts);
        editTextMovieReleaseDate = view.findViewById(R.id.editText_movie_release_date);
        buttonEditMovie = view.findViewById(R.id.button_edit_movie);
        buttonReturnMain = view.findViewById(R.id.button_return_main_movie);
        buttonBackPrevious = view.findViewById(R.id.button_back_previous_movie);

        // TODO: Implement the actual editing logic here for the buttonEditMovie

        // Set click listener for the "Return to Main Page" button
        buttonReturnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the main page (assuming MainActivity is the main page)
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for the "Back to Previous Page" button
        buttonBackPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go back to the previous fragment or activity
                if (getActivity() != null) {
                    getActivity().onBackPressed();
                }
            }
        });

        return view;
    }

    // TODO: Add other necessary methods or logic for this fragment
}


