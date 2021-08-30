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
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.webkit.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class HtmlActivity extends AppCompatActivity {
	
	private FloatingActionButton _fab;
	private String save_html = "";
	private String hint = "";
	private String Save = "";
	private String Cancel = "";
	private String toast = "";
	
	private LinearLayout linear1;
	private ScrollView vscroll1;
	private LinearLayout linear2;
	private TextView textview1;
	
	private RequestNetwork WIFI;
	private RequestNetwork.RequestListener _WIFI_request_listener;
	private SharedPreferences html;
	private SharedPreferences mode;
	private AlertDialog.Builder dialog;
	private Intent i = new Intent();
	private SharedPreferences s;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.html);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		}
		else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_fab = (FloatingActionButton) findViewById(R.id._fab);
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		textview1 = (TextView) findViewById(R.id.textview1);
		WIFI = new RequestNetwork(this);
		html = getSharedPreferences("html", Activity.MODE_PRIVATE);
		mode = getSharedPreferences("mode", Activity.MODE_PRIVATE);
		dialog = new AlertDialog.Builder(this);
		s = getSharedPreferences("s", Activity.MODE_PRIVATE);
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dialog.setTitle(save_html);
				LinearLayout mylayout = new LinearLayout(HtmlActivity.this);
				
				LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
				
				mylayout.setLayoutParams(params); mylayout.setOrientation(LinearLayout.VERTICAL);
				
				final EditText myedittext = new EditText(HtmlActivity.this);
				myedittext.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT, android.widget.LinearLayout.LayoutParams.WRAP_CONTENT));
				 
				mylayout.addView(myedittext);
				dialog.setView(mylayout);
				myedittext.setHint(hint);
				myedittext.setHintTextColor(0xFF9E9E9E);
				if (mode.getString("darkmode", "").equals("true")) {
					myedittext.setTextColor(0xFFFFFFFF);
				}
				else {
					myedittext.setTextColor(0xFF000000);
				}
				dialog.setPositiveButton(Save, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						FileUtil.writeFile(FileUtil.getExternalStorageDir().concat("/webview download/Extracted HTML/".concat(myedittext.getText().toString().concat(".html"))), textview1.getText().toString());
						SketchwareUtil.showMessage(getApplicationContext(), toast);
					}
				});
				dialog.setNegativeButton(Cancel, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				dialog.create().show();
			}
		});
		
		_WIFI_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				textview1.setText(_response);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				textview1.setText(_message);
			}
		};
	}
	
	private void initializeLogic() {
		_SpanText("#42A5F5", "#F1BE49", "#26A69A", "#FF1744", "#9E9E9E", textview1);
		if (FileUtil.isExistFile(FileUtil.getExternalStorageDir().concat("/webview download/Extracted HTML"))) {
			
		}
		else {
			FileUtil.makeDir(FileUtil.getExternalStorageDir().concat("/webview download/Extracted HTML"));
		}
		_dark();
		_language();
		if (!html.getString("html_view", "").equals("")) {
			WIFI.startRequestNetwork(RequestNetworkController.GET, html.getString("html_view", ""), "WIFI", _WIFI_request_listener);
		}
		else {
			
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
		i.setClass(getApplicationContext(), MainActivity.class);
		startActivity(i);
	}
	public void _SpanText (final String _spanpcolor, final String _spanscolor, final String _spanncolor, final String _spanqcolor, final String _spanccolor, final TextView _spanableview) {
		final TextView tags = new TextView(this);
		final TextView attribute = new TextView(this);
		final TextView attValue = new TextView(this);
		final TextView regex4 = new TextView(this);
		final TextView regex5 = new TextView(this);
		final TextView regex6 = new TextView(this);
		final TextView regex7 = new TextView(this);
		final TextView regex8 = new TextView(this);
		final TextView regex9 = new TextView(this);
		final TextView regex10 = new TextView(this);
		tags.setText("<([^  >]+[#\\w a-z >#])");
		attribute.setText("\\{(.|\\n)*?\\}");
		attValue.setText("\\:(.|\\n)*?\\;");
		regex4.setText("(<|>|/>|\\{|\\})");
		regex5.setText("val|int|bool|listval|listnum|return|short|static|strictfp|super|switch|synchronized|this|throw|throws|transient|try|void|volatile|while|true|false|import|null)");
		regex6.setText("([0-9]+)|public|private");
		regex7.setText("(\\w+)(\\()+|class");
		regex8.setText("\\@\\s*(\\w+)");
		regex9.setText("\"(.*?)\"|'(.*?)'|field|extract|val|int|bool|listval|listnum|return|short|static|strictfp|super|switch|synchronized|this|throw|throws|transient|try|void|volatile|while|true|false|import|null");
		regex10.setText("<!--.*?(?=(-->)|$)-->|$");
		
		final String tag = "#FF4F00";
		final String attri = "#4169E1";
		final String atval = "#007FFF";
		final String symbol = "#007FFF";
		final String fun = "#18A8A6";
		final String com = "#49308B";
		final String num = "#DE3163";
		final String special = "#03C03C";
		final String ex = "#177245";
		final String secex = "#6940C2";
		_spanableview.addTextChangedListener(new TextWatcher() {
			ColorScheme keywords1 = new ColorScheme(java.util.regex.Pattern.compile(tags.getText().toString()), Color.parseColor(tag));
			ColorScheme keywords2 = new ColorScheme(java.util.regex.Pattern.compile(attribute.getText().toString()), Color.parseColor(attri));
			ColorScheme keywords3 = new ColorScheme(java.util.regex.Pattern.compile(regex6.getText().toString()), Color.parseColor(atval));
			ColorScheme keywords4 = new ColorScheme(java.util.regex.Pattern.compile(regex7.getText().toString()), Color.parseColor(symbol));
			ColorScheme keywords5 = new ColorScheme(java.util.regex.Pattern.compile(regex9.getText().toString()), Color.parseColor(fun));
			ColorScheme keywords6 = new ColorScheme(java.util.regex.Pattern.compile(regex10.getText().toString()), Color.parseColor(com));
			ColorScheme keywords7 = new ColorScheme(java.util.regex.Pattern.compile(regex8.getText().toString()), Color.parseColor(num));
			ColorScheme keywords8 = new ColorScheme(java.util.regex.Pattern.compile(attValue.getText().toString()), Color.parseColor(special));
			
			ColorScheme keywords9 = new ColorScheme(java.util.regex.Pattern.compile(regex4.getText().toString()), Color.parseColor(secex));
			final ColorScheme[] schemes = {keywords7, keywords6, keywords3, keywords4, keywords5, keywords2,keywords1,keywords8,keywords9};
			 @Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			}
			@Override
			public void afterTextChanged(Editable s) {
				_spanableview.post(new Runnable() {
					@Override
					public void run() {
					}});
				removeSpans(s, android.text.style.ForegroundColorSpan.class);
				for(ColorScheme scheme : schemes) {
					for(java.util.regex.Matcher m = scheme.pattern.matcher(s);
					m.find();
					) {
						if (scheme == keywords4) {
							s.setSpan(new android.text.style.ForegroundColorSpan(scheme.color), m.start(), m.end()-1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
						} else {
							s.setSpan(new android.text.style.ForegroundColorSpan(scheme.color), m.start(), m.end(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
						}}}}
			void removeSpans(Editable e, Class<? extends android.text.style.CharacterStyle> type) {
				android.text.style.CharacterStyle[] spans = e.getSpans(0, e.length(), type);
				for (android.text.style.CharacterStyle span : spans) {
					e.removeSpan(span);
				}
			}
			class ColorScheme {
				final java.util.regex.Pattern pattern;
				final int color;
				ColorScheme(java.util.regex.Pattern pattern, int color) {
					this.pattern = pattern;
					this.color = color;
				}
			}
		});
	}
	
	
	public void _dark () {
		if (mode.getString("darkmode", "").equals("true")) {
			textview1.setTextColor(0xFFFFFFFF);
			dialog = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
			linear1.setBackgroundColor(0xFF212121);
			linear2.setBackgroundColor(0xFF212121);
			vscroll1.setBackgroundColor(0xFF212121);
		}
		else {
			textview1.setTextColor(0xFF000000);
			linear1.setBackgroundColor(0xFFFFFFFF);
			linear2.setBackgroundColor(0xFFFFFFFF);
			vscroll1.setBackgroundColor(0xFFFFFFFF);
			dialog = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
		}
	}
	
	
	public void _language () {
		if (s.getString("language", "").equals("english")) {
			save_html = "Save The Code";
			hint = "File Name";
			Save = "Save";
			Cancel = "Cancel";
			toast = "File Saved";
		}
		else {
			if (s.getString("language", "").equals("persian")) {
				save_html = "ذخیره کد";
				hint = "نام فایل";
				Save = "ذخیره";
				Cancel = "لغو";
				toast = "فایل ذخیره شد";
			}
			else {
				if (s.getString("language", "").equals("china")) {
					save_html = "保存代码";
					hint = "文件名";
					Save = "保存";
					Cancel = "取消";
					toast = "文件已保存";
				}
				else {
					save_html = "Save The Code";
					hint = "File Name";
					Save = "Save";
					Cancel = "Cancel";
					toast = "File Saved";
				}
			}
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