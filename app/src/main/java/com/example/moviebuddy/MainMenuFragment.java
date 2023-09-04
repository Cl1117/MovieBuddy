package com.example.moviebuddy;

    import android.os.Bundle;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.Button;
    import androidx.fragment.app.Fragment;
    import androidx.fragment.app.FragmentTransaction;

    public class MainMenuFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_main_menu, container, false);

    // Setup movie management button
    Button movieButton = view.findViewById(R.id.btn_manage_movies);
    movieButton.setOnClickListener(v -> {
    FragmentTransaction transaction = getFragmentManager().beginTransaction();
    transaction.replace(R.id.fragment_container, new MovieManagementFragment());
    transaction.addToBackStack(null);
    transaction.commit();
    });

    // Setup cinema management button
    Button cinemaButton = view.findViewById(R.id.btn_manage_cinemas);
    cinemaButton.setOnClickListener(v -> {
    FragmentTransaction transaction = getFragmentManager().beginTransaction();
    transaction.replace(R.id.fragment_container, new CinemaManagementFragment());
    transaction.addToBackStack(null);
    transaction.commit();
    });

    return view;
    }
    }
