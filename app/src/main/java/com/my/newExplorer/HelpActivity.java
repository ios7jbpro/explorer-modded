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
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import androidx.webkit.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class HelpActivity extends AppCompatActivity {
	
	private ScrollView vscroll3;
	private LinearLayout linear3;
	private LinearLayout linear1;
	private Button button1;
	private LinearLayout linear4;
	private ScrollView vscroll2;
	private TextView textview1;
	private ImageView imageview1;
	
	private Intent intent = new Intent();
	private SharedPreferences s;
	private SharedPreferences mode;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.help);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll3 = (ScrollView) findViewById(R.id.vscroll3);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		button1 = (Button) findViewById(R.id.button1);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		vscroll2 = (ScrollView) findViewById(R.id.vscroll2);
		textview1 = (TextView) findViewById(R.id.textview1);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		s = getSharedPreferences("s", Activity.MODE_PRIVATE);
		mode = getSharedPreferences("mode", Activity.MODE_PRIVATE);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("https://t.me/Explorer_browser"));
				startActivity(intent);
			}
		});
		
		textview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
	}
	
	private void initializeLogic() {
		if (s.getString("language", "").equals("english")) {
			textview1.setText("Tell us about your problems on Telegram Explorer so that the developer can fix them quickly");
			button1.setText("Telegram Explorer");
		}
		else {
			if (s.getString("language", "").equals("persian")) {
				textview1.setText("از مشکلات خود در تلگرام اکسپلورر برای ما بگویید تا توسعه دهنده بتواند به سرعت آنها را برطرف کند");
				button1.setText("تلگرام Explorer");
			}
			else {
				if (s.getString("language", "").equals("china")) {
					textview1.setText("告诉我们您在 中遇到的问题，以便开发人员可以快速解决它们");
					button1.setText("电报浏览器");
				}
				else {
					
				}
			}
		}
		if (mode.getString("darkmode", "").equals("true")) {
			button1.setTextColor(0xFFFFFFFF);
			textview1.setTextColor(0xFFFFFFFF);
			vscroll3.setBackgroundColor(0xFF212121);
			linear3.setBackgroundColor(0xFF212121);
			linear4.setBackgroundColor(0xFF212121);
			imageview1.setBackgroundColor(0xFF212121);
			_setBackground(button1, 20, 60, "#757575", true);
			_card_style(linear1, 25, 80, "#000000");
		}
		else {
			button1.setTextColor(0xFF000000);
			textview1.setTextColor(0xFF000000);
			vscroll3.setBackgroundColor(0xFFFFFFFF);
			linear3.setBackgroundColor(0xFFFFFFFF);
			linear4.setBackgroundColor(0xFFFFFFFF);
			imageview1.setBackgroundColor(0xFFFFFFFF);
			_setBackground(button1, 20, 60, "#FFFFFF", true);
			_card_style(linear1, 25, 80, "#FFFFFF");
		}
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
	
	
	public void _setBackground (final View _view, final double _radius, final double _shadow, final String _color, final boolean _ripple) {
		if (_ripple) {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			_view.setElevation((int)_shadow);
			android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor("#9e9e9e")});
			android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrb , gd, null);
			_view.setClickable(true);
			_view.setBackground(ripdrb);
		}
		else {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			_view.setBackground(gd);
			_view.setElevation((int)_shadow);
		}
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