package com.news.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.View;
import android.widget.ImageView;
import android.widget.SimpleAdapter.ViewBinder;

/**
 * ͼƬ��������
 */
public class ImageHelper {
	
	public static Bitmap getHttpBitmap(String url){  
	    URL myurl = null;  
	    InputStream in = null;  
	    Bitmap bitmap=null;
	    try{  
	    	myurl = new URL(url);  
	        HttpURLConnection conn = (HttpURLConnection)myurl.openConnection();  
	        conn.setConnectTimeout(0);  
	        conn.setDoInput(true);  
	        conn.connect();  
	        in = conn.getInputStream();  
	         bitmap = BitmapFactory.decodeStream(in);  
	    }catch (IOException e){  
	        e.printStackTrace();  
	    }  
	    finally{  
	    	 try {
	    		 if (null != in){  in.close(); }
	    	 }catch(IOException e) {
				e.printStackTrace();
			}  
	    }  
	    return bitmap;  
	}  
	/**
	 * ���ر���ͼƬ
	 * 
	 * @param url
	 * @return
	 */
	public static Bitmap getLoacalBitmap(String url) {
		try {
			FileInputStream fis = new FileInputStream(url);
			return BitmapFactory.decodeStream(fis); // /����ת��ΪBitmapͼƬ
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * ������ԴID��ȡ��Ӧ��Bitmapʵ��
	 * @param ctx
	 * @param id
	 * @return
	 */
	public static Bitmap getBitmap(Context ctx, int id){
		return BitmapFactory.decodeResource(ctx.getResources(), id);
	}
	
	/**
	 * ��png��jpg(jpeg)��ʽͼƬ��ָ������д��ָ��Ŀ¼��
	 * @param bmp
	 * @param path
	 * @param fileName
	 */
	public static void write(Bitmap bmp, File file){
		FileOutputStream fos = null;
		
		try {
			if(!file.exists()){
				file.createNewFile();
			}
			fos = new FileOutputStream(file);
			bmp.compress(Bitmap.CompressFormat.PNG, 75, fos);
			
			fos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(null != fos){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * ��png��jpg(jpeg)��ʽͼƬ��ָ������д��ָ��Ŀ¼��
	 * @param bmp
	 * @param path
	 * @param fileName
	 */
	public static void write(Bitmap bmp, String fileName){
		String extension = IOHelper.getExtension(fileName);
		FileOutputStream fos = null;
		
		try {
			File file = new File(fileName);
			if(!file.exists()){
				file.createNewFile();
			}
			fos = new FileOutputStream(file);
			
			if("png".equalsIgnoreCase(extension)){
				bmp.compress(Bitmap.CompressFormat.PNG, 75, fos);
			}else if("jpg".equalsIgnoreCase(extension) || "jpeg".equalsIgnoreCase(extension)){
				bmp.compress(Bitmap.CompressFormat.JPEG, 75, fos);
			}
			
			fos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(null != fos){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * ��png��jpg(jpeg)��ʽͼƬ��ָ������д��ָ��Ŀ¼��
	 * @param bmp
	 * @param path
	 * @param fileName
	 */
	public static void write(Bitmap bmp, String path, String fileName){
		String extension = IOHelper.getExtension(fileName);
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(new File(path, fileName));
			
			if("png".equalsIgnoreCase(extension)){
				bmp.compress(Bitmap.CompressFormat.PNG, 75, fos);
			}else if("jpg".equalsIgnoreCase(extension) || "jpeg".equalsIgnoreCase(extension)){
				bmp.compress(Bitmap.CompressFormat.JPEG, 75, fos);
			}
			
			fos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(null != fos){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static Bitmap loadFromFile(File name) throws IOException{
		Bitmap bmp = null;
		InputStream is = null;
		try {
			is = new FileInputStream(name);
			bmp = BitmapFactory.decodeStream(is);
		} catch (IOException e) {
			throw e;
		}finally{
			if(null != is){
				try {
					is.close();
				} catch (IOException e) {
					throw e;
				}
			}
		}
		return bmp;
	}
	
	public static Bitmap loadFromFile(String name) throws IOException{
		Bitmap bmp = null;
		InputStream is = null;
		try {
			is = new FileInputStream(name);
			bmp = BitmapFactory.decodeStream(is);
		} catch (IOException e) {
			throw e;
		}finally{
			if(null != is){
				try {
					is.close();
				} catch (IOException e) {
					throw e;
				}
			}
		}
		return bmp;
	}
	
	/**
	 * ͼƬ�����ţ���ͼƬ��ԭ��Ⱥ�Ŀ������Ϊ���ű�
	 * @param src ԴͼƬ
	 * @param destWidth Ŀ����
	 * @return
	 */
	public static Bitmap zoom(Bitmap src, int destWidth){
		int width = src.getWidth();
	    int height = src.getHeight();
	    if(width == destWidth )
	    {
	    	width = width-1;
	    	height = height - 1;
	    }
	    // �������ű���
	    float scaleWidth = ((float) destWidth) / width;
	    //float scaleHeight = ((float) destHeight) / height;
	    // ȡ����Ҫ���ŵ�matrix����
	    Matrix matrix = new Matrix();
	    
	    matrix.postScale(scaleWidth, scaleWidth);
	    
	    
	    // �õ��µ�ͼƬ
	    Bitmap b = Bitmap.createBitmap(src, 0, 0, width, height, matrix, true);
	    src.recycle();
	    src=null;
	    return b;
	}
	
	public static Bitmap zoom(Bitmap src, int destWidth, int destHeight){
		int width = src.getWidth();
	    int height = src.getHeight();
	    if(width == destWidth || height == destHeight )
	    {
	    	width = width-1;
	    	height = height - 1;
	    }
	    // �������ű���
	    float scaleWidth = ((float) destWidth) / width;
	    //float scaleHeight = ((float) destHeight) / height;
	    // ȡ����Ҫ���ŵ�matrix����
	    Matrix matrix = new Matrix();
	    
	    matrix.postScale(scaleWidth, scaleWidth);
	    
	    // �õ��µ�ͼƬ
	    Bitmap b = Bitmap.createBitmap(src, 0, 0, width, height, matrix, true);
	    src.recycle();
	    return b;
	}
	/**
	 * ����ͼƬ���ƣ���assets�м��ض�Ӧ��Bitmap����
	 * @param ctx
	 * @param fileName
	 * @return
	 */
    public static Bitmap getImageFromAssetsFile(Context ctx, String fileName){
        Bitmap image = null;
        AssetManager am = ctx.getResources().getAssets();
        InputStream is = null;
        try{
            is = am.open(fileName);
            image = BitmapFactory.decodeStream(is);
            
        }catch (IOException e){
            e.printStackTrace();
        }finally{
        	if(null != is){
        		try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        }

        return image;
    }
    
    /**
     * ͼ��������
     * @author qjyong
     */
    public static class MyViewBinder implements ViewBinder {
		public boolean setViewValue(View view, Object data,
				String textRepresentation) {
			if ((view instanceof ImageView) && (data instanceof Bitmap)) {
				ImageView iv = (ImageView) view;
				Bitmap bm = (Bitmap) data;
				iv.setImageBitmap(bm);

				return true;
			}
			return false;
		}
	}
	
}
