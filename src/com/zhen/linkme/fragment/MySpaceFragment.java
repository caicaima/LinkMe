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
 * Œ“
 *
 */
public class MySpaceFragment extends Fragment{
	
	private TextView mTextView_mime;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.my_space_fragment, container, false);
		
		mTextView_mime = (TextView) view.findViewById(R.id.centercontainer);
		
		mTextView_mime.setText(R.string.me);
		
		return view;
	}

}
