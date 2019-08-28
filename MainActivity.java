package com.example.a17094857.temperatureconverter;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1=(Button)findViewById(R.id.buttonConvert);
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView textView = (TextView) findViewById(R.id.textView);

                EditText display = (EditText) findViewById(R.id.editTextDegrees);

                RadioButton toCent = (RadioButton) findViewById(R.id.radioCentigrade);
                RadioButton toFare = (RadioButton) findViewById(R.id.radioFarehnheit);
                RadioButton toKelv = (RadioButton) findViewById(R.id.radioKelvin);

                RadioButton fromCent = (RadioButton) findViewById(R.id.fromC);
                RadioButton fromFare = (RadioButton) findViewById(R.id.fromF);
                RadioButton fromKelv = (RadioButton) findViewById(R.id.fromK);

                CheckBox intOnly = (CheckBox) findViewById(R.id.checkIntOnly);

                String strToCon = display.getText().toString();
                //double numToCon = Double.parseDouble(strToCon);
                float intNumToCon = (float)Double.parseDouble(strToCon);

                if(fromCent.isChecked())
                {
                    if(toFare.isChecked())
                    {
                        if(intOnly.isChecked())
                        {
                            long l1 = Math.round(CtoF(intNumToCon));
                            String number1 = String.valueOf(l1);
                            textView.setText(number1 + " Farehnheit");

                        }else{
                            String eNumber1 = convertToString(CtoF(intNumToCon));
                            textView.setText(eNumber1 + " Farehnheit");

                        }

                    }else if(toKelv.isChecked())
                    {
                        if(intOnly.isChecked())
                        {
                            long l2 = Math.round(CtoK(intNumToCon));
                            String number2 = String.valueOf(l2);
                            textView.setText(number2 + " Kelvin");

                        }else{
                            String eNumber2 = convertToString(CtoK(intNumToCon));
                            textView.setText(eNumber2 + " Kelvin");

                        }

                    }else{
                        textView.setText("Please check a valid to... Radio button");

                    }
                }else if(fromFare.isChecked())
                {
                    if(toCent.isChecked())
                    {
                        if(intOnly.isChecked())
                        {
                            long l4 = Math.round(FtoC(intNumToCon));
                            String number4 = String.valueOf(l4);
                            textView.setText(number4 + " Centigrade");

                        }else{
                            String eNumber4 = convertToString(FtoC(intNumToCon));
                            textView.setText(eNumber4 + " Centigrade");

                        }

                    }else if(toKelv.isChecked())
                    {
                        if(intOnly.isChecked())
                        {
                            long l5 = Math.round(FtoK(intNumToCon));
                            String number5 = String.valueOf(l5);
                            textView.setText(number5 + " Kelvin");

                        }else{
                            String eNumber5 = convertToString(FtoK(intNumToCon));
                            textView.setText(eNumber5 + " Kelvin");

                        }

                    }else {
                        textView.setText("Please check a valid to... Radio button");

                    }
                }else if(fromKelv.isChecked())
                {
                    if(toCent.isChecked())
                    {
                        if(intOnly.isChecked())
                        {
                            long l7 = Math.round(KtoC(intNumToCon));
                            String number7 = String.valueOf(l7);
                            textView.setText(number7 + " Centigrade");

                        }else{
                            String eNumber7 = convertToString(KtoC(intNumToCon));
                            textView.setText(eNumber7 + " Centigrade");

                        }

                    }else if(toFare.isChecked())
                    {
                        if(intOnly.isChecked())
                        {
                            long l8 = Math.round(KtoF(intNumToCon));
                            String number8 = String.valueOf(l8);
                            textView.setText(number8 + " Farehnheit");

                        }else{
                            String eNumber8 = convertToString(KtoF(intNumToCon));
                            textView.setText(eNumber8 + " Farehnheit");

                        }

                    }else {
                        textView.setText("Please check a valid to... Radio button");

                    }
                }else {
                    textView.setText("Please check a from... Radio button");

                }


                /*if(toCent.isChecked())
                {
                    if(intOnly.isChecked())
                    {
                        long l = Math.round(toC(intNumToCon));
                        String word = String.valueOf(l);
                        textView.setText(word + " Centigrade");
                    }else{
                        String centAns = toCentigrade(numToCon);
                        textView.setText(centAns + " Centigrade");
                    }

                }else if(toFare.isChecked())
                {
                    if (intOnly.isChecked())
                    {
                        long l1 = Math.round(toF(intNumToCon));
                        String word1 = String.valueOf(l1);
                        textView.setText(word1 + " Farehnheit");
                    }else {
                    String fareAns = toFarehnheit(numToCon);
                    textView.setText(fareAns + " Farehnheit");
                }

                }*/


            }
        });
    }

    public float CtoF(float a)
    {
    float b;
        b=(a*9/5)+32           ;
        return b;
    }

    public float CtoK(float c)
    {
        float d;
        d=(float)(c+273.15);
        return d;
    }

    public float FtoC(float e)
    {
        float f;
        f=(e-32)*5/9;
        return f;
    }

    public float FtoK(float g)
    {
        float h;
        h= (float)((g-32)*5/9+273.15);
        return h;
    }

    public float KtoC(float i)
    {
        float j;
        j=(float)(i-273.15);
        return j;
    }

    public float KtoF(float k)
    {
        float l;
        l=(float)((k-273.15)*9/5+32);
        return l;
    }

    public String convertToString(float i)
    {
        String num = Float.toString(i);
        return num;
    }

}
