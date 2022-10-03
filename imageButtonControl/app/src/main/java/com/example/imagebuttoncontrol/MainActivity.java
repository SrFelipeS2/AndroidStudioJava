package com.example.imagebuttoncontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mensajeBuo(View view){
        Toast.makeText(this, "Esto es un Buo", Toast.LENGTH_LONG).show();
    }
    public void mensajeCigueña(View view){
        Toast.makeText(this, "Esto es una Cigueña", Toast.LENGTH_LONG).show();
    }

}