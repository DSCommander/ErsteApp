package com.example.daniel.ersteapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GetHighscoreActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String PREFS_NAME = "MyPrefsFile";
    //private class MainActivity{};
    EditText inputName;
    TextView inputPoints;
    int points = 0;
    int zah = 0;
    int test = 55;


    @Override
    protected void onCreate(Bundle State) {
        super.onCreate(State);
        setContentView(R.layout.activity_get_highscore);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle zielkorb = getIntent().getExtras();
        points = zielkorb.getInt("datenpaket1");

        TextView pointsView = (TextView) findViewById(R.id.points_view);
        pointsView.setText("Punkte: " + points);

        //SharedPreferences pref = getSharedPreferences("GAME", 0);
        //zah = pref.getInt("zahl", 4);

        inputName = (EditText)findViewById(R.id.editText_Name);
        //inputPoints = (TextView) findViewById(R.id.points_view);
        Button saveButton = (Button) findViewById(R.id.button_save);
        Button viewButton = (Button) findViewById(R.id.button_view);

        saveButton.setOnClickListener(this);
        viewButton.setOnClickListener(this);


    }


     @Override
    public void onClick(View view) {
        if(view.getId()==R.id.button_save){
           //final TextView pointsView = (TextView) findViewById(R.id.points_view);

            String name = inputName.getText().toString();
            SharedPreferences prefname = getSharedPreferences("NAME", 0);
            SharedPreferences.Editor editor = prefname.edit();

            //SharedPreferences prefpoints = getSharedPreferences("GAME", 0);
            //SharedPreferences.Editor editor = prefpoints.edit();

           //pointsView.setText(String.valueOf(points));

            //editor.putString("myname",name);
            //editor.putInt("punkte", 0);
            //editor.putInt("HIGHSCORE", points);

            //Mein Vorschlag - Seeger
            editor.putInt(name, points);

            editor.apply();

            editor.commit();


            


        }else{

            startActivity(new Intent(getApplicationContext(),ShowHighScoreActivity.class));

        }
    }

}

