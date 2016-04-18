package com.miguel.wifimeasurebox;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.widget.TextView;

/**
 * Created by MiguelAngel on 15/04/16.
 */
public class Async_measure extends AsyncTask<Void, Integer, String> {

    New_Mes mes;
    Context cn;
    int number;


    public Async_measure(New_Mes mes, int number, Context cn) {

        this.mes = mes;
        this.number = number;
        this.cn = cn;

    }

    @Override
    protected String doInBackground(Void... params) {

        WifiManager wifiManager = (WifiManager) cn.getSystemService(Context.WIFI_SERVICE);
        int numberOfLevels = 200;
        int tries = 4;
        WifiInfo wifiInfo;
        int i = 0;
        int level = 0;
        while (i < 4) {
            publishProgress(i);
            wifiInfo = wifiManager.getConnectionInfo();
            level = level + WifiManager.calculateSignalLevel(wifiInfo.getRssi(), numberOfLevels);
            //Log.d("Level", "Level measured --> " + level);
            i++;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        level = (level / 4) / 2;


        return String.valueOf(level);
    }

    protected void onProgressUpdate(Integer... y) {

        if (number == 1) {

            TextView t = (TextView) mes.findViewById(R.id.mes1);
            t.setText("Completed test at " + (((y[0].intValue() + 1) * 100) / 4) + "%");
        } else {

            if (number == 2) {

                TextView t = (TextView) mes.findViewById(R.id.mes2);
                t.setText("Completed test at " + (((y[0].intValue() + 1) * 100) / 4) + "%");
            } else {

                if (number == 3) {

                    TextView t = (TextView) mes.findViewById(R.id.mes3);
                    t.setText("Completed test at " + (((y[0].intValue() + 1) * 100) / 4) + "%");
                }
            }
        }


    }


    protected void onPostExecute(String z) {


        if (number == 1) {

            TextView t = (TextView) mes.findViewById(R.id.mes1);
            t.setText("WiFi signal --> " + z + "%");
            mes.first = Integer.valueOf(z);
            mes.next(1);
        } else {

            if (number == 2) {

                TextView t = (TextView) mes.findViewById(R.id.mes2);
                t.setText("WiFi signal --> " + z + "%");
                mes.second = Integer.valueOf(z);
                mes.next(2);
            } else {

                if (number == 3) {

                    TextView t = (TextView) mes.findViewById(R.id.mes3);
                    t.setText("WiFi signal --> " + z + "%");
                    mes.third = Integer.valueOf(z);
                    mes.next(3);
                }
            }
        }
    }
}
