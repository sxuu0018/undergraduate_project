package com.news.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TabHost;

public class TabHostActivity extends TabActivity {
	
	
	
	private TabHost mHost;
	
	private RadioGroup tabItems;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabhost);
		initResourceRefs();
	    initSettings();
		
	}

	
	 private void initResourceRefs(){
		  mHost = getTabHost();
		  
		  mHost.addTab(mHost.newTabSpec("news").setIndicator("news")
		    		.setContent(new Intent(this , NewsActivity.class)));

		    
		  mHost.addTab(mHost.newTabSpec("pingjia").setIndicator("pingjia")
		    		.setContent(new Intent(this , PingjiaActivity.class)));
		  
		  mHost.addTab(mHost.newTabSpec("shoucang").setIndicator("shoucang")
		    		.setContent(new Intent(this , ShoucangActivity.class)));
		    
		  mHost.addTab(mHost.newTabSpec("userinfo").setIndicator("userinfo")
		    		.setContent(new Intent(this , UserinfoActivity.class)));  
			    
		  
		  
		  tabItems = (RadioGroup)findViewById(R.id.home_radio_button_group);
	 }
	 
	 
	 
	 private void initSettings(){
		 
		 
		 tabItems.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					// TODO Auto-generated method stub
					
					
					switch(checkedId){
					

					 case R.id.tab_item_news :
						 mHost.setCurrentTabByTag("news");
						 break;
					 case R.id.tab_item_pingjia :
						 mHost.setCurrentTabByTag("pingjia");
						 break;
					 case R.id.tab_item_shoucang :
						 mHost.setCurrentTabByTag("shoucang");
						 break;
					 case R.id.tab_item_userinfo :
						 mHost.setCurrentTabByTag("userinfo");
						 break;			
					
					
					}
					
					
				}
			});
		 
		
	 }
	
	

}
