package com.miguel.wifimeasurebox;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Name extends AppCompatActivity {

    @Override
    public void onBackPressed() {

        DialogInterface.OnClickListener dialogClickListener_mes1 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:

                        Intent intent = new Intent(getApplicationContext(), startActivity.class);
                        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(Name.this, findViewById(R.id.imageView), "profile");
                        startActivity(intent, options.toBundle());
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you wanna erase this measure?").setPositiveButton("Yes", dialogClickListener_mes1).setNegativeButton("No", dialogClickListener_mes1).show();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        Intent intent = getIntent();

        final int door = intent.getIntExtra("door", 0);
        final int middle = intent.getIntExtra("middle", 0);
        final int furthest = intent.getIntExtra("fur", 0);

        String name = "";

        Button but = (Button) findViewById(R.id.button3);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectMapper mapper = new ObjectMapper();
                EditText text = (EditText) findViewById(R.id.mes2);
                Measure mes = new Measure(text.getText().toString(), furthest, middle, door);
                try {

                    SharedPreferences sharedPref = getSharedPreferences("appData", Context.MODE_WORLD_WRITEABLE);
                    SharedPreferences.Editor prefEditor = getSharedPreferences("appData", Context.MODE_WORLD_WRITEABLE).edit();
                    prefEditor.putString("json" + mes.getName(), mapper.writeValueAsString(mes));
                    prefEditor.commit();

                    Intent intent = new Intent(getApplicationContext(), startActivity.class);
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(Name.this, findViewById(R.id.imageView), "profile");
                    startActivity(intent, options.toBundle());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

}
