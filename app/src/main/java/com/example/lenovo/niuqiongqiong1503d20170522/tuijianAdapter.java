package com.example.lenovo.niuqiongqiong1503d20170522;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by lenovo on 2017/5/22.
 */

public class tuijianAdapter extends BaseAdapter {
    private Context context;
    private List<TabTitle.DataBean>  list;
    private vh v;

    public tuijianAdapter(Context context, List<TabTitle.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){

          convertView= View.inflate(context, R.layout.tuijianlistview, null);

            v = new vh();

            v.tvtitle=(TextView) convertView.findViewById(R.id.title);
            v.tvneirong=(TextView) convertView.findViewById(R.id.neirong);
            v.iv=(ImageView) convertView.findViewById(R.id.iv);

            convertView.setTag(v);

        }else{


            v=(vh)convertView.getTag();
        }

        v.tvtitle.setText(list.get(position).getTITLE());
        v.tvtitle.setText(list.get(position).getSUBTITLE());
        ImageLoader.getInstance().displayImage(list.get(position).getIMAGEURL(),v.iv);

        return convertView;
    }

    class vh{
        TextView  tvtitle;
        TextView  tvneirong;
        ImageView iv;


    }
}
