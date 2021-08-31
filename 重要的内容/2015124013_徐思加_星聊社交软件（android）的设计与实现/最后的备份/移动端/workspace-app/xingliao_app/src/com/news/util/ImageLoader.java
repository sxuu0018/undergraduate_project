package com.news.util;

import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpStatus;

import android.graphics.Bitmap;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;




public class ImageLoader {
	public static final String TAG = "ImageLoader";
	
	private final static ImageLoader imageLoader = new ImageLoader();
	
	private static ConcurrentHashMap<String, SoftReference<Bitmap>> imageCache = new ConcurrentHashMap<String, SoftReference<Bitmap>>();
	
	private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(6,30, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
	
	private ImageLoader(){}
	
	public static ImageLoader getInstance(){
	    return imageLoader;
	}
	
	public interface ImageCallback {
		/** ͼƬ������ɵĻص����� */
		public void imageLoaded(Bitmap bmp, String url);
	}
	
	public static void downloadBitmap(final String url){
		String destFileName = MD5Encoder.encode(url);
		File dest = new File(Constants.CACHE_DIR_IMAGE, destFileName);
		if(!dest.exists()){
			try {
				HttpHelper.download(url, dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * �첽����ָ��url����ͼƬ���õ�imageView��<br/>
	 * ע�⣺��ԭ��Ⱥ�Ŀ���ȵ����űȶ�ԭͼƬ���������š�
	 * @param url
	 * @param width
	 * @param imageView
	 */
	public void asyncLoadBitmap(final String url, final int width, final ImageCallback callback) {
        Bitmap bitmap = getBitmapFromCache(url);
        if (null != bitmap) { //�ڴ�
        	callback.imageLoaded(bitmap, url);
        } else if((bitmap = getBitmapFromDisk(url)) != null){ //����
        	callback.imageLoaded(bitmap, url);
        }else {
        	Handler handler = new Handler(){
    			@Override
    			public void handleMessage(Message msg) {
    				if(HttpStatus.SC_OK == msg.what){
    					Bitmap bitmap = (Bitmap)msg.obj;
    					callback.imageLoaded(bitmap, url);
    				}
    			}
    		};
    		threadPool.execute(new LoadBitmapRunnable(url, width, handler));
        }
    }
	
	/**
	 * �첽����ָ��url����ͼƬ���õ�imageView��<br/>
	 * @param url
	 * @param imageView
	 */
	public void asyncLoadBitmap(final String url, final ImageCallback callback) {
		Bitmap bitmap = getBitmapFromCache(url);
        if (null != bitmap) { //�ڴ�
        	callback.imageLoaded(bitmap, url);
        } else if((bitmap = getBitmapFromDisk(url)) != null){ //����
        	callback.imageLoaded(bitmap, url);
        } else {
    		Handler handler = new Handler(){
    			@Override
    			public void handleMessage(Message msg) {
    				if(HttpStatus.SC_OK == msg.what){
    					Bitmap bitmap = (Bitmap)msg.obj;
    					callback.imageLoaded(bitmap, url);
    				}else{
    					callback.imageLoaded(null,url);
    				}
    			}
    		};
    		threadPool.execute(new LoadBitmapRunnable(url,-1, handler));
        }
    }

	private static Bitmap getBitmapFromCache(String url) {
        SoftReference<Bitmap> bitmapReference = imageCache.get(url);
        if (bitmapReference != null && bitmapReference.get() != null){
        	Log.d(TAG, "in cache-->" + url);
            return bitmapReference.get();
        } else { //��bitmap�����ѱ������ͷţ���Ҫ���¼���
        	imageCache.remove(url);
        }
        return null;
    }
	
	public static Bitmap getBitmapFromDisk(String url){
		Bitmap bmp = null;
		
		//String name = IOHelper.getName(url);
		//String ext = IOHelper.getExtension(name);
		String destFileName = MD5Encoder.encode(url);
		
		if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
			File dest = new File(Constants.CACHE_DIR_IMAGE, destFileName);
			if(dest.exists()){
				try {
					bmp = ImageHelper.loadFromFile(dest);
					Log.d(TAG, "in SD-->" + url);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return bmp;
	}
	
	private class LoadBitmapRunnable implements Runnable{
		private String url;
		private Handler handler;
		private int width;
		
		public LoadBitmapRunnable(final String url, final int width, final Handler handler){
			this.url = url;
			this.handler = handler;
			this.width = width;
		}
		@Override
		public void run() {
			Message msg = handler.obtainMessage(HttpStatus.SC_OK);
			Bitmap bmp = null;
			try {
				/*
				if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
					//String name = IOHelper.getName(url);
					//String ext = IOHelper.getExtension(name);
					String destFileName = MD5Encoder.encode(url);
					
					File dest = new File(Constants.CACHE_DIR_IMAGE, destFileName);
					if(!dest.exists()){
						try {
							HttpHelper.download(url, dest);
							
							bmp = ImageHelper.loadFromFile(dest);
							
							imageCache.put(url, new SoftReference<Bitmap>(bmp)); //�����ڴ滺��
							msg.obj = bmp;
							handler.sendMessage(msg);
							
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}else{*/
				bmp = HttpHelper.downloadBitmap(url);
				
				//System.out.println("size bmp download-->" + bmp.getByteCount());
				if(null != bmp){
					if(width > 0){
						bmp = ImageHelper.zoom(bmp, width);
					}
					imageCache.put(url, new SoftReference<Bitmap>(bmp)); //�����ڴ滺��
					msg.obj = bmp;
					handler.sendMessage(msg);
					//д����
					String destFileName = MD5Encoder.encode(url);
					File dest = new File(Constants.CACHE_DIR_IMAGE, destFileName);
					if(!dest.exists()){
						ImageHelper.write(bmp, dest);
					}
				}
			} catch (IOException e) {
				msg.what = HttpStatus.SC_INTERNAL_SERVER_ERROR;
				e.printStackTrace();
			}
			
			if(null != bmp){
				Log.d(TAG, "bmp.width=" + bmp.getWidth() +",bmp.height=" + bmp.getHeight() + "-->" + url);
			}else{
				Log.d(TAG, "Bitmap is null -->" + url);
			}
		}
	} 
}
