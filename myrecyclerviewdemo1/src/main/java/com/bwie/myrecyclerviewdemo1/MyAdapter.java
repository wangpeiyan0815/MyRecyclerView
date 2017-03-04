package com.bwie.myrecyclerviewdemo1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dell on 2017/2/8.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements View.OnClickListener{
    private Context context;
    private List<String> list;
    private OnChildClickListener listener;
    private RecyclerView recyclerView;

    public void setOnChildClickListener(OnChildClickListener listener) {
        this.listener = listener;
    }

    public MyAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }
    //解绑
    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itmeText.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    //删除的方法
    public void remove(int position){
        list.remove(position);
        notifyItemRemoved(position);
    }
    @Override
    public void onClick(View view) {
        //recyclerView != null && listener != null.if  快捷生成
        if (recyclerView != null && listener != null) {
            //快捷  recyclerView.getChildAdapterPosition(view).var
            int position = recyclerView.getChildAdapterPosition(view);
            listener.onChildClick(recyclerView,view,position,list.get(position));
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView itmeText;

        public ViewHolder(View itemView) {
            super(itemView);
            itmeText = (TextView) itemView.findViewById(R.id.item_text);
            //itemView.findViewById(R.id.item_text).cast
            //((TextView) itemView.findViewById(R.id.item_text)).field
            //text = ((TextView) itemView.findViewById(R.id.item_text));
        }
    }

    //定义一个接口
    public interface OnChildClickListener {
        void onChildClick(RecyclerView recyclerView, View view, int position, String data);
    }
}
