package com.market.scrollerconflict;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class MyViewPager extends ViewPager {

    private int lastXIntercept;
    private int lastYIntercept;

    public MyViewPager(@NonNull Context context) {
        super(context);
    }

    public MyViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
       //默认不拦截
        boolean intercept = false;
      //获取原始的点击处的坐标
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        final int action = ev.getAction() & MotionEvent.ACTION_MASK;

        switch (action){
           case MotionEvent.ACTION_DOWN://按下操作不拦截,如果拦截了就会导致无法分发到子View
               intercept = false;
               //这一句必不可少，缺少的话，无法继续分发
               super.onInterceptTouchEvent(ev);
               break;
               case MotionEvent.ACTION_MOVE://
                   //横向位移增量
                   int deltaX = x - lastXIntercept;
                   //竖向位移增量
                   int deltaY = y - lastYIntercept;
                   //如果横向滑动距离大于竖向滑动距离，则认为使用者是想要左右滑动
                   //此时就使 ViewPager 拦截此事件
                   intercept = Math.abs(deltaX) > Math.abs(deltaY);
                   break;
           case MotionEvent.ACTION_UP:
                   break;
           default:
               break;
       }
        lastXIntercept = x;
        lastYIntercept = y;
       return intercept;
    }
}
