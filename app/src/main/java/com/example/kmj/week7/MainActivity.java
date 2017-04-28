package com.example.kmj.week7;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kmj.week6.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    ArrayList<Data> AL = new ArrayList<>();
    ArrayList<Data> AL2 = new ArrayList<>();
    DataAdapter adapter;
    ListView lv;
    final int _ADD_LIST = 10;
    Button bt4;
    EditText et;
    Boolean deletemode=false;
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
        et=(EditText)findViewById(R.id.Search);
        lv=(ListView)findViewById(R.id.listview);
        adapter = new DataAdapter(this,AL,false);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),Main3Activity.class);
                intent.putExtra("pos",AL.get(position));
                startActivity(intent);
            }
        });

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String searchtext=et.getText().toString();
                AL.clear();
                if (searchtext.equals("")){
                    AL.addAll(AL2);
                }else{
                    for (int i=0;i<AL2.size();i++){
                        if (AL2.get(i).getName().toUpperCase().contains(searchtext.toUpperCase())){
                            AL.add(AL2.get(i));
                        }
                    }
                }
                adapter.notifyDataSetChanged();
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
            if (deletemode==false){
                deletemode=true;
                bt4.setText("삭제");
                adapter.setDelete(true);
                adapter.notifyDataSetChanged();
            }else{
                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setMessage("선택한 맛집을 정말 삭제할거에요?")
                        .setNegativeButton("취소",null)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                for (int j=AL.size()-1;j>=0;j--){
                                    if (AL.get(j).getIsDelete()=="Yes"){
                                        for (int k=AL2.size()-1;k>=0;k--){
                                            if (AL2.get(k).equals(AL.get(j))) {
                                                AL2.remove(j);
                                                break;
                                            }
                                        }
                                        AL.remove(j);
                                    }
                                }
                                deletemode=false;
                                bt4.setText("선택");
                                adapter.setDelete(false);
                                adapter.notifyDataSetChanged();
                            }
                        }).show();
            }
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
            AL2.add(dt);
            AL.add(dt);
            adapter.notifyDataSetChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
