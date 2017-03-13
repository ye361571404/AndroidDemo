package hua.demo.feature.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.OnClick;
import hua.demo.R;
import hua.demo.main.activity.BaseActivity;

public class RxJavaDemoActivity extends BaseActivity {



    @Bind(R.id.btn_send)
    Button mBtnSend;


    @Override
    protected int getLayoutRes() {
        return R.layout.activity_rx_java_demo;
    }

    @Override
    protected void assignViews() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

    }


    @OnClick(R.id.btn_send)
    public void onClick(View view){

        switch(view.getId()){
            case R.id.btn_send:

                Observable.create(new OnSubscrible<String>() {
                    @Override
                    public void call(Subscrible<? super String> subscrible) {
                        subscrible.onNext("男生: 走 ,看电影去");

                    }
                }).subscrible(new Subscrible<String>(){

                    @Override
                    public void onNext(String s) {
                        Log.e("RxJava", s);
                        Log.e("RxJava", "女生: 可以, ...");
                    }
                });

                break;

        }
    }

}
