package com.example.lenovo.niuqiongqiong1503d20170522;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取控件
        TabLayout tabLayout = (TabLayout) findViewById(R.id.table);
        ViewPager viewPager = (ViewPager) findViewById(R.id.vp);
//获取适配器
        IndextAdapter adapter = new IndextAdapter(getSupportFragmentManager());
        adapter.notifyDataSetChanged();
        viewPager.setAdapter(adapter);
//绑定
        tabLayout.setupWithViewPager(viewPager);
//字体颜色
        tabLayout.setTabTextColors(getResources().getColor(R.color.colorhui), getResources().getColor(R.color.colorAccent));
//指示器颜色
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorhui));
//模式      MODE_FIXED  填满宽度
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }
}
