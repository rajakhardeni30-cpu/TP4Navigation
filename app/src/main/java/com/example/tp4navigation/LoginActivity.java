package com.example.tp4navigation;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText edtEmailLogin, edtPasswordLogin;
    private Button btnLogin;
    private TextView txtGoToRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtEmailLogin = findViewById(R.id.edtEmailLogin);
        edtPasswordLogin = findViewById(R.id.edtPasswordLogin);
        btnLogin = findViewById(R.id.btnLogin);
        txtGoToRegister = findViewById(R.id.txtGoToRegister);

        btnLogin.setOnClickListener(v -> {
            String email = edtEmailLogin.getText() != null ? edtEmailLogin.getText().toString().trim() : "";
            String password = edtPasswordLogin.getText() != null ? edtPasswordLogin.getText().toString().trim() : "";

            if (TextUtils.isEmpty(email)) {
                edtEmailLogin.setError("Veuillez saisir votre email");
                return;
            }
            if (TextUtils.isEmpty(password) || password.length() < 6) {
                edtPasswordLogin.setError("Mot de passe requis (min. 6 caractères)");
                return;
            }

            // Exemple de connexion réussie -> ouverture de MainActivity
            Toast.makeText(this, "Connexion réussie", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("user_email", email);
            startActivity(intent);
            finish();
        });

        txtGoToRegister.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}