package com.example.kmj.week6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Data> AL = new ArrayList<>();
    ArrayAdapter<Data> AA;
    ListView lv;
    TextView tv;
    final int _ADD_LIST = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    void init(){
        tv=(TextView)findViewById(R.id.list);
        setListView();
    }

    public void setListView(){
        lv=(ListView)findViewById(R.id.listview);
        AA=new ArrayAdapter<Data>(this,android.R.layout.simple_list_item_1,AL);
        lv.setAdapter(AA);
    }

    public void onClick(View v){
        if (v.getId()==R.id.bt1){
            Intent intent = new Intent(this,Main2Activity.class);
            startActivityForResult(intent,_ADD_LIST);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode==RESULT_OK){
            Data dt = data.getParcelableExtra("hereyougo");
            AL.add(dt);
            AA.notifyDataSetChanged();
            tv.setText("맛집 리스트("+AL.size()+")개");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
