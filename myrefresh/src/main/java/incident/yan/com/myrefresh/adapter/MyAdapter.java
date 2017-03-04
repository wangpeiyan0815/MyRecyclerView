package incident.yan.com.myrefresh.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import incident.yan.com.myrefresh.R;

/**
 * Created by dell on 2017/2/16.
 */

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private Context context;
    private List<String> list;

    public MyAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    //添加数据
    public void add(List<String> list){
        list.addAll(list);
        notifyDataSetChanged();
    }
    //删除
    public void delete(List<String> list){
        list.removeAll(list);
        notifyDataSetChanged();
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView text;
        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text_View);
        }
    }
}
