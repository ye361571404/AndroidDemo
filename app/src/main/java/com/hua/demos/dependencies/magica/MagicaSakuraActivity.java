package com.hua.demos.dependencies.magica;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.bilibili.magicasakura.utils.ThemeUtils;
import com.hua.R;

/**
 * Android多主题库
 * https://github.com/Bilibili/MagicaSakura
 *
 * 0.添加依赖库compile 'com.bilibili:magicasakura:0.1.6@aar'
 * 1.colors.xml中定义颜色
 * 2.创建ThemeHelper类,定义主题类型
 * 3.Applicatino中初始化动态改变应用主题库
 *      * ThemeUtils.setSwitchColor(this);
 *      * 实现ThemeUtils.switchColor接口
 *          实现以下方法:
 *              replaceColorById();
 *              replaceColor();
 *              getThemeColor();
 *              getThemeColorId();
 *
 *              主要修改getTheme()该方法
 *
 */
public class MagicaSakuraActivity extends AppCompatActivity implements CardPickerDialog.ClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magica_sakura);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ThemeUtils.getColorById(this, R.color.theme_color_primary_dark));
            ActivityManager.TaskDescription description = new ActivityManager.TaskDescription(null, null,
                    ThemeUtils.getThemeAttrColor(this, android.R.attr.colorPrimary));
            setTaskDescription(description);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.change_theme) {
            CardPickerDialog dialog = new CardPickerDialog();
            dialog.setClickListener(this);
            dialog.show(getSupportFragmentManager(), CardPickerDialog.TAG);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onConfirm(int currentTheme) {
        if (ThemeHelper.getTheme(MagicaSakuraActivity.this) != currentTheme) {
            ThemeHelper.setTheme(MagicaSakuraActivity.this, currentTheme);
            ThemeUtils.refreshUI(MagicaSakuraActivity.this, new ThemeUtils.ExtraRefreshable() {
                        @Override
                        public void refreshGlobal(Activity activity) {
                            //for global setting, just do once
                            if (Build.VERSION.SDK_INT >= 21) {
                                final MagicaSakuraActivity context = MagicaSakuraActivity.this;
                                // toolbar背景色
                                ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription(null, null, ThemeUtils.getThemeAttrColor(context, android.R.attr.colorPrimary));
                                setTaskDescription(taskDescription);
                                // 状态栏颜色
                                getWindow().setStatusBarColor(ThemeUtils.getColorById(context, R.color.theme_color_primary_dark));
                            }
                        }

                        @Override
                        public void refreshSpecificView(View view) {
                            //TODO: will do this for each traversal
                        }
                    }
            );
        }

    }
}
