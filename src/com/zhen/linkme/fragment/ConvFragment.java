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
 * »á»°
 *
 */
public class ConvFragment extends Fragment{
	
	private TextView mTextView_message;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.conv_fragment, container, false);
		
		mTextView_message = (TextView) view.findViewById(R.id.centercontainer);
		mTextView_message.setText(R.string.messages);
		
		return view;
	}

}
