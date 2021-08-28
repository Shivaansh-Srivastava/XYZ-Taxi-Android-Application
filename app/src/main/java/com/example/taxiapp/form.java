package com.example.taxiapp;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;

public class form extends AppCompatActivity {

    public EditText edt3, edt4, edt5, edt6, edt7;
    public Button btncon;
    public ConstraintLayout cL;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);

        Taxi  taxi =(Taxi)getIntent().getSerializableExtra("Taxi");

        edt3 = findViewById(R.id.edtView3);
        edt4 = findViewById(R.id.edtView4);
        edt5 = findViewById(R.id.edtView5);
        edt6 = findViewById(R.id.edtView6);
        edt7 = findViewById(R.id.edtView7);
        btncon = findViewById(R.id.btncon);
        cL = findViewById(R.id.cL);

        edt3.setText(taxi.getFname());
        edt4.setText(taxi.getPhn());
        edt5.setText(taxi.getFlat());
        edt6.setText(taxi.getAddress());
        edt7.setText(taxi.getCity());



        btncon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                {
                    if(checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED)
                    {
                        sendm(taxi);
                    }
                    else
                    {
                        requestPermissions( new String[]{Manifest.permission.SEND_SMS},1);

                    }
                }
                newact();
            }
        });
    }

    private void sendm(Taxi taxi) {
        String message="Booking confirmed.Your bill amounts to ₹1000.";
        try {
            Intent intent = new Intent(getApplicationContext(),form.class);
            //PendingIntent pi = PendingIntent.getActivity(getApplicationContext(),0,intent,0);
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(taxi.getPhn(),null,message,null,null);
        } catch (Exception e) {
            Snackbar.make(cL,"Error in sending message.",Snackbar.LENGTH_SHORT).show();
        }

    }

    private void newact() {
        Intent intent = new Intent(this,finaly.class);
        startActivity(intent);
    }

}
