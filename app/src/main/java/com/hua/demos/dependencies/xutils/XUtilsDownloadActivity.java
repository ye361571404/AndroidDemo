package com.hua.demos.dependencies.xutils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.hua.R;
import com.hua.demos.dependencies.xutils.download.DownloadManager;

import org.xutils.ex.DbException;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;


@ContentView(R.layout.activity_xutils_download)
public class XUtilsDownloadActivity extends AppCompatActivity {

    @ViewInject(R.id.et_url)
    private EditText etUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        // setContentView(R.layout.activity_xutils_download);
    }


    /**
     * 开始下载
     * 备注:方法修饰符改为 private才有效
     * @throws DbException
     */
    @Event(value = R.id.tv_down)
    private void down(View view) throws DbException {
        String url = etUrl.getText().toString();
        for (int i = 0; i < 5; i++) {
            String label = i + "xUtils_" + System.nanoTime();
            DownloadManager.getInstance().startDownload(url, label, "/sdcard/xUtils/" + label + ".aar", true, false, null);
        }
    }

    /**
     * 打开下载列表页
     * @param view
     * @throws DbException
     */
    @Event(value = R.id.tv_down_list)
    private void goToDownloadList(View view) throws DbException {
       startActivity(new Intent(XUtilsDownloadActivity.this, DownloadActivity.class));
    }



}
