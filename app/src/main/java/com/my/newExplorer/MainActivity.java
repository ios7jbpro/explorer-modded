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
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.TextView;
import android.widget.LinearLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.app.Activity;
import android.content.SharedPreferences;
import android.speech.SpeechRecognizer;
import android.speech.RecognizerIntent;
import android.speech.RecognitionListener;
import android.content.Context;
import android.os.Vibrator;
import android.content.Intent;
import android.content.ClipData;
import java.util.Timer;
import java.util.TimerTask;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import android.view.View;
import android.webkit.WebViewClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.webkit.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.widget.TextView.OnEditorActionListener;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.EditorInfo;

public class MainActivity extends AppCompatActivity {
	public final int REQ_CD_FP = 101;
	public final int REQ_CD_RUNHTML = 102;
	private Timer _timer = new Timer();
	
	private String share = "";
	private String OK = "";
	private String toast = "";
	private String lock_site = "";
	private String open_lock_site = "";
	private String copy = "";
	private double TotalItems = 0;
	private boolean FoundItems = false;
	private String found = "";
	private String title_home = "";
	private String set = "";
	private String cancel = "";
	private String homelink = "";
	private String path = "";
	private HashMap<String, Object> spinner = new HashMap<>();
	private String shortcut_download = "";
	private String shortcut_downloadLong = "";
	private String shortcut_settings = "";
	private String shortcut_settingsLong = "";
	private String notsupport = "";
	private double width = 0;
	private String massage_notif = "";
	
	private ArrayList<String> str = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> map = new ArrayList<>();
	
	private TextView intenturltext;
	private LinearLayout linear3;
	private LinearLayout linear6;
	private LinearLayout linear;
	private SwipeRefreshLayout swiperefreshlayout1;
	private LinearLayout linear1;
	private ImageView imageview17;
	private ImageView imageview21;
	private ImageView imageview15;
	private ImageView lock;
	private ImageView open_lock;
	private LinearLayout linear2;
	private ImageView imageview16;
	private ImageView imageview1;
	private EditText edittext2;
	private EditText edittext1;
	private TextView textview1;
	private ImageView imageview20;
	private TextView textview3;
	private ProgressBar prog;
	private WebView webview1;
	
	private SharedPreferences shared;
	private SpeechRecognizer Sp;
	private Vibrator V;
	private Intent fp = new Intent(Intent.ACTION_GET_CONTENT);
	private TimerTask timer;
	private SharedPreferences s;
	private SharedPreferences mode;
	private SharedPreferences url;
	
	private OnCompleteListener cloud_onCompleteListener;
	private AlertDialog.Builder Dia_lock_site;
	private Intent settings = new Intent();
	private SharedPreferences homepage;
	private Calendar ie = Calendar.getInstance();
	private SharedPreferences history;
	private Intent his = new Intent();
	private TimerTask textopening;
	private SharedPreferences cookies;
	private Intent runhtml = new Intent(Intent.ACTION_GET_CONTENT);
	private SharedPreferences run;
	private SharedPreferences button;
	private SharedPreferences size;
	private SharedPreferences html;
	private Intent go = new Intent();
	private TimerTask time;
	private TimerTask check;
	private TimerTask reloader;
	private SharedPreferences dialogytlink;
	private Intent ytb = new Intent();
	private SharedPreferences flowe;
	private TimerTask word;
	private AlertDialog.Builder home;
	private Intent d = new Intent();
	private SharedPreferences y;
	private SharedPreferences error;
	private Calendar er = Calendar.getInstance();
	private RequestNetwork weberror;
	private RequestNetwork.RequestListener _weberror_request_listener;
	private TimerTask no_net;
	private Intent change = new Intent();
	private SharedPreferences stop;
	private SharedPreferences clear;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO}, 1000);
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
		intenturltext = (TextView) findViewById(R.id.intenturltext);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear = (LinearLayout) findViewById(R.id.linear);
		swiperefreshlayout1 = (SwipeRefreshLayout) findViewById(R.id.swiperefreshlayout1);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		imageview17 = (ImageView) findViewById(R.id.imageview17);
		imageview21 = (ImageView) findViewById(R.id.imageview21);
		imageview15 = (ImageView) findViewById(R.id.imageview15);
		lock = (ImageView) findViewById(R.id.lock);
		open_lock = (ImageView) findViewById(R.id.open_lock);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		imageview16 = (ImageView) findViewById(R.id.imageview16);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		edittext2 = (EditText) findViewById(R.id.edittext2);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		textview1 = (TextView) findViewById(R.id.textview1);
		imageview20 = (ImageView) findViewById(R.id.imageview20);
		textview3 = (TextView) findViewById(R.id.textview3);
		prog = (ProgressBar) findViewById(R.id.prog);
		webview1 = (WebView) findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		shared = getSharedPreferences("shared", Activity.MODE_PRIVATE);
		Sp = SpeechRecognizer.createSpeechRecognizer(this);
		V = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		fp.setType("*/*");
		fp.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		s = getSharedPreferences("s", Activity.MODE_PRIVATE);
		mode = getSharedPreferences("mode", Activity.MODE_PRIVATE);
		url = getSharedPreferences("url", Activity.MODE_PRIVATE);
		Dia_lock_site = new AlertDialog.Builder(this);
		homepage = getSharedPreferences("homepage", Activity.MODE_PRIVATE);
		history = getSharedPreferences("history", Activity.MODE_PRIVATE);
		cookies = getSharedPreferences("cookies", Activity.MODE_PRIVATE);
		runhtml.setType("text/*");
		runhtml.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		run = getSharedPreferences("run", Activity.MODE_PRIVATE);
		button = getSharedPreferences("button", Activity.MODE_PRIVATE);
		size = getSharedPreferences("size", Activity.MODE_PRIVATE);
		html = getSharedPreferences("html", Activity.MODE_PRIVATE);
		dialogytlink = getSharedPreferences("dialogytlink", Activity.MODE_PRIVATE);
		flowe = getSharedPreferences("flowe", Activity.MODE_PRIVATE);
		home = new AlertDialog.Builder(this);
		y = getSharedPreferences("y", Activity.MODE_PRIVATE);
		error = getSharedPreferences("error", Activity.MODE_PRIVATE);
		weberror = new RequestNetwork(this);
		stop = getSharedPreferences("stop", Activity.MODE_PRIVATE);
		clear = getSharedPreferences("clear", Activity.MODE_PRIVATE);
		
		imageview17.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!homepage.getString("homepage", "").equals("")) {
					webview1.loadUrl(homepage.getString("homepage", ""));
				}
				else {
					LinearLayout mylayout = new LinearLayout(MainActivity.this);
					
					LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
					
					mylayout.setLayoutParams(params); mylayout.setOrientation(LinearLayout.VERTICAL);
					
					final EditText myedittext = new EditText(MainActivity.this);
					myedittext.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT, android.widget.LinearLayout.LayoutParams.WRAP_CONTENT));
					 
					mylayout.addView(myedittext);
					home.setView(mylayout);
					myedittext.setHint(homelink);
					myedittext.setHintTextColor(0xFF9E9E9E);
					if (mode.getString("darkmode", "").equals("true")) {
						myedittext.setTextColor(0xFFFFFFFF);
					}
					else {
						myedittext.setTextColor(0xFF000000);
					}
					home.setTitle(title_home);
					home.setPositiveButton(set, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							if (Patterns.WEB_URL.matcher(myedittext.getText().toString()).matches())
							{
								homepage.edit().putString("homepage", myedittext.getText().toString()).commit();
								webview1.loadUrl(homepage.getString("homepage", ""));
							}
							else
							{
								homepage.edit().putString("homepage", "").commit();
							}
						}
					});
					home.setNegativeButton(cancel, new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					home.create().show();
				}
			}
		});
		
		imageview21.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Popup();
			}
		});
		
		imageview15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent _intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
				_intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getPackageName());
				_intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
				_intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
				Sp.startListening(_intent);
				SketchwareUtil.showMessage(getApplicationContext(), toast);
			}
		});
		
		lock.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Dia_lock_site.setMessage(lock_site);
				Dia_lock_site.setPositiveButton(OK, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				Dia_lock_site.create().show();
			}
		});
		
		open_lock.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Dia_lock_site.setMessage(open_lock_site);
				Dia_lock_site.setPositiveButton(OK, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				Dia_lock_site.create().show();
			}
		});
		
		imageview16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(runhtml, REQ_CD_RUNHTML);
			}
		});
		
		imageview1.setOnLongClickListener(new View.OnLongClickListener() {
			 @Override
				public boolean onLongClick(View _view) {
				
				return true;
				}
			 });
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext1.setText(webview1.getUrl());
			}
		});
		
		edittext2.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				webview1.findAllAsync(_charSeq);
				webview1.findNext(true);
				webview1.findFocus();
				textview3.setText(found.concat(":".concat(String.valueOf((long)(TotalItems)))));
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		edittext1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview1.setVisibility(View.VISIBLE);
			}
		});
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (edittext1.getText().toString().contains("view-source:")) {
					html.edit().putString("html_view", edittext1.getText().toString().replace("view-source:", "")).commit();
					go.setClass(getApplicationContext(), HtmlActivity.class);
					startActivity(go);
				}
				else {
					
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		imageview20.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext1.setVisibility(View.VISIBLE);
				edittext2.setVisibility(View.GONE);
				linear6.setVisibility(View.GONE);
				edittext2.setText("");
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
				linear.setVisibility(View.VISIBLE);
				if ((_url.indexOf("https://") == 0) || (_url.indexOf("https://www.") == 0)) {
					open_lock.setVisibility(View.GONE);
					lock.setVisibility(View.VISIBLE);
				}
				else {
					open_lock.setVisibility(View.VISIBLE);
					lock.setVisibility(View.GONE);
				}
				ie = Calendar.getInstance();
				history.edit().putString("history", "[".concat(new SimpleDateFormat("yyyy/MM/dd | hh:mm").format(ie.getTime()).concat("] ".concat(webview1.getUrl()))).concat("\n\n".concat(history.getString("history", "")))).commit();
				if (mode.getString("ytplayer", "").equals("1")) {
					if (webview1.getUrl().contains("m.youtube.com/watch")) {
						ytb.setAction(Intent.ACTION_VIEW);
						ytb.setClass(getApplicationContext(), DialogytplayerActivity.class);
						startActivity(ytb);
						dialogytlink.edit().putString("link", webview1.getUrl()).commit();
						y.edit().putString("YouTube URL", webview1.getUrl()).commit();
						webview1.stopLoading();
						webview1.goBack();
					}
				}
				else {
					
				}
				weberror.startRequestNetwork(RequestNetworkController.GET, webview1.getUrl(), "A", _weberror_request_listener);
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				edittext1.setText(webview1.getTitle());
				linear.setVisibility(View.GONE);
				swiperefreshlayout1.setRefreshing(false);
				url.edit().putString("url", _url).commit();
				super.onPageFinished(_param1, _param2);
			}
		});
		
		Sp.setRecognitionListener(new RecognitionListener() {
			@Override
			public void onReadyForSpeech(Bundle _param1) {
			}
			@Override
			public void onBeginningOfSpeech() {
			}
			@Override
			public void onRmsChanged(float _param1) {
			}
			@Override
			public void onBufferReceived(byte[] _param1) {
			}
			@Override
			public void onEndOfSpeech() {
			}
			@Override
			public void onPartialResults(Bundle _param1) {
			}
			@Override
			public void onEvent(int _param1, Bundle _param2) {
			}
			@Override
			public void onResults(Bundle _param1) {
				final ArrayList<String> _results = _param1.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
				final String _result = _results.get(0);
				edittext1.setText(_result);
				timer = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								if ((edittext1.getText().toString().indexOf("http://") == 0) || (edittext1.getText().toString().indexOf("https://") == 0)) {
									webview1.loadUrl(edittext1.getText().toString());
								}
								else {
									if (edittext1.getText().toString().indexOf("www.") == 0) {
										webview1.loadUrl("http://".concat(edittext1.getText().toString()));
									}
									else {
										webview1.loadUrl(shared.getString("search engine", "").concat(edittext1.getText().toString()));
									}
								}
							}
						});
					}
				};
				_timer.schedule(timer, (int)(100));
			}
			
			@Override
			public void onError(int _param1) {
				final String _errorMessage;
				switch (_param1) {
					case SpeechRecognizer.ERROR_AUDIO:
					_errorMessage = "audio error";
					break;
					case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
					_errorMessage = "speech timeout";
					break;
					case SpeechRecognizer.ERROR_NO_MATCH:
					_errorMessage = "speech no match";
					break;
					case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
					_errorMessage = "recognizer busy";
					break;
					case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
					_errorMessage = "recognizer insufficient permissions";
					break;
					default:
					_errorMessage = "recognizer other error";
					break;
				}
				SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
			}
		});
		
		cloud_onCompleteListener = new OnCompleteListener<InstanceIdResult>() {
			@Override
			public void onComplete(Task<InstanceIdResult> task) {
				final boolean _success = task.isSuccessful();
				final String _token = task.getResult().getToken();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_weberror_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				er = Calendar.getInstance();
				error.edit().putString("Web Errors", "[".concat(new SimpleDateFormat("yyyy/MM/dd | hh:mm").format(er.getTime()).concat("]".concat(" URL : ".concat(webview1.getUrl().concat("\nError :".concat(_message)))))).concat("\n\n".concat(error.getString("Web Errors", "")))).commit();
			}
		};
	}
	
	private void initializeLogic() {
		webview1.getSettings().setJavaScriptEnabled(true); registerForContextMenu(webview1);
		_language();
		if (stop.getString("stop", "").equals("")) {
			stop.edit().putString("stop", "false").commit();
		}
		else {
			
		}
		if (stop.getString("stop", "").equals("false")) {
			if (!homepage.getString("homepage", "").equals("")) {
				webview1.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
				webview1.loadUrl(homepage.getString("homepage", ""));
			}
			else {
				if (!url.getString("url", "").equals("")) {
					webview1.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
					webview1.loadUrl(url.getString("url", ""));
				}
				else {
					webview1.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
					webview1.loadUrl("https://www.google.com");
				}
			}
		}
		else {
			_createChannel();
			if (clear.getString("cleaner", "").equals("cache")) {
				webview1.clearCache(true);
				if (!homepage.getString("homepage", "").equals("")) {
					webview1.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
					webview1.loadUrl(homepage.getString("homepage", ""));
				}
				else {
					if (!url.getString("url", "").equals("")) {
						webview1.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
						webview1.loadUrl(url.getString("url", ""));
					}
					else {
						webview1.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
						webview1.loadUrl("https://www.google.com");
					}
				}
				_showNotification("Explorer Cleaner", massage_notif);
			}
			else {
				if (clear.getString("cleaner", "").equals("history")) {
					webview1.clearHistory();
					if (!homepage.getString("homepage", "").equals("")) {
						webview1.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
						webview1.loadUrl(homepage.getString("homepage", ""));
					}
					else {
						if (!url.getString("url", "").equals("")) {
							webview1.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
							webview1.loadUrl(url.getString("url", ""));
						}
						else {
							webview1.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
							webview1.loadUrl("https://www.google.com");
						}
					}
					_showNotification("Explorer Cleaner", massage_notif);
				}
				else {
					if (clear.getString("cleaner", "").equals("history-cache")) {
						webview1.clearCache(true);
						webview1.clearHistory();
						if (!homepage.getString("homepage", "").equals("")) {
							webview1.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
							webview1.loadUrl(homepage.getString("homepage", ""));
						}
						else {
							if (!url.getString("url", "").equals("")) {
								webview1.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
								webview1.loadUrl(url.getString("url", ""));
							}
							else {
								webview1.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
								webview1.loadUrl("https://www.google.com");
							}
						}
						_showNotification("Explorer Cleaner", massage_notif);
					}
				}
			}
		}
		if (FileUtil.isExistFile(FileUtil.getExternalStorageDir().concat("/Webview/Download"))) {
			
		}
		else {
			FileUtil.makeDir(FileUtil.getExternalStorageDir().concat("/Webview/Download"));
		}
		swiperefreshlayout1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				webview1.reload();
			}
		});
		edittext2.setVisibility(View.GONE);
		linear6.setVisibility(View.GONE);
		_download_to("/webview download");
		_webzoominzoomout();
		_opening();
		_Text_size();
		if (cookies.getString("cookies", "").equals("true")) {
			CookieManager.getInstance().setAcceptCookie(true);
		}
		else {
			CookieManager.getInstance().setAcceptCookie(false);
		}
		if (shared.getString("search engine", "").equals("")) {
			shared.edit().putString("search engine", "https://www.google.com/search?q=").commit();
		}
		if (run.getString("runhtml", "").equals("on")) {
			imageview16.setVisibility(View.VISIBLE);
		}
		else {
			imageview16.setVisibility(View.GONE);
		}
		//Reloads the settings every 1.5 second instead of launching a new mainactivity
		width = Math.round(SketchwareUtil.getDisplayWidthPixels(getApplicationContext()));
		View a = getWindow().getDecorView();
		a.setSystemUiVisibility(0);
		reloader = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						_darkmode();
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(reloader, (int)(0), (int)(1500));
		webview1.setFindListener(new WebView.FindListener() {
			@Override
			public void onFindResultReceived(int actionMatchOrdinal, int numberOfMatches, boolean isDoneCounting) {
				TotalItems = numberOfMatches;
				FoundItems = isDoneCounting;
				 
			}
		});
		if (flowe.getString("flagfollowsystem", "").equals("")) {
			if (Double.parseDouble(Build.VERSION.SDK) > 27) {
				flowe.edit().putString("flagfollowsystem", "1").commit();
			}
			else {
				flowe.edit().putString("flagfollowsystem", "0").commit();
			}
		}
		else {
			
		}
		if (Double.parseDouble(Build.VERSION.SDK) > 27) {
			//Checks so that if its above android 9 then turns on follow system
			check = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							if (flowe.getString("flagfollowsystem", "").equals("1")) {
								switch (getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) {
									    case Configuration.UI_MODE_NIGHT_YES:
									mode.edit().putString("darkmode", "true").commit();
									
									        break;
									    case Configuration.UI_MODE_NIGHT_NO:
									mode.edit().putString("darkmode", "false").commit();
									break; 
								}
							}
							else {
								
							}
						}
					});
				}
			};
			_timer.scheduleAtFixedRate(check, (int)(0), (int)(500));
		}
		else {
			
		}
		EditText editText = (EditText)findViewById(R.id.edittext1); editText.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				boolean handled = false;
				if (actionId == EditorInfo.IME_ACTION_GO) {
					_loadurl();
					_hideSoftKeyboard(edittext1);
					handled = true;
				}
				return handled;
			}
		});
		_CheckWifiMobileData();
		_DynamicShortcuts();
		imageview1.setVisibility(View.GONE);
		_circleRipple("#9E9E9E", imageview17);
		_circleRipple("#9E9E9E", imageview21);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			case REQ_CD_FP:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
			}
			break;
			
			case REQUEST_SELECT_FILE:
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
				if (uploadMessage == null) return; uploadMessage.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(_resultCode, _data)); uploadMessage = null; }
			break;
			
			case FILECHOOSER_RESULTCODE:
			if (null == mUploadMessage){
				return; }
			Uri result = _data == null || _resultCode != RESULT_OK ? null : _data.getData(); mUploadMessage.onReceiveValue(result);
			mUploadMessage = null;
			
			if (true){
			}
			else {
				
			}
			break;
			
			case REQ_CD_RUNHTML:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				if (_filePath.get((int)(0)).endsWith(".html")) {
					path = _filePath.get((int)(0));
					webview1.loadUrl("file:///" + path);
				}
				else {
					
				}
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		if (webview1.canGoBack()) {
			webview1.goBack();
		}
		else {
			finish();
		}
	}
	
	public void _webzoominzoomout () {
		webview1.getSettings().setBuiltInZoomControls(true);webview1.getSettings().setDisplayZoomControls(false);
	}
	
	
	public void _download_to (final String _path) {
		if (FileUtil.isExistFile(_path)) {
			
		}
		else {
			FileUtil.makeDir(_path);
		}
		webview1.setDownloadListener(new DownloadListener() {
			
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
			
			if (MainActivity.this == null) {
				
				return null; }
			
			return BitmapFactory.decodeResource(MainActivity.this.getApplicationContext().getResources(), 2130837573); }
		
		
		public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback viewCallback) {
			
			if (this.mCustomView != null) {
				
				onHideCustomView();
				
				return; }
			
			this.mCustomView = paramView;
			
			this.mOriginalSystemUiVisibility = MainActivity.this.getWindow().getDecorView().getSystemUiVisibility();
			
			// When CustomView is shown screen orientation changes to mOriginalOrientation (Landscape).
			MainActivity.this.setRequestedOrientation(this.mOriginalOrientation);
			
			// After that mOriginalOrientation is set to portrait.
			
			this.mOriginalOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
			
			this.mCustomViewCallback = viewCallback; ((FrameLayout)MainActivity.this.getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1)); MainActivity.this.getWindow().getDecorView().setSystemUiVisibility(3846);
			
		}
		
		
		public void onHideCustomView() {
			
			((FrameLayout)MainActivity.this.getWindow().getDecorView()).removeView(this.mCustomView);
			
			this.mCustomView = null;
			
			MainActivity.this.getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
			
			// When CustomView is hidden, screen orientation is set to mOriginalOrientation (portrait).
			
			
			
			MainActivity.this.setRequestedOrientation(this.mOriginalOrientation);
			
			
			
			// After that mOriginalOrientation is set to landscape.
			
			
			
			this.mOriginalOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE; this.mCustomViewCallback.onCustomViewHidden();
			
			this.mCustomViewCallback = null;
			
		}
		
	}
	
	
	{
	}
	
	
	public void _nothing () {
		
	}
	@Override public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo){ super.onCreateContextMenu(contextMenu, view, contextMenuInfo); final WebView.HitTestResult webViewHitTestResult = webview1.getHitTestResult(); if (webViewHitTestResult.getType() == WebView.HitTestResult.IMAGE_TYPE || webViewHitTestResult.getType() == WebView.HitTestResult.SRC_IMAGE_ANCHOR_TYPE) { contextMenu.setHeaderTitle("Download Image From Below"); contextMenu.add(0, 1, 0, "Save - Download Image") .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { @Override public boolean onMenuItemClick(MenuItem menuItem) { String DownloadImageURL = webViewHitTestResult.getExtra(); if(URLUtil.isValidUrl(DownloadImageURL)){ DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadImageURL)); request.allowScanningByMediaScanner();
						request.setTitle("download.png");
						request.setDestinationInExternalPublicDir("/Webview/Download", "download.png"); request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE); downloadManager.enqueue(request); Toast.makeText(MainActivity.this,"Image Downloaded Successfully.",Toast.LENGTH_LONG).show(); } else { Toast.makeText(MainActivity.this,"Sorry.. Something Went Wrong.",Toast.LENGTH_LONG).show(); } return false; } }); }
	}
	
	
	public void _upload () {
	}
	private ValueCallback<Uri> mUploadMessage;
	public ValueCallback<Uri[]> uploadMessage;
	public static final int REQUEST_SELECT_FILE = 100;
	private final static int FILECHOOSER_RESULTCODE = 1;
	{
	}
	
	
	public void _card_style (final View _view, final double _shadow, final double _rounds, final String _colour) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_colour));
		gd.setCornerRadius((int)_rounds);
		_view.setBackground(gd);
		_view.setElevation((int)_shadow);
	}
	
	
	public void _loadurl () {
		V.vibrate((long)(100));
		imageview1.setVisibility(View.GONE);
		if ((edittext1.getText().toString().indexOf("http://") == 0) || (edittext1.getText().toString().indexOf("https://") == 0)) {
			webview1.loadUrl(edittext1.getText().toString());
		}
		else {
			if (edittext1.getText().toString().indexOf("www.") == 0) {
				webview1.loadUrl("http://".concat(edittext1.getText().toString()));
			}
			else {
				webview1.loadUrl(shared.getString("search engine", "").concat(edittext1.getText().toString()));
			}
		}
	}
	
	
	public void _hideSoftKeyboard (final View _view) {
		InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE); inputMethodManager.hideSoftInputFromWindow(_view.getWindowToken(), 0);
	}
	
	
	public void _opening () {
		textview1.setVisibility(View.VISIBLE);
		edittext1.setVisibility(View.GONE);
		edittext1.setAlpha((float)(0.0d));
		textopening = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						textview1.setAlpha((float)(0.9d));
						textopening = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										textview1.setAlpha((float)(0.8d));
										textopening = new TimerTask() {
											@Override
											public void run() {
												runOnUiThread(new Runnable() {
													@Override
													public void run() {
														textview1.setAlpha((float)(0.7d));
														textopening = new TimerTask() {
															@Override
															public void run() {
																runOnUiThread(new Runnable() {
																	@Override
																	public void run() {
																		textview1.setAlpha((float)(0.6d));
																		textopening = new TimerTask() {
																			@Override
																			public void run() {
																				runOnUiThread(new Runnable() {
																					@Override
																					public void run() {
																						textview1.setAlpha((float)(0.5d));
																						textopening = new TimerTask() {
																							@Override
																							public void run() {
																								runOnUiThread(new Runnable() {
																									@Override
																									public void run() {
																										textview1.setAlpha((float)(0.4d));
																										textopening = new TimerTask() {
																											@Override
																											public void run() {
																												runOnUiThread(new Runnable() {
																													@Override
																													public void run() {
																														textview1.setAlpha((float)(0.3d));
																														textopening = new TimerTask() {
																															@Override
																															public void run() {
																																runOnUiThread(new Runnable() {
																																	@Override
																																	public void run() {
																																		textview1.setAlpha((float)(0.2d));
																																		textopening = new TimerTask() {
																																			@Override
																																			public void run() {
																																				runOnUiThread(new Runnable() {
																																					@Override
																																					public void run() {
																																						textview1.setAlpha((float)(0.1d));
																																						textopening = new TimerTask() {
																																							@Override
																																							public void run() {
																																								runOnUiThread(new Runnable() {
																																									@Override
																																									public void run() {
																																										textview1.setAlpha((float)(0.0d));
																																										textopening = new TimerTask() {
																																											@Override
																																											public void run() {
																																												runOnUiThread(new Runnable() {
																																													@Override
																																													public void run() {
																																														textview1.setVisibility(View.GONE);
																																														edittext1.setVisibility(View.VISIBLE);
																																														textopening = new TimerTask() {
																																															@Override
																																															public void run() {
																																																runOnUiThread(new Runnable() {
																																																	@Override
																																																	public void run() {
																																																		edittext1.setAlpha((float)(0.1d));
																																																		textopening = new TimerTask() {
																																																			@Override
																																																			public void run() {
																																																				runOnUiThread(new Runnable() {
																																																					@Override
																																																					public void run() {
																																																						edittext1.setAlpha((float)(0.2d));
																																																						textopening = new TimerTask() {
																																																							@Override
																																																							public void run() {
																																																								runOnUiThread(new Runnable() {
																																																									@Override
																																																									public void run() {
																																																										edittext1.setAlpha((float)(0.3d));
																																																										textopening = new TimerTask() {
																																																											@Override
																																																											public void run() {
																																																												runOnUiThread(new Runnable() {
																																																													@Override
																																																													public void run() {
																																																														edittext1.setAlpha((float)(0.4d));
																																																														textopening = new TimerTask() {
																																																															@Override
																																																															public void run() {
																																																																runOnUiThread(new Runnable() {
																																																																	@Override
																																																																	public void run() {
																																																																		edittext1.setAlpha((float)(0.5d));
																																																																		textopening = new TimerTask() {
																																																																			@Override
																																																																			public void run() {
																																																																				runOnUiThread(new Runnable() {
																																																																					@Override
																																																																					public void run() {
																																																																						edittext1.setAlpha((float)(0.6d));
																																																																						textopening = new TimerTask() {
																																																																							@Override
																																																																							public void run() {
																																																																								runOnUiThread(new Runnable() {
																																																																									@Override
																																																																									public void run() {
																																																																										edittext1.setAlpha((float)(0.7d));
																																																																										textopening = new TimerTask() {
																																																																											@Override
																																																																											public void run() {
																																																																												runOnUiThread(new Runnable() {
																																																																													@Override
																																																																													public void run() {
																																																																														edittext1.setAlpha((float)(0.8d));
																																																																														textopening = new TimerTask() {
																																																																															@Override
																																																																															public void run() {
																																																																																runOnUiThread(new Runnable() {
																																																																																	@Override
																																																																																	public void run() {
																																																																																		edittext1.setAlpha((float)(0.9d));
																																																																																		textopening = new TimerTask() {
																																																																																			@Override
																																																																																			public void run() {
																																																																																				runOnUiThread(new Runnable() {
																																																																																					@Override
																																																																																					public void run() {
																																																																																						edittext1.setAlpha((float)(1.0d));
																																																																																					}
																																																																																				});
																																																																																			}
																																																																																		};
																																																																																		_timer.schedule(textopening, (int)(90));
																																																																																	}
																																																																																});
																																																																															}
																																																																														};
																																																																														_timer.schedule(textopening, (int)(90));
																																																																													}
																																																																												});
																																																																											}
																																																																										};
																																																																										_timer.schedule(textopening, (int)(90));
																																																																									}
																																																																								});
																																																																							}
																																																																						};
																																																																						_timer.schedule(textopening, (int)(90));
																																																																					}
																																																																				});
																																																																			}
																																																																		};
																																																																		_timer.schedule(textopening, (int)(90));
																																																																	}
																																																																});
																																																															}
																																																														};
																																																														_timer.schedule(textopening, (int)(90));
																																																													}
																																																												});
																																																											}
																																																										};
																																																										_timer.schedule(textopening, (int)(90));
																																																									}
																																																								});
																																																							}
																																																						};
																																																						_timer.schedule(textopening, (int)(90));
																																																					}
																																																				});
																																																			}
																																																		};
																																																		_timer.schedule(textopening, (int)(90));
																																																	}
																																																});
																																															}
																																														};
																																														_timer.schedule(textopening, (int)(90));
																																													}
																																												});
																																											}
																																										};
																																										_timer.schedule(textopening, (int)(90));
																																									}
																																								});
																																							}
																																						};
																																						_timer.schedule(textopening, (int)(90));
																																					}
																																				});
																																			}
																																		};
																																		_timer.schedule(textopening, (int)(90));
																																	}
																																});
																															}
																														};
																														_timer.schedule(textopening, (int)(90));
																													}
																												});
																											}
																										};
																										_timer.schedule(textopening, (int)(90));
																									}
																								});
																							}
																						};
																						_timer.schedule(textopening, (int)(90));
																					}
																				});
																			}
																		};
																		_timer.schedule(textopening, (int)(90));
																	}
																});
															}
														};
														_timer.schedule(textopening, (int)(90));
													}
												});
											}
										};
										_timer.schedule(textopening, (int)(90));
									}
								});
							}
						};
						_timer.schedule(textopening, (int)(90));
					}
				});
			}
		};
		_timer.schedule(textopening, (int)(1000));
	}
	
	
	public void _darkmode () {
		View a = getWindow().getDecorView();
		a.setSystemUiVisibility(0);
		if (mode.getString("darkmode", "").equals("true")) {
			if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK));
			WebSettingsCompat.setForceDark(webview1.getSettings(), WebSettingsCompat.FORCE_DARK_ON);
			edittext1.setTextColor(0xFFFFFFFF);
			textview1.setTextColor(0xFFFFFFFF);
			linear3.setBackgroundColor(0xFF212121);
			prog.setBackgroundColor(0xFF212121);
			imageview1.setImageResource(R.drawable.ic_edit_white);
			imageview15.setImageResource(R.drawable.ic_keyboard_voice_white);
			imageview16.setImageResource(R.drawable.ic_play_arrow_white);
			open_lock.setImageResource(R.drawable.ic_warning_white);
			lock.setImageResource(R.drawable.ic_lock_outline_white);
			Dia_lock_site = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
			textview3.setTextColor(0xFFFFFFFF);
			linear6.setBackgroundColor(0xFF212121);
			edittext2.setTextColor(0xFFFFFFFF);
			linear.setBackgroundColor(0xFF212121);
			imageview17.setImageResource(R.drawable.ic_home_white);
			home = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
			imageview20.setImageResource(R.drawable.ic_chevron_left_white);
			imageview21.setImageResource(R.drawable.ic_more_vert_white);
			if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
				Window w =MainActivity.this.getWindow();
				w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
				w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFF000000);
			}
		}
		else {
			if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK));
			WebSettingsCompat.setForceDark(webview1.getSettings(), WebSettingsCompat.FORCE_DARK_OFF);
			linear.setBackgroundColor(0xFFFFFFFF);
			edittext1.setTextColor(0xFF000000);
			textview1.setTextColor(0xFF9E9E9E);
			prog.setBackgroundColor(0xFFFFFFFF);
			linear3.setBackgroundColor(0xFFFFFFFF);
			imageview1.setImageResource(R.drawable.ic_edit_black);
			imageview15.setImageResource(R.drawable.ic_keyboard_voice_black);
			imageview16.setImageResource(R.drawable.ic_play_arrow_black);
			open_lock.setImageResource(R.drawable.ic_warning_black);
			lock.setImageResource(R.drawable.ic_lock_outline_black);
			Dia_lock_site = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
			textview3.setTextColor(0xFF000000);
			linear6.setBackgroundColor(0xFFFFFFFF);
			edittext2.setTextColor(0xFF000000);
			imageview17.setImageResource(R.drawable.ic_home_black);
			home = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
			imageview20.setImageResource(R.drawable.ic_chevron_left_black);
			imageview21.setImageResource(R.drawable.ic_more_vert_black);
			getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
			getWindow().setStatusBarColor(0xFFFFFFFF);
			if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
				Window w =MainActivity.this.getWindow();
				w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
				w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFFFFFFFF);
			}
		}
		_searchBarUI();
	}
	
	
	public void _language () {
		if (Locale.getDefault().getDisplayLanguage().equals("English")) {
			toast = "Listening...";
			lock_site = "The connection is secure.";
			open_lock_site = "The connection is not secure\n\nYou should not enter any sensitive information such as (password or credit card) on this site, as it may be stolen by attackers.";
			OK = "OK";
			copy = "The link was copied to the clipboard";
			found = "Found";
			homelink = "URL";
			title_home = "set home page url";
			set = "Set";
			cancel = "Cancel";
			if (clear.getString("cleaner", "").equals("cache")) {
				massage_notif = "Web cache cleared";
			}
			else {
				if (clear.getString("cleaner", "").equals("history")) {
					massage_notif = "Web history cleared";
				}
				else {
					if (clear.getString("cleaner", "").equals("history-cache")) {
						massage_notif = "Web history and cache cleared";
					}
					else {
						
					}
				}
			}
			notsupport = "This feature requires Android 5 or above.";
			edittext1.setHint("Search Or Type URL ");
			edittext2.setHint("Find on Page");
			s.edit().putString("language", "english").commit();
		}
		else {
			if (Locale.getDefault().getDisplayLanguage().equals("فارسی")) {
				toast = "در حال گوش دادن ...";
				lock_site = "اتصال امن است.";
				open_lock_site = "اتصال امن نیست\n\nشما نباید هیچ اطلاعات حساسی مانند ( گذرواژه یا کارت اعتباری ) را در این سایت وارد کنید ، زیرا ممکن است مهاجمین آن ها را سرقت کنند.";
				OK = "باشه ";
				copy = "پیوند در کلیپ بورد کپی شد";
				found = "یافت شد ";
				homelink = "پیوند";
				title_home = "تنظیم پیوند صفحه اصلی";
				set = "تنظیم";
				cancel = "لغو";
				notsupport = "این ویژگی به اندروید 5 یا بالاتر نیاز دارد.";
				if (clear.getString("cleaner", "").equals("cache")) {
					massage_notif = "حافظه پنهان وب پاک شد";
				}
				else {
					if (clear.getString("cleaner", "").equals("history")) {
						massage_notif = "تاریخچه وب پاک شد";
					}
					else {
						if (clear.getString("cleaner", "").equals("history-cache")) {
							massage_notif = "تاریخچه و حافظه پنهان وب پاک شد";
						}
						else {
							
						}
					}
				}
				edittext1.setHint("جستجو یا نوشتن پیوند ");
				edittext2.setHint("یافتن در صفحه");
				s.edit().putString("language", "persian").commit();
			}
			else {
				if (Locale.getDefault().getDisplayLanguage().equals("简体中文")) {
					toast = "听...";
					lock_site = "连接是安全的";
					open_lock_site = "连接不安全\n\n您不应在此站点上输入任何敏感信息，例如（密码或信用卡），因为它可能被攻击者窃取。";
					OK = "好的 ";
					copy = "链接已复制到剪贴板";
					found = "成立";
					homelink = "网址";
					title_home = "设置主页网址";
					set = "放";
					cancel = "取消";
					notsupport = "此功能需要 Android 5 或更高版本。";
					if (clear.getString("cleaner", "").equals("cache")) {
						massage_notif = "网络缓存已清除";
					}
					else {
						if (clear.getString("cleaner", "").equals("history")) {
							massage_notif = "网络历史记录已清除";
						}
						else {
							if (clear.getString("cleaner", "").equals("history-cache")) {
								massage_notif = "网络历史记录和缓存已清除";
							}
							else {
								
							}
						}
					}
					edittext1.setHint("搜索或编写链接\n");
					edittext2.setHint("在页面上查找");
					s.edit().putString("language", "china").commit();
				}
				else {
					toast = "Listening...";
					lock_site = "The connection is secure.";
					open_lock_site = "The connection is not secure\n\nYou should not enter any sensitive information such as (password or credit card) on this site, as it may be stolen by attackers.";
					OK = "OK";
					copy = "The link was copied to the clipboard";
					found = "Found";
					homelink = "URL";
					set = "Set";
					cancel = "Cancel";
					notsupport = "This feature requires Android 5 or above.";
					if (clear.getString("cleaner", "").equals("cache")) {
						massage_notif = "Web cache cleared";
					}
					else {
						if (clear.getString("cleaner", "").equals("history")) {
							massage_notif = "Web history cleared";
						}
						else {
							if (clear.getString("cleaner", "").equals("history-cache")) {
								massage_notif = "Web history and cache cleared";
							}
							else {
								
							}
						}
					}
				}
			}
		}
	}
	
	
	public void _Text_size () {
		if (size.getString("size", "").equals("default")) {
			
		}
		else {
			if (size.getString("size", "").equals("50")) {
				WebSettings webSettings = webview1.getSettings(); 
				webSettings.setTextZoom((int)50); 
			}
			else {
				if (size.getString("size", "").equals("60")) {
					WebSettings webSettings = webview1.getSettings(); 
					webSettings.setTextZoom((int)60); 
				}
				else {
					if (size.getString("size", "").equals("70")) {
						WebSettings webSettings = webview1.getSettings(); 
						webSettings.setTextZoom((int)70); 
					}
					else {
						if (size.getString("size", "").equals("80")) {
							WebSettings webSettings = webview1.getSettings(); 
							webSettings.setTextZoom((int)80); 
						}
						else {
							if (size.getString("size", "").equals("90")) {
								WebSettings webSettings = webview1.getSettings(); 
								webSettings.setTextZoom((int)90); 
							}
							else {
								if (size.getString("size", "").equals("100")) {
									WebSettings webSettings = webview1.getSettings(); 
									webSettings.setTextZoom((int)100); 
								}
								else {
									if (size.getString("size", "").equals("110")) {
										WebSettings webSettings = webview1.getSettings(); 
										webSettings.setTextZoom((int)110); 
									}
									else {
										if (size.getString("size", "").equals("120")) {
											WebSettings webSettings = webview1.getSettings(); 
											webSettings.setTextZoom((int)120); 
										}
										else {
											if (size.getString("size", "").equals("130")) {
												WebSettings webSettings = webview1.getSettings(); 
												webSettings.setTextZoom((int)130); 
											}
											else {
												if (size.getString("size", "").equals("140")) {
													WebSettings webSettings = webview1.getSettings(); 
													webSettings.setTextZoom((int)140); 
												}
												else {
													if (size.getString("size", "").equals("150")) {
														WebSettings webSettings = webview1.getSettings(); 
														webSettings.setTextZoom((int)150); 
													}
													else {
														
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	
	public void _CheckWifiMobileData () {
		android.net.ConnectivityManager cm = (android.net.ConnectivityManager) this.getSystemService(android.content.Context.CONNECTIVITY_SERVICE);
		android.net.NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
		
		if ((activeNetwork != null)) {
			// online
			if ((activeNetwork.getType() == android.net.ConnectivityManager.TYPE_WIFI) || (activeNetwork.getType() == android.net.ConnectivityManager.TYPE_MOBILE)) {
				// online
			}
		}
		else {
			//offline
			no_net = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							change.setAction(Intent.ACTION_VIEW);
							change.setClass(getApplicationContext(), NoInternetActivity.class);
							startActivity(change);
						}
					});
				}
			};
			_timer.schedule(no_net, (int)(950));
		}
	}
	
	
	public void _DynamicShortcuts () {
		if (Locale.getDefault().getDisplayLanguage().equals("English")) {
			shortcut_download = "Downloads";
			shortcut_downloadLong = "Open Downloads";
			shortcut_settings = "Settings";
			shortcut_settingsLong = "Open Settings";
		}
		else {
			if (Locale.getDefault().getDisplayLanguage().equals("فارسی")) {
				shortcut_download = "بارگیری ها";
				shortcut_downloadLong = "بازکردن بارگیری ها";
				shortcut_settings = "تنظیمات";
				shortcut_settingsLong = "بازکردن تنظیمات";
			}
			else {
				if (Locale.getDefault().getDisplayLanguage().equals("简体中文")) {
					shortcut_download = "下载";
					shortcut_downloadLong = "打开下载";
					shortcut_settings = "设置";
					shortcut_settingsLong = "打开设置";
				}
				else {
					shortcut_download = "Downloads";
					shortcut_downloadLong = "Open Downloads";
					shortcut_settings = "Settings";
					shortcut_settingsLong = "Open Settings";
				}
			}
		}
		android.content.pm.ShortcutManager shortcutManager = null;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
			shortcutManager = getSystemService(android.content.pm.ShortcutManager.class);
		}
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			if (shortcutManager != null) {
				android.content.pm.ShortcutInfo downloadshortcut = new android.content.pm.ShortcutInfo.Builder(MainActivity.this, "download")
									.setShortLabel(shortcut_download)
									.setLongLabel(shortcut_downloadLong)
									.setRank(0)
									.setIntent(new android.content.Intent(android.content.Intent.ACTION_VIEW, null, MainActivity.this, DownloadActivity.class))
									.setIcon(android.graphics.drawable.Icon.createWithResource(MainActivity.this, R.drawable.download))
									.build();
				android.content.pm.ShortcutInfo settingsshortcut = new android.content.pm.ShortcutInfo.Builder(MainActivity.this, "settings")
									.setShortLabel(shortcut_settings)
									.setLongLabel(shortcut_settingsLong)
									.setRank(1)
									.setIntent(new android.content.Intent(android.content.Intent.ACTION_VIEW, null, MainActivity.this, SettingsActivity.class))
									.setIcon(android.graphics.drawable.Icon.createWithResource(MainActivity.this, R.drawable.settings))
									.build();
				shortcutManager.setDynamicShortcuts(java.util.Arrays.asList(downloadshortcut, settingsshortcut));
			}
		}
		else {
			Toast.makeText(getApplicationContext(), "Pinned shortcuts are not supported!", Toast.LENGTH_SHORT).show();
		}
	}
	
	
	public void _extra () {
	}
	
	android.print.PrintJob printJob;
	
	
	
	@androidx.annotation.RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	
	private void PrintTheWebPage(WebView webView) {
		
		android.print.PrintManager printManager = (android.print.PrintManager) this.getSystemService(Context.PRINT_SERVICE);
		
		String jobName = "[Created By Explorer]" + webView.getUrl();
		
		android.print.PrintDocumentAdapter printAdapter = webView.createPrintDocumentAdapter(jobName);
		
		assert printManager != null;
		
		printJob = printManager.print(jobName, printAdapter, new android.print.PrintAttributes.Builder().build());
		
	}
	
	{
	}
	
	
	public void _searchBarUI () {
		if (mode.getString("darkmode", "").equals("true")) {
			_rippleRoundStroke(linear1, "#000000", "#000000", 18, 2.5d, "#9E9E9E");
		}
		else {
			_rippleRoundStroke(linear1, "#FFFFFF", "#000000", 18, 2.5d, "#E0E0E0");
		}
	}
	
	
	public void _circleRipple (final String _color, final View _v) {
		android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor(_color)});
		android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrb , null, null);
		_v.setBackground(ripdrb);
	}
	
	
	public void _createChannel () {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			CharSequence name = "Channel name 1";
			String description = "Notification channel";
			int importance = NotificationManager.IMPORTANCE_MAX;
			NotificationChannel channel = new NotificationChannel("id 1", name, importance);
			channel.setDescription(description);
			
			NotificationManager notificationManager = getSystemService(NotificationManager.class);
			notificationManager.createNotificationChannel(channel);
			
		}
	}
	
	
	public void _showNotification (final String _title, final String _message) {
		
		androidx.core.app.NotificationCompat.Builder builder = new androidx.core.app.NotificationCompat.Builder(MainActivity.this, "id 1")
		.setSmallIcon(R.drawable.cleaner)
		.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
		.setContentTitle(_title)
		.setContentText(_message)
		.setPriority(androidx.core.app.NotificationCompat.PRIORITY_MAX)
		
		.setAutoCancel(true);
		
		androidx.core.app.NotificationManagerCompat notificationManager = androidx.core.app.NotificationManagerCompat.from(MainActivity.this);
		notificationManager.notify(1, builder.build());
	}
	
	
	public void _Popup () {
		View popupView = getLayoutInflater().inflate(R.layout.popup, null);
		
		//popup is the name of your custom view
		
		final PopupWindow popup = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
		TextView text1 = popupView.findViewById(R.id.text1);
		
		TextView text2 = popupView.findViewById(R.id.text2);
		
		TextView text3 = popupView.findViewById(R.id.text3);
		
		TextView text4 = popupView.findViewById(R.id.text4);
		
		
		LinearLayout line_popup = popupView.findViewById(R.id.line_popup);
		
		LinearLayout line_Download = popupView.findViewById(R.id.line_Download);
		
		LinearLayout line_find = popupView.findViewById(R.id.line_find);
		
		LinearLayout line_pdf = popupView.findViewById(R.id.line_pdf);
		
		LinearLayout line_settings = popupView.findViewById(R.id.line_settings);
		
		LinearLayout line_div1 = popupView.findViewById(R.id.line_div1);
		
		LinearLayout line_div2 = popupView.findViewById(R.id.line_div2);
		
		LinearLayout line_div3 = popupView.findViewById(R.id.line_div3);
		line_Download.setOnClickListener(new OnClickListener() { public void onClick(View view) {
				d.setClass(getApplicationContext(), DownloadActivity.class);
				startActivity(d);
				popup.dismiss();
			} });
		
		line_find.setOnClickListener(new OnClickListener() { public void onClick(View view) {
				linear6.setVisibility(View.VISIBLE);
				edittext2.setVisibility(View.VISIBLE);
				edittext1.setVisibility(View.GONE);
				popup.dismiss();
			} });
		
		line_pdf.setOnClickListener(new OnClickListener() { public void onClick(View view) {
				//print web page
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
					PrintTheWebPage(webview1);
				}
				else {
					showMessage(notsupport);
				}
				popup.dismiss();
			} });
		
		line_settings.setOnClickListener(new OnClickListener() { public void onClick(View view) {
				settings.setClass(getApplicationContext(), SettingsActivity.class);
				startActivity(settings);
				popup.dismiss();
			} });
		
		if (mode.getString("darkmode", "").equals("true")) {
			android.graphics.drawable.GradientDrawable round = new android.graphics.drawable.GradientDrawable ();
			round.setColor (Color.parseColor("#2E2F32"));
			
			round.setCornerRadius (20);
			
			line_popup.setBackground (round);
			
			line_popup.setElevation(8);
			
			text1.setTextColor(0xFFFFFFFF);
			text2.setTextColor(0xFFFFFFFF);
			text3.setTextColor(0xFFFFFFFF);
			text4.setTextColor(0xFFFFFFFF);
			
			line_div1.setBackgroundColor(0xFF202124);
			line_div2.setBackgroundColor(0xFF202124);
			line_div3.setBackgroundColor(0xFF202124);
		}
		else {
			android.graphics.drawable.GradientDrawable round2 = new android.graphics.drawable.GradientDrawable ();
			round2.setColor (Color.parseColor("#FFFFFF"));
			
			round2.setCornerRadius (20);
			
			line_popup.setBackground (round2);
			
			line_popup.setElevation(8);
			
			text1.setTextColor(0xFF616161);
			text2.setTextColor(0xFF616161);
			text3.setTextColor(0xFF616161);
			text4.setTextColor(0xFF616161);
			
			line_div1.setBackgroundColor(0xFFF1F3F4);
			line_div2.setBackgroundColor(0xFFF1F3F4);
			line_div3.setBackgroundColor(0xFFF1F3F4);
		}
		popup.setAnimationStyle(android.R.style.Animation_Dialog);
		
		popup.showAsDropDown(imageview21, 0,0);
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