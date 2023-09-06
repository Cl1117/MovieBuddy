package com.example.moviebuddy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

public class EditMovieFragment extends Fragment {

    private EditText idEditText, titleEditText, directorsEditText, castsEditText, releaseDateEditText;
    private Movie movieToEdit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_movie, container, false);

        idEditText = view.findViewById(R.id.editText_movie_id);
        titleEditText = view.findViewById(R.id.editText_movie_title);
        directorsEditText = view.findViewById(R.id.editText_movie_directors);
        castsEditText = view.findViewById(R.id.editText_movie_casts);
        releaseDateEditText = view.findViewById(R.id.editText_movie_release_date);

        // Assume movieToEdit contains the movie data passed from ViewMoviesFragment
        populateFields(movieToEdit);

        Button updateButton = view.findViewById(R.id.button_update_movie);
        updateButton.setOnClickListener(v -> {
            updateMovieDetails(movieToEdit);
            // Navigate back to ViewMoviesFragment or give a success message
        });

        return view;
    }

    private void populateFields(Movie movie) {
        idEditText.setText(String.valueOf(movie.getId()));
        titleEditText.setText(movie.getTitle());
        directorsEditText.setText(movie.getDirectors());
        castsEditText.setText(movie.getCasts());
        releaseDateEditText.setText(movie.getReleaseDate());
    }

    private void updateMovieDetails(Movie movie) {
        movie.setId(Integer.parseInt(idEditText.getText().toString()));
        movie.setTitle(titleEditText.getText().toString());
        movie.setDirectors(directorsEditText.getText().toString());
        movie.setCasts(castsEditText.getText().toString());
        movie.setReleaseDate(releaseDateEditText.getText().toString());
    }
}

