package com.zhen.linkme.entity;

import com.avos.avoscloud.AVInstallation;
import com.avos.avoscloud.AVUser;

public class User {
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String AVATAR = "avatar";
	public static final String INSTALLATION = "installation";
	public static final String GENDER = "gender";
	public static final String LOCATION = "location";

	/**
	 * 定义 性别为枚举类型
	 */
	public static enum Gender {

		// 利用构造函数传参
		Male(0), femal(1);

		int value;

		// 构造器
		Gender(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;

		}

	}

	/**
	 * 返回当前用户的Id
	 */

	public static String getCurrentUserId() {
		AVUser user = AVUser.getCurrentUser();
		if (user != null) {
			return user.getObjectId();
		} else {
			return null;
		}
	}

	/**
	 * 返回设备号
	 * @param user
	 * @return installation
	 */
	public static AVInstallation getInstallation(AVUser user) {

		try {
			return user.getAVObject(INSTALLATION, AVInstallation.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
