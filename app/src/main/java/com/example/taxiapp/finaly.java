package com.example.taxiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;

public class finaly extends AppCompatActivity {

    public Button quit;
    public ConstraintLayout cli;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_des);

        cli = findViewById(R.id.cli);

        Snackbar.make(cli,"Check your registered mobile phone for confirmation.",Snackbar.LENGTH_SHORT).show();

        quit = findViewById(R.id.btn3);

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newact();
            }
        });
    }

    private void newact() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
