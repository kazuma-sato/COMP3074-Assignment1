package com.comp3074.kazumasato.clicktester;
/*
George Brown College
COMP3074 Fall 2016 Assignment 1
Due Date: Saturday, October 8, 2016
Instructor Ilir Dema
Kazuma Sato 100 948 212
kazuma.sato@georgebrown.ca
*/
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.widget.Button;
import android.widget.Toast;

import java.io.Console;


public class MainActivity extends AppCompatActivity
    implements View.OnClickListener{
    private String eventName;
    private String viewName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eventName = "";
        viewName = "";
        Button button = (Button)findViewById(R.id.button1);

        View red = findViewById(R.id.redViewTag);
        View green = findViewById(R.id.greenViewTag);
        View yellow = findViewById(R.id.yellowViewTag);
        View blue = findViewById(R.id.blueViewTag);

        button.setOnClickListener(this);
        red.setOnClickListener(this);
        green.setOnClickListener(this);
        blue.setOnClickListener(this);
        yellow.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        eventName = "clicked";

        getViewName(v);

        Toast.makeText(this
                , "The " + viewName + " was " + eventName + "."
                , Toast.LENGTH_SHORT
            ).show();
    }
    private void getViewName(View v){
        switch (v.getId()){
            case R.id.redViewTag:
                viewName = "red";
                break;
            case R.id.greenViewTag:
                viewName = "green";
                break;
            case R.id.blueViewTag:
                viewName = "blue";
                break;
            case R.id.yellowViewTag:
                viewName = "yellow";
                break;
            case R.id.button1:
                exit();
                break;
            default:
        }
    }
    private void exit(){

    }
}
