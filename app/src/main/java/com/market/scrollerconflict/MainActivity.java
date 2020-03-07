package com.market.scrollerconflict;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<View> viewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyViewPager viewPager = findViewById(R.id.myViewPager);
        viewList = new ArrayList<>();
        initData(true);
        viewPager.setAdapter(new MyPagerAdapter(viewList));
    }


    private void initData(boolean flag) {
        for (int j = 0; j < 4; j++) {
            View view;
            if (flag) {
                ListView listView = new ListView(this);
                List<String> dataList = new ArrayList<>();
                for (int i = 0; i < 30; i++) {
                    dataList.add("leavesC " + i);
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
                listView.setAdapter(adapter);
                view = listView;
            } else {
                TextView textView = new TextView(this);
                textView.setGravity(Gravity.CENTER);
                textView.setText("leavesC " + j);
                textView.setClickable(true);
                view = textView;
            }
            viewList.add(view);
        }
    }
}
