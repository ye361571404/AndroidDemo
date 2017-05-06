package hua.demo.feature.proguard.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;

import org.xutils.common.util.LogUtil;

import hua.demo.R;
import hua.demo.feature.proguard.bean.UserBean;

public class ProguardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proguard);

        UserBean user = new UserBean();
        user.setName("ye361571404");
        user.setEmail("wo8013@163.com");

        Gson gson = new Gson();
        String json = gson.toJson(user);
        LogUtil.e("onCreate: json = " + json);

    }
}
