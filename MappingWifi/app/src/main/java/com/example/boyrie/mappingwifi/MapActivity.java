package com.example.boyrie.mappingwifi;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Boyrie on 20/06/2016.
 */
public class MapActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interface_map);

        //Bloque la rotation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //Association des bouttons avec leurs equivalents graphique
        Button btnMenu = (Button) findViewById(R.id.btnMenu);
        Button btnParametre = (Button) findViewById(R.id.btnParametre);

        try{
            btnMenu.setOnClickListener((onClickButtonListener));
            btnParametre.setOnClickListener((onClickButtonListener));
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
                    case R.id.btnMenu: // Creation d'un objet Intent permettant de lancer l'activité en fonction
                        myIntent = new Intent(MapActivity.this, MainActivity.class);
                        startActivity(myIntent);
                        break;

                /*case R.id.btnMap:
                    myIntent = new Intent(MainActivity.this, SupportActivity.class);
                    startActivity(myIntent);
                    break;

                case R.id.btnWifi:
                    myIntent = new Intent(MainActivity.this, ContactActivity.class);
                    startActivity(myIntent);
                    break;*/
                }
            }
        };
}
