package com.example.moviebuddy;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sample list of movies
        String[] movies = {
                "The Shawshank Redemption",
                "The Godfather",
                "Pulp Fiction",
                "The Dark Knight",
                "Forrest Gump"
        };

        // Setting up the ListView to display movies
        ListView moviesListView = findViewById(R.id.moviesListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, movies);
        moviesListView.setAdapter(adapter);
    }
}
