package com.zhen.linkme;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class MainActivity extends Activity {
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
	}
	
	public void onclick(View view){
		//获取组件的id
		int id = view.getId();
		
		//个组件的监听
		switch (id) {
		case R.id.head_img:
			//点击头像的监听
			
			
			break;
			
		case R.id.login_img:
			//点击登录按钮
			Intent intent_login = new Intent(MainActivity.this,MessageActivity.class);
			startActivity(intent_login);
			
			break;
			
		case R.id.seg_img:
			//点击注册按钮
			Intent intent_reg = new Intent(MainActivity.this,RegisterActivity.class);
			startActivity(intent_reg);
			
			break;
			
		case R.id.username:
			//登录用户名
			
			break;
			
		case R.id.password:
			//登录的密码
			
			break;

	
		}
		
		
		
	}
	

}
