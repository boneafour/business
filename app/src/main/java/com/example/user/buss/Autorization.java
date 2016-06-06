package com.example.user.buss;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Autorization extends AppCompatActivity implements View.OnClickListener {

    private TextView txtTitle;
    Spinner type;
    EditText Login, Parol;
    String typeS, a="админ", b="клиент";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autorization);


        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText(getString(R.string.app_name));
        type = (Spinner) findViewById(R.id.type);
        Login = (EditText) findViewById(R.id.login);
        Parol = (EditText) findViewById(R.id.parol);
        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginButton:
                typeS=type.getSelectedItem().toString();
                  Intent intent=new Intent(this,MainActivity.class);
                intent.putExtra("typeS", typeS);
                startActivity(intent);
                break;
        }
    }
}
