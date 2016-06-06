package com.example.user.buss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView txtTitle;
    boolean a=false;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.print("0");
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText(getString(R.string.app_name));

        GridView gridview = (GridView) findViewById(R.id.grid);
        gridview.setAdapter(new ImageAdapter(this));

        Intent intent = getIntent();
        type = intent.getStringExtra("typeS");
        System.out.println(type);


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {



                if(position==0){
                    startActivity(new Intent(MainActivity.this, Cook.class));
                }
                else if (position==1){
                    startActivity(new Intent(MainActivity.this, Clean.class));
                }
                else if(position==2){
                    startActivity(new Intent(MainActivity.this, Wash.class));
                }
                else if(position==3){
                    startActivity(new Intent(MainActivity.this, Contact.class));
                }
                else if(position==4){

                    startActivity(new Intent(MainActivity.this, Table.class));
                    if(type=="клиент") {
                       onWindowFocusChanged(false);
                    }
                }


                }

        });


    }
}

