package com.example.lenovo.niuqiongqiong1503d20170522;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/5/22.
 */

    public class IndextAdapter extends FragmentPagerAdapter {


        //要展示的标题
        public String[] TITLE = {"推荐", "热点", "本地", "视频", "社会", "娱乐", "科技", "汽车", "科技", "汽车", "体育", "财经", "军事", "国际", "段子", "趣图", "健康", "美女"};

     public IndextAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
     }

    @Override
    public Fragment getItem(int position) {

//如果需要不同的类型。可根据判断下标进行加载接口地址
        TuijianFragment tuijianFragment = new TuijianFragment();
        return tuijianFragment;


    }

    @Override
    public int getCount() {
        return TITLE.length;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return TITLE[position];
    }



}


