package com.click.recyleview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by S on 2017/11/16.
 *
 */

public class TwoActivity extends AppCompatActivity{
    String acc,pas;
    EditText account,password;
    Button ok;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent);


          account = (EditText) findViewById(R.id.account);
          password = (EditText) findViewById(R.id.password);
          ok = (Button) findViewById(R.id.ok);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acc = account.getText().toString().trim();
                pas = password.getText().toString().trim();


                Intent intent = new Intent();

                intent.putExtra("account", acc);
                intent.putExtra("password", pas);
                intent.setClass(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"提交成功", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}
