package com.hua.demos.feature.openfile;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.hua.R;
import com.hua.common.Constants;
import com.hua.utils.AssetsUtil;
import com.hua.utils.StorageUtil;

import java.io.File;

/**
 * 调用系统安装的相关app打开文件
 */
public class OpenFileActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvText;
    private TextView tvPdf;
    private TextView tvOffice;
    private TextView tvImg;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_file);
        assignViews();
        setListener();
        initData();
    }

    private void initData() {
        String data = AssetsUtil.readFile("89 调用第三方app打开文件步骤.html");
        webView.loadDataWithBaseURL(null,data,"text/html", "utf-8", null);
    }


    private void assignViews() {
        tvText = (TextView) findViewById(R.id.tv_text);
        tvPdf = (TextView) findViewById(R.id.tv_pdf);
        tvOffice = (TextView) findViewById(R.id.tv_office);
        tvImg = (TextView) findViewById(R.id.tv_img);
        webView = (WebView) findViewById(R.id.webview);
    }

    private void setListener() {
        tvText.setOnClickListener(this);
        tvPdf.setOnClickListener(this);
        tvOffice.setOnClickListener(this);
        tvImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        File file = null;
        switch (v.getId()) {
            case R.id.tv_text:
                file = StorageUtil.getAppCustomCacheDirectory(Constants.APP_CACHE_DIR_FILES + File.separator + "002.txt");
                // File file = StorageUtil.getAppCustomCacheDirectory(Constants.APP_CACHE_DIR + File.separator + "统计年鉴20170613-13.txt");
                break;
            case R.id.tv_pdf:

                break;
            case R.id.tv_office:
                file = StorageUtil.getAppCustomCacheDirectory(Constants.APP_CACHE_DIR_FILES + File.separator + "001.doc");
                break;
            case R.id.tv_img:

                break;
        }

        openFile(file);
    }

    /**
     * 打开文件
     * @param file
     */
    private void openFile(File file){
        Uri photoURI = FileProvider.getUriForFile(OpenFileActivity.this, "com.hua.fileprovider", file);

        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //设置intent的Action属性
        intent.setAction(Intent.ACTION_VIEW);
        //获取文件file的MIME类型
        String type = getMIMEType(file);
        //设置intent的data和Type属性。
        intent.setDataAndType(photoURI, type);
        // intent.setDataAndType(/*uri*/Uri.fromFile(file), type);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        startActivity(intent);

    }

    /**
     * 根据文件后缀名获得对应的MIME类型。
     * @param file
     */
    private String getMIMEType(File file) {

        String type="*/*";
        String fName = file.getName();
        //获取后缀名前的分隔符"."在fName中的位置。
        int dotIndex = fName.lastIndexOf(".");
        if(dotIndex < 0){
            return type;
        }
    /* 获取文件的后缀名 */
        String end=fName.substring(dotIndex,fName.length()).toLowerCase();
        if(end=="")return type;
        //在MIME和文件类型的匹配表中找到对应的MIME类型。
        for(int i=0;i<MIME_MapTable.length;i++){ //MIME_MapTable??在这里你一定有疑问，这个MIME_MapTable是什么？
            if(end.equals(MIME_MapTable[i][0]))
                type = MIME_MapTable[i][1];
        }
        return type;
    }

    private final String[][] MIME_MapTable={
            //{后缀名， MIME类型}
            {".3gp",    "video/3gpp"},
            {".apk",    "application/vnd.android.package-archive"},
            {".asf",    "video/x-ms-asf"},
            {".avi",    "video/x-msvideo"},
            {".bin",    "application/octet-stream"},
            {".bmp",    "image/bmp"},
            {".c",  "text/plain"},
            {".class",  "application/octet-stream"},
            {".conf",   "text/plain"},
            {".cpp",    "text/plain"},
            {".doc",    "application/msword"},
            {".docx",   "application/vnd.openxmlformats-officedocument.wordprocessingml.document"},
            {".xls",    "application/vnd.ms-excel"},
            {".xlsx",   "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"},
            {".exe",    "application/octet-stream"},
            {".gif",    "image/gif"},
            {".gtar",   "application/x-gtar"},
            {".gz", "application/x-gzip"},
            {".h",  "text/plain"},
            {".htm",    "text/html"},
            {".html",   "text/html"},
            {".jar",    "application/java-archive"},
            {".java",   "text/plain"},
            {".jpeg",   "image/jpeg"},
            {".jpg",    "image/jpeg"},
            {".js", "application/x-javascript"},
            {".log",    "text/plain"},
            {".m3u",    "audio/x-mpegurl"},
            {".m4a",    "audio/mp4a-latm"},
            {".m4b",    "audio/mp4a-latm"},
            {".m4p",    "audio/mp4a-latm"},
            {".m4u",    "video/vnd.mpegurl"},
            {".m4v",    "video/x-m4v"},
            {".mov",    "video/quicktime"},
            {".mp2",    "audio/x-mpeg"},
            {".mp3",    "audio/x-mpeg"},
            {".mp4",    "video/mp4"},
            {".mpc",    "application/vnd.mpohun.certificate"},
            {".mpe",    "video/mpeg"},
            {".mpeg",   "video/mpeg"},
            {".mpg",    "video/mpeg"},
            {".mpg4",   "video/mp4"},
            {".mpga",   "audio/mpeg"},
            {".msg",    "application/vnd.ms-outlook"},
            {".ogg",    "audio/ogg"},
            {".pdf",    "application/pdf"},
            {".png",    "image/png"},
            {".pps",    "application/vnd.ms-powerpoint"},
            {".ppt",    "application/vnd.ms-powerpoint"},
            {".pptx",   "application/vnd.openxmlformats-officedocument.presentationml.presentation"},
            {".prop",   "text/plain"},
            {".rc", "text/plain"},
            {".rmvb",   "audio/x-pn-realaudio"},
            {".rtf",    "application/rtf"},
            {".sh", "text/plain"},
            {".tar",    "application/x-tar"},
            {".tgz",    "application/x-compressed"},
            {".txt",    "text/plain"},
            {".wav",    "audio/x-wav"},
            {".wma",    "audio/x-ms-wma"},
            {".wmv",    "audio/x-ms-wmv"},
            {".wps",    "application/vnd.ms-works"},
            {".xml",    "text/plain"},
            {".z",  "application/x-compress"},
            {".zip",    "application/x-zip-compressed"},
            {"",        "*/*"}
    };


}
