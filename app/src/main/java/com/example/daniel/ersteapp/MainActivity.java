package com.example.daniel.ersteapp;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

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
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        // Intent zehn = new Intent(MainActivity.this, ZehnActivity.class);

        // Intent hundert = new Intent(MainActivity.this, HundertActivity.class);

        // Intent highscore = new Intent(MainActivity.this, ShowHighScoreActivity.class);


        buttonzehn = (Button) findViewById(R.id.button_zehn);
        buttonhundert = (Button) findViewById(R.id.button_hundert);
        buttonhighscore = (Button) findViewById(R.id.button_highscore);

        buttonzehn.setOnClickListener(this);
        buttonhundert.setOnClickListener(this);
        buttonhighscore.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.info_id:
                Toast.makeText(getApplicationContext(),"Info Icon ist ausgewählt", Toast.LENGTH_SHORT).show();
                break;

            case R.id.zehn_id:
                Toast.makeText(getApplicationContext(),"Spiel Zehn ist ausgewählt", Toast.LENGTH_SHORT).show();
                Intent zehn = new Intent(MainActivity.this, ZehnActivity.class);
                startActivity(zehn);
                break;

            case R.id.hunder_id:
                Toast.makeText(getApplicationContext(),"Spiel Hundert ist ausgewählt", Toast.LENGTH_SHORT).show();
                Intent hundert = new Intent(MainActivity.this, HundertActivity.class);
                startActivity(hundert);
                break;

            case R.id.highscore_id:
                Toast.makeText(getApplicationContext(),"Highscore  ist ausgewählt", Toast.LENGTH_SHORT).show();
                Intent highscore = new Intent(MainActivity.this, ShowHighScoreActivity.class);
                startActivity(highscore);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }



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

