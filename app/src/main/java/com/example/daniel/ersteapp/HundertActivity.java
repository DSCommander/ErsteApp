package com.example.daniel.ersteapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Daniel on 30.06.2016.
 */
public class HundertActivity extends AppCompatActivity {

    private int num100;
    private int num101;
    private int points;
    private boolean isCanceled = true;
    private long timeRemaining = 0;
    private boolean first = true;


    private CountDownTimer countDownTimer = new CountDownTimer(4500, 1000) {

        @Override
        public void onTick(long millisUntilFinished) {
            TextView TimerView = (TextView) findViewById(R.id.timer_view);
            TimerView.setText("Noch " + millisUntilFinished / 1000 + " Sekunden");
        }

        @Override
        public void onFinish() {
            TextView TimerView = (TextView) findViewById(R.id.timer_view);
            startActivity(new Intent(getApplicationContext(),GetHighscoreActivity.class));
            TimerView.setText("Zeit abglaufen!");
            uebergabe();
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hundert);
        // TODO hinzufügen der ActionBar mit neuem eigenem Menü und eigenem Symbol und Symbol in der OnCreateOptionMenu
        points = 0;
        pickNumbersHundert();
    }


    private void uebergabe(){

        //String text = "Test";
        Bundle korb = new Bundle();
        korb.putInt("hundert_datenpaket", points);
        Intent in = new Intent(HundertActivity.this, HundertGetHighscoreActivity.class);
        in.putExtras(korb);
        startActivity(in);
    }

    private void pickNumbersHundert() {

        TextView pointsView = (TextView) findViewById(R.id.points_view);
        pointsView.setText("Punkte: " + points);

        // initialization code
        Random randyHundert = new Random();
        while (true) {
            num100 = randyHundert.nextInt(100);
            num101 = randyHundert.nextInt(100);
            if (num100 != num101) break;
        }

        Button leftHundert = (Button) findViewById(R.id.leftHundert_button);
        Button rightHundert = (Button) findViewById(R.id.rightHundert_button);
        leftHundert.setText(String.valueOf(num100));
        rightHundert.setText(String.valueOf(num101));
    }

    //Button Hundert
    public void leftHundertButtonClick(View view) {
        if(first){
            countDownTimer.start();
            first = false;
        }
        if (num100 > num101) {
            //correct
            countDownTimer.cancel();
            countDownTimer.start();
            points++;
        } else {
            //incorrect
            countDownTimer.cancel();
            TextView TimerView = (TextView) findViewById(R.id.timer_view);
            TimerView.setText("Falsch");
            startActivity(new Intent(getApplicationContext(),GetHighscoreActivity.class));
            uebergabe();
            points = 0;
            finish();
        }
        pickNumbersHundert();
    }

    public void rightHundertButtonClick(View view) {
        if(first) {
            countDownTimer.start();
            first = false;
        }
        if (num101 > num100) {
            //correct
            countDownTimer.cancel();
            countDownTimer.start();
            points++;
        } else {
            //incorrect
            countDownTimer.cancel();
            TextView TimerView = (TextView) findViewById(R.id.timer_view);
            TimerView.setText("Falsch");
            startActivity(new Intent(getApplicationContext(),GetHighscoreActivity.class));
            uebergabe();
            points = 0;
            finish();
        }
        pickNumbersHundert();
    }

    //Zurücksetzen
    public void centerButtonClick(View view) {
        Button center = (Button) findViewById(R.id.center_button);
        points = 0;
        TextView pointsView = (TextView) findViewById(R.id.points_view);
        pointsView.setText("Punkte: " + points);

    }


}


