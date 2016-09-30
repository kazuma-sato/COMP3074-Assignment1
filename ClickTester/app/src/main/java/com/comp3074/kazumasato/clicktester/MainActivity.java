package com.comp3074.kazumasato.clicktester;
/*
George Brown College
COMP3074 Fall 2016 Assignment 1
Due Date: Saturday, October 8, 2016
Instructor Ilir Dema
Kazuma Sato 100 948 212
kazuma.sato@georgebrown.ca
*/
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
    implements View.OnClickListener, View.OnLongClickListener{

    private String eventName;
    private String viewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eventName = "";
        viewName = "";

        Button button = (Button) findViewById(R.id.button1);
        View views[] = {
                findViewById(R.id.redViewTag),
                findViewById(R.id.greenViewTag),
                findViewById(R.id.yellowViewTag),
                findViewById(R.id.blueViewTag)
        };

        button.setOnClickListener(this);
        for(View i : views) {
            i.setOnClickListener(this);
            i.setOnLongClickListener(this);
        }

    }
    @Override
    public void onClick(View v){
        eventName = "clicked";

        getViewName(v);

        Toast.makeText(this
                , "The " + viewName + " box was " + eventName + "."
                , Toast.LENGTH_SHORT
            ).show();
    }
    public boolean onLongClick(View v){
        eventName = "held";

        getViewName(v);

        Toast.makeText(this
                , "The " + viewName + " box was " + eventName + "."
                , Toast.LENGTH_SHORT
        ).show();
        return true;
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
            default:
                finish();
                System.exit(0);
        }
        return;
    }
    private void exit(){

    }
}
