package com.example.guardarpreferencias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.txt1);

        SharedPreferences Email = getSharedPreferences("datos", Context.MODE_PRIVATE);
        et1.setText(Email.getString("mail", ""));
    }
    public void Guardar(View view){
        SharedPreferences preferencias = getSharedPreferences( "datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("mail", et1.getText().toString());
        editor.commit();
        finish();
    }
}