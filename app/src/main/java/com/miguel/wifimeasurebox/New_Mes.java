package com.miguel.wifimeasurebox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class New_Mes extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__mes);

        TextView mes1 = (TextView)findViewById(R.id.mes1);
        new Async_measure(mes1,this).execute();


    }

}
