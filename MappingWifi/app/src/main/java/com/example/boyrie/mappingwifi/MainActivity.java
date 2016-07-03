package com.example.boyrie.mappingwifi;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bloque la rotation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Association des bouttons avec leurs equivalents graphique
        Button btnMapping = (Button) findViewById(R.id.btnMapping);
        Button btnMaps = (Button) findViewById(R.id.btnMap);
        Button btnWifi = (Button) findViewById(R.id.btnWifi);
        Button btnQuitter = (Button) findViewById(R.id.btnQuitter);

        try{
            btnMapping.setOnClickListener((onClickButtonListener));
            btnMaps.setOnClickListener((onClickButtonListener));
            btnWifi.setOnClickListener((onClickButtonListener));
            btnQuitter.setOnClickListener((onClickButtonListener));
        }catch (NullPointerException e){
            Log.e("Exception Recu", "Onclick Error");
        }

    }

    //Gestionnaire des clics sur les boutons du menu
    private View.OnClickListener onClickButtonListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {

            Intent myIntent;
            switch (v.getId()) {
                case R.id.btnMap: // Creation d'un objet Intent permettant de lancer l'activité en fonction
                    myIntent = new Intent(MainActivity.this, MapActivity.class);
                    startActivity(myIntent);
                    break;

                case R.id.btnMapping:
                    myIntent = new Intent(MainActivity.this, HeatMapsActivity.class);
                    startActivity(myIntent);
                    break;

                case R.id.btnParametre:
                    myIntent = new Intent(MainActivity.this, ParametreActivity.class);
                    startActivity(myIntent);
                    break;

                case R.id.btnQuitter:
                    finish();
                    System.exit(0);
                    break;
            }
        }
    };

}
