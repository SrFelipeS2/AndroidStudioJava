package com.example.almacenamientosd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);

    }

    public void Guardar(View view){
        String nombre = et1.getText().toString();
        String contenido = et2.getText().toString();

        try {
            File tarjetaSD = Environment.getExternalStorageDirectory();
            Toast.makeText(this, tarjetaSD.getPath(), Toast.LENGTH_SHORT).show();
            File rutaArchivo = new File(tarjetaSD.getPath(), nombre);
            OutputStreamWriter abrirArchivo = new OutputStreamWriter(openFileOutput(nombre, Activity.MODE_PRIVATE));

            abrirArchivo.write(contenido);
            abrirArchivo.flush();
            abrirArchivo.close();

            Toast.makeText(this, "Guardado Correctamente", Toast.LENGTH_SHORT).show();

            et1.setText("");
            et2.setText("");
        }catch (IOException e){
            Toast.makeText(this, "No se pudo guardar", Toast.LENGTH_SHORT).show();
        }
    }

    public void consultar(View view){
        String nombre = et1.getText().toString();
        try {
            File tarjetaSD = Environment.getExternalStorageDirectory();
            File rutaArchivo = new File(tarjetaSD.getPath(), nombre);
            InputStreamReader abrirArchivo = new InputStreamReader(openFileInput(nombre));

            BufferedReader leerArchivo = new BufferedReader(abrirArchivo);
            String linea = leerArchivo.readLine();
            String ContenidoCompleto = "";
            while (linea!=null){
                ContenidoCompleto = ContenidoCompleto + linea + "\n";
                linea = leerArchivo.readLine();
            }
            leerArchivo.close();
            abrirArchivo.close();
            et2.setText(ContenidoCompleto);
        }catch(IOException e){
            Toast.makeText(this, "Error al leer el archivo", Toast.LENGTH_SHORT).show();

        }
    }
}