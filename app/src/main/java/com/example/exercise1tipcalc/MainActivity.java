package com.example.exercise1tipcalc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText cost;
    RadioGroup rg;
    Switch sw;
    Button calc;
    TextView res;
    boolean selected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cost = findViewById(R.id.amount);
        rg = findViewById(R.id.radioGroup);
        sw = findViewById(R.id.dec_sw);
        calc = findViewById(R.id.calc);
        res = findViewById(R.id.res_txt);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                double amount = Double.parseDouble(cost.getText().toString());
                Double interest = null;
                switch (rg.getCheckedRadioButtonId()){
                    case R.id.amazing_radio:
                        interest = (amount * 20)/ 100;
                        break;
                    case R.id.good_radio:
                        interest = (amount * 15)/100;
                        break;
                    case R.id.ok_radio:
                        interest = (amount * 10)/100;
                        break;
                    default:
                        break;
                }

                sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                        if(checked)
                            selected = true;
                        else
                            selected =false;
                    }
                });

                if(selected)
                    res.setText(String.valueOf(Math.round(interest)));
                else
                    res.setText(String.valueOf(interest));
            }
        });

    }
}