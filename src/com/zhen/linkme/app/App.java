package com.zhen.linkme.app;

import com.avos.avoscloud.AVAnalytics;
import com.avos.avoscloud.AVOSCloud;

import android.app.Application;

public class App extends Application {

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		AVOSCloud.initialize(this,
				"mccobk3aohfmpgjy5nitcei77cshb516itg4bsr0ymo77gbj",
				"ikq6p2f14cp8lv79pk6o4mhd1o5lqnouf0y18qaf4ai2srmp");
		AVAnalytics.setAnalyticsEnabled(false);
	}
}
