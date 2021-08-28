package com.example.taxiapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class dash extends AppCompatActivity {

    public TextView txt5,txt6;
    public ImageButton imgbtn1;
    public CardView tp1, tp2, tp3, tp4, th1, th2, th3, th4,custom;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Taxi  taxi =(Taxi)getIntent().getSerializableExtra("Taxi");
        txt5 = findViewById(R.id.txtView5);
        txt6 = findViewById(R.id.txtView6);
        txt5.setText(taxi.getFname());
        txt6.setText(taxi.getPhn());
        imgbtn1 = findViewById(R.id.imgBtn1);
        imgbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                func_one();
            }
        });

        tp1 = findViewById(R.id.tp1);
        tp2 = findViewById(R.id.tp2);
        tp3 = findViewById(R.id.tp3);
        tp4 = findViewById(R.id.tp4);
        th1 = findViewById(R.id.th1);
        th2 = findViewById(R.id.th2);
        th3 = findViewById(R.id.th3);
        th4 = findViewById(R.id.th4);
        custom = findViewById(R.id.custom);

        tp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cform(taxi.getFname(),taxi.getPhn(),"Jantar Mantar");
            }
        });

        tp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cform(taxi.getFname(), taxi.getPhn(), "Red Fort");
            }
        });

        tp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cform(taxi.getFname(), taxi.getPhn(), "India Gate");
            }
        });

        tp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cform(taxi.getFname(), taxi.getPhn(), "Lodhi Garden");
            }
        });

        th1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chotel(taxi.getFname(), taxi.getPhn(), "Leela Hotel");
            }
        });

        th2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chotel(taxi.getFname(), taxi.getPhn(),"The Oberoi");
            }
        });
        th3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chotel(taxi.getFname(), taxi.getPhn(), "ITC Maurya");
            }
        });
        th4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chotel(taxi.getFname(), taxi.getPhn(), "Eros Hotel");
            }
        });

        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customfunc(taxi.getFname(), taxi.getPhn(), "Required");
            }
        });
    }

    private void customfunc(String name, String phn, String place) {
        Intent intent = new Intent(getApplicationContext(), form.class);
        Taxi new_taxi = new Taxi(name, phn, "Required","Required",place,"Required");
        intent.putExtra("Taxi",new_taxi);
        startActivity(intent);
    }

    private void chotel(String name, String phn, String place) {
        Intent intent = new Intent(getApplicationContext(), form.class);
        Taxi new_taxi = new Taxi( name, phn,"Required","NR",place,"New Delhi");
        intent.putExtra("Taxi",new_taxi);
        startActivity(intent);
    }

    private void cform(String name, String phn, String place) {
        Intent intent = new Intent(getApplicationContext(),form.class);
        Taxi new_taxi = new Taxi(name,phn,"Required","NR",place,"New Delhi");
        intent.putExtra("Taxi",new_taxi);
        startActivity(intent);
    }

    private void func_one() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
