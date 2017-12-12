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

    private List<ItemBean> mDataList ;

    private MyAdapter myAdapter;

    private Button add;

    private String account,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        account = getIntent().getStringExtra("account");
        password = getIntent().getStringExtra("password");
        initView();
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


        mDataList = new ArrayList<ItemBean>();
        ItemBean data = new ItemBean(account,password);
        mDataList.add(data);
        /*
        设置适配器
         */
        myAdapter = new MyAdapter(this,mDataList);
        mRecyclerView.setAdapter(myAdapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mRecyclerView!=null){
                    Intent intent = new Intent(MainActivity.this,TwoActivity.class);
                    startActivity(intent);
                }else{
                    ItemBean data = new ItemBean(account, password);

                    mDataList.add(data);
                    myAdapter.notifyItemInserted(0);
                    myAdapter.notifyItemRangeChanged(0, mDataList.size());
                }
            }
        });


    }


    /**
     * //        for (int i=0;i<50;i++){
     //            mDataList.add("内容 - "+i);
     //        }

     * 初始化数据
     */
//    private void initData() {
//
//
//        mDataList = new ArrayList<ItemBean>();
//        ItemBean data = new ItemBean(account,password);
//        mDataList.add(data);
//        /*
//        设置适配器
//         */
//        myAdapter = new MyAdapter(this,mDataList);
//        mRecyclerView.setAdapter(myAdapter);
////        myAdapter.notifyDataSetChanged();
//    }


}