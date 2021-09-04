package com.news.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * IO������
 */
public class IOHelper {
	
	/**
	 * ������·���л�ȡ��Դ����
	 * @param url
	 * @return
	 */
	public static String getName(String url){
		String result = null;
		if(null != url){
			result =  url.substring(url.lastIndexOf("smiley/") + 7);
			result =  result.replace("/", "-");
		}
		return result;
	}
	
	public static String getExtension(String name){
		return name.substring(name.lastIndexOf(".") + 1);
	}
	
	public static void copy(File src, File dest){
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		byte[] b = new byte[1024];
		
		try {
			bis = new BufferedInputStream(new FileInputStream(src));
			bos = new BufferedOutputStream(new FileOutputStream(dest));
			
			for(int count = -1; (count = bis.read(b)) != -1;){
				bos.write(b, 0, count);
			}
			bos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null!= bis){
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(null != bos){
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * ͳ��ָ��Ŀ¼�µ����ļ��Ĵ�С���ֽ���������������Ŀ¼�µ������ļ�
	 * @param baseDir
	 * @return
	 */
	public static long totalFileSize(File baseDir){
		long size = 0; 
		if ((baseDir != null) && (baseDir.isDirectory())) {
			File[] subs = baseDir.listFiles();
			int length = subs == null ? 0 : subs.length;
			for(int i = 0; i < length; i++){
				File sub = subs[i];
				if(sub.isFile()){
					size += sub.length();
				}else{
					size += totalFileSize(sub);
				}
			}
		}
		return size;
	}
	
	/**
	 * �h��ָ��Ŀ¼�µ������ļ�����������Ŀ¼�µ��ļ��������ر�ɾ�����ļ�����
	 * @param baseDir
	 * @return ��ɾ�����ļ�����
	 */
	public static int clearCacheFolder(File baseDir) {
		int count = 0;
		if ((baseDir != null) && (baseDir.isDirectory())) {
			File[] subs = baseDir.listFiles();
			int length = subs == null ? 0 : subs.length;
			for(int i = 0; i < length; i++){
				File sub = subs[i];
				if(sub.isFile()){
					if(sub.delete()){
						count++;
					}
				}else{
					if((!sub.getName().equals("smiley")))
						count += clearCacheFolder(sub);
				}
			}
		}
		return count;
	}
}
