package com.news.activity;

import java.util.HashMap;
import java.util.Map;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.news.http.HttpUtil;



public class PingjiaaddActivity extends Activity {
	
	
	private EditText et_pneirong;
	private SharedPreferences mSharedPreferences;
	
	private String username;
	
	private String xid ;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pingjiaadd);
		
		mSharedPreferences = getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE);
        
        username = mSharedPreferences.getString("username", null);
			
        et_pneirong = (EditText) findViewById(R.id.pneirong);
	        
        Intent intent=getIntent();
		Bundle bundle=intent.getExtras();
		xid = bundle.getString("xid");
	}
	
	
	
	
	//我要评价按钮响应函数
	public void pingjia_system(View v) { 

			String pneirong = et_pneirong.getText().toString();
			
			Map<String, String> parameter = new HashMap<String, String>();
			
			parameter.put("username", username);
			parameter.put("pneirong", pneirong);
			parameter.put("xid", xid);

			String response = HttpUtil.sendRequest(HttpUtil.pingjiaadd, parameter);
			
			if("success".equals(response)){
				
				Toast.makeText(PingjiaaddActivity.this,"评价成功", Toast.LENGTH_LONG).show();
			    PingjiaaddActivity.this.finish();
				
			}else {
				Toast.makeText(PingjiaaddActivity.this,"评价失败", Toast.LENGTH_LONG).show();
			}
			
		}
	
		
	//返回按钮响应函数
		 public void system_back(View v){
			 PingjiaaddActivity.this.finish();
			 
		 }
	
}
