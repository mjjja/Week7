package com.example.kmj.week7;

import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.kmj.week6.R;

public class Main2Activity extends AppCompatActivity {

    DateFormat df = new SimpleDateFormat("yyyyMMdd");
    Calendar now = Calendar.getInstance();

    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;
    EditText et5;
    EditText et6;
    RadioGroup rg;
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    String Name;
    String Tel;
    String Menu1;
    String Menu2;
    String Menu3;
    String Homepage;
    String Date;
    String Category="Chicken";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }

    void init(){
        et1=(EditText)findViewById(R.id.Name);
        et2=(EditText)findViewById(R.id.Tel);
        et3=(EditText)findViewById(R.id.Menu1);
        et4=(EditText)findViewById(R.id.Menu2);
        et5=(EditText)findViewById(R.id.Menu3);
        et6=(EditText)findViewById(R.id.Homepage);
        rg=(RadioGroup) findViewById(R.id.RGoup);
        rb1=(RadioButton)findViewById(R.id.radio1);
        rb2=(RadioButton)findViewById(R.id.radio2);
        rb3=(RadioButton)findViewById(R.id.radio3);
        rb1.setOnClickListener(rbOnClick);
        rb2.setOnClickListener(rbOnClick);
        rb3.setOnClickListener(rbOnClick);
        rb1.setChecked(true);
    }


    RadioButton.OnClickListener rbOnClick = new RadioButton.OnClickListener(){
        public void onClick(View v){
            if (rb1.isChecked()) Category="Chicken";
            if (rb2.isChecked()) Category="Pizza";
            if (rb3.isChecked()) Category="Hamburger";
        }
    };

    public void onClick(View v){
        Intent intent = new Intent();
        if (v.getId()==R.id.btnAdd){
            Name=et1.getText().toString();
            Tel=et2.getText().toString();
            Menu1=et3.getText().toString();
            Menu2=et4.getText().toString();
            Menu3=et5.getText().toString();
            Homepage=et6.getText().toString();
            Date=df.format(now.getTime());
            Data box = new Data(Name,Category,Tel,Menu1,Menu2,Menu3,Homepage,Date);
            intent.putExtra("hereyougo",box);
            setResult(RESULT_OK,intent);
            finish();
        }else{
            setResult(RESULT_CANCELED, intent);
            finish();
        }
    }
}
