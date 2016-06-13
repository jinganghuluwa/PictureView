package com.example.tongzhichao.pictureviewer;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.weight.ImageSource;
import com.example.weight.SubsamplingScaleImageView;

import java.util.ArrayList;

/**
 * Created by tongzhichao on 6/12/16.
 */
public class PictureAdapter extends PagerAdapter {

    private ArrayList<String> mData;

    private MainActivity mContext;

    public PictureAdapter(Context context, ArrayList<String> list) {
        mContext = (MainActivity) context;
        mData = list;
    }


    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView pictureView = new ImageView(mContext);
        pictureView.setImageBitmap(BitmapFactory.decodeFile(mData.get(position)));
        pictureView.setOnClickListener(listener);

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        container.addView(pictureView, position, layoutParams);
        return pictureView;
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mContext.changeFullScreen();
        }
    };

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
