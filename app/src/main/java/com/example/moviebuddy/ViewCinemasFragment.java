package com.example.moviebuddy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class ViewCinemasFragment extends Fragment {

    // Declare variables for the ListView and the ArrayAdapter
    private ListView cinemaListView;
    private ArrayAdapter<Cinema> cinemaAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_cinemas, container, false);

        // Initialize the ListView
        cinemaListView = view.findViewById(R.id.listView_cinemas);

        // Set the ArrayAdapter for the ListView
        cinemaAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, DataStoreCinema.cinemaList);
        cinemaListView.setAdapter(cinemaAdapter);

        // Set an item click listener to navigate to EditCinemaFragment
        cinemaListView.setOnItemClickListener((parent, v, position, id) -> {
            Cinema selectedCinema = DataStoreCinema.cinemaList.get(position);

            EditCinemaFragment editFragment = new EditCinemaFragment();
            Bundle args = new Bundle();
            args.putSerializable("selectedCinema", selectedCinema);
            editFragment.setArguments(args);

            // Use the fragment manager to replace the current fragment with the EditCinemaFragment
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, editFragment)
                    .addToBackStack(null)
                    .commit();
        });

        // Set a long click listener to delete a cinema
        cinemaListView.setOnItemLongClickListener((parent, view1, position, id) -> {
            DataStoreCinema.cinemaList.remove(position);
            cinemaAdapter.notifyDataSetChanged();
            return true;
        });

        // Initialize the buttons for navigation
        Button returnMainButton = view.findViewById(R.id.button_return_main_from_cinema_view);
        Button previousPageButton = view.findViewById(R.id.button_back_previous_from_cinema_view);

        // Set click listeners for the buttons to navigate between fragments
        returnMainButton.setOnClickListener(v -> getParentFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE));
        previousPageButton.setOnClickListener(v -> getParentFragmentManager().popBackStack());

        return view;
    }

    // When the fragment resumes, refresh the cinema list
    @Override
    public void onResume() {
        super.onResume();
        if (cinemaAdapter != null) {
            cinemaAdapter.notifyDataSetChanged();
        }
    }
}
