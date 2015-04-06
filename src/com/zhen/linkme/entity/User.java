package com.zhen.linkme.entity;

import com.avos.avoscloud.AVInstallation;
import com.avos.avoscloud.AVUser;

public class User {
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	private static final String AVATAR = "avatar";
	private static final String INSTALLATION = "installation";
	private static final String GENDER = "gender";
	private static final String LOCATION = "location";

	/**
	 * ���� �Ա�Ϊö������
	 */
	public static enum Gender {

		// ���ù��캯������
		Male(0), femal(1);

		int value;

		// ������
		Gender(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;

		}

	}

	/**
	 * ���ص�ǰ�û���Id
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
	 * �����豸��
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
