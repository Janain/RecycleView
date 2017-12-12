package com.click.recyleview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity  {

    private RecyclerView mRecyclerView;

    private List<ItemBean> mDataList = new ArrayList<ItemBean>();

    private MyAdapter myAdapter;

    private Button add;

    String contacts,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    final int RESULT_CODE = 101;
    final int REQUEST_CODE = 1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_CODE) {
                contacts = data.getStringExtra("contacts");
                phone = data.getStringExtra("phone");
                mDataList.add(new ItemBean(contacts,phone));
                myAdapter = new MyAdapter(this, mDataList);
                mRecyclerView.setAdapter(myAdapter);
                myAdapter.notifyDataSetChanged();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    /**
     * 初始化
     */
    private void initView() {

        add = findViewById(R.id.add);
        //找到这个Listview
        mRecyclerView = (RecyclerView) findViewById(R.id.main_recylist);
        //设置线性管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TwoActivity.class);
                startActivityForResult(intent, REQUEST_CODE);

            }
        });
    }
}