package com.example.daniel.ersteapp;


import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.support.v7.app.ActionBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    private Button buttonzehn;
    private Button buttonhundert;
    private Button buttonhighscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setLogo(R.drawable.ic_launcher);
        ab.setDisplayUseLogoEnabled(true);
        ab.setDisplayShowHomeEnabled(true);
       /* Toolbar myMainActivity = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myMainActivity);
        ActionBar ab = getSupportActionBar();

        ab.setDisplayShowHomeEnabled(true);*/

        buttonzehn = (Button) findViewById(R.id.button_zehn);
        buttonhundert = (Button) findViewById(R.id.button_hundert);
        buttonhighscore = (Button) findViewById(R.id.button_highscore);

        buttonzehn.setOnClickListener(this);
        buttonhundert.setOnClickListener(this);
       buttonhighscore.setOnClickListener(this);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }


    // Anfang der Action Bar oben recht
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        // TODO eigenes main_activity_menu erstellen anstatt menu highscore, damit es den Stern nicht Doppelt gibt evtl. zurück ins Menü Symbol
        menuInflater.inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.menu_id:
                Toast.makeText(getApplicationContext(),"Menü ist ausgewählt", Toast.LENGTH_SHORT).show();
                Intent menu = new Intent(MainActivity.this, MainActivity.class);
                startActivity(menu);
                return true;

            case R.id.setting_id:
                Toast.makeText(getApplicationContext(),"Setting ist ausgewählt", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.info_id:
                Toast.makeText(getApplicationContext(),"Info ist ausgewählt", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.zehn_id:
                Toast.makeText(getApplicationContext(),"Spiel Zehn ist ausgewählt", Toast.LENGTH_SHORT).show();
                Intent zehn = new Intent(MainActivity.this, ZehnActivity.class);
                startActivity(zehn);
                return true;

            case R.id.hunder_id:
                Toast.makeText(getApplicationContext(),"Spiel Hundert ist ausgewählt", Toast.LENGTH_SHORT).show();
                Intent hundert = new Intent(MainActivity.this, HundertActivity.class);
                startActivity(hundert);
                return true;

            case R.id.zehn_highscore_id:
                Toast.makeText(getApplicationContext(),"Zehner Highscore ist ausgewählt", Toast.LENGTH_SHORT).show();
                Intent highscore = new Intent(MainActivity.this, ShowHighScoreActivity.class);
                startActivity(highscore);
                return true;

            case R.id.hundert_highscore_id:
                Toast.makeText(getApplicationContext(),"Hunderter Highscore ist ausgewählt", Toast.LENGTH_SHORT).show();
                //Intent highscore = new Intent(MainActivity.this, ShowHighScoreActivity.class);
                //startActivity(highscore);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
    // Ende der Action Bar oben rechts




    public void onClick(View view) {
        int ce = view.getId();

        if (ce == R.id.button_zehn){
            Intent zehn = new Intent(MainActivity.this, ZehnActivity.class);
            startActivity(zehn);
        }

        if (ce == R.id.button_hundert){
            Intent hundert = new Intent(MainActivity.this, HundertActivity.class);
            startActivity(hundert);
        }

        if (ce == R.id.button_highscore){
            Intent highscore = new Intent(MainActivity.this, ShowHighScoreActivity.class);
            startActivity(highscore);
        }
        finish();
    }

}

