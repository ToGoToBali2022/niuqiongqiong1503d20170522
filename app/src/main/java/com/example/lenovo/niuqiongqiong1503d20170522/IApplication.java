package com.example.lenovo.niuqiongqiong1503d20170522;

import android.app.Application;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;

/**
 * Created by lenovo on 2017/5/22.
 */

public class IApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        initImageLoader();




    }



    private void initImageLoader(){
        String path = Environment.getExternalStorageDirectory() + "/imageload" ;
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .memoryCacheExtraOptions(480, 800)//缓存图片最大的长和宽
                .threadPoolSize(2)//线程池的数量
                .threadPriority(4)
                .memoryCacheSize(2*1024*1024)//设置内存缓存区大小
                .diskCacheSize(20*1024*1024)//设置sd卡缓存区大小
                .writeDebugLogs()//打印日志内容
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .build();
        ImageLoader.getInstance().init(config);
    }



    public static DisplayImageOptions getOption(){
        DisplayImageOptions options = new DisplayImageOptions.Builder()
        .showImageOnLoading(R.mipmap.ic_launcher) // resource or drawable
// .showImageForEmptyUri(R.mipmap.timg) // resource or drawable
               // .showImageOnFail(R.mipmap.ic_launcher) // resource or drawable
//delayInMillis为你设置的下载前的延迟时间
                .delayBeforeLoading(1000)
                .cacheInMemory(true) //设置下载的图片是否缓存在内存中
                .cacheOnDisk(true) // 设置下载的图片是否缓存在SD卡中
// 是否设置为圆角，弧度为多少
//.displayer(new RoundedBitmapDisplayer(20))
                // 是否图片加载好后渐入的动画时间
// .displayer(new FadeInBitmapDisplayer(100))
                .build();
        return options;

    }
}
