package com.example.kmj.week6;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.kmj.week6.R.id.Homepage;
import static com.example.kmj.week6.R.id.Tel;

public class Main3Activity extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView tv6;
    TextView tv7;
    ImageView iv;
    Button bt;
    String Name;
    int Category;
    String Tel;
    String Menu1;
    String Menu2;
    String Menu3;
    String Homepage;
    String Date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
        Intent intent = getIntent();
        Data dt = intent.getParcelableExtra("pos");
        Name=dt.Name;
        Category=dt.Category;
        Tel=dt.Tel;
        Menu1=dt.Menu1;
        Menu2=dt.Menu2;
        Menu3=dt.Menu3;
        Homepage=dt.Homepage;
        Date=dt.Date;
        tv1.setText(Name);
        tv2.setText(Menu1);
        tv3.setText(Menu2);
        tv4.setText(Menu3);
        tv5.setText(Tel);
        tv6.setText(Homepage);
        tv7.setText(Date);
        switch (Category){
            case 1:
                iv.setImageResource(R.drawable.chicken);
                break;
            case 2:
                iv.setImageResource(R.drawable.pizza);
                break;
            case 3:
                iv.setImageResource(R.drawable.hamburger);
                break;
            default:
                iv.setImageResource(R.drawable.rest);
        }
    }

    public void onClick(View v){
        if (v.getId()==R.id.btnback) {
            finish();
        }
        if (v.getId()==R.id.imageView2){
            Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:/"+Tel));
            Log.d("Tel:",Tel);
            startActivity(call);
        }
        if (v.getId()==R.id.imageView3){
            Intent go = new Intent(Intent.ACTION_VIEW,Uri.parse("http://"+Homepage));
            startActivity(go);
        }
    }

    void init(){
        tv1=(TextView)findViewById(R.id.txtname);
        tv2=(TextView)findViewById(R.id.etmenu1);
        tv3=(TextView)findViewById(R.id.etmenu2);
        tv4=(TextView)findViewById(R.id.etmenu3);
        tv5=(TextView)findViewById(R.id.tvTel);
        tv6=(TextView)findViewById(R.id.tvURL);
        tv7=(TextView)findViewById(R.id.tvRegdate);
        iv=(ImageView)findViewById(R.id.imgno);
        bt=(Button)findViewById(R.id.btnback);

    }
}
