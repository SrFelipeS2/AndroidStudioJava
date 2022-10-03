package com.example.myfristaplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private TextView tv1;
    private RadioButton rb1,rb2,rb3, rb4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.number1);
        et2 = (EditText)findViewById(R.id.number2);
        tv1 = (TextView)findViewById(R.id.txtShowCalculate);
        rb1 = (RadioButton)findViewById(R.id.rSumar);
        rb2 = (RadioButton)findViewById(R.id.rRestar);
        rb3 = (RadioButton)findViewById(R.id.rMultiplicar);
        rb4 = (RadioButton)findViewById(R.id.rDividir);
    }


    public void Calcular(View view){
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();

        if(valor2.equals("")||valor1.equals("")){
            String informacion = "Campos vacios rellene los valores ";
            tv1.setText(informacion);
        }else{
            if(rb1.isChecked() == false&&rb2.isChecked() == false&&rb3.isChecked() == false&&rb4.isChecked() == false){
                String informacion = "seleccione que desea hacer con los valores ingresados ";
                tv1.setText(informacion);
            }else{
                int num1 = Integer.parseInt(valor1);
                int num2 = Integer.parseInt(valor2);

                if(rb1.isChecked() == true){
                    int suma = num1 + num2;
                    String  result = String.valueOf(suma);
                    tv1.setText(result);
                }else if(rb2.isChecked() == true){
                    int resta = num1 - num2;
                    String  result = String.valueOf(resta);
                    tv1.setText(result);
                }else if(rb3.isChecked() == true){
                    int multiplicacion = num1 * num2;
                    String  result = String.valueOf(multiplicacion);
                    tv1.setText(result);
                }else if(rb4.isChecked() == true){

                    if(num2 != 0){
                        int dividr = num1 / num2;
                        String  resultDividir = String.valueOf(dividr);
                        tv1.setText(resultDividir);
                    }else{
                        String informacion = "no se puede dividr entre 0";
                        tv1.setText(informacion);
                    }
                }
            }

        }
    }
    /*public void Restar(View view){
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();

        int num1 = Integer.parseInt(valor1);
        int num2 = Integer.parseInt(valor2);
        int resta = num1 - num2;

        String  resultResta = String.valueOf(resta);
        tv1.setText(resultResta);


    }
    public void Multiplicar(View view){
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();

        int num1 = Integer.parseInt(valor1);
        int num2 = Integer.parseInt(valor2);
        int multiplicacion = num1 * num2;

        String  resultMultiplicacion = String.valueOf(multiplicacion);
        tv1.setText(resultMultiplicacion);
    }
    public void Dividir(View view){
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();

        int num1 = Integer.parseInt(valor1);
        int num2 = Integer.parseInt(valor2);
        if(num2 != 0){
            int dividr = num1 / num2;
            String  resultDividir = String.valueOf(dividr);
            tv1.setText(resultDividir);
        }else{
            String informacion = "no se puede dividr entre 0";
            tv1.setText(informacion);
        }

    }*/
}