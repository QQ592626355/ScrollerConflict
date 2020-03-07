package com.market.scrollerconflict;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class MyPagerAdapter extends PagerAdapter {

    private List<View> list;

    public MyPagerAdapter(List<View> list){
        this.list = list;
    }
    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == list.get((int)Integer.parseInt(object.toString()));

    }



    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = list.get(position);
        container.addView(view);
      //  Log.i(TAG, NAME + "--instantiateItem++container:" + container.getChildCount() + "++position:" + position);
        return position;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
      //  Log.i(TAG, NAME + "--destroyItem++container:" + container.getChildCount() + "++position:" + position);
    }


}
