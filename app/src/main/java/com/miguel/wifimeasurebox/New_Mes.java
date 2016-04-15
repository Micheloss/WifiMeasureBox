package com.miguel.wifimeasurebox;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class New_Mes extends AppCompatActivity {


    AlertDialog.Builder builder;
    final Object ob = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__mes);

        final TextView mes1 = (TextView)findViewById(R.id.mes1);


        DialogInterface.OnClickListener dialogClickListener_mes1 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        new Async_measure((New_Mes)ob,1,getApplicationContext()).execute();
                        break;

                }
            }
        };

        builder = new AlertDialog.Builder(this);
        builder.setMessage("First measure should be taken on the furthest part of the room from the door. Are you there? ").setPositiveButton("Yes", dialogClickListener_mes1).show();




    }

    public void next(int i) {

        if(i == 1){

            DialogInterface.OnClickListener dialogClickListener_mes2 = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which){
                        case DialogInterface.BUTTON_POSITIVE:
                            new Async_measure((New_Mes)ob,2,getApplicationContext()).execute();
                            break;

                    }
                }
            };

            builder.setMessage("Second measure should be taken on the middle part of the room. Are you there? ").setPositiveButton("Yes", dialogClickListener_mes2).show();


        }else{



            DialogInterface.OnClickListener dialogClickListener_mes3 = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which){
                        case DialogInterface.BUTTON_POSITIVE:
                            new Async_measure((New_Mes)ob,3,getApplicationContext()).execute();
                            break;

                    }
                }
            };

            builder.setMessage("Third measure should be taken at the door. Are you there? ").setPositiveButton("Yes", dialogClickListener_mes3).show();


        }
    }
}
