package com.example.taxiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {

    public ConstraintLayout cl;

    public EditText edt1, edt2;
    public Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        edt1=findViewById(R.id.edtView1);
        edt2=findViewById(R.id.edtView2);
        cl=findViewById(R.id.cl);

        btn=findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(edt1.getText().toString()) && TextUtils.isEmpty(edt2.getText().toString()))
                {
                    Snackbar.make(cl,"Please fill the above fields.",Snackbar.LENGTH_SHORT ).show();
                }
                else
                {
                    if(edt2.getText().toString().length()>10 || edt2.getText().toString().length()<10)
                    {
                        Snackbar.make(cl,"Please fill a valid phone number.",Snackbar.LENGTH_SHORT).show();
                    }
                    else
                    {
                        maindash();
                    }
                }
            }
        });


    }

    private void maindash() {
        Intent intent = new Intent(getApplicationContext(),dash.class);
        Taxi taxi = new Taxi(edt1.getText().toString(),edt2.getText().toString(),"Required","Required","Required","Required");
        intent.putExtra("Taxi",taxi);
        startActivity(intent);
    }
}