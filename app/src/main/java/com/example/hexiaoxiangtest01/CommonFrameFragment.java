package com.example.hexiaoxiangtest01;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class CommonFrameFragment extends BaseFragment {
    private TextView textView;
    private static final String TAG = CommonFrameFragment.class.getSimpleName();

    @Override
    public View initView() {
        textView = new TextView(context);
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        textView.setText("框架");
    }
}
