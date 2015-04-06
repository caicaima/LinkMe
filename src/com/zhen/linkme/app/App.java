package com.zhen.linkme.app;

import java.io.File;

import android.app.Application;
import android.content.Context;

import com.avos.avoscloud.AVAnalytics;
import com.avos.avoscloud.AVOSCloud;
import com.baidu.mapapi.SDKInitializer;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.utils.StorageUtils;

/**
 * 对leancloud 的初始化
 * 
 * @author Administrator 需要做的工作 1.初始化 百度 地图 2.初始化 图片缓存 3.初始化 全局context
 *         4.对当前用户进行的信息进行初始化和读取
 * 
 * 
 */
public class App extends Application {

	/**
	 * 1、初始化百度地图
	 */
	private void initBDMap() {
		SDKInitializer.initialize(getApplicationContext());
	}

	/**
	 * 1、配置ImageLoader
	 */

	public static void initImageLoader(Context context) {

		File cacheDir = StorageUtils.getCacheDirectory(context);

		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				context).discCache(new UnlimitedDiscCache(cacheDir))
				// 自定义的缓存路径
				.threadPoolSize(3)
				// 线程池的大小
				.threadPriority(Thread.NORM_PRIORITY - 2)
				// 线程的优先级
				.denyCacheImageMultipleSizesInMemory()
				.tasksProcessingOrder(QueueProcessingType.LIFO)// 定义任务进程为后进先出
				.build();
		ImageLoader.getInstance().init(config); // 单例模式初始化ImgeLoader 配置

	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		AVOSCloud.initialize(this,
				"mccobk3aohfmpgjy5nitcei77cshb516itg4bsr0ymo77gbj",
				"ikq6p2f14cp8lv79pk6o4mhd1o5lqnouf0y18qaf4ai2srmp");

		initImageLoader(this);
		initBDMap();
		AVAnalytics.setAnalyticsEnabled(false);
	}
}
