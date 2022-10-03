package com.example.control_checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText et1;
    private EditText et2;
    private TextView tv1;
    private CheckBox cb1,cb2,cb3, cb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.number1);
        et2 = findViewById(R.id.number2);
        tv1 = findViewById(R.id.txtShowCalculate);
        cb1 = findViewById(R.id.cSumar);
        cb2 = findViewById(R.id.cRestar);
        cb3 = findViewById(R.id.cMultiplicar);
        cb4 = findViewById(R.id.cDividir);
    }

    public void Calcular(View view){
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();

        if(valor2.equals("")||valor1.equals("")){
            String informacion = "Campos vacios rellene los valores ";
            tv1.setText(informacion);
        }else{
            if(cb1.isChecked() == false&&cb2.isChecked() == false&&cb3.isChecked() == false&&cb4.isChecked() == false){
               String informacion = "debe seleccionar al menos un checkbox ";
                tv1.setText(informacion);
           }else{
                String result = "";
                int num1 = Integer.parseInt(valor1);
                int num2 = Integer.parseInt(valor2);

               if(cb1.isChecked() == true){
                    int suma = num1 + num2;
                    result = " la suma es igual a: " + suma + " / ";
                }
               if(cb2.isChecked() == true){
                    int resta = num1 - num2;
                    result =  result + " la resta es igual a: " + resta + " / ";
                }
               if(cb3.isChecked() == true){
                    int multiplicacion = num1 * num2;
                    result = result + " la multiplicacion es igual a: " + multiplicacion + " / ";
                }
               if(cb4.isChecked() == true){

                    if(num2 != 0){
                        int dividir = num1 / num2;
                        result =  result + " la division es igual a: " + dividir + " / ";
                    }else{
                        result = result + "no se puede dividr entre 0";
                    }
               }
                tv1.setText(result);
            }

        }
    }

}