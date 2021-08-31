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
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.news.http.HttpUtil;
import com.news.vo.Pingjia;




public class PingjialistActivity extends Activity   {
	
	private String xid;
	
	private List<Pingjia> list = new ArrayList<Pingjia>() ;

	public ListView showList;
	

	private ListViewAdapter adapter;
	

	
	@Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.pingjialist);
	       
	        Intent intent=getIntent();
			Bundle bundle=intent.getExtras();
			xid = bundle.getString("xid");
	        
			
			showList = (ListView) findViewById(R.id.pingjiaListView);
			
			showList.setOnItemClickListener(new MyListItemListener());
			
			

			adapter = new ListViewAdapter(PingjialistActivity.this);
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

	 	
	 //返回响应函数
	 public void loginout_system(View v){
		
			
	 }
	 
	 public final class MyListItemListener implements OnItemClickListener {
			
			public void onItemClick(AdapterView<?> view, View arg1,
					final int position, long arg3) {
				
			}
		}

	
	 
	 
	 
	 void initData() {
		 	list.clear();
		 	
		 	
		 	Map<String, String> parameter = new HashMap<String, String>();
		 	parameter.put("xid", xid);
		 	
			String result = HttpUtil.sendRequest(HttpUtil.pingjialist, parameter);
			
			
			
			try {
				
				JSONArray tables = new JSONArray(result);

				for (int i = 0; i < tables.length(); i++) {

					JSONObject obj_tmp = tables.getJSONObject(i);
					Pingjia bean = new Pingjia();
					bean.setId(obj_tmp.getInt("id"));
					bean.setCtime(obj_tmp.getString("ctime"));
					bean.setPneirong(obj_tmp.getString("pneirong"));
					bean.setUser(obj_tmp.getString("nichen"));

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
		private List<Pingjia> lists;
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

		
		public List<Pingjia> getLists() {
			return lists;
		}
		
		public void setLists(List<Pingjia> lists) {
			this.lists = lists;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder;
			Pingjia bean= lists.get(position);
			convertView = inflater.inflate(R.layout.pingjia_listivew_item, null);
			holder = new ViewHolder();

			holder.pneirong = (TextView) convertView.findViewById(R.id.pneirong);
		
			

			
			
			holder.pneirong.setText(bean.getUser()+" 在 "+bean.getCtime()+" 说："+bean.getPneirong());
	
			
			return convertView;
		}
		
		class ViewHolder {
			TextView pneirong;

			
		}
	}
	
	
	
	//返回按钮响应函数
	 public void system_back(View v){
		 PingjialistActivity.this.finish();
		 
	 }
	
	//我要评价响应函数
	public void pingjia_system(View v){
		
		Intent intent = new Intent(PingjialistActivity.this ,PingjiaaddActivity.class);
		
		intent.putExtra("xid",  xid);
		
		PingjialistActivity.this.startActivity(intent);
			 
	}

}
