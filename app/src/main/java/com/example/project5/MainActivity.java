package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Dialog.OnCancelListener {

    private AlertDialog dialog_id;
    private AlertDialog dialog_pass;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .permitDiskReads()
                .permitDiskWrites()
                .permitNetwork().build());

        final EditText idText = (EditText) findViewById(R.id.idText);
        final EditText passwordText = (EditText) findViewById(R.id.passwordText);

        final Button loginButton = (Button) findViewById(R.id.loginButton);
        final TextView registerButton = (TextView) findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(getApplicationContext(), RegisterButtonPage.class);
                startActivity(registerIntent);
            }
        });
            //로그인 버튼 이벤트 => 아이디 또는 비밀번호를 치지 않을때 alert 뜨도록
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String userID = idText.getText().toString();
                String userPASS = passwordText.getText().toString();

                if(userID.equals(""))
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    dialog_id = builder.setMessage("아이디는 빈 칸일 수 없습니다")
                            .setPositiveButton("확인",null)
                            .create();
                    dialog_id.show();
                    return;
                }else if(userPASS.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    dialog_pass = builder.setMessage("비밀번호는 빈 칸일 수 없습니다")
                            .setPositiveButton("확인",null)
                            .create();
                    dialog_pass.show();
                    return;
                }else{
                    Intent loginIntent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(loginIntent);
                }



            }
            });

    }

    @Override
    public void onCancel(DialogInterface dialog) {

    }

    @Override
    public void onClick(View v) {

    }
}