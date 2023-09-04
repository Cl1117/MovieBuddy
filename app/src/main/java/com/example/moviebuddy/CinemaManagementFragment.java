package com.example.moviebuddy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class CinemaManagementFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cinema_management, container, false);

        // Setup button to add a new cinema
        Button addCinemaButton = view.findViewById(R.id.btn_add_cinema);
        addCinemaButton.setOnClickListener(v -> {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new AddCinemaFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        });

        // Setup button to view cinema records
        Button viewCinemasButton = view.findViewById(R.id.btn_view_cinemas);
        viewCinemasButton.setOnClickListener(v -> {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new ViewCinemasFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        });

        // Setup button to edit a cinema record
        Button editCinemaButton = view.findViewById(R.id.btn_edit_cinema);
        editCinemaButton.setOnClickListener(v -> {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new EditCinemaFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        });

        return view;
    }
}
