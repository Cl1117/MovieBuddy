package com.example.moviebuddy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

public class EditCinemaFragment extends Fragment {

    private EditText idEditText, nameEditText, locationEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_cinema, container, false);

        idEditText = view.findViewById(R.id.editText_cinema_id);
        nameEditText = view.findViewById(R.id.editText_cinema_name);
        locationEditText = view.findViewById(R.id.editText_cinema_location);

        Button editButton = view.findViewById(R.id.button_edit_cinema);
        editButton.setOnClickListener(v -> {
            // Update the selected cinema details in data store (e.g. ArrayList)
            //...
        });

        return view;
    }
}
