package com.pacheco.energymaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Micasa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_micasa);
    }

    public void regresar(View view) {
        Intent intent=new Intent(this,Contenido.class);
        startActivity(intent);
        finish();
    }
}