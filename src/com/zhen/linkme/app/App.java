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
 * ��leancloud �ĳ�ʼ��
 * 
 * @author Administrator ��Ҫ���Ĺ��� 1.��ʼ�� �ٶ� ��ͼ 2.��ʼ�� ͼƬ���� 3.��ʼ�� ȫ��context
 *         4.�Ե�ǰ�û����е���Ϣ���г�ʼ���Ͷ�ȡ
 * 
 * 
 */
public class App extends Application {

	/**
	 * 1����ʼ���ٶȵ�ͼ
	 */
	private void initBDMap() {
		SDKInitializer.initialize(getApplicationContext());
	}

	/**
	 * 1������ImageLoader
	 */

	public static void initImageLoader(Context context) {

		File cacheDir = StorageUtils.getCacheDirectory(context);

		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				context).discCache(new UnlimitedDiscCache(cacheDir))
				// �Զ���Ļ���·��
				.threadPoolSize(3)
				// �̳߳صĴ�С
				.threadPriority(Thread.NORM_PRIORITY - 2)
				// �̵߳����ȼ�
				.denyCacheImageMultipleSizesInMemory()
				.tasksProcessingOrder(QueueProcessingType.LIFO)// �����������Ϊ����ȳ�
				.build();
		ImageLoader.getInstance().init(config); // ����ģʽ��ʼ��ImgeLoader ����

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
