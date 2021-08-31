package com.news.activity;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.news.http.HttpUtil;






public class NewsViewActivity extends Activity {

	
	private TextView xtitle;
	private TextView fenlei;
	private TextView ctime;
	private TextView dianji;
	private TextView xneirong;
	
	private Button button1;
	private Button button3;
	
	private String id;
	
	private SharedPreferences mSharedPreferences;
	
	private String username;
	

	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.newsview);
	        
	        Intent intent=getIntent();
			Bundle bundle=intent.getExtras();
			id = bundle.getString("id");
			
			
			
			xtitle = (TextView)findViewById(R.id.xtitle);
			fenlei = (TextView)findViewById(R.id.fenlei);
			ctime = (TextView)findViewById(R.id.ctime);
			dianji = (TextView)findViewById(R.id.dianji);
			xneirong = (TextView)findViewById(R.id.xneirong);
			
			button1 = (Button)findViewById(R.id.button1);
			button3 = (Button)findViewById(R.id.button3);
			
			mSharedPreferences = getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE);
	        
	        username = mSharedPreferences.getString("username", null);
			
			
			initData();
			
	        
	    }
	 
	 @Override
		public void onRestart() {
			super.onRestart();
			initData();
		}
	 
	 	void initData(){
	 		Map<String, String> parameter = new HashMap<String, String>();
		 	parameter.put("id", id);
		 	
		 	
			String result = HttpUtil.sendRequest(HttpUtil.xinwendetails, parameter);
			
			
			
			try {
				
				JSONArray tables = new JSONArray(result);

				for (int i = 0; i < tables.length(); i++) {

					JSONObject obj_tmp = tables.getJSONObject(i);
					
					xtitle.setText(obj_tmp.getString("xtitle"));
					fenlei.setText(obj_tmp.getString("fenlei"));
					ctime.setText(obj_tmp.getString("ctime"));

					dianji.setText(obj_tmp.getString("dianji"));
					xneirong.setText(obj_tmp.getString("xneirong"));
					
					button1.setText("评价列表("+obj_tmp.getString("pingjia")+")");
					button3.setText("收藏文章("+obj_tmp.getString("shoucang")+")");
					
				}

			} catch (JSONException e) {
			
				e.printStackTrace();
				Log.e("mobile", "格式转换错误");
			}
	 	}

	
	 	//返回按钮响应函数
		 public void system_back(View v){
			 NewsViewActivity.this.finish();
			 
		 }
		 
		//评价列表
		 public void pingjialist_system(View v){
			 
			Intent intent = new Intent(NewsViewActivity.this ,PingjialistActivity.class);
				
			intent.putExtra("xid", id);
				
			NewsViewActivity.this.startActivity(intent);
			 
		 }
		 
		
		 
		//收藏新闻
		 public void shoucang_system(View v){
			 Map<String, String> parameter = new HashMap<String, String>();
			 parameter.put("xid", id);
			 parameter.put("username", username);
			 	
			 	
			String response = HttpUtil.sendRequest(HttpUtil.shoucangadd, parameter);
			
			if("success".equals(response)){
				
				Toast.makeText(NewsViewActivity.this,"收藏成功", Toast.LENGTH_LONG).show();
				this.onRestart();
				
			}else if("fail".equals(response)){
				
				Toast.makeText(NewsViewActivity.this,"你已经收藏过该新闻不可重复收藏", Toast.LENGTH_LONG).show();
				
				
			}else {
				Toast.makeText(NewsViewActivity.this,"网络异常", Toast.LENGTH_LONG).show();
			}
			 
		 }
		 
}
