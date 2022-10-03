package com.example.slideactivitydata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView1 = findViewById(R.id.textView1);

        String dato = getIntent().getStringExtra("primerNombre");
        textView1.setText("Hola " + dato);
    }

    public void Regresar(View view){
        Intent i = new Intent(this, MainActivity.class);
//        i.putExtra("NombreVacio", textView1.setText(""););
        startActivity(i);
    }
}