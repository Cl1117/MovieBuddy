package com.example.moviebuddy;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import java.util.Calendar;

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

        // Setup release date EditText to show DatePickerDialog when clicked
        releaseDateEditText.setOnClickListener(v -> {
            // Get current date
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            // Date Picker Dialog
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    getContext(),
                    (view1, selectedYear, selectedMonth, selectedDay) -> {
                        // +1 because month is 0-based
                        String selectedDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                        releaseDateEditText.setText(selectedDate);
                    },
                    year, month, day
            );
            datePickerDialog.show();
        });

        Button addButton = view.findViewById(R.id.button_add_movie);
        addButton.setOnClickListener(v -> {
            Movie newMovie = new Movie();
            newMovie.setId(idEditText.getText().toString());
            newMovie.setTitle(titleEditText.getText().toString());
            newMovie.setDirectors(directorsEditText.getText().toString());
            newMovie.setCasts(castsEditText.getText().toString());
            newMovie.setReleaseDate(releaseDateEditText.getText().toString());

            // Add the new movie to the data store
            DataStore.moviesList.add(newMovie);
        });

        return view;
    }
}
