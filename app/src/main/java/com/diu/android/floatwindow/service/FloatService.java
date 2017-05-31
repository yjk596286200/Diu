package com.diu.android.floatwindow.service;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.diu.android.floatwindow.FloatViewManager;
import com.diu.android.ui.FontManager;

/**
 * Created by Administrator on 2017/5/26.
 */

public class FloatService extends Service {

    private String datas;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {
        Log.e("阳江看见",intent.getStringExtra("data"));
        datas=intent.getStringExtra("data");
        FloatViewManager manager=FloatViewManager.getInstance(this);
        manager.showFloatView();
        return super.onStartCommand(intent, flags, startId);
    }


}
