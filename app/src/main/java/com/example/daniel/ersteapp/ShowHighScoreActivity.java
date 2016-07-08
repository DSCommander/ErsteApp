package com.example.daniel.ersteapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class ShowHighScoreActivity extends AppCompatActivity {


    String[] arrayName;
    int[] arrayValue;
    int zahl = 0;
    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_high_score);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setLogo(R.drawable.ic_star_black_24dp);
        ab.setDisplayUseLogoEnabled(true);
        ab.setDisplayShowHomeEnabled(true);
        Eintrag();

        //Mein Vorschlag - Seeger
    }


    // Anfang der Action Bar oben recht
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_showhighscore_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.menu_id:
                Toast.makeText(getApplicationContext(),"Menü ist ausgewählt", Toast.LENGTH_SHORT).show();
                Intent menu = new Intent(ShowHighScoreActivity.this, MainActivity.class);
                startActivity(menu);
                return true;

            case R.id.zehn_id:
                Toast.makeText(getApplicationContext(),"Spiel Zehn ist ausgewählt", Toast.LENGTH_SHORT).show();
                Intent zehn = new Intent(ShowHighScoreActivity.this, ZehnActivity.class);
                startActivity(zehn);
                return true;

            case R.id.hunder_id:
                Toast.makeText(getApplicationContext(),"Spiel Hundert ist ausgewählt", Toast.LENGTH_SHORT).show();
                Intent hundert = new Intent(ShowHighScoreActivity.this, HundertActivity.class);
                startActivity(hundert);
                return true;

            case R.id.zehn_highscore_id:
                Toast.makeText(getApplicationContext(),"Highscore ist ausgewählt", Toast.LENGTH_SHORT).show();
                Intent highscore = new Intent(ShowHighScoreActivity.this, ShowHighScoreActivity.class);
                startActivity(highscore);
                return true;

            case R.id.hundert_highscore_id:
                Toast.makeText(getApplicationContext(),"Highscore ist ausgewählt", Toast.LENGTH_SHORT).show();
                Intent hundert_highscore = new Intent(ShowHighScoreActivity.this, HundertShowHighscoreActivity.class);
                startActivity(hundert_highscore);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
    // Ende der Action Bar oben rechts



    public void Sortieren(Map<String,?> map){

        int i, j;       // Zählindizes
        int tmp;        // Hilfsvariable zu Vertauschen von Werten
        String tmpS;    // Hilfsvariable zu Vertauschen von Werten
        int n = map.size();
        arrayName = new String[n];
        arrayValue = new int[n];

        i = 0;
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            arrayName[i] = entry.getKey();
            String test = entry.getValue().toString();
            arrayValue[i] = Integer.parseInt(test);
            i++;
        }

        // durch das ganze Feld gehen

        for( i = 0; i < n; i++){
            // am Ende beginnen das kleinste Element zu suchen
            for(j = n -1; j > i; j--)
            {
                // prüfen ob das Element kleiner als das Vorgänger ist
                if(arrayValue[j] > arrayValue[j - 1])
                {
                    // Punkte vertauschen
                    tmp = arrayValue[j];
                    arrayValue[j] = arrayValue[j - 1];
                    arrayValue[j - 1] = tmp;

                    // Name vertauschen
                    tmpS = arrayName[j];
                    arrayName[j] = arrayName[j - 1];
                    arrayName[j - 1] = tmpS;
                }
            }
        }
    }


    public void Eintrag() {
        SharedPreferences sharedPreferences = getSharedPreferences("Zehn", MODE_PRIVATE);
        TextView textViewName = (TextView) findViewById(R.id.textView_Name);
        TextView textViewPoints = (TextView) findViewById(R.id.textView_Points);

        String name = "";
        String points = "";
        Map<String, ?> allEntries = sharedPreferences.getAll();
        Sortieren(allEntries);


        for (int i = 0; i < allEntries.size(); i++) {
            name += arrayName[i] + "\n";
            points += arrayValue[i] + "\n";
        }




        textViewName.setText(name);
        textViewPoints.setText(String.valueOf(points));
    }



}

