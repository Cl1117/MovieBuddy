package com.example.moviebuddy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

public class EditCinemaFragment extends Fragment {

    private EditText idEditText, nameEditText, locationEditText;
    private LinearLayout moviesCheckBoxContainer;
    private List<CheckBox> movieCheckBoxes = new ArrayList<>();
    private Cinema selectedCinema;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_cinema, container, false);

        idEditText = view.findViewById(R.id.editText_cinema_id);
        nameEditText = view.findViewById(R.id.editText_cinema_name);
        locationEditText = view.findViewById(R.id.editText_cinema_location);
        moviesCheckBoxContainer = view.findViewById(R.id.checkBoxes_movies_container_edit);

        Bundle arguments = getArguments();
        if (arguments != null) {
            selectedCinema = (Cinema) arguments.getSerializable("selectedCinema");
            if (selectedCinema != null) {
                idEditText.setText(selectedCinema.getId());
                nameEditText.setText(selectedCinema.getName());
                locationEditText.setText(selectedCinema.getLocation());

                // Display checkboxes for each movie and mark selected ones
                for (Movie movie : DataStore.moviesList) {
                    CheckBox movieCheckBox = new CheckBox(getContext());
                    movieCheckBox.setText(movie.getTitle() + " (" + movie.getReleaseDate() + ")");
                    if (selectedCinema.getMovieList().contains(movie)) {
                        movieCheckBox.setChecked(true);
                    }
                    moviesCheckBoxContainer.addView(movieCheckBox);
                    movieCheckBoxes.add(movieCheckBox);
                }
            }
        }

        Button updateButton = view.findViewById(R.id.button_update_cinema);
        updateButton.setOnClickListener(v -> {
            selectedCinema.setId(idEditText.getText().toString());
            selectedCinema.setName(nameEditText.getText().toString());
            selectedCinema.setLocation(locationEditText.getText().toString());

            List<Movie> selectedMovies = new ArrayList<>();
            for (int i = 0; i < movieCheckBoxes.size(); i++) {
                if (movieCheckBoxes.get(i).isChecked()) {
                    selectedMovies.add(DataStore.moviesList.get(i));
                }
            }
            selectedCinema.setMovieList(selectedMovies);
            getParentFragmentManager().popBackStack();
        });

        Button returnMainButton = view.findViewById(R.id.button_return_main_from_cinema_edit);
        Button previousPageButton = view.findViewById(R.id.button_back_previous_from_cinema_edit);

        returnMainButton.setOnClickListener(v -> {
            getParentFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        });

        previousPageButton.setOnClickListener(v -> {
            getParentFragmentManager().popBackStack();
        });

        return view;
    }
}
