package com.news.util;

import android.os.Environment;

/**
 * ������
 */
public final class Constants {
	/** ϵͳ��ʼ�������ļ��� */
	public static final String SYSTEM_INIT_FILE_NAME = "sysini";
	/** ���ػ���Ŀ¼ */
	public static final String CACHE_DIR;
	
	public static final int PAGESIZE=10;
	/** ���黺��Ŀ¼ */
	public static final String CACHE_DIR_SMILEY;
	/** ͼƬ����Ŀ¼ */
	public static final String CACHE_DIR_IMAGE;
	/** ���ϴ�ͼƬ����Ŀ¼ */
	public static final String CACHE_DIR_UPLOADING_IMG;


	static {
		if (Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState())) {
			CACHE_DIR = Environment.getExternalStorageDirectory().getAbsolutePath() + "/CangShengWang/";
		} else {
			CACHE_DIR = Environment.getRootDirectory().getAbsolutePath() + "/CangShengWang/";
		}
		
		CACHE_DIR_SMILEY = CACHE_DIR + "/smiley";
		CACHE_DIR_IMAGE = CACHE_DIR + "/pic";
		CACHE_DIR_UPLOADING_IMG = CACHE_DIR + "/uploading_img";
	}
	
	
}
