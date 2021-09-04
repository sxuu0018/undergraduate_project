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
import android.widget.TextView;

import com.news.http.HttpUtil;


public class UserinfoActivity extends Activity {

	
	private SharedPreferences mSharedPreferences;
	
	private SharedPreferences.Editor mEditor;
	
	private TextView userinfo_username;
	private TextView userinfo_createtime;
	private TextView userinfo_nichen;
	private TextView userinfo_tel;
	
	private String username;

	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.userinfo_details_view);
	        
	        mSharedPreferences = getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE);
	        
			username = mSharedPreferences.getString("username", null);
			
			userinfo_username = (TextView)findViewById(R.id.userinfo_username);
			userinfo_createtime = (TextView)findViewById(R.id.userinfo_createtime);
			userinfo_tel = (TextView)findViewById(R.id.userinfo_tel);
			userinfo_nichen = (TextView)findViewById(R.id.userinfo_nichen);
			
			initData();
	        
	 }

	 void initData() {
		 Map<String, String> parameter = new HashMap<String, String>();
		 	parameter.put("username", username);
		 	
		 	
			String result = HttpUtil.sendRequest(HttpUtil.userdetails, parameter);
			
			
			try {
				
				JSONArray tables = new JSONArray(result);

				for (int i = 0; i < tables.length(); i++) {

					JSONObject obj_tmp = tables.getJSONObject(i);
					
					userinfo_username.setText(obj_tmp.getString("username"));
					userinfo_createtime.setText(obj_tmp.getString("createtime"));
					userinfo_tel.setText(obj_tmp.getString("tel"));
					userinfo_nichen.setText(obj_tmp.getString("nichen"));
					
					
					
				}

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Log.e("mobile", "��ʽת������");
			}
		 
	 }
	 
	 
	 @Override
		protected void onRestart() {
			super.onRestart();
			initData();
			
		}
	 
	 //�޸����밴ť��Ӧ����
	 public void userinfo_password(View v){
		 Intent intent = new Intent(UserinfoActivity.this, PasswordActivity.class);
		 startActivity(intent);
		
		 
	 }
	 
	//�༭�û���Ϣ��ť��Ӧ����
	public void userinfo_edit(View v){
			 Intent intent = new Intent(UserinfoActivity.this, UserinfoEditActivity.class);
			 startActivity(intent);
			
			 
	}

	//�˳���ť��Ӧ����
	public void loginout_system(View v){
		Intent intent = new Intent(UserinfoActivity.this, LoginActivity.class);
		startActivity(intent);
		
		this.finish();
		 
		mSharedPreferences = getSharedPreferences("SharedPreferences",
					Context.MODE_PRIVATE);
			
		mEditor = mSharedPreferences.edit();
		mEditor.putString("username", null);
		mEditor.commit();	
			
	}

}
