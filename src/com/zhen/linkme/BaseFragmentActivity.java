package com.zhen.linkme;

import com.zhen.linkme.fragment.ContactFragment;
import com.zhen.linkme.fragment.ConvFragment;
import com.zhen.linkme.fragment.DiscoverFragment;
import com.zhen.linkme.fragment.MySpaceFragment;
import com.zhen.linkme.fragment.ShareFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

public class BaseFragmentActivity extends FragmentActivity {
	
	
	public static final int FRAGMENT_N = 5;
	public static final int[] tabsNormalBackIds = new int[] {
			R.drawable.tabbar_chat, R.drawable.tabbar_contacts,
			R.drawable.tabbar_contacts, R.drawable.tabbar_discover,
			R.drawable.tabbar_me };
	public static final int[] tabsActiveBackIds = new int[] {
			R.drawable.tabbar_chat_active, R.drawable.tabbar_contacts_active,
			R.drawable.tabbar_contacts_active,
			R.drawable.tabbar_discover_active, R.drawable.tabbar_me_active };

	Button conversationBtn, contactBtn, shareButton, discoverBtn, mySpaceBtn;
	Button[] tabs;
	View fragmentContainer;
	View recentTips, contactTips, shareTips;

	ContactFragment contactFragment;
	DiscoverFragment discoverFragment;
	ConvFragment convFragment;
	MySpaceFragment mySpaceFragment;
	ShareFragment shareFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.message_activity);

		findView();
		init();

		conversationBtn.performClick();
		

	}

	/**
	 * 初始化Button
	 */
	private void init() {
		tabs = new Button[] { conversationBtn, contactBtn, shareButton,
				discoverBtn, mySpaceBtn };

	}

	/**
	 * 获取各个控件的Id
	 */
	private void findView() {
		conversationBtn = (Button) findViewById(R.id.btn_message);
		contactBtn = (Button) findViewById(R.id.btn_contact);
		shareButton = (Button) findViewById(R.id.btn_share);
		discoverBtn = (Button) findViewById(R.id.btn_discover);
		mySpaceBtn = (Button) findViewById(R.id.btn_my_space);
		fragmentContainer = findViewById(R.id.fragment_container);
		recentTips = findViewById(R.id.iv_recent_tips);
		contactTips = findViewById(R.id.iv_contact_tips);
		shareTips = findViewById(R.id.iv_share_tips);
	}

	/**
	 * 各个Button的监听
	 */
	public void onTabSelect(View view) {
		int id = view.getId();
		FragmentManager manager = getFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		hideFragments(transaction);
		setNormalBackgrounds();
		if (id == R.id.btn_message) {     //会话
			if (convFragment == null) {
				convFragment = new ConvFragment();
				transaction.add(R.id.fragment_container, convFragment);
			}
			transaction.show(convFragment);
		} else if (id == R.id.btn_contact) {  //通讯录
			if (contactFragment == null) {
				contactFragment = new ContactFragment();
				transaction.add(R.id.fragment_container, contactFragment);
			}
			transaction.show(contactFragment);
		} else if (id == R.id.btn_share) {     //分享
			if (shareFragment == null) {
				shareFragment = new ShareFragment();
				transaction.add(R.id.fragment_container, shareFragment);
			}
			transaction.show(shareFragment);
		} else if (id == R.id.btn_discover) {   //发现
			if (discoverFragment == null) {
				discoverFragment = new DiscoverFragment();
				transaction.add(R.id.fragment_container, discoverFragment);
			}
			transaction.show(discoverFragment);
		} else if (id == R.id.btn_my_space) {    //我
			if (mySpaceFragment == null) {
				mySpaceFragment = new MySpaceFragment();
				transaction.add(R.id.fragment_container, mySpaceFragment);
			}
			transaction.show(mySpaceFragment);
		}
		int pos;
		for (pos = 0; pos < FRAGMENT_N; pos++) {
			if (tabs[pos] == view) {
				break;
			}
		}
		transaction.commit();
		setTopDrawable(tabs[pos], tabsActiveBackIds[pos]);

	}

	private void setNormalBackgrounds() {
		for (int i = 0; i < tabs.length; i++) {
			Button v = tabs[i];
			setTopDrawable(v, tabsNormalBackIds[i]);
		}
	}

	private void setTopDrawable(Button v, int resId) {
		v.setCompoundDrawablesWithIntrinsicBounds(null, this.getResources()
				.getDrawable(resId), null, null);

	}

	private void hideFragments(FragmentTransaction transaction) {
		Fragment[] fragments = new Fragment[] { convFragment, contactFragment,shareFragment,
				discoverFragment, mySpaceFragment };
		for (Fragment f : fragments) {
			if (f != null) {
				transaction.hide(f);
			}
		}
	}

	public static void goMainActivity(MainActivity mainActivity) {
		Intent intent = new Intent(mainActivity, MainActivity.class);
		mainActivity.startActivity(intent);
	}

}
