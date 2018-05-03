package com.hua.demos.dependencies.okhttp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.blankj.utilcode.utils.LogUtils;
import com.hua.R;

import org.xutils.common.util.LogUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn01;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);

        btn01 = (Button) findViewById(R.id.btn_01);
        btn01.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_01:
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        // 声明缓存地址和大小
                        Cache cache = new Cache(getCacheDir(),10*1024*1024);
                        //参考：http://blog.csdn.net/changsimeng/article/details/54668884
                        OkHttpClient client = new OkHttpClient.Builder()
                                .cache(cache)
                                .addInterceptor(new XInterceptor.CommonLog())
                                .addInterceptor(new XInterceptor.Retry(3))
                                .addInterceptor(new Interceptor() {
                                    @Override
                                    public Response intercept(Chain chain) throws IOException {
                                        Request request = chain.request();
                                        if (!NetworkUtils.isConnected(OkHttpActivity.this)) {
                                            int maxStale = 4 * 7 * 24 * 60; // 离线时缓存保存4周,单位:秒
                                            CacheControl tempCacheControl = new CacheControl.Builder()
                                                    .onlyIfCached()
                                                    .maxStale(maxStale, TimeUnit.SECONDS)
                                                    .build();
                                            request = request.newBuilder()
                                                    .cacheControl(tempCacheControl)
                                                    .build();
                                        }
                                        return chain.proceed(request);
                                    }
                                })
                                .addNetworkInterceptor(new Interceptor() {
                                    @Override
                                    public Response intercept(Chain chain) throws IOException {
                                        Request request = chain.request();
                                        Response originalResponse = chain.proceed(request);
                                        int maxAge = 30;    // 在线缓存,单位:秒
                                        return originalResponse.newBuilder()
                                                .removeHeader("Pragma")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                                                .removeHeader("Cache-Control")
                                                .header("Cache-Control", "public, max-age=" + maxAge)
                                                .build();
                                    }
                                })
                                .connectTimeout(10, TimeUnit.SECONDS)
                                .readTimeout(20, TimeUnit.SECONDS)
                                .writeTimeout(20, TimeUnit.SECONDS)
                                .build();

                        // String url = "http://www.publicobject.com/helloworld.txt";
                        String url = "http://39.107.90.144:8080/appsrv/api/get_vip_type1";
                        Request request = new Request.Builder()
                                .url(url)
                                .build();
                        try {
                            Response response = client.newCall(request).execute();
                            String string = response.body().string();
                            LogUtils.e(string);
                            response.body().close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }



                        /*
                        String url = "http://39.107.90.144:8080/appsrv/api/get_pay_mode";
                        OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder()
                                    .url(url)
                                    .build();

                        Response response = null;
                        try {
                            response = client.newCall(request).execute();
                            String string = response.body().string();
                            LogUtil.e(string);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }*/





                    }
                }).start();



                break;
        }
    }
}
