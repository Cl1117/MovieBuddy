package com.example.moviebuddy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

public class AddMovieFragment extends Fragment {

    private EditText idEditText, titleEditText, directorsEditText, castsEditText, releaseDateEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_movie, container, false);

        idEditText = view.findViewById(R.id.editText_movie_id);
        titleEditText = view.findViewById(R.id.editText_movie_title);
        directorsEditText = view.findViewById(R.id.editText_movie_directors);
        castsEditText = view.findViewById(R.id.editText_movie_casts);
        releaseDateEditText = view.findViewById(R.id.editText_movie_release_date);

        Button addButton = view.findViewById(R.id.button_add_movie);
        addButton.setOnClickListener(v -> {
            Movie newMovie = new Movie();
            // Populate movie object from EditText fields and add to data store (e.g. ArrayList)
            //...
        });

        return view;
    }
}
