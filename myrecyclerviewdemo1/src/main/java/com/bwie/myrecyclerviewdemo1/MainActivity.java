package com.bwie.myrecyclerviewdemo1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnChildClickListener {

    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recycler = (RecyclerView) findViewById(R.id.recycler);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(String.format(Locale.CANADA, "第%03d条数据%s", i, i % 2 == 0 ? "" : "-----------------"));
        }
        adapter = new MyAdapter(this, list);
        //参数： 2.垂直方向， 3.数据翻转，也就是倒叙
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //参数： 2.显示的列数 3.垂直方向， 4.数据翻转，也就是倒叙
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        //判断item根据垂直方向，占多少行与多少列。
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0) {
                    return 3;
                }
                //根据这个判断占的行与列
                return 1;
            }
        });
        //瀑布流
        StaggeredGridLayoutManager gridLayoutManager1 = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recycler.setLayoutManager(linearLayoutManager);
        //添加动画
        MyitemAnimator itemAnimator = new MyitemAnimator();
        recycler.setItemAnimator(itemAnimator);
        recycler.setAdapter(adapter);
        adapter.setOnChildClickListener(this);
    }

    @Override
    public void onChildClick(RecyclerView recyclerView, View view, int position, String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
        adapter.remove(position);
    }
}
