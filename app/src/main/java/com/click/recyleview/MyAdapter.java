package com.click.recyleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * RecyclerView适配器
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ItemBean> mDataList;

    public MyAdapter(Context context,List<ItemBean> list) {
            this.mDataList = list;
    }

    public void addList(List<ItemBean> list) {
        mDataList = list;
//        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        // 返回数据集合大小
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

//        //获取这个TextView
//        ItemBean bean = mDataList.get(position);
//
//        holder.accTvTitle.setText(bean.getAccount());
//        holder.pasTvTitle.setText(bean.getPassword());


        if (holder instanceof ViewHolder) {
            ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.accTvTitle.setText(mDataList.get(position).getAccount() + "");
            viewHolder.pasTvTitle.setText(mDataList.get(position).getPassword() + "");
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "当前位置：" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView accTvTitle;
        private TextView pasTvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            accTvTitle = (TextView) itemView.findViewById(R.id.account_item);
            pasTvTitle = (TextView) itemView.findViewById(R.id.password_item);

        }


    }


}