package com.news.activity;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.news.http.HttpUtil;
import com.news.vo.Shoucang;




public class ShoucangActivity extends Activity   {
	
	
	private SharedPreferences mSharedPreferences;
	
	private String username;
	
	private List<Shoucang> list = new ArrayList<Shoucang>() ;

	public ListView showList;
	

	private ListViewAdapter adapter;
	

	
	@Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.shoucang);
	       
	        mSharedPreferences = getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE);
	        
	        username = mSharedPreferences.getString("username", null);
	        
			
			showList = (ListView) findViewById(R.id.shoucangListView);
			
			showList.setOnItemClickListener(new MyListItemListener());
			
			

			adapter = new ListViewAdapter(ShoucangActivity.this,ShoucangActivity.this);
			showList.setCacheColorHint(Color.TRANSPARENT);
			showList.setAdapter(adapter);
			adapter.notifyDataSetChanged();
			
			initData();
			
	    }
	
	@Override
	public void onRestart() {
		super.onRestart();
		initData();
	}

	 	
	 
	 public final class MyListItemListener implements OnItemClickListener {
			
			public void onItemClick(AdapterView<?> view, View arg1,
					final int position, long arg3) {
				
				Intent intent = new Intent(ShoucangActivity.this ,NewsViewActivity.class);
				
				intent.putExtra("id",  String.valueOf(list.get(position).getXid()));
				
				ShoucangActivity.this.startActivity(intent);
				
			}
		}

	
	 
	 
	 
	 void initData() {
		 	list.clear();
		 	
		 	
		 	Map<String, String> parameter = new HashMap<String, String>();
		 	parameter.put("username", username);
		 	
			String result = HttpUtil.sendRequest(HttpUtil.shoucanglist, parameter);
			
			
			
			try {
				
				JSONArray tables = new JSONArray(result);

				for (int i = 0; i < tables.length(); i++) {

					JSONObject obj_tmp = tables.getJSONObject(i);
					Shoucang bean = new Shoucang();
					bean.setId(obj_tmp.getInt("id"));
					bean.setCtime(obj_tmp.getString("ctime"));
					bean.setXid(obj_tmp.getString("xid"));
					bean.setXtitle(obj_tmp.getString("xtitle"));
					

					list.add(bean);
					
					
				}

				adapter.setLists(list);
				
				adapter.notifyDataSetChanged();

			} catch (JSONException e) {
				
				e.printStackTrace();
				Log.e("mobile", "格式转换错误");
			}
		}
	 

	
	
	class ListViewAdapter extends BaseAdapter{
		private Context context;
		private LayoutInflater inflater;
		private List<Shoucang> lists;
		private ShoucangActivity shoucangActivity;
		
		public ListViewAdapter(Context context,ShoucangActivity shoucangActivity) {
			this.context = context;
			this.inflater = LayoutInflater.from(context);
			this.shoucangActivity = shoucangActivity;
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

		
		public List<Shoucang> getLists() {
			return lists;
		}
		
		public void setLists(List<Shoucang> lists) {
			this.lists = lists;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder;
			final  Shoucang bean= lists.get(position);
			convertView = inflater.inflate(R.layout.shoucang_listivew_item, null);
			holder = new ViewHolder();

			holder.xtitle = (TextView) convertView.findViewById(R.id.xtitle);
			holder.ctime = (TextView) convertView.findViewById(R.id.ctime);
			holder.imageCartDetele = (ImageView) convertView.findViewById(R.id.imageCartDetele);

			
			holder.xtitle.setText("新闻标题:"+bean.getXtitle());
			holder.ctime.setText("收藏时间:"+bean.getCtime());
	
			//删除调用函数
			holder.imageCartDetele.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					shoucangActivity.quxiao(bean.getId()+"");
				}
			});
			
			return convertView;
		}
		
		class ViewHolder {
			TextView xtitle;
			TextView ctime;
			ImageView imageCartDetele;
			
		}
	}
	
	
	 //取消收藏操作
	 public void quxiao(String s_id ){
		 
		Map<String, String> parameter = new HashMap<String, String>();
			
		parameter.put("id", s_id);
			

		String result = HttpUtil.sendRequest(HttpUtil.shoucangdelete, parameter);
		
		if("success".equals(result)){
			Toast.makeText(ShoucangActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
			initData();
		}else{
			Toast.makeText(ShoucangActivity.this, "删除失败", Toast.LENGTH_SHORT).show();
		}
		
		
			
	}
	 
	

}
