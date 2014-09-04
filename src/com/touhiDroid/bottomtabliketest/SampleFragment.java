package com.touhiDroid.bottomtabliketest;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class SampleFragment extends Fragment {

	private final String TAG = this.getClass().getSimpleName();

	public static final int FRAG_OFFER = 1;
	public static final int FRAG_REWARD = 2;
	public static final int FRAG_ADD_POST = 3;
	public static final int FRAG_MORE = 4;

	private int itemIndex;
	private InterTabCommunicator iTabcom;
	private Button b;

	public SampleFragment(int index) {
		itemIndex = index;
		Log.i(TAG, "Item index: " + itemIndex);
		this.iTabcom = null;
	}

	public SampleFragment(int index, InterTabCommunicator iTabCom) {
		itemIndex = index;
		Log.i(TAG, "Item index: " + itemIndex);
		this.iTabcom = iTabCom;
	}

	@SuppressLint("NewApi")
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.frag_sample, container, false);
		Log.d(TAG, "inside onCreateView");

		if (itemIndex == FRAG_OFFER) {
			Log.d(TAG, "Offer");
			v.setBackgroundColor(Color.CYAN);
		} else if (itemIndex == FRAG_REWARD) {
			Log.d(TAG, "Reward");
			v.setBackgroundColor(Color.RED);
		} else if (itemIndex == FRAG_ADD_POST) {
			Log.d(TAG, "Add post");
			v.setBackgroundColor(Color.GREEN);
		} else if (itemIndex == FRAG_MORE) {
			Log.d(TAG, "more");
			v.setBackgroundColor(Color.YELLOW);
			b = (Button) v.findViewById(R.id.btnLogIn);
			b.setVisibility(View.VISIBLE);
			if (MainActivity.isLoggedIn)
				b.setText("Log Out");
			else
				b.setText("Log In");
			b.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					if (b.getText().toString().equals("Log In")) {
						iTabcom.listenLogInClick(true);
						// MainActivity m = (MainActivity) getActivity();
						// m.logInOrOut(true);
						b.setText("Log Out");
					} else {
						iTabcom.listenLogInClick(false);
						// MainActivity m = (MainActivity) getActivity();
						// m.logInOrOut(false);
						b.setText("Log In");
					}
				}
			});
		}
		return v;
	}
}
