package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private EditText et1,et2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.txt_valor1);
        et2 = findViewById(R.id.txt_valor2);
        tv1 = findViewById(R.id.tv_resultado);
        spinner1 = findViewById(R.id.spinner);
        String[] opcionesSoinner = {"sumar","restar","multiplicar","dividir"};


        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, opcionesSoinner);
        spinner1.setAdapter(adapter);
    }

    //metodo del boton
    public void Calcular(View view){
        String Valor1_String = et1.getText().toString();
        String Valor2_String = et2.getText().toString();
        String seleccion = spinner1.getSelectedItem().toString();
        if(Valor2_String.equals("")||Valor1_String.equals("")){
          Toast.makeText(this, "No ah ingresado ningun valor", Toast.LENGTH_LONG).show();
        }else{
            int valor1_Int = Integer.parseInt(Valor1_String);
            int valor2_Int = Integer.parseInt(Valor2_String);
            if(seleccion.equals("sumar")){
                int suma  = valor1_Int + valor2_Int;
                String resultado = String.valueOf(suma);
                tv1.setText(resultado);

            }else if(seleccion.equals("restar")){
                int resta  = valor1_Int - valor2_Int;
                String resultado = String.valueOf(resta);
                tv1.setText(resultado);

            }else if(seleccion.equals("multiplicar")){
                int multiplicacion  = valor1_Int + valor2_Int;
                String resultado = String.valueOf(multiplicacion);
                tv1.setText(resultado);
            }else {
                if(valor2_Int != 0){
                    int dividr = valor1_Int / valor2_Int;
                    String  resultDividir = String.valueOf(dividr);
                    tv1.setText(resultDividir);
                }else{
                    Toast.makeText(this, "No se puede Divir entre 0", Toast.LENGTH_LONG).show();
                }

            }
        }

    }
}