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
import java.util.ArrayList;
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.HorizontalScrollView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.Intent;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.util.Timer;
import java.util.TimerTask;
import android.view.View;
import android.widget.CompoundButton;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AdapterView;
import androidx.webkit.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class SettingsActivity extends AppCompatActivity {
	private Timer _timer = new Timer();
	
	private String tex = "";
	private String add = "";
	private String urlsearch = "";
	private String ok = "";
	private String cancel = "";
	private String toast = "";
	private String error = "";
	
	private ArrayList<String> menu_size = new ArrayList<>();
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear11;
	private LinearLayout linear2;
	private LinearLayout linear12;
	private HorizontalScrollView hscroll1;
	private LinearLayout linear20;
	private LinearLayout linear21;
	private Button button12;
	private TextView textview1;
	private LinearLayout linear9;
	private LinearLayout linear5;
	private LinearLayout linear10;
	private LinearLayout linear3;
	private LinearLayout linear13;
	private LinearLayout linear14;
	private LinearLayout linear22;
	private LinearLayout linear15;
	private ImageView imageview6;
	private ImageView imageview7;
	private Button button11;
	private ImageView imageview4;
	private ImageView imageview9;
	private Button button2;
	private LinearLayout linear16;
	private LinearLayout linear19;
	private TextView textview5;
	private EditText edittext1;
	private TextView textview11;
	private Switch switch5;
	private LinearLayout linear17;
	private TextView notSupport_text1;
	private LinearLayout linear18;
	private TextView textview9;
	private TextView textview2;
	private Switch switch1;
	private TextView textview10;
	private Switch switch4;
	private TextView textview6;
	private Switch switch2;
	private TextView textview7;
	private Switch switch3;
	private TextView textview14;
	private Button button16;
	private TextView textview8;
	private Spinner spinner1;
	private TextView textview3;
	private LinearLayout linear8;
	private Button button5;
	private Button button6;
	private Button button7;
	private Button button9;
	private Button button10;
	private Button button8;
	private Button button13;
	private Button button14;
	private ImageView imageviewadd;
	private TextView textview12;
	private TextView textview13;
	private Button button15;
	
	private SharedPreferences s;
	private SharedPreferences mode;
	private Intent Next = new Intent();
	private SharedPreferences shared;
	private Intent check = new Intent();
	private Intent home = new Intent();
	private SharedPreferences homepage;
	private SharedPreferences cookies;
	private SharedPreferences run;
	private SharedPreferences size;
	private AlertDialog.Builder dialog;
	private SharedPreferences restore;
	private SharedPreferences flowe;
	private Intent i = new Intent();
	private Intent d = new Intent();
	private TimerTask timer;
	private Intent er = new Intent();
	private Intent c = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.settings);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		hscroll1 = (HorizontalScrollView) findViewById(R.id.hscroll1);
		linear20 = (LinearLayout) findViewById(R.id.linear20);
		linear21 = (LinearLayout) findViewById(R.id.linear21);
		button12 = (Button) findViewById(R.id.button12);
		textview1 = (TextView) findViewById(R.id.textview1);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		linear22 = (LinearLayout) findViewById(R.id.linear22);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		imageview6 = (ImageView) findViewById(R.id.imageview6);
		imageview7 = (ImageView) findViewById(R.id.imageview7);
		button11 = (Button) findViewById(R.id.button11);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		imageview9 = (ImageView) findViewById(R.id.imageview9);
		button2 = (Button) findViewById(R.id.button2);
		linear16 = (LinearLayout) findViewById(R.id.linear16);
		linear19 = (LinearLayout) findViewById(R.id.linear19);
		textview5 = (TextView) findViewById(R.id.textview5);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		textview11 = (TextView) findViewById(R.id.textview11);
		switch5 = (Switch) findViewById(R.id.switch5);
		linear17 = (LinearLayout) findViewById(R.id.linear17);
		notSupport_text1 = (TextView) findViewById(R.id.notSupport_text1);
		linear18 = (LinearLayout) findViewById(R.id.linear18);
		textview9 = (TextView) findViewById(R.id.textview9);
		textview2 = (TextView) findViewById(R.id.textview2);
		switch1 = (Switch) findViewById(R.id.switch1);
		textview10 = (TextView) findViewById(R.id.textview10);
		switch4 = (Switch) findViewById(R.id.switch4);
		textview6 = (TextView) findViewById(R.id.textview6);
		switch2 = (Switch) findViewById(R.id.switch2);
		textview7 = (TextView) findViewById(R.id.textview7);
		switch3 = (Switch) findViewById(R.id.switch3);
		textview14 = (TextView) findViewById(R.id.textview14);
		button16 = (Button) findViewById(R.id.button16);
		textview8 = (TextView) findViewById(R.id.textview8);
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		textview3 = (TextView) findViewById(R.id.textview3);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		button5 = (Button) findViewById(R.id.button5);
		button6 = (Button) findViewById(R.id.button6);
		button7 = (Button) findViewById(R.id.button7);
		button9 = (Button) findViewById(R.id.button9);
		button10 = (Button) findViewById(R.id.button10);
		button8 = (Button) findViewById(R.id.button8);
		button13 = (Button) findViewById(R.id.button13);
		button14 = (Button) findViewById(R.id.button14);
		imageviewadd = (ImageView) findViewById(R.id.imageviewadd);
		textview12 = (TextView) findViewById(R.id.textview12);
		textview13 = (TextView) findViewById(R.id.textview13);
		button15 = (Button) findViewById(R.id.button15);
		s = getSharedPreferences("s", Activity.MODE_PRIVATE);
		mode = getSharedPreferences("mode", Activity.MODE_PRIVATE);
		shared = getSharedPreferences("shared", Activity.MODE_PRIVATE);
		homepage = getSharedPreferences("homepage", Activity.MODE_PRIVATE);
		cookies = getSharedPreferences("cookies", Activity.MODE_PRIVATE);
		run = getSharedPreferences("run", Activity.MODE_PRIVATE);
		size = getSharedPreferences("size", Activity.MODE_PRIVATE);
		dialog = new AlertDialog.Builder(this);
		restore = getSharedPreferences("restore", Activity.MODE_PRIVATE);
		flowe = getSharedPreferences("flowe", Activity.MODE_PRIVATE);
		
		button12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), MainActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		button11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				check.setAction(Intent.ACTION_VIEW);
				check.setData(Uri.parse("https://t.me/Explorer_browser"));
				startActivity(check);
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Next.setClass(getApplicationContext(), InfoActivity.class);
				startActivity(Next);
			}
		});
		
		edittext1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (edittext1.getText().toString().equals("")) {
					homepage.edit().putString("homepage", edittext1.getText().toString()).commit();
				}
				else {
					if (Patterns.WEB_URL.matcher(edittext1.getText().toString()).matches())
					{
						homepage.edit().putString("homepage", edittext1.getText().toString()).commit();
					}
					else
					{
						((EditText)edittext1).setError(error);
						homepage.edit().putString("homepage", "").commit();
					}
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		switch5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					mode.edit().putString("ytplayer", "1").commit();
				}
				else {
					mode.edit().putString("ytplayer", "0").commit();
				}
			}
		});
		
		switch1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					textview1.setTextColor(0xFFFFFFFF);
					textview3.setTextColor(0xFFFFFFFF);
					textview2.setTextColor(0xFFFFFFFF);
					textview6.setTextColor(0xFFFFFFFF);
					textview7.setTextColor(0xFFFFFFFF);
					textview8.setTextColor(0xFFFFFFFF);
					imageview4.setVisibility(View.GONE);
					
					imageview6.setVisibility(View.GONE);
					imageview7.setVisibility(View.VISIBLE);
					imageview9.setVisibility(View.VISIBLE);
					
					linear1.setBackgroundColor(0xFF212121);
					vscroll1.setBackgroundColor(0xFF212121);
					textview5.setTextColor(0xFFFFFFFF);
					edittext1.setTextColor(0xFFFFFFFF);
					_card_style(linear2, 10, 60, "#000000");
					_card_style(hscroll1, 10, 60, "#000000");
					spinner1.setBackgroundResource(R.drawable.ic_arrow_drop_down_white);
					imageviewadd.setImageResource(R.drawable.ic_add_circle_white);
					textview11.setTextColor(0xFFFFFFFF);
					textview10.setTextColor(0xFFFFFFFF);
					edittext1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)60, 0xFF424242));
					
					mode.edit().putString("darkmode", "true").commit();
				}
				else {
					textview1.setTextColor(0xFF000000);
					textview3.setTextColor(0xFF000000);
					textview2.setTextColor(0xFF000000);
					textview6.setTextColor(0xFF000000);
					textview7.setTextColor(0xFF000000);
					textview8.setTextColor(0xFF000000);
					imageview4.setVisibility(View.VISIBLE);
					
					imageview6.setVisibility(View.VISIBLE);
					imageview7.setVisibility(View.GONE);
					
					imageview9.setVisibility(View.GONE);
					spinner1.setBackgroundResource(R.drawable.ic_arrow_drop_down_black);
					linear1.setBackgroundColor(0xFFFFFFFF);
					vscroll1.setBackgroundColor(0xFFFFFFFF);
					textview5.setTextColor(0xFF000000);
					edittext1.setTextColor(0xFF000000);
					_card_style(linear2, 10, 60, "#FFFFFF");
					_card_style(hscroll1, 10, 60, "#FFFFFF");
					imageviewadd.setImageResource(R.drawable.ic_add_circle_black);
					textview11.setTextColor(0xFF000000);
					textview10.setTextColor(0xFF000000);
					edittext1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)60, 0xFFEEEEEE));
					
					mode.edit().putString("darkmode", "false").commit();
				}
			}
		});
		
		switch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					flowe.edit().putString("flagfollowsystem", "1").commit();
				}
				else {
					flowe.edit().putString("flagfollowsystem", "0").commit();
				}
			}
		});
		
		switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					cookies.edit().putString("cookies", "true").commit();
				}
				else {
					cookies.edit().putString("cookies", "false").commit();
				}
			}
		});
		
		switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					run.edit().putString("runhtml", "on").commit();
				}
				else {
					run.edit().putString("runhtml", "off").commit();
				}
			}
		});
		
		button16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				c.setAction(Intent.ACTION_VIEW);
				c.setClass(getApplicationContext(), ExcleanerActivity.class);
				startActivity(c);
			}
		});
		
		spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (_position == 0) {
					
				}
				if (_position == 1) {
					size.edit().putString("size", "50").commit();
				}
				if (_position == 2) {
					size.edit().putString("size", "60").commit();
				}
				if (_position == 3) {
					size.edit().putString("size", "70").commit();
				}
				if (_position == 4) {
					size.edit().putString("size", "80").commit();
				}
				if (_position == 5) {
					size.edit().putString("size", "90").commit();
				}
				if (_position == 6) {
					size.edit().putString("size", "100").commit();
				}
				if (_position == 7) {
					size.edit().putString("size", "default").commit();
				}
				if (_position == 8) {
					size.edit().putString("size", "110").commit();
				}
				if (_position == 9) {
					size.edit().putString("size", "120").commit();
				}
				if (_position == 10) {
					size.edit().putString("size", "130").commit();
				}
				if (_position == 11) {
					size.edit().putString("size", "140").commit();
				}
				if (_position == 12) {
					size.edit().putString("size", "150").commit();
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				shared.edit().putString("search engine", "https://www.google.com/search?q=").commit();
			}
		});
		
		button6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				shared.edit().putString("search engine", "https://www.bing.com/search?q=").commit();
			}
		});
		
		button7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				shared.edit().putString("search engine", "https://duckduckgo.com/?q=").commit();
			}
		});
		
		button9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				shared.edit().putString("search engine", "https://search.yahoo.com/search?q=").commit();
			}
		});
		
		button10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				shared.edit().putString("search engine", "https://www.qwant.com/?q=").commit();
			}
		});
		
		button8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				shared.edit().putString("search engine", "https://www.ask.com/web?q=").commit();
			}
		});
		
		button13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				shared.edit().putString("search engine", "https://m.youtube.com/results?sp=mAEA&search_query=").commit();
			}
		});
		
		button14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				shared.edit().putString("search engine", "https://translate.google.com/?source=osdd&sl=auto&tl=auto&text=").commit();
			}
		});
		
		imageviewadd.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dialog.setTitle(add);
				LinearLayout mylayout = new LinearLayout(SettingsActivity.this);
				
				LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
				
				mylayout.setLayoutParams(params); mylayout.setOrientation(LinearLayout.VERTICAL);
				
				final EditText myedittext = new EditText(SettingsActivity.this);
				myedittext.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT, android.widget.LinearLayout.LayoutParams.WRAP_CONTENT));
				 
				mylayout.addView(myedittext);
				dialog.setView(mylayout);
				myedittext.setHint(urlsearch);
				myedittext.setHintTextColor(0xFF9E9E9E);
				if (mode.getString("darkmode", "").equals("true")) {
					myedittext.setTextColor(0xFFFFFFFF);
				}
				else {
					myedittext.setTextColor(0xFF000000);
				}
				if (!restore.getString("restore", "").equals("")) {
					myedittext.setText(restore.getString("restore", ""));
				}
				else {
					myedittext.setText("");
				}
				dialog.setPositiveButton(ok, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						if (Patterns.WEB_URL.matcher(myedittext.getText().toString()).matches())
						{
							shared.edit().putString("search engine", myedittext.getText().toString()).commit();
							restore.edit().putString("restore", myedittext.getText().toString()).commit();
						}
						else
						{
							SketchwareUtil.showMessage(getApplicationContext(), error);
							shared.edit().putString("search engine", shared.getString("search engine", "")).commit();
							restore.edit().putString("restore", "").commit();
						}
					}
				});
				dialog.setNegativeButton(cancel, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						shared.edit().putString("search engine", shared.getString("search engine", "")).commit();
						restore.edit().putString("restore", "").commit();
					}
				});
				dialog.create().show();
			}
		});
		
		button15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				er.setClass(getApplicationContext(), ErrorsActivity.class);
				startActivity(er);
			}
		});
	}
	
	private void initializeLogic() {
		_removeScollBar(hscroll1);
		_circleRipple("#9E9E9E", imageviewadd);
		imageview7.setVisibility(View.GONE);
		imageview9.setVisibility(View.GONE);
		if (mode.getString("darkmode", "").equals("true")) {
			textview1.setTextColor(0xFFFFFFFF);
			textview3.setTextColor(0xFFFFFFFF);
			textview2.setTextColor(0xFFFFFFFF);
			textview6.setTextColor(0xFFFFFFFF);
			textview7.setTextColor(0xFFFFFFFF);
			textview8.setTextColor(0xFFFFFFFF);
			imageview4.setVisibility(View.GONE);
			imageview6.setVisibility(View.GONE);
			imageview7.setVisibility(View.VISIBLE);
			imageview9.setVisibility(View.VISIBLE);
			linear1.setBackgroundColor(0xFF212121);
			vscroll1.setBackgroundColor(0xFF212121);
			textview5.setTextColor(0xFFFFFFFF);
			edittext1.setTextColor(0xFFFFFFFF);
			spinner1.setBackgroundResource(R.drawable.ic_arrow_drop_down_white);
			imageviewadd.setImageResource(R.drawable.ic_add_circle_white);
			textview11.setTextColor(0xFFFFFFFF);
			textview10.setTextColor(0xFFFFFFFF);
			edittext1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)60, 0xFF424242));
			_card_style(linear2, 10, 60, "#000000");
			_card_style(hscroll1, 10, 60, "#000000");
			_card_style(linear21, 10, 60, "#000000");
			textview12.setTextColor(0xFFFFFFFF);
			textview13.setTextColor(0xFFFFFFFF);
			button15.setBackgroundColor(0xFF000000);
			textview14.setTextColor(0xFFFFFFFF);
			button16.setBackgroundColor(0xFF000000);
		}
		else {
			textview1.setTextColor(0xFF000000);
			textview3.setTextColor(0xFF000000);
			textview2.setTextColor(0xFF000000);
			textview6.setTextColor(0xFF000000);
			textview7.setTextColor(0xFF000000);
			textview8.setTextColor(0xFF000000);
			imageview4.setVisibility(View.VISIBLE);
			imageview6.setVisibility(View.VISIBLE);
			imageview7.setVisibility(View.GONE);
			imageview9.setVisibility(View.GONE);
			spinner1.setBackgroundResource(R.drawable.ic_arrow_drop_down_black);
			linear1.setBackgroundColor(0xFFFFFFFF);
			vscroll1.setBackgroundColor(0xFFFFFFFF);
			textview5.setTextColor(0xFF000000);
			edittext1.setTextColor(0xFF000000);
			imageviewadd.setImageResource(R.drawable.ic_add_circle_black);
			textview11.setTextColor(0xFF000000);
			textview10.setTextColor(0xFF000000);
			edittext1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)60, 0xFFEEEEEE));
			_card_style(linear2, 10, 60, "#FFFFFF");
			_card_style(hscroll1, 10, 60, "#FFFFFF");
			_card_style(linear21, 10, 60, "#FFFFFF");
			textview12.setTextColor(0xFF000000);
			textview13.setTextColor(0xFF000000);
			button15.setBackgroundColor(0xFFFFFFFF);
			textview14.setTextColor(0xFF000000);
			button16.setBackgroundColor(0xFFFFFFFF);
		}
		if (s.getString("language", "").equals("english")) {
			textview1.setText("Settings");
			textview2.setText("Dark mode");
			textview3.setText("Search engine");
			textview6.setText("Cookies");
			textview7.setText("Run HTML");
			button11.setText("check update");
			button2.setText("about");
			button12.setText("SAVE Settings");
			textview5.setText("Home Page");
			textview8.setText("Text size");
			tex = "Text Size";
			add = "Custom Search Engine";
			urlsearch = "URL Search Engine";
			ok = "Set";
			cancel = "Cancel";
			error = "Just write the links";
			textview11.setText("Use player for Youtube");
			textview10.setText("Follow System");
			textview9.setText("Turn this off to avoid it from following system");
			notSupport_text1.setText("Your Android version is ".concat(Build.VERSION.RELEASE.concat("in which case you can not follow the system")));
			textview13.setText("Detects web errors");
			textview12.setText("Web Errors");
			button15.setText("Show Errors");
			textview14.setText("Explorer Cleaner");
			button16.setText("Choose Mode");
		}
		else {
			if (s.getString("language", "").equals("persian")) {
				textview1.setText("تنظیمات");
				textview2.setText("حالت تاریک");
				textview3.setText("موتور جستجو");
				textview6.setText("کوکی ها ");
				textview7.setText("اجرای HTML");
				button11.setText("بررسی بروزرسانی");
				button2.setText("درباره");
				button12.setText("ذخیره تنظیمات");
				textview5.setText("صفحه اصلی");
				textview8.setText("اندازه متن");
				tex = "اندازه متن";
				add = "موتور جستجوی سفارشی";
				urlsearch = "آدرس موتور جستجو";
				ok = "تنظیم";
				cancel = "لغو";
				error = "فقط پیوند ها را بنویسید";
				textview11.setText("استفاده پخش کننده برای یوتوب");
				textview10.setText("دنبال کردن سیستم");
				textview9.setText("این را خاموش کنید تا از پیروی سیستم جلوگیری شود");
				notSupport_text1.setText("نسخه اندروید شما ".concat(Build.VERSION.RELEASE.concat("است در این صورت نمی توانید سیستم را دنبال کنید")));
				textview13.setText("خطا های وب را شناسایی می کند");
				textview12.setText("خطاهای وب");
				button15.setText("نمایش خطاها");
				textview14.setText("پاک کننده Explorer");
				button16.setText("انتخاب حالت");
			}
			else {
				if (s.getString("language", "").equals("china")) {
					textview1.setText("设定值");
					textview3.setText("搜索引擎");
					textview2.setText(" 暗模式");
					textview6.setText(" 曲奇饼 ");
					textview7.setText(" 运行HTML ");
					button11.setText("检查更新");
					button2.setText("关于");
					textview5.setText("主页");
					button12.setText("保存设置");
					textview8.setText("字体大小");
					tex = "字体大小";
					add = "自定义搜索引擎";
					urlsearch = "网址搜索引擎";
					ok = "调音";
					cancel = "取消";
					error = "只需写链接";
					textview11.setText("使用YouTube播放器");
					textview10.setText("遵循系统");
					textview9.setText("将其关闭以避免其跟随系统");
					notSupport_text1.setText("您的Android版本是 ".concat(Build.VERSION.RELEASE.concat("在这种情况下，您将无法遵循系统")));
					textview13.setText("检测网络错误");
					textview12.setText("网络错误");
					button15.setText("显示错误");
					textview14.setText("探索者清洁剂");
					button16.setText("选择模式");
				}
				else {
					tex = "Text Size";
					add = "Custom Search Engine";
					urlsearch = "URL Search Engine";
					ok = "Set";
					cancel = "Cancel";
					error = "Just write the links";
					notSupport_text1.setText("Your Android version is ".concat(Build.VERSION.RELEASE.concat("in which case you can not follow the system")));
				}
			}
		}
		if (Double.parseDouble(Build.VERSION.SDK) > 27) {
			notSupport_text1.setVisibility(View.GONE);
			linear17.setVisibility(View.GONE);
			linear18.setVisibility(View.VISIBLE);
			textview9.setVisibility(View.VISIBLE);
		}
		else {
			notSupport_text1.setVisibility(View.VISIBLE);
			linear17.setVisibility(View.VISIBLE);
			linear18.setVisibility(View.GONE);
			textview9.setVisibility(View.GONE);
		}
		if (mode.getString("darkmode", "").equals("true")) {
			switch1.setChecked(true);
		}
		else {
			switch1.setChecked(false);
		}
		if (cookies.getString("cookies", "").equals("true")) {
			switch2.setChecked(true);
		}
		else {
			switch2.setChecked(false);
		}
		if (run.getString("runhtml", "").equals("on")) {
			switch3.setChecked(true);
		}
		else {
			switch3.setChecked(false);
		}
		if (mode.getString("ytplayer", "").equals("1")) {
			switch5.setChecked(true);
		}
		else {
			switch5.setChecked(false);
		}
		if (flowe.getString("flagfollowsystem", "").equals("1")) {
			switch4.setChecked(true);
		}
		else {
			switch4.setChecked(false);
		}
		if (homepage.getString("homepage", "").equals("")) {
			edittext1.setText("");
			homepage.edit().putString("homepage", "").commit();
		}
		else {
			edittext1.setText(homepage.getString("homepage", ""));
			if (Patterns.WEB_URL.matcher(homepage.getString("homepage", "")).matches())
			{
				 
			}
			else
			{
				homepage.edit().putString("homepage", "").commit();
			}
		}
		_setBackground(button12, 100, 10, "#2196F3", true);
		_menu();
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						_diadark();
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(timer, (int)(0), (int)(1000));
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
	
	
	public void _menu () {
		menu_size.add(tex);
		menu_size.add("50%");
		menu_size.add("60%");
		menu_size.add("70%");
		menu_size.add("80%");
		menu_size.add("90%");
		menu_size.add("100%");
		menu_size.add("Normal");
		menu_size.add("110%");
		menu_size.add("120%");
		menu_size.add("130%");
		menu_size.add("140%");
		menu_size.add("150%");
		spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, menu_size));
		((ArrayAdapter)spinner1.getAdapter()).notifyDataSetChanged();
	}
	
	
	public void _diadark () {
		if (mode.getString("darkmode", "").equals("true")) {
			dialog = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
		}
		else {
			dialog = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
		}
	}
	
	
	public void _removeScollBar (final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
	}
	
	
	public void _circleRipple (final String _color, final View _v) {
		android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor(_color)});
		android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrb , null, null);
		_v.setBackground(ripdrb);
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