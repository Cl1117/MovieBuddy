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

    private EditText idEditText, titleEditText, directorsEditText, castsEditText, releaseDateEditText;
    private Button updateButton;
    private Movie selectedMovie;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_movie, container, false);

        // Initialize input fields
        idEditText = view.findViewById(R.id.editText_movie_id);
        titleEditText = view.findViewById(R.id.editText_movie_title);
        directorsEditText = view.findViewById(R.id.editText_movie_directors);
        castsEditText = view.findViewById(R.id.editText_movie_casts);
        releaseDateEditText = view.findViewById(R.id.editText_movie_release_date);

        // Initialize the "Update movie" button
        updateButton = view.findViewById(R.id.button_update_movie);

        Bundle arguments = getArguments();
        if(arguments != null) {
            selectedMovie = (Movie) arguments.getSerializable("selectedMovie");
            if(selectedMovie != null) {
                idEditText.setText(String.valueOf(selectedMovie.getId()));
                titleEditText.setText(selectedMovie.getTitle());
                directorsEditText.setText(selectedMovie.getDirectors());
                castsEditText.setText(selectedMovie.getCasts());
                releaseDateEditText.setText(selectedMovie.getReleaseDate());
            }
        }

        updateButton.setOnClickListener(v -> {
            if(selectedMovie != null) {
                selectedMovie.setId(Integer.parseInt(idEditText.getText().toString()));
                selectedMovie.setTitle(titleEditText.getText().toString());
                selectedMovie.setDirectors(directorsEditText.getText().toString());
                selectedMovie.setCasts(castsEditText.getText().toString());
                selectedMovie.setReleaseDate(releaseDateEditText.getText().toString());

                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, new ViewMoviesFragment());
                transaction.commit();
            }
        });

        return view;
    }
}
