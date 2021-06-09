package com.pacheco.energymaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Entrar(View view) {
       Toast toastinicial= Toast.makeText(this,getText(R.string.toastmsj),Toast.LENGTH_LONG);
       toastinicial.setGravity(Gravity.CENTER,0,0);
       toastinicial.show();
        Intent intent= new Intent(this,Login.class);
        startActivity(intent);


    }
}