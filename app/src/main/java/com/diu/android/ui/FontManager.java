package com.diu.android.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Administrator on 2017/5/26.
 */

public class FontManager {
    private static FontManager instance;
    private Context context;
    private FontManager(Context context){
        this.context = context;
    }

    public static FontManager getIsntance(Context context){
        if (instance==null){
            synchronized (FontManager.class){
                if (instance==null){
                    instance = new FontManager(context);
                }
            }
        }
        return instance;
    }

    public void changeFonts(TextView tv){

        Log.e("阳江看见","邹家地覅偶"+tv.getWidth());
        Typeface tf = Typeface.createFromAsset(context.getAssets(),"PinkClouds.ttf");
        tv.setTypeface(tf);
        Log.e("阳江看见","邹家地覅偶法大大"+tv.getWidth());
    }
}
