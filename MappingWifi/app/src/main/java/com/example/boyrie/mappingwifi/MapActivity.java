package com.example.boyrie.mappingwifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Boyrie on 20/06/2016.
 */
public class MapActivity extends Activity {

    WifiManager wifiManagerHeatMap;
    ListView listViewWifi;
    WifiScanReceiver wifiReciever;
    TextView textStatus;
    Button buttonScan;
    int size = 0;
    List<ScanResult> results;
    String wifis[];


    String ITEM_KEY = "key";
    ArrayList<HashMap<String, String>> arraylist = new ArrayList<HashMap<String, String>>();
    SimpleAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interface_map);


//        textStatus = (TextView) findViewById(R.id.textStatus);
//        buttonScan = (Button) findViewById(R.id.buttonScan);
//        buttonScan.setOnClickListener(this);
        listViewWifi = (ListView)findViewById(R.id.listView);

        //Gestion de la détection des réseaux wifi
//        wifiManagerHeatMap = (WifiManager) getSystemService(Context.WIFI_SERVICE);
//        if (wifiManagerHeatMap.isWifiEnabled() == false)
//        {
//            Toast.makeText(getApplicationContext(), "wifi is disabled..making it enabled", Toast.LENGTH_LONG).show();
//            wifiManagerHeatMap.setWifiEnabled(true);
//        }
//         this.adapter = new SimpleAdapter(MapActivity.this, arraylist, R.layout.interface_map, new String[] { ITEM_KEY }, new int[] { R.id.listView });
//        listViewWifi.setAdapter(this.adapter);
//
//        registerReceiver(new BroadcastReceiver()
//        {
//            @Override
//            public void onReceive(Context c, Intent intent)
//            {
//                results = wifiManagerHeatMap.getScanResults();
//                size = results.size();
//            }
//        }, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));


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


        wifiManagerHeatMap=(WifiManager)getSystemService(Context.WIFI_SERVICE);
        wifiReciever = new WifiScanReceiver();
        wifiManagerHeatMap.startScan();

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

                case R.id.btnParametre:
                    myIntent = new Intent(MapActivity.this, ParametreActivity.class);
                    startActivity(myIntent);
                    break;

//                case R.id.btnWifi:
//                    myIntent = new Intent(MapActivity.this, ParametreActivity.class);
//                    startActivity(myIntent);
//                    break;
                }
            }
        };

    protected void onPause() {
        unregisterReceiver(wifiReciever);
        super.onPause();
    }

    protected void onResume() {
        registerReceiver(wifiReciever, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        super.onResume();
    }

    private class WifiScanReceiver extends BroadcastReceiver{
        public void onReceive(Context c, Intent intent) {
            List<ScanResult> wifiScanList = wifiManagerHeatMap.getScanResults();
            wifis = new String[wifiScanList.size()];

            for(int i = 0; i < wifiScanList.size(); i++){
                wifis[i] = ((wifiScanList.get(i)).toString());
            }
            listViewWifi.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,wifis));
        }
    }

}
