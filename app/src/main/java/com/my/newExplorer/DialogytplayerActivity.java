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
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.*;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerUtils;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.ProgressBar;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.Intent;
import android.net.Uri;
import java.util.Timer;
import java.util.TimerTask;
import android.view.View;
import android.webkit.WebViewClient;
import android.graphics.Typeface;
import androidx.webkit.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class DialogytplayerActivity extends AppCompatActivity {
	private Timer _timer = new Timer();
	
	private String share = "";
	
	private LinearLayout linear6;
	private CardView cardview9;
	private CardView cardview1;
	private CardView cardview5;
	private LinearLayout linear15;
	private HorizontalScrollView hscroll1;
	private LinearLayout linear7;
	private CardView cardview4;
	private CardView cardview6;
	private CardView cardview10;
	private CardView cardview12;
	private CardView cardview13;
	private CardView cardview11;
	private LinearLayout linear8;
	private ImageView imageview3;
	private LinearLayout linear12;
	private ImageView imageview2;
	private TextView textview5;
	private LinearLayout linear16;
	private ImageView imageview4;
	private TextView textview7;
	private LinearLayout linear18;
	private ImageView imageview5;
	private TextView textview9;
	private LinearLayout linear19;
	private ImageView imageview6;
	private TextView textview10;
	private LinearLayout linear20;
	private ImageView imageview7;
	private TextView textview11;
	private LinearLayout linear2;
	private CardView cardview2;
	private TextView linktext;
	private CardView cardview3;
	private LinearLayout linear3;
	private ImageView imageview1;
	private TextView textview1;
	private LinearLayout linear4;
	private YouTubePlayerView youtube1;
	private LinearLayout linear1;
	private LinearLayout linear10;
	private TextView textview2;
	private WebView webview1;
	private LinearLayout linear11;
	private WebView webview2;
	private LinearLayout linear17;
	private TextView textview3;
	private TextView textview4;
	private ProgressBar progressbar1;
	private TextView textview8;
	
	private SharedPreferences dialogytlink;
	private SharedPreferences mode;
	private Intent w = new Intent();
	private Intent intent = new Intent();
	private TimerTask rl;
	private SharedPreferences s;
	private Intent open = new Intent();
	private SharedPreferences y;
	private Intent n = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.dialogytplayer);
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
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		cardview9 = (CardView) findViewById(R.id.cardview9);
		cardview1 = (CardView) findViewById(R.id.cardview1);
		cardview5 = (CardView) findViewById(R.id.cardview5);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		hscroll1 = (HorizontalScrollView) findViewById(R.id.hscroll1);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		cardview4 = (CardView) findViewById(R.id.cardview4);
		cardview6 = (CardView) findViewById(R.id.cardview6);
		cardview10 = (CardView) findViewById(R.id.cardview10);
		cardview12 = (CardView) findViewById(R.id.cardview12);
		cardview13 = (CardView) findViewById(R.id.cardview13);
		cardview11 = (CardView) findViewById(R.id.cardview11);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		textview5 = (TextView) findViewById(R.id.textview5);
		linear16 = (LinearLayout) findViewById(R.id.linear16);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		textview7 = (TextView) findViewById(R.id.textview7);
		linear18 = (LinearLayout) findViewById(R.id.linear18);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		textview9 = (TextView) findViewById(R.id.textview9);
		linear19 = (LinearLayout) findViewById(R.id.linear19);
		imageview6 = (ImageView) findViewById(R.id.imageview6);
		textview10 = (TextView) findViewById(R.id.textview10);
		linear20 = (LinearLayout) findViewById(R.id.linear20);
		imageview7 = (ImageView) findViewById(R.id.imageview7);
		textview11 = (TextView) findViewById(R.id.textview11);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		cardview2 = (CardView) findViewById(R.id.cardview2);
		linktext = (TextView) findViewById(R.id.linktext);
		cardview3 = (CardView) findViewById(R.id.cardview3);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview1 = (TextView) findViewById(R.id.textview1);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		youtube1 = (YouTubePlayerView) findViewById(R.id.youtube1);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		textview2 = (TextView) findViewById(R.id.textview2);
		webview1 = (WebView) findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		webview2 = (WebView) findViewById(R.id.webview2);
		webview2.getSettings().setJavaScriptEnabled(true);
		webview2.getSettings().setSupportZoom(true);
		linear17 = (LinearLayout) findViewById(R.id.linear17);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview4 = (TextView) findViewById(R.id.textview4);
		progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
		textview8 = (TextView) findViewById(R.id.textview8);
		dialogytlink = getSharedPreferences("dialogytlink", Activity.MODE_PRIVATE);
		mode = getSharedPreferences("mode", Activity.MODE_PRIVATE);
		s = getSharedPreferences("s", Activity.MODE_PRIVATE);
		y = getSharedPreferences("y", Activity.MODE_PRIVATE);
		
		linear6.setOnLongClickListener(new View.OnLongClickListener() {
			 @Override
				public boolean onLongClick(View _view) {
				
				return true;
				}
			 });
		
		cardview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		cardview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				webview1.loadUrl("https://www.yt-download.org/api/button/videos/".concat(dialogytlink.getString("link", "")));
				webview2.loadUrl("https://www.yt-download.org/@api/button/mp3/".concat(dialogytlink.getString("link", "")));
				if (cardview5.isEnabled()) {
					cardview5.setVisibility(View.GONE);
					cardview5.setEnabled(false);
					if (mode.getString("darkmode", "").equals("true")) {
						imageview2.setImageResource(R.drawable.ic_file_download_white);
					}
					else {
						imageview2.setImageResource(R.drawable.ic_get_app_black);
					}
				}
				else {
					cardview5.setVisibility(View.VISIBLE);
					cardview5.setEnabled(true);
					if (mode.getString("darkmode", "").equals("true")) {
						imageview2.setImageResource(R.drawable.ic_clear_white);
					}
					else {
						imageview2.setImageResource(R.drawable.ic_clear_black);
					}
				}
			}
		});
		
		cardview10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				w.setAction(Intent.ACTION_VIEW);
				w.setClass(getApplicationContext(), DialogytplayerActivity.class);
				startActivity(w);
				finish();
			}
		});
		
		cardview12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				open.setAction(Intent.ACTION_VIEW);
				open.setData(Uri.parse(y.getString("YouTube URL", "")));
				startActivity(open);
				finish();
			}
		});
		
		cardview13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				share = y.getString("YouTube URL", "");
				Intent i = new Intent(android.content.Intent.ACTION_SEND);i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_TEXT, share); startActivity(Intent.createChooser(i,"Share using"));
			}
		});
		
		cardview11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				n.setClass(getApplicationContext(), PipmodeytActivity.class);
				startActivity(n);
				finish();
			}
		});
		
		//webviewOnProgressChanged
		webview1.setWebChromeClient(new WebChromeClient() {
				@Override public void onProgressChanged(WebView view, int _newProgress) {
					
				}
		});
		
		webview1.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				
				super.onPageFinished(_param1, _param2);
			}
		});
		
		//webviewOnProgressChanged
		webview2.setWebChromeClient(new WebChromeClient() {
				@Override public void onProgressChanged(WebView view, int _newProgress) {
					
				}
		});
		
		webview2.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				
				super.onPageFinished(_param1, _param2);
			}
		});
	}
	
	private void initializeLogic() {
		if (getIntent().getBooleanExtra("dialogTheme",true)) {
			// To make the dialog corners round
			getWindow().getDecorView().setBackgroundResource(android.R.color.transparent);
			
			{
				android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
				int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
				SketchUi.setColor(0x00000000);SketchUi.setCornerRadius(d*15);
				
				((ViewGroup)getWindow().getDecorView()).getChildAt(0).setBackground(SketchUi);
			}
			
			// Codes Generated by SketchUi 
		}
		// you may face some issues if you use enable ActionBar due to dialog theme
		linktext.setText(dialogytlink.getString("link", ""));
		linear17.setVisibility(View.GONE);
		cardview5.setVisibility(View.GONE);
		cardview5.setEnabled(false);
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
	public void onStart() {
		super.onStart();
		_setViewSize(linear6, SketchwareUtil.getDisplayWidthPixels(getApplicationContext()) - 130, SketchwareUtil.getDisplayHeightPixels(getApplicationContext()) - 180);
		_removeScollBar(hscroll1);
		getLifecycle().addObserver(youtube1);
		if (linktext.getText().toString().contains("&feature=youtu.be")) {
			linktext.setText(linktext.getText().toString().replace("&feature=youtu.be", ""));
		}
		if (linktext.getText().toString().contains("https://youtu.be/")) {
			linktext.setText(linktext.getText().toString().replace("https://youtu.be/", ""));
			dialogytlink.edit().putString("link", linktext.getText().toString()).commit();
		}
		if (linktext.getText().toString().contains("https://m.youtube.com/watch?v=")) {
			linktext.setText(linktext.getText().toString().replace("https://m.youtube.com/watch?v=", ""));
			dialogytlink.edit().putString("link", linktext.getText().toString()).commit();
		}
		youtube1.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
			  @Override
			  public void onReady(@NonNull YouTubePlayer youTubePlayer) {
				    String videoId = linktext.getText().toString();
				    youTubePlayer.cueVideo(videoId, 0);
				     
				  }
		});
		rl = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (youtube1.isFullScreen()) {
							youtube1.exitFullScreen();
							intent.setClass(getApplicationContext(), YtplayerfullscreenActivity.class);
							startActivity(intent);
							finish();
						}
						else {
							 
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(rl, (int)(0), (int)(75));
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/googlesansbold.ttf"), 0);
		cardview1.setCardBackgroundColor(0xFFFFFFFF);
		cardview1.setRadius((float)15);
		cardview1.setCardElevation((float)3);
		cardview1.setPreventCornerOverlap(true);
		cardview2.setCardBackgroundColor(0xFFEEEEEE);
		cardview2.setRadius((float)15);
		cardview2.setCardElevation((float)3);
		cardview2.setPreventCornerOverlap(true);
		cardview3.setCardBackgroundColor(0xFFFFFFFF);
		cardview3.setRadius((float)15);
		cardview3.setCardElevation((float)3);
		cardview3.setPreventCornerOverlap(true);
		cardview4.setCardBackgroundColor(0xFFFFFFFF);
		cardview4.setRadius((float)360);
		cardview4.setCardElevation((float)0);
		cardview4.setPreventCornerOverlap(true);
		cardview5.setCardBackgroundColor(0xFFFFFFFF);
		cardview5.setRadius((float)15);
		cardview5.setCardElevation((float)3);
		cardview5.setPreventCornerOverlap(true);
		cardview6.setCardBackgroundColor(0xFFFFFFFF);
		cardview6.setRadius((float)360);
		cardview6.setCardElevation((float)0);
		cardview6.setPreventCornerOverlap(true);
		cardview9.setCardBackgroundColor(Color.TRANSPARENT);
		cardview9.setRadius((float)360);
		cardview9.setCardElevation((float)0);
		cardview9.setPreventCornerOverlap(true);
		cardview10.setCardBackgroundColor(0xFFFFFFFF);
		cardview10.setRadius((float)360);
		cardview10.setCardElevation((float)0);
		cardview10.setPreventCornerOverlap(true);
		cardview12.setCardBackgroundColor(0xFFFFFFFF);
		cardview12.setRadius((float)360);
		cardview12.setCardElevation((float)0);
		cardview12.setPreventCornerOverlap(true);
		cardview13.setCardBackgroundColor(0xFFFFFFFF);
		cardview13.setRadius((float)360);
		cardview13.setCardElevation((float)0);
		cardview13.setPreventCornerOverlap(true);
		cardview11.setCardBackgroundColor(0xFFFFFFFF);
		cardview11.setRadius((float)360);
		cardview11.setCardElevation((float)0);
		cardview11.setPreventCornerOverlap(true);
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/googlesansbold.ttf"), 0);
		textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/googlesansbold.ttf"), 0);
		textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/googlesansbold.ttf"), 0);
		if (mode.getString("darkmode", "").equals("true")) {
			cardview1.setCardBackgroundColor(0xFF000000);
			cardview2.setCardBackgroundColor(0xFF212121);
			cardview3.setCardBackgroundColor(0xFF000000);
			cardview4.setCardBackgroundColor(0xFF212121);
			cardview6.setCardBackgroundColor(0xFF212121);
			cardview10.setCardBackgroundColor(0xFF212121);
			textview1.setTextColor(0xFFFFFFFF);
			textview7.setTextColor(0xFFFFFFFF);
			imageview2.setImageResource(R.drawable.ic_file_download_white);
			imageview3.setImageResource(R.drawable.ic_clear_white);
			imageview4.setImageResource(R.drawable.ic_autorenew_white);
			cardview5.setCardBackgroundColor(0xFF000000);
			webview1.setBackgroundColor(0xFF000000);
			webview2.setBackgroundColor(0xFF000000);
			if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK));
			WebSettingsCompat.setForceDark(webview1.getSettings(), WebSettingsCompat.FORCE_DARK_ON);
			if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK));
			WebSettingsCompat.setForceDark(webview2.getSettings(), WebSettingsCompat.FORCE_DARK_ON);
			textview3.setTextColor(0xFFFFFFFF);
			textview4.setTextColor(0xFFFFFFFF);
			textview5.setTextColor(0xFFFFFFFF);
			cardview12.setCardBackgroundColor(0xFF212121);
			textview9.setTextColor(0xFFFFFFFF);
			cardview13.setCardBackgroundColor(0xFF212121);
			textview10.setTextColor(0xFFFFFFFF);
			imageview6.setImageResource(R.drawable.ic_share_white);
			cardview11.setCardBackgroundColor(0xFF212121);
			textview11.setTextColor(0xFFFFFFFF);
			imageview7.setImageResource(R.drawable.ic_tab_unselected_white);
		}
		else {
			cardview1.setCardBackgroundColor(0xFFFFFFFF);
			cardview2.setCardBackgroundColor(0xFFEEEEEE);
			cardview3.setCardBackgroundColor(0xFFFFFFFF);
			cardview4.setCardBackgroundColor(0xFFFFFFFF);
			cardview6.setCardBackgroundColor(0xFFFFFFFF);
			cardview10.setCardBackgroundColor(0xFFFFFFFF);
			textview1.setTextColor(0xFF000000);
			textview7.setTextColor(0xFF000000);
			imageview2.setImageResource(R.drawable.ic_get_app_black);
			imageview3.setImageResource(R.drawable.ic_clear_black);
			imageview4.setImageResource(R.drawable.ic_autorenew_black);
			cardview5.setCardBackgroundColor(0xFFFFFFFF);
			webview1.setBackgroundColor(0xFFFFFFFF);
			webview1.setBackgroundColor(0xFFFFFFFF);
			if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK));
			WebSettingsCompat.setForceDark(webview1.getSettings(), WebSettingsCompat.FORCE_DARK_OFF);
			if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK));
			WebSettingsCompat.setForceDark(webview2.getSettings(), WebSettingsCompat.FORCE_DARK_OFF);
			textview3.setTextColor(0xFF000000);
			textview4.setTextColor(0xFF000000);
			textview5.setTextColor(0xFF000000);
			cardview12.setCardBackgroundColor(0xFFFFFFFF);
			textview9.setTextColor(0xFF000000);
			cardview13.setCardBackgroundColor(0xFFFFFFFF);
			textview10.setTextColor(0xFF000000);
			imageview6.setImageResource(R.drawable.ic_share_black);
			cardview11.setCardBackgroundColor(0xFFFFFFFF);
			textview11.setTextColor(0xFF000000);
			imageview7.setImageResource(R.drawable.ic_tab_unselected_black);
		}
		_translate();
		if (FileUtil.isExistFile(FileUtil.getExternalStorageDir().concat("/webview download"))) {
			
		}
		else {
			FileUtil.makeDir(FileUtil.getExternalStorageDir().concat("/webview download"));
		}
		_enable_Download(webview1, "/webview download");
		_enable_Download(webview2, "/webview download");
	}
	public void _setViewSize (final View _view1, final double _width, final double _height) {
		_view1.setLayoutParams(new LinearLayout.LayoutParams((int)_width, (int)_height));
	}
	
	
	public void _rippleRoundStroke (final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
	}
	
	
	public void _dialogTheme () {
	}
	// setTheme() should be set before setContentView() so a small hack to do this in sketchware
	 @Override 
	    public void setContentView( int layoutResID) {
		if(getIntent().getBooleanExtra("dialogTheme",true)){
			supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
			setTheme(R.style.Theme_AppCompat_Light_Dialog);
			setFinishOnTouchOutside(false);
			
			//change true to false if you want to make dialog non cancellable when clicked outside
			//if you want to use this without app compat  change supportRequestWindowFeature() and setTheme() to below codes.
			/*
requestWindowFeature(Window.FEATURE_NO_TITLE);
setTheme(android.R.style.Theme_Dialog);
*/
			// Calling this allows the Activity behind this one to be seen again. Once all such Activities have been redrawn
			try {
				 	java.lang.reflect.Method getActivityOptions = Activity.class.getDeclaredMethod("getActivityOptions"); getActivityOptions.setAccessible(true);
				 Object options = getActivityOptions.invoke(this); Class<?>[] classes = Activity.class.getDeclaredClasses(); Class<?> translucentConversionListenerClazz = null; 
				for (Class clazz : classes) { if (clazz.getSimpleName().contains("TranslucentConversionListener")) { translucentConversionListenerClazz = clazz; } } 
				java.lang.reflect.Method convertToTranslucent = Activity.class.getDeclaredMethod("convertToTranslucent", translucentConversionListenerClazz, ActivityOptions.class); convertToTranslucent.setAccessible(true); convertToTranslucent.invoke(this, null, options); } catch (Throwable t) {
			}
		}
		super.setContentView(layoutResID);  
	}
	{
	}
	
	
	public void _translate () {
		if (s.getString("language", "").equals("english")) {
			textview5.setText("Download");
			textview7.setText("Reload Video");
			textview8.setText("Loading");
			textview9.setText("Open In YouTube");
			textview10.setText("Share");
			textview11.setText("PIP Mode");
		}
		else {
			if (s.getString("language", "").equals("persian")) {
				textview5.setText("????????????");
				textview7.setText("???????? ???????? ??????????");
				textview8.setText("?????????? ????????????????");
				textview9.setText("?????????????? ???? YouTube");
				textview10.setText("???????????? ??????????");
				textview11.setText("???????? PIP");
			}
			else {
				if (s.getString("language", "").equals("china")) {
					textview5.setText("??????");
					textview7.setText("??????????????????");
					textview8.setText("?????????");
					textview9.setText("??? YouTube ?????????");
					textview10.setText("??????");
					textview11.setText("???????????????");
				}
				else {
					
				}
			}
		}
	}
	
	
	public void _full () {
	}
	
	
	public class CustomWebClient extends WebChromeClient {
		
		private View mCustomView;
		
		private WebChromeClient.CustomViewCallback mCustomViewCallback;
		
		protected FrameLayout frame;
		
		
		// Initially mOriginalOrientation is set to Landscape
		
		private int mOriginalOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
		
		private int mOriginalSystemUiVisibility;
		
		
		// Constructor for CustomWebClient
		
		public CustomWebClient() {}
		
		
		public Bitmap getDefaultVideoPoster() {
			
			if (DialogytplayerActivity.this == null) {
				
				return null; }
			
			return BitmapFactory.decodeResource(DialogytplayerActivity.this.getApplicationContext().getResources(), 2130837573); }
		
		
		public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback viewCallback) {
			
			if (this.mCustomView != null) {
				
				onHideCustomView();
				
				return; }
			
			this.mCustomView = paramView;
			
			this.mOriginalSystemUiVisibility = DialogytplayerActivity.this.getWindow().getDecorView().getSystemUiVisibility();
			
			// When CustomView is shown screen orientation changes to mOriginalOrientation (Landscape).
			DialogytplayerActivity.this.setRequestedOrientation(this.mOriginalOrientation);
			
			// After that mOriginalOrientation is set to portrait.
			
			this.mOriginalOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
			
			this.mCustomViewCallback = viewCallback; ((FrameLayout)DialogytplayerActivity.this.getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1)); DialogytplayerActivity.this.getWindow().getDecorView().setSystemUiVisibility(3846);
			
		}
		
		
		public void onHideCustomView() {
			
			((FrameLayout)DialogytplayerActivity.this.getWindow().getDecorView()).removeView(this.mCustomView);
			
			this.mCustomView = null;
			
			DialogytplayerActivity.this.getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
			
			// When CustomView is hidden, screen orientation is set to mOriginalOrientation (portrait).
			
			
			
			DialogytplayerActivity.this.setRequestedOrientation(this.mOriginalOrientation);
			
			
			
			// After that mOriginalOrientation is set to landscape.
			
			
			
			this.mOriginalOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE; this.mCustomViewCallback.onCustomViewHidden();
			
			this.mCustomViewCallback = null;
			
		}
		
	}
	
	
	{
	}
	
	
	public void _enable_Download (final WebView _webview, final String _path) {
		_webview.setDownloadListener(new DownloadListener() {
			
			public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
				
				DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
				
				String cookies = CookieManager.getInstance().getCookie(url);
				
				request.addRequestHeader("cookie", cookies);
				
				request.addRequestHeader("User-Agent", userAgent);
				
				request.setDescription("Downloading file...");
				
				request.setTitle(URLUtil.guessFileName(url, contentDisposition, mimetype));
				
				request.allowScanningByMediaScanner(); request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
				
				java.io.File aatv = new java.io.File(Environment.getExternalStorageDirectory().getPath() + "/Webview/Download");if(!aatv.exists()){if (!aatv.mkdirs()){ Log.e("TravellerLog ::","Problem creating Image folder");}} request.setDestinationInExternalPublicDir(_path, URLUtil.guessFileName(url, contentDisposition, mimetype));
				
				
				DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
				
				manager.enqueue(request);
				
				showMessage("Downloading File....");
				
				BroadcastReceiver onComplete = new BroadcastReceiver() {
					
					public void onReceive(Context ctxt, Intent intent) {
						
						showMessage("Download Complete!");
						
						unregisterReceiver(this);
						
					}};
				
				registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
				
			}
			
		});
	}
	
	
	public void _removeScollBar (final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
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