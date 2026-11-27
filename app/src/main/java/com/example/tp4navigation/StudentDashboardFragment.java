package com.example.tp4navigation;
import com.example.tp4navigation.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class StudentDashboardFragment extends Fragment {

    public StudentDashboardFragment() {
        // Constructeur obligatoire
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        // Charger l'interface XML de la nouvelle page
        return inflater.inflate(
                R.layout.activity_student_dashboard_fragment,
                container,
                false
        );
    }
}