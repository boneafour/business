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
import android.widget.Toast;

public class Autorization extends AppCompatActivity implements View.OnClickListener {

    private TextView txtTitle;
    Spinner typeS;
    EditText Login, Parol;
    String type, a="админ", b="клиент", loginS, parolS;
    TextView errorMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autorization);


        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText(getString(R.string.app_name));
        typeS = (Spinner) findViewById(R.id.type);
        Login = (EditText) findViewById(R.id.login);
        Parol = (EditText) findViewById(R.id.parol);
        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginButton:
                loginS = Login.getText().toString();
                parolS = Parol.getText().toString();
                type=typeS.getSelectedItem().toString();
                if(type.equals(a) && loginS.equals("admin") && parolS.equals("12345")){
                    Intent intent=new Intent(this,MainActivity.class);
                    startActivity(intent);
                }
                else if(type.equals(b)){
                    Intent intent=new Intent(this,MainActivity1.class);
                    startActivity(intent);
                }
                else if(type.equals(a) && (loginS.equals("") || parolS.equals(""))){
                    Toast.makeText(Autorization.this, "Напишите логин и пароль!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Autorization.this, "Логин или пароль неверный!", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
}
