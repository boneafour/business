package com.example.user.buss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity1 extends Activity {

    private TextView txtTitle;
    boolean a=false;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.print("1");
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText(getString(R.string.app_name));

        GridView gridview = (GridView) findViewById(R.id.grid);
        gridview.setAdapter(new ImageAdapter1(this));


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {



                if(position==0){
                    startActivity(new Intent(MainActivity1.this, Cook1.class));
                }
                else if (position==1){
                    startActivity(new Intent(MainActivity1.this, Clean1.class));
                }
                else if(position==2){
                    startActivity(new Intent(MainActivity1.this, Wash1.class));
                }
                else if(position==3){
                    startActivity(new Intent(MainActivity1.this, Contact1.class));
                }



                }

        });
    }
}

