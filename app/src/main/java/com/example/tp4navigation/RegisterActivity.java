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

public class RegisterActivity extends AppCompatActivity {

    private TextInputEditText edtFullName, edtEmailRegister, edtPasswordRegister, edtConfirmPassword;
    private Button btnRegister;
    private TextView txtGoToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtFullName = findViewById(R.id.edtFullName);
        edtEmailRegister = findViewById(R.id.edtEmailRegister);
        edtPasswordRegister = findViewById(R.id.edtPasswordRegister);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        txtGoToLogin = findViewById(R.id.txtGoToLogin);

        btnRegister.setOnClickListener(v -> {
            String fullName = edtFullName.getText() != null ? edtFullName.getText().toString().trim() : "";
            String email = edtEmailRegister.getText() != null ? edtEmailRegister.getText().toString().trim() : "";
            String password = edtPasswordRegister.getText() != null ? edtPasswordRegister.getText().toString().trim() : "";
            String confirmPassword = edtConfirmPassword.getText() != null ? edtConfirmPassword.getText().toString().trim() : "";

            if (TextUtils.isEmpty(fullName)) {
                edtFullName.setError("Veuillez saisir votre nom complet");
                return;
            }
            if (TextUtils.isEmpty(email) || !email.contains("@")) {
                edtEmailRegister.setError("Email invalide");
                return;
            }
            if (TextUtils.isEmpty(password) || password.length() < 6) {
                edtPasswordRegister.setError("Au moins 6 caractères");
                return;
            }
            if (!password.equals(confirmPassword)) {
                edtConfirmPassword.setError("Les mots de passe ne correspondent pas");
                return;
            }

            Toast.makeText(this, "Compte créé avec succès !", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            intent.putExtra("user_name", fullName);
            intent.putExtra("user_email", email);
            startActivity(intent);
            finish();
        });

        txtGoToLogin.setOnClickListener(v -> finish());
    }
}