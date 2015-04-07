package com.zhen.linkme.fragment;

import com.zhen.linkme.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 
 * @author Administrator
 * 
 * ͨѶ¼
 *
 */
public class ContactFragment extends Fragment{
	
	private TextView mTextView_contact;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.contact_fragment, container, false);
		
		mTextView_contact = (TextView) view.findViewById(R.id.centercontainer);
		mTextView_contact.setText(R.string.contact);
		
		return view;
	}

}
