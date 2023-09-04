package com.example.moviebuddy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.fragment.app.Fragment;

public class ViewCinemasFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_cinemas, container, false);

        ListView cinemaListView = view.findViewById(R.id.listView_cinemas);
        // Populate listView with cinemas from data store (e.g. ArrayList)
        // Set up item click listeners for editing or deleting cinemas

        return view;
    }
}
