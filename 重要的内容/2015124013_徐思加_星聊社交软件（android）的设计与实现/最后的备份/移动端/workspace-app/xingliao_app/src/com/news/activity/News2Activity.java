package com.news.activity;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.news.http.HttpUtil;
import com.news.util.MyBackAsynaTask;
import com.news.vo.Fenlei;
import com.news.vo.News;




public class News2Activity extends Activity   {
	
	private List<News> list = new ArrayList<News>() ;

	public ListView showList;

	private List<Fenlei> fenleilist = new ArrayList<Fenlei>() ;
	
	private  String[] TYPE_SEL = null;
	
	
	private ArrayAdapter disAdapter;
	
	public Spinner disSpi;
	
	private int selType;
	
	private String fenlei = null;
	
	private String tuijian = null;
	
	private EditText search_keyword;
	
	private ListViewAdapter adapter;
	

	@SuppressLint("NewApi")
	@Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.news2);
	        //在android2.3之后同步获取网络数据访问网络的操作， 加入如下2行代码
			StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());	
			StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath().build());
			
			search_keyword = (EditText)findViewById(R.id.search_keyword);
			
			showList = (ListView) findViewById(R.id.newsListView);
			
			showList.setOnItemClickListener(new MyListItemListener());
			
			getFenlei();
			
			TYPE_SEL = new String[fenleilist.size()+2];
			
			TYPE_SEL[0] = "所有分类";
			TYPE_SEL[1] = "推荐文章";
			for(int i=0;i<fenleilist.size();i++){
				TYPE_SEL[i+2] = fenleilist.get(i).getFname();	
			}
			
		
			
			disSpi = (Spinner) findViewById(R.id.name_sel_spinner);
			disAdapter = new ArrayAdapter<String>(this,
					R.layout.spinner_text, TYPE_SEL);
	        
			disAdapter
			.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

			disSpi.setAdapter(disAdapter);
			
			disSpi.setSelection(0);
			disSpi.setOnItemSelectedListener(new SpinnerSelectedListener());
			disSpi.setVisibility(View.VISIBLE);

			adapter = new ListViewAdapter(News2Activity.this);
			showList.setCacheColorHint(Color.TRANSPARENT);
			showList.setAdapter(adapter);
			adapter.notifyDataSetChanged();
			
			initData(null,null,null);
			
	    }
	
	@Override
	public void onRestart() {
		super.onRestart();
		initData(null,null,null);
	}

	 	
	 //登录按钮响应函数
	 public void login_system(View v){
		Intent intent = new Intent(News2Activity.this, LoginActivity.class);
		startActivity(intent);
		
		this.finish();
		
			
	 }
	 
	 public final class MyListItemListener implements OnItemClickListener {
			
			public void onItemClick(AdapterView<?> view, View arg1,
					final int position, long arg3) {
				
				Intent intent = new Intent(News2Activity.this ,LoginActivity.class);
				
				
				News2Activity.this.startActivity(intent);
				
				Toast.makeText(News2Activity.this,"请先登录", Toast.LENGTH_LONG).show();

			}
		}

	 //获取分类信息
	 void getFenlei() {
		 	
		 fenleilist.clear();
		 
		 	
		 String result = HttpUtil.sendRequest(HttpUtil.fenleilist, null);
			
			
			
		try {
				
			JSONArray tables = new JSONArray(result);

			for (int i = 0; i < tables.length(); i++) {

				JSONObject obj_tmp = tables.getJSONObject(i);
				Fenlei bean = new Fenlei();
				bean.setId(obj_tmp.getInt("id"));
				
				bean.setFname(obj_tmp.getString("fname"));
				

				fenleilist.add(bean);
					
					
			}

				

		} catch (JSONException e) {
				
			e.printStackTrace();
			Log.e("mobile", "格式转换错误");
		}
	}
	 
	 
	 
	 void initData(String xtitle,String fenlei,String tuijian) {
		 	list.clear();
		 	
		 	
		 	Map<String, String> parameter = new HashMap<String, String>();
		 	parameter.put("xtitle", xtitle);
		 	parameter.put("fenlei", fenlei);
		 	parameter.put("tuijian", tuijian);
		 
		 	
			String result = HttpUtil.sendRequest(HttpUtil.xinwenlist, parameter);
			
			
			
			try {
				
				JSONArray tables = new JSONArray(result);

				for (int i = 0; i < tables.length(); i++) {

					JSONObject obj_tmp = tables.getJSONObject(i);
					News bean = new News();
					bean.setId(obj_tmp.getInt("id"));
					bean.setFenlei(obj_tmp.getString("fenlei"));
					bean.setXtitle(obj_tmp.getString("xtitle"));
					bean.setPic(obj_tmp.getString("pic"));

					list.add(bean);
					
					
				}

				adapter.setLists(list);
				
				adapter.notifyDataSetChanged();

			} catch (JSONException e) {
				
				e.printStackTrace();
				Log.e("mobile", "格式转换错误");
			}
		}
	 
	 
	 
	 
	 
	 class SpinnerSelectedListener implements OnItemSelectedListener {
		 
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				
				
				selType = arg2;
				
				if (selType ==1 ){
					tuijian = "推荐";
					fenlei = null;
				}else if (selType >1 ){
					fenlei = fenleilist.get(selType-2).getFname();
					tuijian = null;
				}else{
					fenlei = null;
					tuijian = null;
				}
				
				initData(null,fenlei,tuijian);
				
				
		
				

			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}

		}
	 
	 
	 
	//搜索按钮响应函数
	public void search_system(View v){
				
		String keyword = search_keyword.getText().toString();
				
			
		initData(keyword,fenlei,tuijian);		
	}
	
	
	class ListViewAdapter extends BaseAdapter{
		private Context context;
		private LayoutInflater inflater;
		private List<News> lists;
		public ListViewAdapter(Context context) {
			this.context = context;
			this.inflater = LayoutInflater.from(context);
		}
		@Override
		public int getCount() {
			return lists == null ? 0 : lists.size();
		}

		@Override
		public Object getItem(int position) {
			return lists.get(position);
		}
		
		@Override
		public long getItemId(int position) {
			return position;
		}

		
		public List<News> getLists() {
			return lists;
		}
		
		public void setLists(List<News> lists) {
			this.lists = lists;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder;
			News bean= lists.get(position);
			convertView = inflater.inflate(R.layout.news_listivew_item, null);
			holder = new ViewHolder();
			holder.imagePic = (ImageView) convertView.findViewById(R.id.imagePic);
			holder.xtitle = (TextView) convertView.findViewById(R.id.xtitle);
			holder.fenlei = (TextView) convertView.findViewById(R.id.fenlei);
			

			MyBackAsynaTask asynaTask = new MyBackAsynaTask(HttpUtil.URL+"/uploadfile/"+bean.getPic(), holder.imagePic);
			
			asynaTask.execute();
			
			holder.xtitle.setText(bean.getXtitle());
			holder.fenlei.setText(bean.getFenlei());
			
			return convertView;
		}
		class ViewHolder {
			ImageView imagePic;
			TextView xtitle;
			TextView fenlei;
			
		}
	}	
	

}
