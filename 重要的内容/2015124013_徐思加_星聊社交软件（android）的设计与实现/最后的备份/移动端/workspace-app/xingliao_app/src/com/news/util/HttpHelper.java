package com.news.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

/**
 * HttpClient�������󲢷����ַ������ݵĹ�����<br/>
 * ע�⣺��Ҫ���Ȩ��&lt;uses-permission android:name="android.permission.INTERNET"/&gt;
 */
public class HttpHelper {
	/** ��������̰߳�ȫ�� */
	private static HttpClient httpClient;
	
	static {
		if(null == httpClient){
			//httpClient = new DefaultHttpClient();
			//httpClient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
			//httpClient.getParams().setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 20000);
			
			//���´��봦����ͬһ��HttpClientͬʱ�����������ʱ���ܷ����Ķ��߳�����
			HttpParams httpParams = new BasicHttpParams();
			
			HttpProtocolParams.setVersion(httpParams, HttpVersion.HTTP_1_1);
			HttpProtocolParams.setContentCharset(httpParams, HTTP.UTF_8);
			HttpProtocolParams.setUseExpectContinue(httpParams, true);
			
			// �������������  
	        ConnManagerParams.setMaxTotalConnections(httpParams, 10000);  
	        // ���û�ȡ���ӵ����ȴ�ʱ��  
	        ConnManagerParams.setTimeout(httpParams, 60000);  
	        // ����ÿ��·�����������  
	        ConnPerRouteBean connPerRoute = new ConnPerRouteBean(10000);
	        ConnManagerParams.setMaxConnectionsPerRoute(httpParams,connPerRoute);  
	        // �������ӳ�ʱʱ��  
	        HttpConnectionParams.setConnectionTimeout(httpParams, 20000);
	        // ���ö�ȡ��ʱʱ��  
	        HttpConnectionParams.setSoTimeout(httpParams, 30000);
			
			SchemeRegistry schreg = new SchemeRegistry();
			schreg.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
			schreg.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
			
			ClientConnectionManager connManager = new  ThreadSafeClientConnManager(httpParams, schreg);
			
			httpClient = new DefaultHttpClient(connManager, httpParams);
		}
	}
	public static HttpClient getHttpClient(){
		return httpClient;
	}
	
	/**
	 * ����GET���󣬲�������Ӧ��Ϣ����ַ�������
	 * @param url ����URL
	 * @return ��Ӧ��Ϣ����ַ�������
	 * @throws IOException
	 */
	public static String get(String url) throws IOException{
	    String result = null;
	    HttpGet get = new HttpGet(url);
	    HttpResponse response = httpClient.execute(get);
	    if(HttpStatus.SC_OK == response.getStatusLine().getStatusCode()){ 
	        result = EntityUtils.toString(response.getEntity());
	    }
	    return result;
	}
	
	/**
	 * ����POST���󣬲�������Ӧ��Ϣ����ַ�������
	 * @param url ����URL
	 * @return ��Ӧ��Ϣ����ַ�������
	 * @throws IOException
	 */
	public static String post(String url, HashMap<String, String> params)throws IOException{
		String result = null;
		HttpPost post = new HttpPost(url);
		if(null != params){
			List<NameValuePair> pairList = new ArrayList<NameValuePair>();
			for (Entry<String, String> paramPair : params.entrySet()) {
				NameValuePair pair = new BasicNameValuePair(paramPair.getKey()
						, paramPair.getValue());
				pairList.add(pair);
			}
			HttpEntity entity = new UrlEncodedFormEntity(pairList, HTTP.UTF_8);
			post.setEntity(entity);
		}
		HttpResponse response = httpClient.execute(post);
	    if(HttpStatus.SC_OK == response.getStatusLine().getStatusCode()){
	        result = EntityUtils.toString(response.getEntity());
	    }
		return result;
	}
	
	/**
	 * ����POST������Ϣ��ʹ��multipart/form-data���룬��֧�ֶ���ͨ�ֶκͶ��ļ���ͬʱ�ϴ�
	 * @param url ����URL
	 * @param params ��ͨ�ַ�������Map
	 * @param fileMap ���ϴ����ļ�����Map
	 * @return ��Ӧ��Ϣ����ַ�������
	 * @throws IOException
	 */
	public static String multipartPost(String url, HashMap<String, String> params, HashMap<String, File> fileMap) throws IOException{
		String result = null;
		HttpPost post = new HttpPost(url);
		
        MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE); 
        
        //�����������
        if(null != params){
	       for (Entry<String, String> paramPair : params.entrySet()) {
	    	   entity.addPart(paramPair.getKey(), new StringBody(paramPair.getValue(), Charset.forName(HTTP.UTF_8)));
	       }
        }
        
        //�����ļ�����
        if(null != fileMap){
 	       for (Entry<String, File> paramPair : fileMap.entrySet()) {
 	    	   entity.addPart(paramPair.getKey(), new FileBody(paramPair.getValue()));
 	       }
        }
        post.setEntity(entity);
		
		HttpResponse response = httpClient.execute(post);
	    if(200 == response.getStatusLine().getStatusCode()){
	        result = EntityUtils.toString(response.getEntity());
	    }

		return result;
	}
	
	/**
	 * �ļ�����
	 * @param url ����URL
	 * @param dest Ŀ���ļ�����
	 * @throws IOException
	 */
	public static void download(String url, File dest) throws IOException{
		HttpGet get = new HttpGet(url);
	    HttpResponse response = httpClient.execute(get);
	    if(HttpStatus.SC_OK == response.getStatusLine().getStatusCode()){
	    	HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream bis = null;
                BufferedOutputStream bos = null;
                byte[] b = new byte[4096];
                try {
                    bis = entity.getContent();
                    bos = new BufferedOutputStream(new FileOutputStream(dest));
        			for(int count = -1; (count = bis.read(b)) != -1;){
        				bos.write(b, 0, count);
        			}
        			bos.flush();
                } finally {
                    if (bis != null) {
                        bis.close();
                    }
                    if (bos != null) {
                        bos.close();
                    }
                    entity.consumeContent();
                }
            }
	    }
	}
	
	/**
	 * ����Զ��ͼƬ��Drawable����
	 * @param url ͼƬ·��
	 * @return 
	 * @throws IOException
	 */
	public static Drawable loadDrawable(String url, String name) throws IOException{
		Drawable d = null;
		HttpGet get = new HttpGet(url);
	    HttpResponse response = httpClient.execute(get);
	    if(HttpStatus.SC_OK == response.getStatusLine().getStatusCode()){
	    	HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream is = null;
                try {
                    is = entity.getContent();
                    
                    d = Drawable.createFromStream(is, name);
                    
                } catch(IOException e){
                	throw e;
                }finally {
                    if (is != null) {
                        is.close();
                    }
                    entity.consumeContent();
                }
            }
	    }
	    return d;
	}
	
	/**
	 * ����Զ��ͼƬ��Bitmap����
	 * @param url ͼƬ·��
	 * @return 
	 * @throws IOException
	 */
	public static Bitmap downloadBitmap(String url) throws IOException{
		Bitmap bmp = null;
		HttpGet get = new HttpGet(url);
	    HttpResponse response = httpClient.execute(get);
	    if(HttpStatus.SC_OK == response.getStatusLine().getStatusCode()){
	    	HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream is = null;
                try {
                    is = entity.getContent();
                   bmp = BitmapFactory.decodeStream(new FlushedInputStream(is));
                } catch(IOException e){
                	throw e;
                }finally {
                    if (is != null) {
                        is.close();
                    }
                    entity.consumeContent();
                }
            }
	    }else{
	    	return bmp;
	    }
	    return bmp;
	}
	
    /*
     * An InputStream that skips the exact number of bytes provided, unless it reaches EOF.
     */
    private static class FlushedInputStream extends FilterInputStream {
        public FlushedInputStream(InputStream inputStream) {
            super(inputStream);
        }
        @Override
        public long skip(long n) throws IOException {
            long totalBytesSkipped = 0L;
            while (totalBytesSkipped < n) {
                long bytesSkipped = in.skip(n - totalBytesSkipped);
                if (bytesSkipped == 0L) {
                    int b = read();
                    if (b < 0) {
                        break;  // we reached EOF
                    } else {
                        bytesSkipped = 1; // we read one byte
                    }
                }
                totalBytesSkipped += bytesSkipped;
            }
            return totalBytesSkipped;
        }
    }
	
}