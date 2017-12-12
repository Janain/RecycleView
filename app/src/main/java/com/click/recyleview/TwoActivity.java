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
 */

public class TwoActivity extends AppCompatActivity {

    String contacts, phone;
    EditText conEdit, phoEdit;
    Button ok;
    final int RESULT_CODE = 101;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent);
        initView();
    }

    public void initView() {

        conEdit = (EditText) findViewById(R.id.account);
        phoEdit = (EditText) findViewById(R.id.password);
        ok = (Button) findViewById(R.id.ok);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                contacts = conEdit.getText().toString().trim();
                phone = phoEdit.getText().toString().trim();

                Intent intent = new Intent();

                intent.putExtra("contacts", contacts);
                intent.putExtra("phone", phone);

                setResult(RESULT_CODE, intent);
                finish();
                Toast.makeText(getApplicationContext(), "提交成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
