package com.example.gitar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class girisekrani extends AppCompatActivity {

    private EditText editEmail, editPassword;
    private Button btnGiris, btnKayitSayfasinaGit;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        if (user != null) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
            return;
        }

        setContentView(R.layout.activity_girisekrani);

        editEmail = findViewById(R.id.editText_nick);
        editPassword = findViewById(R.id.editTextpassword);
        btnGiris = findViewById(R.id.button_login);
        btnKayitSayfasinaGit = findViewById(R.id.button_register);

        btnGiris.setOnClickListener(v -> {
            String email = editEmail.getText().toString().trim();
            String password = editPassword.getText().toString().trim();

            auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(this, "Giriş başarılı!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(this, MainActivity.class));
                            finish();
                        } else {
                            Toast.makeText(this, "Giriş başarısız: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
        });

        btnKayitSayfasinaGit.setOnClickListener(v -> {
            startActivity(new Intent(this, KayitActivity.class));
            finish();
        });
    }
}
