package com.example.tp4navigation;

import android.os.Bundle;
import android.content.Intent;
import android.view.MenuItem;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. La barre d'outils devient la barre d'action de l'activité
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 2. Le bouton ☰ ouvre et ferme le menu latéral
        drawerLayout = findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle boutonMenu = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.menu_ouvrir, R.string.menu_fermer);
        drawerLayout.addDrawerListener(boutonMenu);
        boutonMenu.syncState();

        // 3. Un clic sur un élément du menu appelle ouvrirElement
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(element -> ouvrirElement(element));

        // 4. Au premier lancement, afficher l'accueil
        if (savedInstanceState == null) {
            afficherFragment(new AccueilFragment());
            navigationView.setCheckedItem(R.id.nav_accueil);
        }
    }

    // Choisit le fragment qui correspond à l'élément cliqué
    private boolean ouvrirElement(MenuItem element) {
        int id = element.getItemId();

        if (id == R.id.nav_accueil) {
            afficherFragment(new AccueilFragment());

        } else if (id == R.id.nav_cours) {
            afficherFragment(new CoursFragment());

        }   else if (id == R.id.nav_emploi) {
        Intent intent = new Intent(MainActivity.this, EmploiDuTempsActivity.class);
        startActivity(intent);

        } else if (id == R.id.nav_profil) {
            afficherFragment(new ProfilFragment());

        } else if (id == R.id.nav_student) {
            afficherFragment(new StudentDashboardFragment());

        } else if (id == R.id.nav_apropos) {
            afficherFragment(new AProposFragment());
        }

        drawerLayout.closeDrawers();
        return true;
    }

    // Place un fragment dans la zone conteneurFragment
    private void afficherFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.conteneurFragment, fragment)
                .commit();
    }
}
