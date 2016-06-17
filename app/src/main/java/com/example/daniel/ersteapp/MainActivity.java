package com.example.daniel.ersteapp;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.util.Random;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private int num10;
    private int num11;
    private int num100;
    private int num101;
    private int points;
    private boolean isCanceled = true;
    private long timeRemaining = 0;
    private boolean first = true;

    private CountDownTimer countDownTimer = new CountDownTimer(5999, 1000) {

        @Override
        public void onTick(long millisUntilFinished) {
            TextView TimerView = (TextView) findViewById(R.id.timer_view);
            TimerView.setText("Noch " + millisUntilFinished / 1000 + " Sekunden");
        }

        @Override
        public void onFinish() {
            TextView TimerView = (TextView) findViewById(R.id.timer_view);
            TimerView.setText("Zeit abglaufen!");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        points = 0;
        pickNumbersZehn();
        pickNumbersHundert();
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
            }
        pickNumbersZehn();
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
            // points = 0;
            // TextView pointsView = (TextView) findViewById(R.id.points_view);
            // pointsView.setText("Punkte: " + points);

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
            // points = 0;
            // TextView pointsView = (TextView) findViewById(R.id.points_view);
            // pointsView.setText("Punkte: " + points);
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