package com.example.daniel.ersteapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

public class GetHighscoreActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String PREFS_NAME = "MyPrefsFile";
    EditText inputName;
    int points = 0;



    @Override
    protected void onCreate(Bundle State) {
        super.onCreate(State);
        setContentView(R.layout.activity_get_highscore);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setLogo(R.drawable.ic_star_black_24dp);
        ab.setDisplayUseLogoEnabled(true);
        ab.setDisplayShowHomeEnabled(true);

        Bundle zielkorb = getIntent().getExtras();
        points = zielkorb.getInt("zehn_datenpaket");

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

    // Anfang der Action Bar oben recht
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_gethighscore_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.menu_id:
                Toast.makeText(getApplicationContext(),"Menü ist ausgewählt", Toast.LENGTH_SHORT).show();
                Intent menu = new Intent(GetHighscoreActivity.this, MainActivity.class);
                startActivity(menu);
                return true;

            case R.id.zehn_id:
                Toast.makeText(getApplicationContext(),"Spiel Zehn ist ausgewählt", Toast.LENGTH_SHORT).show();
                Intent zehn = new Intent(GetHighscoreActivity.this, ZehnActivity.class);
                startActivity(zehn);
                return true;

            case R.id.hundert_id:
                Toast.makeText(getApplicationContext(),"Spiel Hundert ist ausgewählt", Toast.LENGTH_SHORT).show();
                Intent hundert = new Intent(GetHighscoreActivity.this, HundertActivity.class);
                startActivity(hundert);
                return true;

            case R.id.zehn_highscore_id:
                Toast.makeText(getApplicationContext(),"Zehner Highscore ist ausgewählt", Toast.LENGTH_SHORT).show();
                Intent highscore = new Intent(GetHighscoreActivity.this, ShowHighScoreActivity.class);
                startActivity(highscore);
                return true;

            case R.id.hundert_highscore_id:
                Toast.makeText(getApplicationContext(),"Hunderter Highscore ist ausgewählt", Toast.LENGTH_SHORT).show();
                Intent hundert_highscore = new Intent(GetHighscoreActivity.this, HundertShowHighscoreActivity.class);
                startActivity(hundert_highscore);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
    // Ende der Action Bar oben rechts





    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.button_save){
           //final TextView pointsView = (TextView) findViewById(R.id.points_view);

            String name = inputName.getText().toString();
            SharedPreferences prefname = getSharedPreferences("Zehn", 0);
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
            finish();
        }
    }

}

