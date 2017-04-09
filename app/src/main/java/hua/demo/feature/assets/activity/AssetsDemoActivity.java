package hua.demo.feature.assets.activity;

import android.widget.TextView;

import org.xutils.common.util.LogUtil;


import java.io.File;
import java.util.List;

import butterknife.Bind;
import hua.demo.R;
import hua.demo.common.Constants;
import hua.demo.main.activity.BaseActivity;
import hua.demo.utils.AssetsUtil;
import hua.demo.utils.StorageUtil;

public class AssetsDemoActivity extends BaseActivity {

    @Bind(R.id.tv_content)
    TextView tvContent;

    @Override
    protected int getLayoutRes() {

        return R.layout.activity_assets_demo;
    }

    @Override
    protected void assignViews() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

        List<File> files = AssetsUtil.getFiles("files");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < files.size(); i++) {
            String fileName = files.get(i).getName();
            LogUtil.e("initData = " + fileName);
            sb.append(fileName + "\n");
        }

        tvContent.setText(sb.toString());
        String destDir = StorageUtil.getAppCustomCacheDirectory(Constants.APP_CACHE_DIR_FILES).getAbsolutePath();
        AssetsUtil.copyAssetsDir2StorageDir("files", destDir);
    }

}
