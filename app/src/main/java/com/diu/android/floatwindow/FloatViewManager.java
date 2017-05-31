package com.diu.android.floatwindow;

import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.diu.android.R;

/**
 * Created by Administrator on 2017/5/26.
 */

public class FloatViewManager {
    private Context context;
    private WindowManager manager;//通过manager来操控浮窗体的显示与隐藏
    private View floatView;//在悬浮窗上要显示的View
    private WindowManager.LayoutParams params;//要显示的视图参数
    private static FloatViewManager instance;
    public View.OnTouchListener listener = new View.OnTouchListener() {

        private float starty;
        private float startx;

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    startx = event.getRawX();
                    starty = event.getRawY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    float x = event.getRawX();
                    float y = event.getRawY();
                    float dx = x- startx;
                    float dy = y-starty;
                    params.x+=dx;
                    params.y+=dy;
                    manager.updateViewLayout(floatView,params);
                    startx = x;
                    starty = y;
                    break;
                case MotionEvent.ACTION_UP:
                    float x1 = event.getRawX();
                    if (x1>getScreenPoint().x/2){
                        params.x = getScreenPoint().x-floatView.getWidth();
                    }else {
                        params.x = 0;
                    }
                    manager.updateViewLayout(floatView,params);
                    break;

            }
            return false;
        }
    };

    private FloatViewManager(Context context){
        this.context = context;
        manager= (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        floatView = LayoutInflater.from(context).inflate(R.layout.floatview,null);

    }


    public static FloatViewManager getInstance(Context context){
        if (instance==null){
            synchronized (FloatViewManager.class){
                if (instance==null){
                    instance = new FloatViewManager(context);
                }
            }
        }
        return instance;
    }

    /**
     * 展示View到悬浮窗上
     */
    public void showFloatView(){
        params = new WindowManager.LayoutParams();
        params.width = floatView.getWidth();
        params.height = floatView.getHeight();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = 0;
        params.type = WindowManager.LayoutParams.TYPE_PHONE;
        params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE| WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        params.format = PixelFormat.RGBA_8888;
        manager.addView(floatView, params);
    }

    public Point getScreenPoint(){
        Point point = new Point();
        manager.getDefaultDisplay().getSize(point);
        return point;
    }

}
