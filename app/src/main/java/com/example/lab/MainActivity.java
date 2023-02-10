package com.example.lab;

import android.app.Activity;
import android.text.TextUtils;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
    final int MENU_RESET_ID = 1;
    final int MENU_QUIT_ID = 2;
    EditText etN1, etNum2, etNum3;
    Button btnAdd, btnSub, btnMult, btnDiv;
    TextView tvResult, info;
    String oper = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        etN1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);
        etNum3 = (EditText) findViewById(R.id.etNum3);

        tvResult = (TextView) findViewById(R.id.tvResult);
        info = (TextView) findViewById(R.id.info);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

        info.setText("Introduceți câte un număr În fiecare dintre cele două casete de mai jos, apoi apăsați butonul respectiv");
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        float num1, num2, num3;
        float result = 0;

        // check if the fields are empty
        if (TextUtils.isEmpty(etN1.getText().toString()) || TextUtils.isEmpty(etNum2.getText().toString())) {
            return;
        }

        num1 = Float.parseFloat(etN1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());
        num3 = Float.parseFloat(etNum3.getText().toString());

        switch (v.getId()) {
            case R.id.btnAdd:
                oper = "+";
                result = num1 + num2 + num3;
                break;

            case R.id.btnSub:
                oper = "-";
                result = num1 - num2 - num3;
                break;

            case R.id.btnMult:
                oper = "*";
                result = num1 * num2 * num3;
                break;

            case R.id.btnDiv:
                oper = "/";
                result = num1 / num2 / num3;
                break;

            default:
                break;
        }
        // form the output line
        tvResult.setText(num1 + " " + oper + " " + num2 + " " + oper + " " + num3 + " = " + result);
    }
}