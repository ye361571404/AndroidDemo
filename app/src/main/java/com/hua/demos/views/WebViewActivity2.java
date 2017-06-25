package com.hua.demos.views;

import android.webkit.WebView;

import com.hua.R;
import com.hua.main.activity.BaseActivity;
import com.hua.utils.AssetsUtil;

public class WebViewActivity2 extends BaseActivity {


    private WebView webView;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_web_view2;
    }

    @Override
    protected void assignViews() {
        webView = (WebView)findViewById(R.id.webview);

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        // String data = AssetsUtil.readFile("html1.txt");
        // String data = AssetsUtil.readFile("html2.txt");
        // String data = AssetsUtil.readFile("html3.txt");
        String data = AssetsUtil.readFile("table.htm");

        webView.loadDataWithBaseURL(null,data,"text/html", "utf-8", null);
    }
}
