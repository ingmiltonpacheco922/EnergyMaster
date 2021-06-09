package com.pacheco.energymaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText emailEditText;
    private EditText passEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); emailEditText=findViewById(R.id.editTextUsuario);
        passEditText=findViewById(R.id.editTextPass);
        mAuth = FirebaseAuth.getInstance();
    }


    public void iniciar(View view) {
        String email= emailEditText.getText().toString();
        String pass=passEditText.getText().toString();
        if (!email.isEmpty()&& !pass.isEmpty()) {
            if (pass.length()>5) {
                signInWithEmailAndPassword(email, pass);
            }else
                Toast.makeText(this,"contraseña incorrecta",Toast.LENGTH_SHORT).show();

        }else
            Toast.makeText(this,"favor llenar todos los campos",Toast.LENGTH_SHORT).show();

    }

    public void crearRegistro(View view) {
        Toast toastloginOK = Toast.makeText(this, "Abriendo Registro", Toast.LENGTH_SHORT);
        toastloginOK.show();
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
        Log.i("USER",""+currentUser);

    }
public void iniciarcontenido (int orden){
        if (orden==1){
            Intent intent = new Intent(this, Contenido.class);
            startActivity(intent);
            finish();
        }
}

    public void signInWithEmailAndPassword (String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Exito", "signInWithEmail:success");
                            Toast.makeText(Login.this, "INICIO OK.",
                                    Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                            iniciarcontenido(1);


                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Error", "signInWithEmail:failure", task.getException());
                            Toast.makeText(Login.this, "FALLO DE AUTENTICACION.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                                            }
                });

    }
}
