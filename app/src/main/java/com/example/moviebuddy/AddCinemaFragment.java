package com.example.moviebuddy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

public class AddCinemaFragment extends Fragment {

    private EditText idEditText, nameEditText, locationEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_cinema, container, false);

        idEditText = view.findViewById(R.id.editText_cinema_id);
        nameEditText = view.findViewById(R.id.editText_cinema_name);
        locationEditText = view.findViewById(R.id.editText_cinema_location);

        Button addButton = view.findViewById(R.id.button_add_cinema);
        addButton.setOnClickListener(v -> {
            Cinema newCinema = new Cinema();
            // Populate cinema object from EditText fields and add to data store (e.g. ArrayList)
            //...
        });

        return view;
    }
}
