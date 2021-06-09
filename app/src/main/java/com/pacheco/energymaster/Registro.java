package com.pacheco.energymaster;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registro extends AppCompatActivity {
    private EditText usuarioRegistrado;
    private EditText passregistrado;
    private EditText passConfirmado;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        mAuth = FirebaseAuth.getInstance();
        usuarioRegistrado=findViewById(R.id.editTextUsuarioreg);
        passregistrado=findViewById(R.id.editTextPassreg);
        passConfirmado=findViewById(R.id.editTextPassconfir);
    }

    public void moverContenido(View view) {
        String email=usuarioRegistrado.getText().toString();
        String pass=passregistrado.getText().toString();
        String confpass=passConfirmado.getText().toString();

        if (!email.isEmpty()&& !pass.isEmpty()&&!confpass.isEmpty()){
            if (pass.equals(confpass)){
                if (pass.length()>5){
                    createUserWithEmailAndPassword(email,pass);
                    Toast.makeText(this,"REGISTRO OK",Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(this, Contenido.class);
                    startActivity(intent1);
                    finish();
                }else
                    Toast.makeText(this,"LA CONTRASEÑA ES MUY CORTA",Toast.LENGTH_SHORT).show();
            }else
                Toast.makeText(this,"LAS CONTRASEÑAS NO SON IGUALES",Toast.LENGTH_SHORT).show();

        }else
            Toast.makeText(this,"FALTAN DATOS DE REGISTRO",Toast.LENGTH_SHORT).show();


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

    public void createUserWithEmailAndPassword(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Registro ok", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Fallo el registro", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Registro.this, "REGISTRO FALLIDO.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }



}