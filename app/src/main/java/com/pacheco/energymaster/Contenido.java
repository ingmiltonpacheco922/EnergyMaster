package com.pacheco.energymaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Contenido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenido);
    }

    public void btncontrol(View view) {
        Intent intent=new Intent(this,Micasa.class);
        startActivity(intent);
        Toast.makeText(this,"INICIANDO CONTROL HOGAR",Toast.LENGTH_SHORT).show();
    }

    public void btncalculadora(View view) {
        Intent intent=new Intent(this,Calculadora.class);
        startActivity(intent);
        Toast.makeText(this,"CALCULADORA DE CONSUMO ",Toast.LENGTH_SHORT).show();
    }

    public void btntips(View view) {
        Intent intent=new Intent(this,Tips.class);
        startActivity(intent);
        Toast.makeText(this,"TIPS DE AHORRO",Toast.LENGTH_SHORT).show();
    }
}