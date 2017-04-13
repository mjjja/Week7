package com.example.kmj.week7;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kmj.week6.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    ArrayList<Data> AL = new ArrayList<>();
    DataAdapter adapter;
    ListView lv;
    final int _ADD_LIST = 10;
    Button bt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    void init(){
        bt4=(Button)findViewById(R.id.bt4);
        setListView();
    }

    public void setListView(){
        lv=(ListView)findViewById(R.id.listview);
        adapter = new DataAdapter(this,AL);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),Main3Activity.class);
                intent.putExtra("pos",AL.get(position));
                startActivity(intent);
            }
        });
    }

    public void onClick(View v){
        if (v.getId()==R.id.bt1) {
            Intent intent = new Intent(this, Main2Activity.class);
            startActivityForResult(intent, _ADD_LIST);
        }
        if (v.getId()==R.id.bt2) {
            Collections.sort(AL,nameAsc);
            adapter.notifyDataSetChanged();
        }
        if (v.getId()==R.id.bt3) {
            Collections.sort(AL,kindAsc);
            adapter.notifyDataSetChanged();
        }
        if (v.getId()==R.id.bt4) {
            bt4.setText("삭제");
        }
    }

    Comparator<Data> nameAsc = new Comparator<Data>() {
        @Override
        public int compare(Data o1, Data o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    Comparator<Data> kindAsc = new Comparator<Data>() {
        @Override
        public int compare(Data o1, Data o2) {
            return o1.getCategory().compareTo(o2.getCategory());
        }
    };


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode==RESULT_OK){
            Data dt = data.getParcelableExtra("hereyougo");
            AL.add(dt);
            adapter.notifyDataSetChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
