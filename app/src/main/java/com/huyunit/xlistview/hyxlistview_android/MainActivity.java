package com.huyunit.xlistview.hyxlistview_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.huyunit.xlistview.XListView;
import com.huyunit.xlistview.hyxlistview_android.adapter.TextListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements XListView.IXListViewListener {

    private XListView xListView;

    private TextListAdapter textListAdapter;

    private List<String> sList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData(0);
    }

    public void initView() {
        xListView = (XListView) findViewById(R.id.xlistview);
        xListView.setPullRefreshEnable(true);
        xListView.setPullLoadEnable(true);
        xListView.setXListViewListener(this);
        textListAdapter = new TextListAdapter(MainActivity.this, sList);
        xListView.setAdapter(textListAdapter);
    }

    public void refreshListView() {
        textListAdapter.dataList = sList;
        textListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        initData(1);
    }

    @Override
    public void onLoadMore() {
        initData(2);
    }

    public void initData(int refreshModel) {
        int n = sList.size();
        if (refreshModel == 1) {
            for (int i = n; i < n + 15; i++) {
                sList.add(0, "XListView_Header_" + (i + 1));
            }
            xListView.stopRefresh();
        } else if (refreshModel == 2) {
            for (int i = n; i < n + 15; i++) {
                sList.add("XListView_Footer_" + (i + 1));
            }
            xListView.stopLoadMore();
        } else {
            for (int i = 0; i < 15; i++) {
                sList.add("XListView_" + (i + 1));
            }
        }
        refreshListView();
    }
}
