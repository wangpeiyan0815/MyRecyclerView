package com.yan.myrecyclerviewdemo2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yan.myrecyclerviewdemo2.R;

/**
 * Created by dell on 2017/2/9.
 */

public class Fragment_num extends Fragment {

    private TextView frag_text;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment,container,false);
        frag_text = (TextView) view.findViewById(R.id.frag_text);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        String str = bundle.getString("str");
        frag_text.setText(str);
    }
    public static Fragment_num setNew(String str){
        Fragment_num fragment_num = new Fragment_num();
        Bundle bundle = new Bundle();
        bundle.putString("str",str);
        fragment_num.setArguments(bundle);
        return fragment_num;
    }
}
