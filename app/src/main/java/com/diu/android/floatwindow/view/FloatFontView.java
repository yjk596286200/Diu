package com.diu.android.floatwindow.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/5/26.
 */

public class FloatFontView extends View {
    public FloatFontView(Context context) {
        super(context);
        //当用代码动态创建自定义控件时，new 的时候调用

    }

    public FloatFontView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //当自定义控件被配置在布局文件里面，并且这个布局文件里写有自定义属性时调用
    }

    public FloatFontView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //当自定义控件被配置在布局文件里面，并且这个布局文件里写有对应的style样式时调用
    }
}
