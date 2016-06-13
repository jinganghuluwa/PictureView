package com.example.tongzhichao.pictureviewer;

import android.graphics.BitmapFactory;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mPicPager;
    private PictureAdapter mAdapter;
    private boolean mIsFullScreen = false;
    private ArrayList<String> mDatas = new ArrayList<>();

    private FrameLayout mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolBar = (FrameLayout) findViewById(R.id.toolBar);
        mPicPager = (ViewPager) findViewById(R.id.pic_pager);
        mPicPager.setOffscreenPageLimit(2);
        initData();
        mAdapter = new PictureAdapter(this, mDatas);
        mPicPager.setAdapter(mAdapter);
        mToolBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void setFullScreen(boolean fullScreen) {
        WindowManager.LayoutParams params = getWindow().getAttributes();
        if (fullScreen) {
            params.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
            getWindow().setAttributes(params);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            mToolBar.setVisibility(View.GONE);
            mIsFullScreen = true;
        } else {
            params.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().setAttributes(params);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            mToolBar.setVisibility(View.VISIBLE);
            mIsFullScreen = false;
        }
    }

    public void changeFullScreen() {
        setFullScreen(!mIsFullScreen);
    }


    private void initData() {
        mDatas.add("sdcard/Pictures/netease/newsreader/20160324153057aa33a.jpg");
        mDatas.add("sdcard/Pictures/netease/newsreader/20160409195131c2c29.png");
        mDatas.add("sdcard/Pictures/netease/newsreader/20160409195135def29.png");
        mDatas.add("sdcard/Pictures/netease/newsreader/20160410172737b51fc.png");
        mDatas.add("sdcard/Pictures/netease/newsreader/20160414180551c2054.jpg");
    }
}
