package com.example.moviebuddy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

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

        // Check if arguments are not null and then fetch the selected movie
        if (getArguments() != null) {
            movieToEdit = (Movie) getArguments().getSerializable("selectedMovie");
            populateFields(movieToEdit);
        }

        Button updateButton = view.findViewById(R.id.button_update_movie);
        updateButton.setOnClickListener(v -> {
            updateMovieDetails(movieToEdit);
            // Refresh the movies list in ViewMoviesFragment
            ViewMoviesFragment viewMoviesFragment = (ViewMoviesFragment) getParentFragmentManager().findFragmentByTag("ViewMoviesFragment");
            if (viewMoviesFragment != null) {
                viewMoviesFragment.refreshMovieList();
            }
            getParentFragmentManager().popBackStack();
        });

        Button returnMainButton = view.findViewById(R.id.button_return_main_edit);
        Button previousPageButton = view.findViewById(R.id.button_back_previous_edit);

        returnMainButton.setOnClickListener(v -> getParentFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE));
        previousPageButton.setOnClickListener(v -> getParentFragmentManager().popBackStack());

        return view;
    }

    // Populate the fields with the movie details
    private void populateFields(Movie movie) {
        idEditText.setText(String.valueOf(movie.getId()));
        titleEditText.setText(movie.getTitle());
        directorsEditText.setText(movie.getDirectors());
        castsEditText.setText(movie.getCasts());
        releaseDateEditText.setText(movie.getReleaseDate());
    }

    // Update the movie details with the values from the fields
    private void updateMovieDetails(Movie movie) {
        movie.setId(Integer.parseInt(idEditText.getText().toString()));
        movie.setTitle(titleEditText.getText().toString());
        movie.setDirectors(directorsEditText.getText().toString());
        movie.setCasts(castsEditText.getText().toString());
        movie.setReleaseDate(releaseDateEditText.getText().toString());
    }
}
