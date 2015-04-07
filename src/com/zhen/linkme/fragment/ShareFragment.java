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
 * ·ÖÏí
 *
 */
public class ShareFragment extends Fragment{
	
	private TextView mTextView_share;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.share_fragment, container, false);
		
		mTextView_share = (TextView) view.findViewById(R.id.centercontainer);
		
		mTextView_share.setText(R.string.share);
		
		return view;
	}

}
