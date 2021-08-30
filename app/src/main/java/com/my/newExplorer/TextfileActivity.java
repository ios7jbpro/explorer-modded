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
import android.widget.ScrollView;
import android.widget.ImageView;
import android.widget.EditText;
import android.app.Activity;
import android.content.SharedPreferences;
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


public class TextfileActivity extends AppCompatActivity {
	
	private LinearLayout linear3;
	private ScrollView vscroll1;
	private ImageView imageview1;
	private LinearLayout linear4;
	private ImageView un;
	private ImageView re;
	private LinearLayout linear2;
	private EditText edittext1;
	
	private SharedPreferences fileview;
	private SharedPreferences mode;
	private Intent i = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.textfile);
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
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		un = (ImageView) findViewById(R.id.un);
		re = (ImageView) findViewById(R.id.re);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		fileview = getSharedPreferences("fileview", Activity.MODE_PRIVATE);
		mode = getSharedPreferences("mode", Activity.MODE_PRIVATE);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.writeFile(fileview.getString("data", ""), edittext1.getText().toString());
				i.setClass(getApplicationContext(), DownloadActivity.class);
				startActivity(i);
				finish();
			}
		});
	}
	
	private void initializeLogic() {
		_editUndoRedo(edittext1, un, re);
		if (!fileview.getString("data", "").equals("")) {
			if (fileview.getString("data", "").endsWith(".html")) {
				_SpanText("#42A5F5", "#F1BE49", "#26A69A", "#FF1744", "#9E9E9E", edittext1);
				edittext1.setText(FileUtil.readFile(fileview.getString("data", "")));
			}
			else {
				if (fileview.getString("data", "").endsWith(".java")) {
					_setHighlighter(edittext1);
					edittext1.setText(FileUtil.readFile(fileview.getString("data", "")));
				}
				else {
					edittext1.setText(FileUtil.readFile(fileview.getString("data", "")));
				}
			}
		}
		else {
			
		}
		View a = getWindow().getDecorView();
		a.setSystemUiVisibility(0);
		if (mode.getString("darkmode", "").equals("true")) {
			vscroll1.setBackgroundColor(0xFF212121);
			edittext1.setTextColor(0xFFFFFFFF);
			linear2.setBackgroundColor(0xFF212121);
			linear3.setBackgroundColor(0xFF212121);
			un.setImageResource(R.drawable.ic_undo_white);
			re.setImageResource(R.drawable.ic_redo_white);
			imageview1.setImageResource(R.drawable.ic_save_white);
			if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
				Window w =TextfileActivity.this.getWindow();
				w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
				w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFF000000);
			}
		}
		else {
			vscroll1.setBackgroundColor(0xFFFFFFFF);
			edittext1.setTextColor(0xFF000000);
			linear2.setBackgroundColor(0xFFFFFFFF);
			linear3.setBackgroundColor(0xFFFFFFFF);
			un.setImageResource(R.drawable.ic_undo_black);
			re.setImageResource(R.drawable.ic_redo_black);
			imageview1.setImageResource(R.drawable.ic_save_black);
			getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
			getWindow().setStatusBarColor(0xFFFFFFFF);
			if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
				Window w =TextfileActivity.this.getWindow();
				w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
				w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFFFFFFFF);
			}
		}
		_circleRipple("#9E9E9E", imageview1);
		_circleRipple("#9E9E9E", un);
		_circleRipple("#9E9E9E", re);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _editUndoRedo (final TextView _edittext, final View _undo, final View _redo) {
		final TextViewUndoRedo helper = new TextViewUndoRedo(_edittext);
		_undo.setOnClickListener (new View.OnClickListener() {
			@Override
			          public void onClick(View v) {
				            helper.undo();
				          }
		});
		_redo.setOnClickListener (new View.OnClickListener() {
			@Override
			          public void onClick(View v) {
				            helper.redo();
				          }
		});
	}
	public class TextViewUndoRedo {
			
			private boolean mIsUndoOrRedo = false;
			private EditHistory mEditHistory;
			private EditTextChangeListener mChangeListener;
			private TextView mTextView;
		
			
			public TextViewUndoRedo(TextView textView) {
					mTextView = textView;
					mEditHistory = new EditHistory();
					mChangeListener = new EditTextChangeListener();
					mTextView.addTextChangedListener(mChangeListener);
			}
		
			public void disconnect() {
					mTextView.removeTextChangedListener(mChangeListener);
			}
		
			public void setMaxHistorySize(int maxHistorySize) {
					mEditHistory.setMaxHistorySize(maxHistorySize);
			}
		
			public void clearHistory() {
					mEditHistory.clear();
			}
		
			
			public boolean getCanUndo() {
					return (mEditHistory.mmPosition > 0);
			}
		
			public void undo() {
					EditItem edit = mEditHistory.getPrevious();
					if (edit == null) {
							return;
					}
			
					Editable text = mTextView.getEditableText();
					int start = edit.mmStart;
					int end = start + (edit.mmAfter != null ? edit.mmAfter.length() : 0);
			
					mIsUndoOrRedo = true;
					text.replace(start, end, edit.mmBefore);
					mIsUndoOrRedo = false;
			
					for (Object o : text.getSpans(0, text.length(), android.text.style.UnderlineSpan.class)) {
							text.removeSpan(o);
					}
			
					Selection.setSelection(text, edit.mmBefore == null ? start
							: (start + edit.mmBefore.length()));
			}
		
			public boolean getCanRedo() {
					return (mEditHistory.mmPosition < mEditHistory.mmHistory.size());
			}
		
			public void redo() {
					EditItem edit = mEditHistory.getNext();
					if (edit == null) {
							return;
					}
			
					Editable text = mTextView.getEditableText();
					int start = edit.mmStart;
					int end = start + (edit.mmBefore != null ? edit.mmBefore.length() : 0);
			
					mIsUndoOrRedo = true;
					text.replace(start, end, edit.mmAfter);
					mIsUndoOrRedo = false;
			
					for (Object o : text.getSpans(0, text.length(), android.text.style.UnderlineSpan.class)) {
							text.removeSpan(o);
					}
			
					Selection.setSelection(text, edit.mmAfter == null ? start
							: (start + edit.mmAfter.length()));
			}
		
			public void storePersistentState(android.content.SharedPreferences.Editor editor, String prefix) {
			
					editor.putString(prefix + ".hash",
							String.valueOf(mTextView.getText().toString().hashCode()));
					editor.putInt(prefix + ".maxSize", mEditHistory.mmMaxHistorySize);
					editor.putInt(prefix + ".position", mEditHistory.mmPosition);
					editor.putInt(prefix + ".size", mEditHistory.mmHistory.size());
			
					int i = 0;
					for (EditItem ei : mEditHistory.mmHistory) {
							String pre = prefix + "." + i;
				
							editor.putInt(pre + ".start", ei.mmStart);
							editor.putString(pre + ".before", ei.mmBefore.toString());
							editor.putString(pre + ".after", ei.mmAfter.toString());
				
							i++;
					}
			}
		
			public boolean restorePersistentState(SharedPreferences sp, String prefix)
					throws IllegalStateException {
			
					boolean ok = doRestorePersistentState(sp, prefix);
					if (!ok) {
							mEditHistory.clear();
					}
			
					return ok;
			}
		
			private boolean doRestorePersistentState(SharedPreferences sp, String prefix) {
			
					String hash = sp.getString(prefix + ".hash", null);
					if (hash == null) {
							return true;
					}
			
					if (Integer.valueOf(hash) != mTextView.getText().toString().hashCode()) {
							return false;
					}
			
					mEditHistory.clear();
					mEditHistory.mmMaxHistorySize = sp.getInt(prefix + ".maxSize", -1);
			
					int count = sp.getInt(prefix + ".size", -1);
					if (count == -1) {
							return false;
					}
			
					for (int i = 0; i < count; i++) {
							String pre = prefix + "." + i;
				
							int start = sp.getInt(pre + ".start", -1);
							String before = sp.getString(pre + ".before", null);
							String after = sp.getString(pre + ".after", null);
				
							if (start == -1 || before == null || after == null) {
									return false;
							}
							mEditHistory.add(new EditItem(start, before, after));
					}
			
					mEditHistory.mmPosition = sp.getInt(prefix + ".position", -1);
					if (mEditHistory.mmPosition == -1) {
							return false;
					}
			
					return true;
			}
		
			private final class EditHistory {
			
					private int mmPosition = 0;
					private int mmMaxHistorySize = -1;
					private final LinkedList<EditItem> mmHistory = new LinkedList<EditItem>();
					private void clear() {
							mmPosition = 0;
							mmHistory.clear();
					}
			
					private void add(EditItem item) {
							while (mmHistory.size() > mmPosition) {
									mmHistory.removeLast();
							}
							mmHistory.add(item);
							mmPosition++;
				
							if (mmMaxHistorySize >= 0) {
									trimHistory();
							}
					}
			
					private void setMaxHistorySize(int maxHistorySize) {
							mmMaxHistorySize = maxHistorySize;
							if (mmMaxHistorySize >= 0) {
									trimHistory();
							}
					}
			
					private void trimHistory() {
							while (mmHistory.size() > mmMaxHistorySize) {
									mmHistory.removeFirst();
									mmPosition--;
							}
				
							if (mmPosition < 0) {
									mmPosition = 0;
							}
					}
			
					private EditItem getPrevious() {
							if (mmPosition == 0) {
									return null;
							}
							mmPosition--;
							return mmHistory.get(mmPosition);
					}
			
					private EditItem getNext() {
							if (mmPosition >= mmHistory.size()) {
									return null;
							}
				
							EditItem item = mmHistory.get(mmPosition);
							mmPosition++;
							return item;
					}
			}
		
			private final class EditItem {
					private final int mmStart;
					private final CharSequence mmBefore;
					private final CharSequence mmAfter;
			
					public EditItem(int start, CharSequence before, CharSequence after) {
							mmStart = start;
							mmBefore = before;
							mmAfter = after;
					}
			}
		
			private final class EditTextChangeListener implements TextWatcher {
			
					private CharSequence mBeforeChange;
					private CharSequence mAfterChange;
			
					public void beforeTextChanged(CharSequence s, int start, int count,
							int after) {
							if (mIsUndoOrRedo) {
									return;
							}
				
							mBeforeChange = s.subSequence(start, start + count);
					}
			
					public void onTextChanged(CharSequence s, int start, int before,
							int count) {
							if (mIsUndoOrRedo) {
									return;
							}
				
							mAfterChange = s.subSequence(start, start + count);
							mEditHistory.add(new EditItem(start, mBeforeChange, mAfterChange));
					}
			
					public void afterTextChanged(Editable s) {
					}
			}
	}
	{
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
	
	
	public void _setHighlighter (final TextView _view) {
		final String secondaryColor = "#678cb1";
		final String primaryColor = "#86b55a";
		final String numbersColor = "#f6c921";
		final String quotesColor = "#ff1744";
		final String commentsColor = "#9e9e9e";
		final String charColor = "#ff5722";
		final TextView regex1 = new TextView(this);
		final TextView regex2 = new TextView(this);
		final TextView regex3 = new TextView(this);
		final TextView regex4 = new TextView(this);
		final TextView regex5 = new TextView(this);
		final TextView regex6 = new TextView(this);
		final TextView regex7 = new TextView(this);
		final TextView regex8 = new TextView(this);
		final TextView regex9 = new TextView(this);
		final TextView regex10 = new TextView(this);
		final TextView regex11 = new TextView(this);
		
		regex1.setText("\\b(out|print|println|valueOf|toString|concat|equals|for|while|switch|getText");
		
		regex2.setText("|println|printf|print|out|parseInt|round|sqrt|charAt|compareTo|compareToIgnoreCase|concat|contains|contentEquals|equals|length|toLowerCase|trim|toUpperCase|toString|valueOf|substring|startsWith|split|replace|replaceAll|lastIndexOf|size)\\b");
		
		regex3.setText("\\b(public|private|protected|void|switch|case|class|import|package|extends|Activity|TextView|EditText|LinearLayout|CharSequence|String|int|onCreate|ArrayList|float|if|else|static|Intent|Button|SharedPreferences");
		
		regex4.setText("|abstract|assert|boolean|break|byte|case|catch|char|class|const|continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|implements|import|instanceof|interface|long|native|new|package|private|protected|");
		
		regex5.setText("public|return|short|static|strictfp|super|switch|synchronized|this|throw|throws|transient|try|void|volatile|while|true|false|null)\\b");
		
		regex6.setText("\\b([0-9]+)\\b");
		
		regex7.setText("(\\w+)(\\()+");
		
		regex8.setText("\\@\\s*(\\w+)");
		
		regex9.setText("\"(.*?)\"|'(.*?)'");
		
		regex10.setText("/\\*(?:.|[\\n\\r])*?\\*/|//.*");
		
		regex11.setText("\\b(Uzuakoli|Amoji|Bright|Ndudirim|Ezinwanne|Lightworker|Isuochi|Abia|Ngodo)\\b");
		_view.addTextChangedListener(new TextWatcher() {
			ColorScheme keywords1 = new ColorScheme(java.util.regex.Pattern.compile(regex1.getText().toString().concat(regex2.getText().toString())), Color.parseColor(secondaryColor));
			
			ColorScheme keywords2 = new ColorScheme(java.util.regex.Pattern.compile(regex3.getText().toString().concat(regex4.getText().toString().concat(regex5.getText().toString()))), Color.parseColor(primaryColor));
			
			ColorScheme keywords3 = new ColorScheme(java.util.regex.Pattern.compile(regex6.getText().toString()), Color.parseColor(numbersColor));
			
			ColorScheme keywords4 = new ColorScheme(java.util.regex.Pattern.compile(regex7.getText().toString()), Color.parseColor(secondaryColor));
			
			ColorScheme keywords5 = new ColorScheme(java.util.regex.Pattern.compile(regex9.getText().toString()), Color.parseColor(quotesColor));
			
			ColorScheme keywords6 = new ColorScheme(java.util.regex.Pattern.compile(regex10.getText().toString()), Color.parseColor(commentsColor));
			
			ColorScheme keywords7 = new ColorScheme(java.util.regex.Pattern.compile(regex8.getText().toString()), Color.parseColor(numbersColor));
			
			
			ColorScheme keywords8 = new ColorScheme(java.util.regex.Pattern.compile(regex11.getText().toString()), Color.parseColor(charColor));
			
			final ColorScheme[] schemes = {keywords1, keywords2, keywords3, keywords4, keywords5, keywords6, keywords7, keywords8}; @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { } @Override public void onTextChanged(CharSequence s, int start, int before, int count) { } @Override public void afterTextChanged(Editable s) { removeSpans(s, android.text.style.ForegroundColorSpan.class); for(ColorScheme scheme : schemes) { for(java.util.regex.Matcher m = scheme.pattern.matcher(s);
					
					m.find();) { if (scheme == keywords4) { s.setSpan(new android.text.style.ForegroundColorSpan(scheme.color), m.start(), m.end()-1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
						} 
						else { s.setSpan(new android.text.style.ForegroundColorSpan(scheme.color), m.start(), m.end(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); } } } } void removeSpans(Editable e, Class type) { android.text.style.CharacterStyle[] spans = e.getSpans(0, e.length(), type); for (android.text.style.CharacterStyle span : spans) { e.removeSpan(span); } } class ColorScheme { final java.util.regex.Pattern pattern; final int color; ColorScheme(java.util.regex.Pattern pattern, int color) { this.pattern = pattern; this.color = color; } } });
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