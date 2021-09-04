package com.news.util;




import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.news.activity.R;



/**
 * �첽����ͼƬ��Background��
 */
public class MyBackAsynaTask extends AsyncTask<String,Void,String>{
	private String themb;
	private ImageView iv;

	public MyBackAsynaTask(String themb,ImageView iv){
		this.themb=themb;
		this.iv=iv;
	}
	@Override
	protected String doInBackground(String... params) {
		if(themb!=null){
			return themb;
		}
		return null;
	}
	
	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		if(result!=null && !"".equals(result)&& !"null".equals(result)){
//			//����Զ��ͼƬ
			ImageLoader.getInstance().asyncLoadBitmap(result, new ImageLoader.ImageCallback() {
				@Override
				public void imageLoaded(Bitmap bmp, String url) {
					if(bmp!=null){
						//Bitmap bitmap=getBitmap(bmp, bmp.getWidth());
						iv.setBackgroundDrawable(new BitmapDrawable(bmp));
					}else{
						iv.setBackgroundResource(R.drawable.category_icon_123);
					}
				}
			});
		}else{
			iv.setBackgroundResource(R.drawable.category_icon_123);
		}
	}
	/***
	 * ��ͼƬ����
	 * @author zhangjia
	 */
	public Bitmap getBitmap(Bitmap bitmap, int width) {
		int w = bitmap.getWidth();
		int h = bitmap.getHeight();
		Matrix matrix = new Matrix();
		float scale = (float) width / w;
		System.out.println("scale-->" + scale);
		// ��֤ͼƬ������.
		matrix.postScale(scale, scale);
		// w,h��ԭͼ������.
		return Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, true);
	}
	@Override
	protected void onCancelled() {
		super.onCancelled();
	}
	}