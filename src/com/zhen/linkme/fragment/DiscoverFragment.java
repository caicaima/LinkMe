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
 * ����
 *
 */
public class DiscoverFragment extends Fragment{
	
	private TextView mTextView_discover;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.discover_fragment, container, false);
		
		mTextView_discover = (TextView) view.findViewById(R.id.centercontainer);
		mTextView_discover.setText(R.string.discover);
		
		
		return view;
	}

}
