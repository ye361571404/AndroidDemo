package com.hua.demos.dependencies.retrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hua.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnGetCode;
    private TextView tvContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        assignViews();
        setListener();
    }

    private void setListener() {
        btnGetCode.setOnClickListener(this);
    }


    private void assignViews() {
        btnGetCode = (Button) findViewById(R.id.btn_get_code);
        tvContent = (TextView) findViewById(R.id.tv_content);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get_code:

                request();
                break;
        }

    }

    private void request() {
        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                // baseUrl()注意：只能传入以/结尾的网址
                .baseUrl("http://v.juhe.cn/") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .build();


        // 步骤5:创建 网络请求接口 的实例
        GetRequest request = retrofit.create(GetRequest.class);

        //对 发送请求 进行封装
        String key = "1cf516750242a0d14278404dca735df4";
        Call<Movie> call = request.getCall(key,"瘦虎肥龙","","","","");

        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<Movie>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                // 步骤7：处理返回的数据结果
                Movie body = response.body();


            }

            //请求失败时回调
            @Override
            public void onFailure(Call<Movie> call, Throwable throwable) {
                System.out.println("连接失败");
            }
        });

    }
}
