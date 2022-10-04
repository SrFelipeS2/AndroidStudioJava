package com.example.agendapreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1,st1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        st1 = findViewById(R.id.st1);
    }
    //save

    public void save(View view) {
       String Nombre = et1.getText().toString();
       String datos = st1.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString(Nombre, datos);
        editor.commit();

        Toast.makeText(this,"Se guardo correctamente", Toast.LENGTH_SHORT).show();
    }


    //find

    public void buscar(View view) {
        String nombre = et1.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE );
        String datos = preferencias.getString(nombre, "");

        if(datos.length()==0){
            Toast.makeText(this,"No se encontro ningun registro", Toast.LENGTH_SHORT).show();

        }else{
            st1.setText(datos);
        }
    }

}