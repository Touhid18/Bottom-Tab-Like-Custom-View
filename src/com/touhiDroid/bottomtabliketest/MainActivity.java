/**
 * 
 */
package com.touhiDroid.bottomtabliketest;

import java.util.ArrayList;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * @author Touhid
 * 
 */
public class MainActivity extends FragmentActivity implements OnClickListener, InterTabCommunicator {

	private final String TAG = this.getClass().getSimpleName();

	private Button btnOffer, btnReward, btnAddPost, btnMore;
	// private FrameLayout flFragHolder;
	private LinearLayout llBottomTabHoolder;

	private FragmentManager fragMang;
	private FragmentTransaction fragTranx;

	public static boolean isLoggedIn = false;

	private static ArrayList<Fragment> fList;

	@Override
	protected void onCreate(Bundle state) {
		super.onCreate(state);
		setContentView(R.layout.main);
		initTabButtons();
		isLoggedIn = false;
		fList = new ArrayList<>();
		fList.add(new SampleFragment(SampleFragment.FRAG_OFFER));
		fList.add(new SampleFragment(SampleFragment.FRAG_REWARD));
		fList.add(new SampleFragment(SampleFragment.FRAG_ADD_POST));
		fList.add(new SampleFragment(SampleFragment.FRAG_MORE, this));

		fragMang = getSupportFragmentManager();
		fragTranx = fragMang.beginTransaction();
		fragTranx.add(R.id.flFragmentHolder, fList.get(0));
		fragTranx.commit();
		setOfferTabPressed();

		// flFragHolder = (FrameLayout) findViewById(R.id.flFragmentHolder);

		btnOffer.setOnClickListener(this);
		btnReward.setOnClickListener(this);
		btnAddPost.setOnClickListener(this);
		btnMore.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		fragTranx = fragMang.beginTransaction();
		switch (v.getId()) {
		case R.id.btnOffer:
			Log.d(TAG, "Offer Clicked");
			fragTranx.replace(R.id.flFragmentHolder, fList.get(0));
			fragTranx.commit();
			setOfferTabPressed();
			break;
		case R.id.btnReward:
			Log.d(TAG, "Reward Clicked");
			fragTranx.replace(R.id.flFragmentHolder, fList.get(1));
			fragTranx.commit();
			setRewardTabPressed();
			break;
		case R.id.btnAddPost:
			Log.d(TAG, "Add Post Clicked");
			fragTranx.replace(R.id.flFragmentHolder, fList.get(2));
			fragTranx.commit();
			setAddPostTabPressed();
			break;
		case R.id.btnMore:
			Log.d(TAG, "More Clicked");
			fragTranx.replace(R.id.flFragmentHolder, fList.get(3));
			fragTranx.commit();
			setMoreTabPressed();
			break;

		default:
			break;
		}
	}

	public void setTabPressedState(int index) {
		if (index == SampleFragment.FRAG_OFFER)
			setOfferTabPressed();
		else if (index == SampleFragment.FRAG_REWARD)
			setRewardTabPressed();
		else if (index == SampleFragment.FRAG_ADD_POST)
			setAddPostTabPressed();
		else if (index == SampleFragment.FRAG_MORE)
			setMoreTabPressed();
	}

	private void setOfferTabPressed() {
		// initTabButtons();
		btnOffer.setTextColor(Color.BLUE);
		Drawable d = getResources().getDrawable(R.drawable.tab_1_p);
		if (d != null)
			btnOffer.setCompoundDrawablesWithIntrinsicBounds(null, d, null, null);

		d = getResources().getDrawable(R.drawable.tab_2);
		if (d != null)
			btnReward.setCompoundDrawablesWithIntrinsicBounds(null, d, null, null);
		d = getResources().getDrawable(getAddPostResId(false));
		if (d != null)
			btnAddPost.setCompoundDrawablesWithIntrinsicBounds(null, d, null, null);
		d = getResources().getDrawable(R.drawable.tab_4);
		if (d != null)
			btnMore.setCompoundDrawablesWithIntrinsicBounds(null, d, null, null);
		btnReward.setTextColor(Color.BLACK);
		btnAddPost.setTextColor(Color.BLACK);
		btnMore.setTextColor(Color.BLACK);
		llBottomTabHoolder.setBackgroundColor(Color.argb(220, 0, 255, 50));
	}

	private void setRewardTabPressed() {
		// initTabButtons();
		btnReward.setTextColor(Color.BLUE);
		Drawable d = getResources().getDrawable(R.drawable.tab_2_p);
		if (d != null)
			btnReward.setCompoundDrawablesWithIntrinsicBounds(null, d, null, null);

		d = getResources().getDrawable(R.drawable.tab_1);
		if (d != null)
			btnOffer.setCompoundDrawablesWithIntrinsicBounds(null, d, null, null);
		d = getResources().getDrawable(getAddPostResId(false));
		if (d != null)
			btnAddPost.setCompoundDrawablesWithIntrinsicBounds(null, d, null, null);
		d = getResources().getDrawable(R.drawable.tab_4);
		if (d != null)
			btnMore.setCompoundDrawablesWithIntrinsicBounds(null, d, null, null);
		btnOffer.setTextColor(Color.BLACK);
		btnAddPost.setTextColor(Color.BLACK);
		btnMore.setTextColor(Color.BLACK);
		llBottomTabHoolder.setBackgroundColor(Color.argb(220, 235, 20, 20));
	}

	private void setAddPostTabPressed() {
		// initTabButtons();
		btnAddPost.setTextColor(Color.BLUE);
		Drawable d = getResources().getDrawable(getAddPostResId(true));
		if (d != null)
			btnAddPost.setCompoundDrawablesWithIntrinsicBounds(null, d, null, null);

		d = getResources().getDrawable(R.drawable.tab_1);
		if (d != null)
			btnOffer.setCompoundDrawablesWithIntrinsicBounds(null, d, null, null);
		d = getResources().getDrawable(R.drawable.tab_2);
		if (d != null)
			btnReward.setCompoundDrawablesWithIntrinsicBounds(null, d, null, null);
		d = getResources().getDrawable(R.drawable.tab_4);
		if (d != null)
			btnMore.setCompoundDrawablesWithIntrinsicBounds(null, d, null, null);
		btnOffer.setTextColor(Color.BLACK);
		btnReward.setTextColor(Color.BLACK);
		btnMore.setTextColor(Color.BLACK);
		llBottomTabHoolder.setBackgroundColor(Color.argb(220, 25, 255, 25));
	}

	private void setMoreTabPressed() {
		// initTabButtons();
		btnMore.setTextColor(Color.BLUE);
		Drawable d = getResources().getDrawable(R.drawable.tab_4_p);
		if (d != null)
			btnMore.setCompoundDrawablesWithIntrinsicBounds(null, d, null, null);

		d = getResources().getDrawable(R.drawable.tab_1);
		if (d != null)
			btnOffer.setCompoundDrawablesWithIntrinsicBounds(null, d, null, null);
		d = getResources().getDrawable(R.drawable.tab_2);
		if (d != null)
			btnReward.setCompoundDrawablesWithIntrinsicBounds(null, d, null, null);
		d = getResources().getDrawable(getAddPostResId(false));
		if (d != null)
			btnAddPost.setCompoundDrawablesWithIntrinsicBounds(null, d, null, null);
		btnOffer.setTextColor(Color.BLACK);
		btnReward.setTextColor(Color.BLACK);
		btnAddPost.setTextColor(Color.BLACK);
		llBottomTabHoolder.setBackgroundColor(Color.argb(220, 0, 255, 255));
	}

	private void initTabButtons() {
		if (llBottomTabHoolder == null)
			llBottomTabHoolder = (LinearLayout) findViewById(R.id.llBottomTabHolder);
		if (btnOffer == null)
			btnOffer = (Button) findViewById(R.id.btnOffer);
		if (btnReward == null)
			btnReward = (Button) findViewById(R.id.btnReward);
		if (btnAddPost == null)
			btnAddPost = (Button) findViewById(R.id.btnAddPost);
		if (btnMore == null)
			btnMore = (Button) findViewById(R.id.btnMore);
	}

	private int getAddPostResId(boolean isPressed) {
		if (isLoggedIn && isPressed)
			return R.drawable.tab_post_1_p;
		if (isLoggedIn)
			return R.drawable.tab_post_1;
		if (!isLoggedIn && isPressed)
			return R.drawable.tab_3_p;
		return R.drawable.tab_3;
	}

	@Override
	public void listenLogInClick(boolean doLogIn) {
		if (doLogIn) {
			isLoggedIn = true;
			Toast.makeText(this, "Now assume that you're logged in!", Toast.LENGTH_LONG).show();
			Log.d(TAG, "Logging in & log in fragment calling as the reward tab...");
		} else {
			isLoggedIn = false;
			Toast.makeText(this, "Now assume that you're logged out!", Toast.LENGTH_LONG).show();
			Log.d(TAG, "Logged out & Reward tab...");
		}
		fragTranx = fragMang.beginTransaction();
		fragTranx.replace(R.id.flFragmentHolder, fList.get(1));
		fragTranx.commit();
		setRewardTabPressed();
	}

	// public void logInOrOut(boolean doLogIn) {
	// if (doLogIn) {
	// isLoggedIn = true;
	// Toast.makeText(this, "Now assume that you're logged in!",
	// Toast.LENGTH_LONG).show();
	// Log.d(TAG, "Logging in & log in fragment calling as the reward tab...");
	// } else {
	// isLoggedIn = false;
	// Toast.makeText(this, "Now assume that you're logged out!",
	// Toast.LENGTH_LONG).show();
	// Log.d(TAG, "Logged out & Reward tab...");
	// }
	// fragTranx = fragMang.beginTransaction();
	// fragTranx.replace(R.id.flFragmentHolder, fList.get(1));
	// fragTranx.commitAllowingStateLoss();
	// setRewardTabPressed();
	// }
}
