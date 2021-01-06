package com.example.alertbuilderexample;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button2);
        button.setOnClickListener(this);
        builder = new AlertDialog.Builder(this);
    }

    @Override
    public void onClick(View v) {
        builder.setTitle("Test");
        View viewInflated = LayoutInflater.from(this).inflate(R.layout.alert, (ViewGroup) findViewById(android.R.id.content).getRootView(), false);
        builder.setView(viewInflated);
        final Button button2 = viewInflated.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Du trykkede på knappen inde i alerten");

            }
        });
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                System.out.println("Du trykkede på OK!");
            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                System.out.println("Du trykkede på CANCEL!");
            }
        });

        builder.show();
    }
}