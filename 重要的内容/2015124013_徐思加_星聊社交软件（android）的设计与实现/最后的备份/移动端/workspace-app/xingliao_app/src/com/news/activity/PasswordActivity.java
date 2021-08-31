package com.news.activity;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.news.http.HttpUtil;

public class PasswordActivity extends Activity {

	private SharedPreferences mSharedPreferences;
	
	private String username;
	
	private EditText password_password1;
	private EditText password_password2;
	private EditText password_password3;

	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.password);
	        
	        mSharedPreferences = getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE);
	        
			username = mSharedPreferences.getString("username", null);
			
			password_password1 = (EditText) findViewById(R.id.password_password1);
			password_password2 = (EditText) findViewById(R.id.password_password2);
			password_password3 = (EditText) findViewById(R.id.password_password3);
	        
	 }

	
	//�޸����밴ť��Ӧ����
	public void password_system(View v){
		
		String password1 = password_password1.getText().toString();
		String password2 = password_password2.getText().toString();
		String password3 = password_password3.getText().toString();
		
		
		if(password1==null||"".equals(password1)){
			new AlertDialog.Builder(PasswordActivity.this).setTitle("������ʾ").setMessage("ԭ���벻��Ϊ��\n����������").create().show();
			return;
		}
		if(password2==null||"".equals(password2)){
			new AlertDialog.Builder(PasswordActivity.this).setTitle("������ʾ").setMessage("�����벻��Ϊ��\n����������").create().show();
			return;
		}
		
		if(!password2.equals(password3)){
			new AlertDialog.Builder(PasswordActivity.this).setTitle("������ʾ").setMessage("ȷ��������������벻һ��\n����������").create().show();
			return;
		}
		
		Map<String, String> parameter = new HashMap<String, String>();
		
		parameter.put("username",username );
		parameter.put("password1", password1);
		parameter.put("password2", password2);
		
				
		String response = HttpUtil.sendRequest(HttpUtil.passwordedit, parameter);
		
		if("fail".equals(response)){
			new AlertDialog.Builder(PasswordActivity.this).setTitle("�������").setMessage("ԭ�������\n����������").create().show();
			return;
			
		}
		
		if("success".equals(response)){
			Toast.makeText(PasswordActivity.this, "�޸ĳɹ�", Toast.LENGTH_LONG).show();
			Intent intent = new Intent(PasswordActivity.this,LoginActivity.class);
			startActivity(intent);
			this.finish();
			
		}
			 
	}
	
	
	
	//���ذ�ť��Ӧ����
	public void passwordback_system(View v){
		
		PasswordActivity.this.finish();
	}
	
	
	
	
}
