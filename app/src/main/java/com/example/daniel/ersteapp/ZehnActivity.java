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
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Daniel on 30.06.2016.
 */
public class ZehnActivity extends AppCompatActivity {

    private int num10;
    private int num11;
    private int points;
    private boolean isCanceled = true;
    private long timeRemaining = 0;
    private boolean first = true;


    private CountDownTimer countDownTimer = new CountDownTimer(2000, 1000) {

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
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zehn);
        // TODO hinzufügen der ActionBar mit neuem eigenem Menü und eigenem Symbol und Symbol in der OnCreateOptionMenu
        points = 0;
        pickNumbersZehn();

    }


    private void uebergabe(){

        //String text = "Test";
        Bundle korb = new Bundle();
        korb.putInt("zehn_datenpaket", points);
        Intent in = new Intent(ZehnActivity.this, GetHighscoreActivity.class);
        in.putExtras(korb);
        startActivity(in);
    }

    private void pickNumbersZehn() {
        TextView pointsView = (TextView) findViewById(R.id.points_view);
        pointsView.setText("Punkte: " + points);

        // initialization code
        Random randyZehn = new Random();
        while (true) {
            num10 = randyZehn.nextInt(10);
            num11 = randyZehn.nextInt(10);
            if (num10 != num11) break;
        }

        Button left = (Button) findViewById(R.id.left_button);
        Button right = (Button) findViewById(R.id.right_button);
        left.setText(String.valueOf(num10));
        right.setText(String.valueOf(num11));
    }




    //Button Zehn
    public void leftButtonClick(View view) {
        if(first) {
            countDownTimer.start();
            first = false;
        }
        if (num10 > num11) {
            //correct
            countDownTimer.cancel();
            countDownTimer.start();
            points++;
        } else {
            //incorrect
            first = true;
            countDownTimer.cancel();
            TextView TimerView = (TextView) findViewById(R.id.timer_view);
            TimerView.setText("Falsch!");
            uebergabe();
            points = 0;
        }
        pickNumbersZehn();
    }

    public void rightButtonClick(View view) {
        if(first) {
            countDownTimer.start();
            first = false;
        }
        if (num11 > num10) {
            //correct
            countDownTimer.cancel();
            countDownTimer.start();
            points++;
        } else {
            //incorrect
            first = true;
            countDownTimer.cancel();
            TextView TimerView = (TextView) findViewById(R.id.timer_view);
            TimerView.setText("Falsch!");
            uebergabe();
            points = 0;
        }
        pickNumbersZehn();
    }


    //Zurücksetzen
    public void centerButtonClick(View view) {
        Button center = (Button) findViewById(R.id.center_button);
        points = 0;
        TextView pointsView = (TextView) findViewById(R.id.points_view);
        pointsView.setText("Punkte: " + points);


    }

}


