package com.touhiDroid.bottomtabliketest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SampleFragment3 extends Fragment {

	private final String TAG = this.getClass().getSimpleName();

	public static final int FRAG_OFFER = 1;
	public static final int FRAG_REWARD = 2;
	public static final int FRAG_ADD_POST = 3;
	public static final int FRAG_MORE = 4;

	private int itemIndex;

	public SampleFragment3(int index) {
		itemIndex = index;
		Log.i(TAG, "Item index: " + itemIndex);
	}

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
		}
		return v;
	}
}
