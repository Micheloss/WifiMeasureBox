package com.miguel.wifimeasurebox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by MiguelAngel on 15/04/16.
 */
public class Adapter extends BaseAdapter {


    ArrayList<Measure> list;
    LayoutInflater inflater;
    Context c;
    Measure mes;

    public Adapter(ArrayList<Measure> items, Context c) {
        this.list = items;
        inflater = LayoutInflater.from(c);
        this.c = c;
    }

    @Override
    public int getCount() {
        return list.size();

    }

    @Override
    public Measure getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        mes = list.get(position);

        MeasureHolder holder;
        if (convertView == null) {


            convertView = inflater.inflate(R.layout.list_element, null);
            holder = new MeasureHolder();
            holder.door = (TextView) convertView
                    .findViewById(R.id.tx1);
            holder.middle = (TextView) convertView.findViewById(R.id.tx2);
            holder.fur = (TextView) convertView.findViewById(R.id.tx3);
            holder.name = (TextView) convertView.findViewById(R.id.root);


            holder.door.setText("Door signal = " + String.valueOf(list.get(position).getDoor()) + "%");
            holder.middle.setText("Middle room signal = " + String.valueOf(list.get(position).getMiddle()) + "%");
            holder.fur.setText("Furthest point signal = " + String.valueOf(list.get(position).getFurthest()) + "%");
            holder.name.setText(String.valueOf(list.get(position).getName()));

            convertView.setTag(holder);

        } else {
            //holder = (MeasureHolder) convertView.getTag();
        }

        return convertView;

    }

    static class MeasureHolder {
        public TextView name;
        public TextView door;
        public TextView middle;
        public TextView fur;

    }

}


