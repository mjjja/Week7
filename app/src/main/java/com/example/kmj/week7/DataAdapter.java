package com.example.kmj.week7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kmj.week6.R;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by KMJ on 2017-04-13.
 */

public class DataAdapter extends BaseAdapter {

    ArrayList<Data> data = new ArrayList<Data>();
    Context context;

    public DataAdapter(Context context, ArrayList<Data> data){
        this.context=context;
        this.data=data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item,null);
        }

        TextView tv1 = (TextView)convertView.findViewById(R.id.ItemName);
        TextView tv2 = (TextView)convertView.findViewById(R.id.ItemTel);
        ImageView iv = (ImageView)convertView.findViewById(R.id.ItemImg);

        Data one = data.get(position);
        tv1.setText(one.getName());
        tv2.setText(one.getTel());
        switch (one.Category){
            case "Chicken":
                iv.setImageResource(R.drawable.chicken);
                break;
            case "Pizza":
                iv.setImageResource(R.drawable.pizza);
                break;
            case "Hamburger":
                iv.setImageResource(R.drawable.hamburger);
                break;
        }
        return convertView;
    }

    Comparator<Data> nameAsc = new Comparator<Data>() {
        @Override
        public int compare(Data o1, Data o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    Comparator<Data> telAsc = new Comparator<Data>() {
        @Override
        public int compare(Data o1, Data o2) {
            return o1.getTel().compareTo(o2.getTel());
        }
    };
}
