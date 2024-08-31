package com.example.bmib1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private RadioButton maleButton;
    private RadioButton femaleButton;
    private EditText ageEditText;
    private EditText feetEditText;
    private EditText inchesEditText;
    private EditText weightEditText;
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
        maleButton = findViewById(R.id.radio_button_male);
        femaleButton = findViewById(R.id.radio_button_female);
        ageEditText = findViewById(R.id.edit_text_age);
        feetEditText = findViewById(R.id.edit_text_feet);
        inchesEditText = findViewById(R.id.edit_text_inches);
        weightEditText = findViewById(R.id.edit_text_weight);
        calculateButton = findViewById(R.id.edit_text_button);
        resultText = findViewById(R.id.edit_text_view_result);
    }

    private void onClick() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this,"Wow! This button works on clicking.Cool!",Toast.LENGTH_LONG).show();
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String ageText = ageEditText.getText().toString();
        String feetText = feetEditText.getText().toString();
        String inchesText = inchesEditText.getText().toString();
        String weightText = weightEditText.getText().toString();

        //resultText.setText("Age :"+ ageText + ", feet" + feetText + ", inches :" + inchesText + ", weight :" + weightText);

        int age = Integer.parseInt(ageText);
        int feet = Integer.parseInt(feetText);
        int inches = Integer.parseInt(inchesText);
        int weight = Integer.parseInt(weightText);

        int totalInches = (feet*12)+inches;
        double HeightinMeters = totalInches * 0.0254;
        double bmi = weight / (HeightinMeters*HeightinMeters);

        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);
        resultText.setText(bmiTextResult);
        String fullResultString;
        if(bmi<18.5)
        {
            fullResultString = bmiTextResult + "You are Under weight";
        }else if(bmi>25){
            fullResultString = bmiTextResult + "You are Over weight";
        }else{
            fullResultString = bmiTextResult + "You are Healthy";
        }
        resultText.setText(fullResultString);
    }

}