package com.example.lenovo.niuqiongqiong1503d20170522;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.liaoinstan.springview.container.MeituanFooter;
import com.liaoinstan.springview.container.MeituanHeader;
import com.liaoinstan.springview.widget.SpringView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/5/22.
 */

public class TuijianFragment extends Fragment {

    private SpringView springView;
    private ListView listView;
    private String urls;
    private List<TabTitle.DataBean> all = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tuijianfragment, container, false);
        springView = (SpringView) view.findViewById(R.id.tuijian_fragment_spingview);
        listView = (ListView) view.findViewById(R.id.tuijian_fragment_lv);

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//设置头尾  刷新类型  OVERLAP 表面刷新
        springView.setHeader(new MeituanHeader(getContext()));
        springView.setFooter(new MeituanFooter(getContext()));
        springView.setType(SpringView.Type.FOLLOW);

        getData();
        tuijianAdapter  adapter=new tuijianAdapter(getActivity(),all);

        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);


//监听事件
        springView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                springView.onFinishFreshAndLoad();
            }

            @Override
            public void onLoadmore() {
                springView.onFinishFreshAndLoad();
            }
        });


    }

    private void getData() {


        RequestParams requestParams = new RequestParams("http://www.93.gov.cn/93app/data.do?channelId=0&startNum=0");

        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson g=new Gson();
                TabTitle tabTitle = g.fromJson(result, TabTitle.class);

                List<TabTitle.DataBean> data = tabTitle.getData();

                all.addAll(data);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                System.out.println("+++++++++++++++++++++++++++++++++");
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });


    }
}