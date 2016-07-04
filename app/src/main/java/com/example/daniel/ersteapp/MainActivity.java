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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

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
    }
}

