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
import java.util.HashMap;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.Intent;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import com.bumptech.glide.Glide;
import java.text.DecimalFormat;
import androidx.webkit.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class DownloadActivity extends AppCompatActivity {
	
	private String folder = "";
	private double n = 0;
	private double B = 0;
	private double KB = 0;
	private double MB = 0;
	private double GB = 0;
	private double TB = 0;
	private String returnedSize = "";
	private String path = "";
	private String delet = "";
	private String ok = "";
	private String cancel = "";
	private String Upfolder = "";
	private String title = "";
	private String yes = "";
	private String zipfile_path = "";
	
	private ArrayList<String> list = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private TextView textview1;
	private TextView textview2;
	private ListView listview1;
	
	private SharedPreferences fileview;
	private Intent i = new Intent();
	private Intent main = new Intent();
	private AlertDialog.Builder delete;
	private SharedPreferences s;
	private SharedPreferences mode;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.download);
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
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		listview1 = (ListView) findViewById(R.id.listview1);
		fileview = getSharedPreferences("fileview", Activity.MODE_PRIVATE);
		delete = new AlertDialog.Builder(this);
		s = getSharedPreferences("s", Activity.MODE_PRIVATE);
		mode = getSharedPreferences("mode", Activity.MODE_PRIVATE);
		
		textview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				folder = FileUtil.getExternalStorageDir().concat("/webview download");
				_refreshList();
			}
		});
		
		textview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				folder = FileUtil.getExternalStorageDir().concat("/Webview/Download");
				_refreshList();
			}
		});
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (FileUtil.isDirectory(list.get((int)(_position)))) {
					folder = list.get((int)(_position));
					_refreshList();
				}
				else {
					if (list.get((int)(_position)).endsWith(".mp4") || (list.get((int)(_position)).endsWith(".mp3") || (list.get((int)(_position)).endsWith(".avi") || (list.get((int)(_position)).endsWith(".wav") || list.get((int)(_position)).endsWith(".m4a"))))) {
						fileview.edit().putString("data", list.get((int)(_position))).commit();
						i.setClass(getApplicationContext(), ViewActivity.class);
						startActivity(i);
					}
					else {
						if (list.get((int)(_position)).endsWith(".txt") || (list.get((int)(_position)).endsWith(".html") || (list.get((int)(_position)).endsWith(".java") || (list.get((int)(_position)).endsWith(".xml") || (list.get((int)(_position)).endsWith(".json") || (list.get((int)(_position)).endsWith(".php") || list.get((int)(_position)).endsWith(".css"))))))) {
							fileview.edit().putString("data", list.get((int)(_position))).commit();
							i.setClass(getApplicationContext(), TextfileActivity.class);
							startActivity(i);
						}
						else {
							if (list.get((int)(_position)).endsWith(".png") || (list.get((int)(_position)).endsWith(".jpeg") || list.get((int)(_position)).endsWith(".jpg"))) {
								fileview.edit().putString("data", list.get((int)(_position))).commit();
								i.setClass(getApplicationContext(), ViewActivity.class);
								startActivity(i);
							}
							else {
								
							}
						}
					}
				}
			}
		});
		
		listview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				delete.setTitle(delet);
				delete.setPositiveButton(ok, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						FileUtil.deleteFile(list.get((int)(_position)));
						_refreshList();
					}
				});
				delete.setNegativeButton(cancel, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				delete.create().show();
				return true;
			}
		});
	}
	
	private void initializeLogic() {
		folder = FileUtil.getExternalStorageDir().concat("/webview download");
		_refreshList();
		_language();
		if (mode.getString("darkmode", "").equals("true")) {
			linear1.setBackgroundColor(0xFF212121);
			linear2.setBackgroundColor(0xFF212121);
			textview1.setTextColor(0xFFFFFFFF);
			textview2.setTextColor(0xFFFFFFFF);
			delete = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
		}
		else {
			linear1.setBackgroundColor(0xFFFFFFFF);
			linear2.setBackgroundColor(0xFFFFFFFF);
			textview1.setTextColor(0xFF000000);
			textview2.setTextColor(0xFF000000);
			delete = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
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
	
	@Override
	public void onBackPressed() {
		if (folder.equals(FileUtil.getExternalStorageDir().concat("/Webview/Download")) || folder.equals(FileUtil.getExternalStorageDir().concat("/webview download"))) {
			finish();
		}
		else {
			Upfolder = folder.substring((int)(0), (int)(folder.lastIndexOf("/")));
			folder = Upfolder;
			_refreshList();
		}
	}
	public void _refreshList () {
		list.clear();
		listmap.clear();
		FileUtil.listDir(folder, list);
		_SortString(list, true);
		n = 0;
		for(int _repeat14 = 0; _repeat14 < (int)(list.size()); _repeat14++) {
			{
				HashMap<String, Object> _item = new HashMap<>();
				_item.put("file", list.get((int)(n)));
				listmap.add(_item);
			}
			
			n++;
		}
		listview1.setAdapter(new Listview1Adapter(listmap));
		((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
	}
	
	
	public void _SortString (final ArrayList<String> _listString, final boolean _Ascending) {
		Collections.sort(_listString, String.CASE_INSENSITIVE_ORDER);
		if (!_Ascending) {
			Collections.reverse(_listString);
		}
	}
	
	
	public void _setImageFromFile (final ImageView _img, final String _path) {
		
		java.io.File file = new java.io.File(_path);
		Uri imageUri = Uri.fromFile(file);
		
		Glide.with(getApplicationContext ()).load(imageUri).into(_img);
	}
	
	
	public void _getFileSize (final double _filesize) {
		B = 1024;
		KB = B * B;
		MB = B * (B * B);
		GB = B * (B * (B * B));
		TB = B * (B * (B * (B * B)));
		if (_filesize < B) {
			returnedSize = String.valueOf((long)(_filesize)).concat("B");
		}
		else {
			if (_filesize < KB) {
				returnedSize = new DecimalFormat("0.00").format(_filesize / B).concat("KB");
			}
			else {
				if (_filesize < MB) {
					returnedSize = new DecimalFormat("0.00").format(_filesize / KB).concat("MB");
				}
				else {
					if (_filesize < GB) {
						returnedSize = new DecimalFormat("0.00").format(_filesize / MB).concat("GB");
					}
					else {
						if (_filesize < TB) {
							returnedSize = new DecimalFormat("0.00").format(_filesize / GB).concat("TB");
						}
						else {
							returnedSize = new DecimalFormat("0.00").format(_filesize / TB).concat("PB");
						}
					}
				}
			}
		}
	}
	
	
	public void _language () {
		if (s.getString("language", "").equals("english")) {
			delet = "Do you want to delete this file?";
			ok = "Delete";
			cancel = "Cancel";
			textview1.setText("Files");
			textview2.setText("Images");
		}
		else {
			if (s.getString("language", "").equals("persian")) {
				delet = "آیا می خواهید این فایل را حذف کنید ؟";
				ok = "حذف";
				cancel = "لغو";
				textview1.setText("فایل ها");
				textview2.setText("عکس ها");
			}
			else {
				if (s.getString("language", "").equals("china")) {
					delet = "您要删除此文件吗？";
					ok = "删除";
					cancel = "取消";
					textview1.setText("文件");
					textview2.setText("图片");
				}
				else {
					delet = "Do you want to delete this file?";
					ok = "Delete";
					cancel = "Cancel";
				}
			}
		}
	}
	
	
	public class Listview1Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.castom, null);
			}
			
			final LinearLayout linear1 = (LinearLayout) _view.findViewById(R.id.linear1);
			final ImageView imageview1 = (ImageView) _view.findViewById(R.id.imageview1);
			final LinearLayout linear2 = (LinearLayout) _view.findViewById(R.id.linear2);
			final TextView textview1 = (TextView) _view.findViewById(R.id.textview1);
			final TextView textview2 = (TextView) _view.findViewById(R.id.textview2);
			
			if (mode.getString("darkmode", "").equals("true")) {
				linear1.setBackgroundColor(0xFF212121);
				textview1.setTextColor(0xFFFFFFFF);
				textview2.setTextColor(0xFFFFFFFF);
			}
			else {
				linear1.setBackgroundColor(0xFFFFFFFF);
				textview1.setTextColor(0xFF000000);
				textview2.setTextColor(0xFF000000);
			}
			textview1.setText(Uri.parse(list.get((int)(_position))).getLastPathSegment());
			if (FileUtil.isDirectory(list.get((int)(_position)))) {
				textview2.setVisibility(View.GONE);
				imageview1.setImageResource(R.drawable.folder);
			}
			else {
				textview2.setVisibility(View.VISIBLE);
				_getFileSize(FileUtil.getFileLength(list.get((int)(_position))));
				textview2.setText(returnedSize);
				path = list.get((int)(_position));
				if (path.endsWith(".mp4") || path.endsWith(".mp3")) {
					if (mode.getString("darkmode", "").equals("true")) {
						imageview1.setImageResource(R.drawable.ic_play_circle_fill_white);
					}
					else {
						imageview1.setImageResource(R.drawable.ic_play_circle_fill_black);
					}
				}
				else {
					if (path.endsWith(".txt") || (path.endsWith(".html") || (path.endsWith(".java") || (path.endsWith(".xml") || (path.endsWith(".json") || (path.endsWith(".php") || path.endsWith(".css"))))))) {
						if (mode.getString("darkmode", "").equals("true")) {
							imageview1.setImageResource(R.drawable.ic_description_white);
						}
						else {
							imageview1.setImageResource(R.drawable.ic_description_black);
						}
					}
					else {
						if (path.endsWith(".zip")) {
							imageview1.setImageResource(R.drawable.zipfile);
						}
						else {
							if (path.endsWith(".png") || (path.endsWith(".jpeg") || (path.endsWith(".jpg") || path.endsWith(".gif")))) {
								_setImageFromFile(imageview1, path);
							}
							else {
								if (mode.getString("darkmode", "").equals("true")) {
									imageview1.setImageResource(R.drawable.ic_insert_drive_file_white);
								}
								else {
									imageview1.setImageResource(R.drawable.ic_insert_drive_file_black);
								}
							}
						}
					}
				}
			}
			
			return _view;
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