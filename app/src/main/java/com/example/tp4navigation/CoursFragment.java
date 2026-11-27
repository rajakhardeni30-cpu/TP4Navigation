package com.example.tp4navigation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CoursFragment extends Fragment {

    public CoursFragment() {
        super(R.layout.fragment_cours);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnMobile = view.findViewById(R.id.btnDetailsMobile);
        Button btnWeb = view.findViewById(R.id.btnDetailsWeb);
        Button btnBD = view.findViewById(R.id.btnDetailsBD);

        btnMobile.setOnClickListener(v -> {
            afficherDetails(
                    "Développement mobile",
                    "Professeur : Mr Ahmed\nSalle : 3\nMatière : Développement mobile"
            );
        });

        btnWeb.setOnClickListener(v -> {
            afficherDetails(
                    "Développement Web",
                    "Professeur : Mme Salma\nSalle : 12\nMatière : Développement Web"
            );
        });

        btnBD.setOnClickListener(v -> {
            afficherDetails(
                    "Bases de données",
                    "Professeur : Mme Ines\nSalle : 5\nMatière : Bases de données"
            );
        });
    }

    private void afficherDetails(String titre, String informations) {
        new AlertDialog.Builder(requireContext())
                .setTitle(titre)
                .setMessage(informations)
                .setPositiveButton("Fermer", null)
                .show();
    }
}