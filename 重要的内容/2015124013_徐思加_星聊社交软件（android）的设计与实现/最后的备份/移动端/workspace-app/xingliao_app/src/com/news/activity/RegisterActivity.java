package com.news.activity;

import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.news.http.HttpUtil;




public class RegisterActivity extends Activity {

	
	private EditText editUsername;
	private EditText editPassword;
	private EditText editPassword2;
	private EditText editnichen;
	private EditText edittel;
	
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		 //在android2.3之后同步获取网络数据访问网络的操作， 加入如下2行代码
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());	
		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath().build());
		
		editUsername = (EditText)findViewById(R.id.editUsername);
		editPassword = (EditText)findViewById(R.id.editPassword);
		editPassword2 = (EditText)findViewById(R.id.editPassword2);
		editnichen = (EditText)findViewById(R.id.editnichen);
		edittel = (EditText)findViewById(R.id.edittel);
		
	}

	
	
	
	//注册按钮响应函数
		 public void register_system(View v){
			
			String username = editUsername.getText().toString();
			String password1 = editPassword.getText().toString();
			String password2 = editPassword2.getText().toString();
			String tel = edittel.getText().toString();
			String nichen = editnichen.getText().toString();
			
			if(username==null||"".equals(username)){
				new AlertDialog.Builder(RegisterActivity.this).setTitle("错误提示").setMessage("用户名不能为空\n请重新输入").create().show();
				return;
			}
			if(password1==null||"".equals(password1)){
				new AlertDialog.Builder(RegisterActivity.this).setTitle("错误提示").setMessage("密码不能为空\n请重新输入").create().show();
				return;
			}
			
			if(!password1.equals(password2)){
				new AlertDialog.Builder(RegisterActivity.this).setTitle("错误提示").setMessage("两次输入的密码不一致\n请重新输入").create().show();
				return;
			}
			 
			Map<String, String> parameter = new HashMap<String, String>();
				
			parameter.put("username",username );
			parameter.put("password", password1);
			parameter.put("tel", tel);
			parameter.put("nichen", nichen);
			
			
			String response = HttpUtil.sendRequest(HttpUtil.register, parameter);
			
			if("fail".equals(response)){
				new AlertDialog.Builder(RegisterActivity.this).setTitle("错误提出").setMessage("该用户名已经存在\n请重新输入").create().show();
				return;
				
			}
			
			if("success".equals(response)){
				Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_LONG).show();
				Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
				startActivity(intent);
				this.finish();
				
			}
			
			 
		}
		 
		 
		//返回按钮响应函数
		 public void register_back(View v){
			Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
			startActivity(intent);
			
			this.finish();	
		 }

}
