package com.miguel.wifimeasurebox;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Old_data extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_old_data);

        SharedPreferences sharedPref = getSharedPreferences("appData", Context.MODE_WORLD_WRITEABLE);

        ObjectMapper mapper = new ObjectMapper();

        Measure mes = null;

        Map<String, ?> allEntries = sharedPref.getAll();

        ArrayList<Measure> list = new ArrayList<Measure>();

        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {

            Log.d("map values", entry.getKey() + ": " + entry.getValue().toString());

            try {
                mes = mapper.readValue(entry.getValue().toString(), Measure.class);
                list.add(mes);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        ListView list_view = (ListView) findViewById(R.id.list);
        list_view.setAdapter(new Adapter(list, getApplicationContext()));


    }

}



