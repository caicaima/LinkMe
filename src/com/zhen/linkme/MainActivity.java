package com.zhen.linkme;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.zhen.linkme.utils.Utils;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText mEditText_username;
	private EditText mEditText_password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// find activity
		setContentView(R.layout.activity_main);

		mEditText_username = (EditText) findViewById(R.id.username);
		mEditText_password = (EditText) findViewById(R.id.password);

	}

	public void onclick(View view) {
		// ��ȡ�����id
		int id = view.getId();

		// ������ļ���
		switch (id) {
		case R.id.head_img:
			// ���ͷ��ļ���

			break;

		case R.id.login_img:
			// �����¼��ť

			LogIn();

			break;

		case R.id.seg_img:
			// ���ע�ᰴť
			Intent intent_reg = new Intent(MainActivity.this,
					RegisterActivity.class);
			startActivity(intent_reg);

			break;

		}

	}

	// ��¼�ķ���
	private void LogIn() {

		final String user_name = mEditText_username.getText().toString();
		final String pass_word = mEditText_password.getText().toString();

		if (TextUtils.isEmpty(user_name)) {
			Utils.toast(R.string.username_cannot_null);
			return;
		}

		if (TextUtils.isEmpty(pass_word)) {
			Utils.toast(R.string.password_can_not_null);
			return;
		}

		AVUser.logInInBackground(user_name, pass_word,
				new LogInCallback<AVUser>() {

					@Override
					public void done(AVUser arg0, AVException e) {
						if (arg0 != null) {
							Intent intent_login = new Intent(MainActivity.this,
									BaseFragmentActivity.class);
							startActivity(intent_login);
						} else {
							Utils.toast(e + "");

						}
					}
				});
	}
}
