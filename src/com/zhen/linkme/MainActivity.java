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
		//��ȡ�����id
		int id = view.getId();
		
		//������ļ���
		switch (id) {
		case R.id.head_img:
			//���ͷ��ļ���
			
			
			break;
			
		case R.id.login_img:
			//�����¼��ť
			Intent intent_login = new Intent(MainActivity.this,MessageActivity.class);
			startActivity(intent_login);
			
			break;
			
		case R.id.seg_img:
			//���ע�ᰴť
			Intent intent_reg = new Intent(MainActivity.this,RegisterActivity.class);
			startActivity(intent_reg);
			
			break;
			
		case R.id.username:
			//��¼�û���
			
			break;
			
		case R.id.password:
			//��¼������
			
			break;

	
		}
		
		
		
	}
	

}
