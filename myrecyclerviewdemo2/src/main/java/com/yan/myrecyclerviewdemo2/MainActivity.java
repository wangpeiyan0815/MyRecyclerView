package com.yan.myrecyclerviewdemo2;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yan.myrecyclerviewdemo2.adapter.LeftAdapter;
import com.yan.myrecyclerviewdemo2.fragment.Fragment_num;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LeftAdapter.OnChildClickListener{
    private List<String> list = new ArrayList<>();
    private LeftAdapter leftAdapter;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
        RecyclerView main_recycler = (RecyclerView) findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        main_recycler.setLayoutManager(layoutManager);
        leftAdapter = new LeftAdapter(this,list);
        main_recycler.setAdapter(leftAdapter);
        leftAdapter.setOnClickChildListener(this);
        manager = getSupportFragmentManager();
        Fragment_num fragment_num = Fragment_num.setNew("1");
        manager.beginTransaction().add(R.id.frame,fragment_num).commit();
    }
    //添加数据源
    private void getData(){
        for (int i = 0; i < 30; i++) {
            list.add("第"+i+"个数据");
        }
    }
    //实现抽象方法
    @Override
    public void onChildClick(RecyclerView recyclerView, View view, int position, String data) {
         //进行创建fragment
        Fragment_num fragment_num = Fragment_num.setNew(data);
        manager.beginTransaction().replace(R.id.frame,fragment_num).commit();
    }
}
