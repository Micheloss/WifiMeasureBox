package com.miguel.wifimeasurebox;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class New_Mes extends AppCompatActivity {


    AlertDialog.Builder builder;
    final Object ob = this;

    int first;
    int second;
    int third;

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


            if(i == 2) {
                DialogInterface.OnClickListener dialogClickListener_mes3 = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case DialogInterface.BUTTON_POSITIVE:
                                new Async_measure((New_Mes) ob, 3, getApplicationContext()).execute();
                                break;

                        }
                    }
                };

                builder.setMessage("Third measure should be taken at the door. Are you there? ").setPositiveButton("Yes", dialogClickListener_mes3).show();

            }else{
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(getApplicationContext(), Name.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(New_Mes.this, (View)this.findViewById(R.id.imageView) , "profile");
                intent.putExtra("door", third);
                intent.putExtra("middle", second);
                intent.putExtra("fur", first);
                startActivity(intent, options.toBundle());
            }
        }
    }
}
