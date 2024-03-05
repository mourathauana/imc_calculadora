package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    float weight;
    float height;
    float bmi;
    String message = "";

    EditText editWeight, editHeight;
    TextView result;
    Button buttonCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editWeight = findViewById(R.id.editWeight);
        editHeight = findViewById(R.id.editHeight);
        result = findViewById(R.id.result);
        buttonCalc = findViewById(R.id.buttonCalc);

        buttonCalc.setOnClickListener (new View.OnClickListener() {
           @Override
            public void  onClick (View view) {
               weight = Float.parseFloat(editWeight.getText().toString());
               height = Float.parseFloat(editHeight.getText().toString());

               bmi = weight / (height * height);

               if (bmi < 18.5){
                   message = "Abaixo do peso";
               } else if ((bmi >= 18.5) && (bmi < 25)){
                   message = "Peso ideal";
               } else if ((bmi >= 25.0) && (bmi < 30.0)){
                   message = "Levemente acima do peso";
               } else if ((bmi >= 30.0) && (bmi < 35.0)){
                   message = "Obesidade Grau I";
               } else if ((bmi >= 35.0) && (bmi < 40.0)){
                   message = "Obesidade Grau II (Severa)";
               } else {
                   message = "Obesidade Grau III (Mórbida)";
               }

               result.setText("IMC: " + String.valueOf(bmi) + "\nMensagem: " + message);
           }
        });
    }
}