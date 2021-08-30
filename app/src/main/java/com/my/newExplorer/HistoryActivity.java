package com.my.newExplorer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.app.Activity;
import android.content.SharedPreferences;
import java.util.Timer;
import java.util.TimerTask;
import android.view.View;
import android.content.ClipData;
import android.content.ClipboardManager;
import androidx.webkit.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class HistoryActivity extends AppCompatActivity {
	private Timer _timer = new Timer();
	
	private FloatingActionButton _fab;
	
	private LinearLayout linear1;
	private ScrollView vscroll1;
	private TextView textview1;
	private TextView textview2;
	private LinearLayout linear2;
	private TextView textview3;
	
	private SharedPreferences history;
	private TimerTask reload;
	private SharedPreferences mode;
	private SharedPreferences s;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.history);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_fab = (FloatingActionButton) findViewById(R.id._fab);
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		textview3 = (TextView) findViewById(R.id.textview3);
		history = getSharedPreferences("history", Activity.MODE_PRIVATE);
		mode = getSharedPreferences("mode", Activity.MODE_PRIVATE);
		s = getSharedPreferences("s", Activity.MODE_PRIVATE);
		
		textview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				history.edit().putString("history", "").commit();
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", textview3.getText().toString()));
			}
		});
	}
	
	private void initializeLogic() {
		reload = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						textview3.setText(history.getString("history", ""));
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(reload, (int)(0), (int)(90));
		if (mode.getString("darkmode", "").equals("true")) {
			linear1.setBackgroundColor(0xFF212121);
			linear2.setBackgroundColor(0xFF212121);
			vscroll1.setBackgroundColor(0xFF212121);
			textview1.setTextColor(0xFFFFFFFF);
			textview2.setTextColor(0xFFFFFFFF);
			textview3.setTextColor(0xFFFFFFFF);
		}
		else {
			linear1.setBackgroundColor(0xFFFFFFFF);
			linear2.setBackgroundColor(0xFFFFFFFF);
			vscroll1.setBackgroundColor(0xFFFFFFFF);
			textview1.setTextColor(0xFF000000);
			textview2.setTextColor(0xFF000000);
			textview3.setTextColor(0xFF000000);
		}
		if (s.getString("language", "").equals("persian")) {
			textview1.setText("تاریخچه");
			textview2.setText("پاک کردن تاریخچه");
		}
		else {
			if (s.getString("language", "").equals("english")) {
				textview1.setText("History");
				textview2.setText("Clear History");
			}
			else {
				if (s.getString("language", "").equals("china")) {
					textview1.setText("历史 ");
					textview2.setText("清除历史记录 ");
				}
				else {
					
				}
			}
		}
		_fab.setSize(FloatingActionButton.SIZE_AUTO);
		final ObjectAnimator animator = ObjectAnimator.ofInt(_fab, "backgroundTint", Color.rgb(122, 214, 255), Color.rgb(33, 148, 243));
		animator.setDuration(2000L);
		animator.setEvaluator(new ArgbEvaluator());
		animator.setInterpolator(new DecelerateInterpolator(2));
		animator.addUpdateListener(new ObjectAnimator.AnimatorUpdateListener() {
			    @Override
			    public void onAnimationUpdate(ValueAnimator animation) {
				        int animatedValue = (int) animation.getAnimatedValue();
				        _fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(animatedValue));
				    }
		});
		animator.start();
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		finish();
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