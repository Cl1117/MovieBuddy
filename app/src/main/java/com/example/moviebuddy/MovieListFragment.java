package com.example.moviebuddy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MovieListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);

        // Return to main page button
        Button returnToMainButton = view.findViewById(R.id.btn_return_main);
        returnToMainButton.setOnClickListener(v -> {
            // Close the current activity to return to the main activity
            requireActivity().finish();
        });

        // Back to previous page button
        Button backButton = view.findViewById(R.id.btn_back);
        backButton.setOnClickListener(v -> {
            // Go back to the previous fragment
            if (getFragmentManager() != null) {
                getFragmentManager().popBackStack();
            }
        });

        return view;
    }
}
