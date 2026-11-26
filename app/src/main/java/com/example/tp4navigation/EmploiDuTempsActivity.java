
package com.example.tp4navigation;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// Cette classe représente l'écran de l'emploi du temps
public class EmploiDuTempsActivity extends AppCompatActivity {

    // TextView pour afficher le jour sélectionné
    TextView txtJour;

    // TextView pour les informations des trois cours
    TextView txtHoraire1, txtMatiere1, txtSalle1, txtProf1;
    TextView txtHoraire2, txtMatiere2, txtSalle2, txtProf2;
    TextView txtHoraire3, txtMatiere3, txtSalle3, txtProf3;

    // Boutons pour choisir le jour
    Button btnLundi, btnMardi, btnMercredi, btnJeudi, btnVendredi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Activer l'affichage EdgeToEdge
        EdgeToEdge.enable(this);

        // Afficher le fichier XML de cette activité
        setContentView(R.layout.activity_emploi_du_temps);

        // Gestion des espaces de la barre système
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());

            v.setPadding(
                    systemBars.left,
                    systemBars.top,
                    systemBars.right,
                    systemBars.bottom
            );

            return insets;
        });

        // Récupérer le TextView du jour
        txtJour = findViewById(R.id.txtJour);

        // Récupérer les informations du premier cours
        txtHoraire1 = findViewById(R.id.txtHoraire1);
        txtMatiere1 = findViewById(R.id.txtMatiere1);
        txtSalle1 = findViewById(R.id.txtSalle1);
        txtProf1 = findViewById(R.id.txtProf1);

        // Récupérer les informations du deuxième cours
        txtHoraire2 = findViewById(R.id.txtHoraire2);
        txtMatiere2 = findViewById(R.id.txtMatiere2);
        txtSalle2 = findViewById(R.id.txtSalle2);
        txtProf2 = findViewById(R.id.txtProf2);

        // Récupérer les informations du troisième cours
        txtHoraire3 = findViewById(R.id.txtHoraire3);
        txtMatiere3 = findViewById(R.id.txtMatiere3);
        txtSalle3 = findViewById(R.id.txtSalle3);
        txtProf3 = findViewById(R.id.txtProf3);

        // Récupérer les boutons des jours
        btnLundi = findViewById(R.id.btnLundi);
        btnMardi = findViewById(R.id.btnMardi);
        btnMercredi = findViewById(R.id.btnMercredi);
        btnJeudi = findViewById(R.id.btnJeudi);
        btnVendredi = findViewById(R.id.btnVendredi);

        // Afficher les cours du lundi au démarrage
        afficherJour("Lundi");

        // Actions des boutons
        btnLundi.setOnClickListener(v -> afficherJour("Lundi"));
        btnMardi.setOnClickListener(v -> afficherJour("Mardi"));
        btnMercredi.setOnClickListener(v -> afficherJour("Mercredi"));
        btnJeudi.setOnClickListener(v -> afficherJour("Jeudi"));
        btnVendredi.setOnClickListener(v -> afficherJour("Vendredi"));
    }

    // Méthode qui affiche les cours selon le jour choisi
    private void afficherJour(String jour) {

        // Afficher le nom du jour
        txtJour.setText(jour);

        if (jour.equals("Lundi")) {

            afficherCours(
                    "08:00 - 10:00", "Développement Android", "B12", "Mme Salma",
                    "10:15 - 12:00", "Bases de données", "A03", "Mr Ahmed",
                    "13:00 - 15:00", "Programmation Java", "C05", "Mme Ines"
            );

        } else if (jour.equals("Mardi")) {

            afficherCours(
                    "08:00 - 10:00", "Réseaux informatiques", "B10", "Mr Sami",
                    "10:15 - 12:00", "Développement Web", "A02", "Mme Amira",
                    "13:00 - 15:00", "UML", "C01", "Mr Ali"
            );

        } else if (jour.equals("Mercredi")) {

            afficherCours(
                    "08:00 - 10:00", "Programmation Java", "C05", "Mme Ines",
                    "10:15 - 12:00", "Bases de données", "A03", "Mr Ahmed",
                    "13:00 - 15:00", "Anglais", "B04", "Mme Sara"
            );

        } else if (jour.equals("Jeudi")) {

            afficherCours(
                    "08:00 - 10:00", "Développement Web", "A02", "Mme Amira",
                    "10:15 - 12:00", "Réseaux informatiques", "B10", "Mr Sami",
                    "13:00 - 15:00", "UML", "C01", "Mr Ali"
            );

        } else if (jour.equals("Vendredi")) {

            afficherCours(
                    "08:00 - 10:00", "Bases de données", "A03", "Mr Ahmed",
                    "10:15 - 12:00", "Développement Android", "B12", "Mme Salma",
                    "13:00 - 15:00", "Anglais", "B04", "Mme Sara"
            );
        }
    }

    // Méthode pour mettre à jour les informations des trois cours
    private void afficherCours(
            String horaire1, String matiere1, String salle1, String prof1,
            String horaire2, String matiere2, String salle2, String prof2,
            String horaire3, String matiere3, String salle3, String prof3) {

        // Mise à jour du premier cours
        txtHoraire1.setText(horaire1);
        txtMatiere1.setText(matiere1);
        txtSalle1.setText("Salle : " + salle1);
        txtProf1.setText("Professeur : " + prof1);

        // Mise à jour du deuxième cours
        txtHoraire2.setText(horaire2);
        txtMatiere2.setText(matiere2);
        txtSalle2.setText("Salle : " + salle2);
        txtProf2.setText("Professeur : " + prof2);

        // Mise à jour du troisième cours
        txtHoraire3.setText(horaire3);
        txtMatiere3.setText(matiere3);
        txtSalle3.setText("Salle : " + salle3);
        txtProf3.setText("Professeur : " + prof3);
    }
}
