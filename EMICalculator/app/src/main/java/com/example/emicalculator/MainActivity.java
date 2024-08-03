package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText PrincipalEditText;
    private EditText InterestEditText;
    private EditText NOMEditText;
    private Button calculateButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        onClick();

        resultText.setText("Click on Calculate");


    }

    private void findView(){

        PrincipalEditText = findViewById(R.id.edit_text_principala);
        InterestEditText = findViewById(R.id.edit_text_interest);
        NOMEditText = findViewById(R.id.edit_text_nom);
        calculateButton = findViewById(R.id.edit_text_button);
        resultText = findViewById(R.id.edit_text_view_result);
    }

    private void onClick() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this,"Wow! This button works on clicking.Cool!",Toast.LENGTH_LONG).show();
                calculateEMI();
            }
        });
    }

    private void calculateEMI() {
        String PrincipalText = PrincipalEditText.getText().toString();
        String InterestText = InterestEditText.getText().toString();
        String NOMText = NOMEditText.getText().toString();

        int p = Integer.parseInt(PrincipalText);
        double i = Double.parseDouble(InterestText);
        int n = Integer.parseInt(NOMText);
        double PI = Math.pow((1+i),n);
        double EMI = p * i * (PI/(PI-1));

        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String EmiTextResult = myDecimalFormatter.format(EMI);
        resultText.setText("Your EMI is "+EmiTextResult+" Rs");
    }

}