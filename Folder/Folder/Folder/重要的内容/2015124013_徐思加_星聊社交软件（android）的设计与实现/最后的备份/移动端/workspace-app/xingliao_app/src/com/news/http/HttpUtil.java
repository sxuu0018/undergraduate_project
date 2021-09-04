package com.news.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;



//�����˽������ݽ���

public class HttpUtil
{
	public static  String URL = "http://10.0.2.2:8080/news/";//����ķ�������ַ
	
	public static  String register = "appmethod!register";//ע������󷽷�
	
	public static  String login = "appmethod!login";//��¼�����󷽷�
	
	public static  String fenleilist = "appmethod!fenleilist";//���ŷ�����Ϣ
	
	public static  String xinwenlist = "appmethod!xinwenlist";//������Ϣ
	
	public static  String xinwendetails = "appmethod!xinwendetails";//������ϸ��Ϣ
	
	public static  String pingjialist = "appmethod!pingjialist";//���������б�
	
	public static  String pingjiaadd = "appmethod!pingjiaadd";//�������
	
	public static  String shoucangadd = "appmethod!shoucangadd";//�ղ�����
	
	public static  String shoucanglist = "appmethod!shoucanglist";//�ҵ��ղ�
	
	public static  String shoucangdelete = "appmethod!shoucangdelete";//ȡ���ղ�
	
	public static  String pingjialist2 = "appmethod!pingjialist2";//���������б�
	
	public static  String pingjiadelete = "appmethod!pingjiadelete";//ɾ������
	
	public static  String userdetails = "appmethod!userdetails";//�ҵ���Ϣ
	
	public static  String passwordedit = "appmethod!passwordedit";//�޸�����
	
	public static  String userdedit = "appmethod!userdedit";//�༭�û���Ϣ
	
	
	//�������󣬴ӷ���˻�ȡ����
	public static  String sendRequest(String method,Map<String, String> parameter) {
			

		String urlStr = URL+method;
		String response = null;

		try {
				
			List<Parameter>  params = HttpUtil.getParameter(parameter);
				
			response = HttpUtil.httpPost(urlStr, params);
				
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return response;
			
			
	}
	
	
	
	/**
	 * ͨ��GET��ʽ��������
	 * @param url URL��ַ
	 * @param params ����
	 * @return 
	 * @throws Exception
	 */
	public  static String httpGet(String url, String params) throws Exception
	{
		String response = null; //������Ϣ
		//ƴ������URL
		if (null!=params&&!params.equals(""))
		{
			url += "?" + params;
		}
		
		int timeoutConnection = 3000;  
		int timeoutSocket = 5000;  
		HttpParams httpParameters = new BasicHttpParams();// Set the timeout in milliseconds until a connection is established.  
	    HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);// Set the default socket timeout (SO_TIMEOUT) // in milliseconds which is the timeout for waiting for data.  
	    HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);  
	    
		// ����HttpClient��ʵ��
		HttpClient httpClient = new DefaultHttpClient(httpParameters);  
		// ����GET������ʵ��
		HttpGet httpGet = new HttpGet(url);
		try
		{
			HttpResponse httpResponse = httpClient.execute(httpGet);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) //SC_OK = 200
			{
				// ��÷��ؽ��
				response = EntityUtils.toString(httpResponse.getEntity());
			}
			else
			{
				response = "�����룺"+statusCode;
			}
		} catch (Exception e)
		{
			throw new Exception(e);
		} 
		return response;
	}

	/**
	 * ͨ��POST��ʽ��������
	 * @param url URL��ַ
	 * @param params ����
	 * @return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * @throws Exception
	 */
	public  static String httpPost(String url, List<Parameter> params) throws ClientProtocolException, IOException 
	{
		String response = null;
		int timeoutConnection = 3000;  
		int timeoutSocket = 5000;  
		HttpParams httpParameters = new BasicHttpParams();// Set the timeout in milliseconds until a connection is established.  
	    HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);// Set the default socket timeout (SO_TIMEOUT) // in milliseconds which is the timeout for waiting for data.  
	    HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);  
		// ����HttpClient��ʵ��
		HttpClient httpClient = new DefaultHttpClient(httpParameters);  
		HttpPost httpPost = new HttpPost(url);
		if (params.size()>=0)
		{
			//����httpPost�������
			httpPost.setEntity(new UrlEncodedFormEntity(buildNameValuePair(params),HTTP.UTF_8));
		}
		//ʹ��execute��������HTTP Post���󣬲�����HttpResponse����
		
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		
		
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		if(statusCode==HttpStatus.SC_OK)
		{
			//��÷��ؽ��
			response = EntityUtils.toString(httpResponse.getEntity());
			
		}
		else
		{
			response = "�����룺"+statusCode;
		}
		return response;
	}
	
	/**
	 * ��Parameter���ͼ���ת����NameValuePair���ͼ���
	 * @param params ��������
	 * @return
	 */
	private static List<BasicNameValuePair> buildNameValuePair(List<Parameter> params)
	{
		List<BasicNameValuePair> result = new ArrayList<BasicNameValuePair>();
		for (Parameter param : params)
		{
			BasicNameValuePair pair = new BasicNameValuePair(param.getName(), param.getValue());
			result.add(pair);
		}
		return result;
	}
	
	
	public static List<Parameter> getParameter(Map<String,String> map){
		List<Parameter> params = new ArrayList<Parameter>();
		
		if(map!=null){
			for (String key : map.keySet()) {
		       	 
				String value = map.get(key);
				String name = key;
				
				Parameter p = new Parameter();
				p.setName(name);
				p.setValue(value);
				params.add(p);
	        }
		}
		
		
		return params;
	}
	
	
	
	public static void main(String[] args) throws Exception {
		String urlStr = "http://127.0.0.1:8080/as_hotel/method!register";
		
		Map<String ,String> map = new HashMap<String,String>();
		map.put("sex","Ů");
		map.put("dianhua", "13000000000");
		map.put("xingming", "aaa");
		map.put("password", "111111");
		map.put("username","ttyy");
 		
		for (String key : map.keySet()) {
       	 
            System.out.println("key= "+ key + " and value= " + map.get(key));
  
        }
		
		List<Parameter>  params = HttpUtil.getParameter(map);
		
		
		String response = HttpUtil.httpPost(urlStr,params);
		System.out.println(response);
	}
}
