package com.hua.feature.sharedpreferences.activity;

import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import com.hua.R;
import com.hua.main.activity.BaseActivity;
import com.hua.utils.SPUtil;

public class SharedPreferencesActivity extends BaseActivity {


    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_pwd)
    TextView tvPwd;
    @BindView(R.id.btn_login)
    Button btnLogin;
    private SharedPreferences sp;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_shared_preferences;
    }

    @Override
    protected void assignViews() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

        // 该sharedPreferences只能被当前activity调用
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString("activity",getClass().getSimpleName());
        edit.commit();

        // 该sharedPreferences只能被当前应用中的其他组件调用
        sp = getSharedPreferences("config", MODE_APPEND);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("name", "ye361571404");
        editor.putString("password", "123456");
        editor.commit();

        String name = sp.getString("name", "");
        String password = sp.getString("password", "");

        tvName.setText(name);
        tvPwd.setText(password);

        SPUtil.setPreferences(SPUtil.TYPE_USER,"name","ye361571404");
        SPUtil.setPreferences(SPUtil.TYPE_USER,"password","654321");

        SPUtil.setPreferences(SPUtil.TYPE_APP,"name","AndroidDemo");
    }



    @OnClick(R.id.btn_login)
    public void onClick() {
        sp = getSharedPreferences("config", MODE_APPEND);
        String name = tvName.getText().toString();
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("name",name);
        editor.commit();

    }
}
