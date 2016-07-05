package com.example.daniel.ersteapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Map;

public class ShowHighScoreActivity extends AppCompatActivity {



    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_high_score);

        //Restore preferences
        //SharedPreferences sharedPreferences = getSharedPreferences("NAME", MODE_PRIVATE);
        //String name = sharedPreferences.getString("myname", "no name found");

        //if (sharedPreferences.getInt("HIGHSCORE", 0) >= points){
        //    points = sharedPreferences.getInt("HIGHSCORE", 0);
        //}

        //textViewName.setText(name);
        //textViewPoints.setText(String.valueOf(points));

        //Mein Vorschlag - Seeger
        SharedPreferences sharedPreferences = getSharedPreferences("NAME", MODE_PRIVATE);
        TextView textViewName = (TextView) findViewById(R.id.textView_Name);
        TextView textViewPoints = (TextView) findViewById(R.id.textView_Points);

        String name = "";
        String points = "";
        Map<String, ?> allEntries = sharedPreferences.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            name += entry.getKey() + "\n";
            points += entry.getValue().toString()  + "\n";;
        }

        textViewName.setText(name);
        textViewPoints.setText(String.valueOf(points));
    }


}