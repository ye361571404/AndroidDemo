package com.hua.demos.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.hua.R;
import com.hua.main.activity.BaseActivity;
import com.hua.utils.AssetsUtil;

public class WebViewActivity3  extends BaseActivity {


    private ProgressBar bar;
    private WebView webView;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_web_view3;
    }

    @Override
    protected void assignViews() {
        bar = (ProgressBar) findViewById(R.id.myProgressBar);
        webView = (WebView)findViewById(R.id.webview);

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        initWebView();
    }

    private void initWebView() {
        WebSettings webSettings = webView.getSettings();
        //设置支持javaScript脚步语言
        webSettings.setJavaScriptEnabled(true);

        //支持双击-前提是页面要支持才显示
//        webSettings.setUseWideViewPort(true);

        //支持缩放按钮-前提是页面要支持才显示
        webSettings.setBuiltInZoomControls(true);

        //设置客户端-不跳转到默认浏览器中
        webView.setWebViewClient(new WebViewClient());

        //设置支持js调用java
        // wvContent.addJavascriptInterface(new AndroidAndJSInterface(),"Android");


        //加载网络资源
//        wvContent.loadUrl("http://10.0.2.2:8080/assets/JavaAndJavaScriptCall.html");
        // webView.loadUrl("file:///android_asset/table.htm");
        webView.loadUrl("file:///mnt/sdcard/table.htm");


        webView.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    bar.setVisibility(View.INVISIBLE);
                } else {
                    if (View.INVISIBLE == bar.getVisibility()) {
                        bar.setVisibility(View.VISIBLE);
                    }
                    bar.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }

        });

    }


}
