package com.hua.feature.recyclerview.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import com.hua.R;
import com.hua.feature.recyclerview.adapter.RecyclerViewAdapter;
import com.hua.main.activity.BaseActivity;

/**
 * Created by Administrator on 2017/2/24.
 */

public class RecyclerViewActivity extends BaseActivity {

    private XRecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    private ArrayList<String> listData;
    private int refreshTime = 0;
    private int times = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_recyclerview;
    }

    @Override
    protected void assignViews() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerView = (XRecyclerView)this.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        // 设置下拉刷新样式
        mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        // 设置上拉加载样式
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        // 设置下拉刷新的箭头
        mRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);

        // 给RecyclerView 添加header
        View header = LayoutInflater.from(this).inflate(R.layout.recyclerview_header, (ViewGroup)findViewById(android.R.id.content),false);
        mRecyclerView.addHeaderView(header);
    }

    @Override
    protected void setListener() {

        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                // 下拉刷新
                refreshTime ++;
                times = 0;
                new Handler().postDelayed(new Runnable(){
                    public void run() {
                        listData.clear();
                        for(int i = 0; i < 25 ;i++){
                            listData.add("item" + i);
                        }
                        mAdapter.notifyDataSetChanged();
                        // 刷新完成
                        mRecyclerView.refreshComplete();
                    }

                }, 1000);            //refresh data here
            }

            @Override
            public void onLoadMore() {
                // 上拉加载
                if(times < 2){
                    new Handler().postDelayed(new Runnable(){
                        public void run() {
                            for(int i = 0; i < 25 ;i++){
                                listData.add("item" + (1 + listData.size() ) );
                            }
                            // 加载更多完成
                            mRecyclerView.loadMoreComplete();
                            mAdapter.notifyDataSetChanged();
                        }
                    }, 1000);
                } else {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            for(int i = 0; i < 9 ;i++){
                                listData.add("item" + (1 + listData.size() ) );
                            }
                            // 表示无更多内容
                            mRecyclerView.setNoMore(true);
                            mAdapter.notifyDataSetChanged();
                        }
                    }, 1000);
                }
                times ++;
            }
        });
    }

    @Override
    protected void initData() {
        listData = new  ArrayList<String>();
        mAdapter = new RecyclerViewAdapter(listData);
        mRecyclerView.setAdapter(mAdapter);
        // 开始刷新
        mRecyclerView.refresh();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // 返回上一界面
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
