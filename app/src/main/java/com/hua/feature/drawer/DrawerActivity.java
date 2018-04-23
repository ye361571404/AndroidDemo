package com.hua.feature.drawer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import com.hua.R;

public class DrawerActivity extends AppCompatActivity {


    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
    }
}


