package com.my.newExplorer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import de.hdodenhof.circleimageview.*;
import android.app.Activity;
import android.content.SharedPreferences;
import androidx.webkit.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class InfoActivity extends AppCompatActivity {
	
	private ScrollView vscroll1;
	private LinearLayout linear8;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private LinearLayout linear10;
	private LinearLayout linear13;
	private ImageView imageview1;
	private LinearLayout linear15;
	private TextView textview7;
	private TextView textandroidversion;
	private TextView textmodel;
	private TextView textview1;
	private TextView textview14;
	private TextView textview8;
	private CircleImageView circleimageview2;
	private LinearLayout linear12;
	private TextView amirali;
	private TextView textview11;
	private CircleImageView circleimageview3;
	private LinearLayout linear14;
	private TextView ios7jbpro;
	private TextView textview13;
	
	private SharedPreferences s;
	private SharedPreferences mode;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.info);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		textview7 = (TextView) findViewById(R.id.textview7);
		textandroidversion = (TextView) findViewById(R.id.textandroidversion);
		textmodel = (TextView) findViewById(R.id.textmodel);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview14 = (TextView) findViewById(R.id.textview14);
		textview8 = (TextView) findViewById(R.id.textview8);
		circleimageview2 = (CircleImageView) findViewById(R.id.circleimageview2);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		amirali = (TextView) findViewById(R.id.amirali);
		textview11 = (TextView) findViewById(R.id.textview11);
		circleimageview3 = (CircleImageView) findViewById(R.id.circleimageview3);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		ios7jbpro = (TextView) findViewById(R.id.ios7jbpro);
		textview13 = (TextView) findViewById(R.id.textview13);
		s = getSharedPreferences("s", Activity.MODE_PRIVATE);
		mode = getSharedPreferences("mode", Activity.MODE_PRIVATE);
	}
	
	private void initializeLogic() {
		View a = getWindow().getDecorView();
		a.setSystemUiVisibility(0);
		if (mode.getString("darkmode", "").equals("true")) {
			vscroll1.setBackgroundColor(0xFF212121);
			linear8.setBackgroundColor(0xFF212121);
			_card_style(linear10, 10, 15, "#000000");
			_card_style(linear13, 10, 15, "#000000");
			amirali.setTextColor(0xFFFFFFFF);
			ios7jbpro.setTextColor(0xFFFFFFFF);
			textview11.setTextColor(0xFFFFFFFF);
			textview13.setTextColor(0xFFFFFFFF);
			textview7.setTextColor(0xFFFFFFFF);
			textview8.setTextColor(0xFFFFFFFF);
			if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
				Window w =InfoActivity.this.getWindow();
				w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
				w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFF000000);
			}
		}
		else {
			vscroll1.setBackgroundColor(0xFFFFFFFF);
			linear8.setBackgroundColor(0xFFFFFFFF);
			_card_style(linear10, 10, 15, "#FFFFFF");
			_card_style(linear13, 10, 15, "#FFFFFF");
			amirali.setTextColor(0xFF000000);
			ios7jbpro.setTextColor(0xFF000000);
			textview11.setTextColor(0xFF000000);
			textview13.setTextColor(0xFF000000);
			textview8.setTextColor(0xFF000000);
			textview7.setTextColor(0xFF000000);
			getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
			getWindow().setStatusBarColor(0xFFFFFFFF);
			if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
				Window w =InfoActivity.this.getWindow();
				w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
				w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFFFFFFFF);
			}
		}
		if (s.getString("language", "").equals("persian")) {
			textview8.setText("توسعه دهندگان");
		}
		else {
			if (s.getString("language", "").equals("english")) {
				textview8.setText("Developers");
			}
			else {
				if (s.getString("language", "").equals("china")) {
					textview8.setText("开发商");
				}
				else {
					
				}
			}
		}
		textandroidversion.setText("Android ".concat(Build.VERSION.RELEASE));
		textmodel.setText(Build.MANUFACTURER.concat(" ".concat(Build.MODEL)));
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _card_style (final View _view, final double _shadow, final double _rounds, final String _colour) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_colour));
		gd.setCornerRadius((int)_rounds);
		_view.setBackground(gd);
		_view.setElevation((int)_shadow);
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}