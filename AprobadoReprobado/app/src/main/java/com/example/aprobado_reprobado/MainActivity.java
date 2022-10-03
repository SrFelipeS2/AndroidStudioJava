package com.example.aprobado_reprobado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et1;
    private EditText et2;
    private EditText et3;
    private TextView tv1;

    Button btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.number1);
        et2 = findViewById(R.id.number2);
        et3 = findViewById(R.id.number3);
        tv1 = findViewById(R.id.textView1);

        btn1 = findViewById(R.id.button);
        btn1.setOnClickListener(this);

    }

    public void calcularPromedio() {
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();
        String valor3 = et3.getText().toString();
        if((valor1.equals("") || valor2.equals("") || valor3.equals(""))){
            tv1.setText("debe ingresar las notas finales de cada asignatura para calcular el promedio, revise los campos y asegurese de que no esten vacios");

        }else{
            float num1  = Float.parseFloat(valor1);
            float num2  = Float.parseFloat(valor2);
            float num3  = Float.parseFloat(valor3);
            float Promedio = (num1+num2+num3)/3;
            String resultadoPromedio = "";
            if(Promedio > 10){
                resultadoPromedio = "Las notas que introdujo estan herradas";

            }else if(Promedio >= 7){
                resultadoPromedio = "Su promedio es aprobatorio con un valor de: " + Promedio ;
            }
            else{
                resultadoPromedio = "Su promedio es muy bajo, con un valor de: " + Promedio + " no aprobara el semestre"  ;
            }

            String result = String.valueOf(resultadoPromedio);
            tv1.setText(result);
        }

    }

    @Override
    public void onClick(View view) {
        if(view == btn1){
            calcularPromedio();
        }
    }
}