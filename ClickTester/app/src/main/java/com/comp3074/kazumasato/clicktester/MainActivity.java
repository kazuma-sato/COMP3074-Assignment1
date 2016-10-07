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
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
    implements View.OnClickListener, View.OnLongClickListener{

    private String viewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button1);

        // Creates an array for all the views eventslisteners will be applied to
        View views[] = {
                findViewById(R.id.redViewTag),
                findViewById(R.id.greenViewTag),
                findViewById(R.id.yellowViewTag),
                findViewById(R.id.blueViewTag)
        };

        button.setOnClickListener(this);

        // applying onClick and onLongClick
        for(View i : views) {
            i.setOnClickListener(this);
            i.setOnLongClickListener(this);
        }

    }

    // creating toast for onclick
    @Override
    public void onClick(View v) {
        Toast.makeText(
                this,
                "The " + getViewName(v) + " box was held.",
                Toast.LENGTH_SHORT
        ).show();
    }

    // creating toast for onlongclick
    @Override
    public boolean onLongClick(View v) {

        Toast.makeText(
                this,
                "The " + getViewName(v) + " box was held.",
                Toast.LENGTH_SHORT
        ).show();
        return true;
    }
    // returning a string based on which view the event occured on.
    private String getViewName(View v) { //
        switch (v.getId()) {
            case R.id.redViewTag:
                return "red";
            case R.id.greenViewTag:
                return "green";
            case R.id.blueViewTag:
                return "blue";
            case R.id.yellowViewTag:
                return "yellow";
            default:
                finish();
                System.exit(0);
        }
        return "";
    }
}
