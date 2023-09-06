package com.example.moviebuddy;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class EditMovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_movie);

        // Check if the savedInstanceState is null, which means the activity is just being created
        if (savedInstanceState == null) {
            // Begin a new fragment transaction
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            // Add the MovieListFragment to the activity
            fragmentTransaction.add(R.id.fragment_container, new MovieListFragment());

            // Commit the transaction
            fragmentTransaction.commit();
        }
    }
}
