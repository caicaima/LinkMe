package com.zhen.linkme.utils;

import android.content.Context;
import android.widget.Toast;
import com.zhen.linkme.app.App;

public class Utils {

	public static void toast(int id) {
		toast(App.ctx, id);
	}

	public static void toast(String s) {
		toast(App.ctx, s);
	}

	public static void toast(Context cxt, int id) {
		Toast.makeText(cxt, id, Toast.LENGTH_SHORT).show();
	}

	public static void toast(Context context, String str) {
		Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
	}
	
	
	
}
