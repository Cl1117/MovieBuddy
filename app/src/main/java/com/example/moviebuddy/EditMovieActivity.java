package com.example.moviebuddy;  // Ensure you have the correct package name

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class EditMovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_movie);  // Ensure you're referencing the correct layout

        // Check if savedInstanceState is null, which means the activity is just being created
        if (savedInstanceState == null) {
            // Begin a FragmentTransaction to add the MovieListFragment
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, new MovieListFragment());
            fragmentTransaction.commit();
        }

        // Setup the "Back to previous page" button
        Button backButton = findViewById(R.id.btn_back_edit);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  // This will close the current activity and return to the previous one
            }
        });
    }
}
