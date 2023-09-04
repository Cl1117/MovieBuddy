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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_movie, container, false);

        idEditText = view.findViewById(R.id.editText_movie_id);
        titleEditText = view.findViewById(R.id.editText_movie_title);
        directorsEditText = view.findViewById(R.id.editText_movie_directors);
        castsEditText = view.findViewById(R.id.editText_movie_casts);
        releaseDateEditText = view.findViewById(R.id.editText_movie_release_date);

        Button editButton = view.findViewById(R.id.button_edit_movie);
        editButton.setOnClickListener(v -> {
            // Update the selected movie details in data store (e.g. ArrayList)
            //...
        });

        return view;
    }
}
