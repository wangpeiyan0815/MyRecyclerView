package incident.yan.com.myrefresh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import incident.yan.com.myrefresh.adapter.MyAdapter;

public class MainActivity extends AppCompatActivity implements XRecyclerView.LoadingListener {

    private XRecyclerView recyclerview;
    private List<String> list = new ArrayList<>();
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData(false);
        recyclerview = (XRecyclerView) findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);
        adapter = new MyAdapter(this, list);
        recyclerview.setAdapter(adapter);
        recyclerview.setLoadingListener(this);
    }

    //获取数据源
    private void getData(boolean isRefresh) {

        for (int i = 0; i < 50; i++) {
            list.add("我是第" + i + "条数据");
        }
        if (isRefresh) {
            stop();
        }
    }

    @Override
    public void onRefresh() {
        getData(true);
        adapter.add(list);
    }

    @Override
    public void onLoadMore() {
        adapter.add(list);
        getData(true);
    }

    /**
     * 暂停
     */
    private void stop() {
        /*recyclerview.postDelayed(new Runnable() {
            @Override
            public void run() {
                recyclerview.refreshComplete();

            }
        },2000);*/
      /*  recyclerview.postDelayed(new Runnable() {
            @Override
            public void run() {
                recyclerview.loadMoreComplete();
            }
        },2000);*/
    }
}
