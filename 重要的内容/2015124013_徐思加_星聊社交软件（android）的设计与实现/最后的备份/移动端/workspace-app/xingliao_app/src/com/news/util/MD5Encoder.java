package com.news.util;

import java.security.MessageDigest;

/**
 * 
 * ��˵��:Ϊ�����ַ�������MD5����
 * 
 */
public class MD5Encoder {
	/**
	 * 
	 * ����˵��:�����ַ���
	 * 
	 * @param Դ�ַ���
	 * @return ���ܺ���ַ���
	 */
	public static String encode(String src) {
		String resultString = null;
		try {
			resultString = new String(src);
			MessageDigest md = MessageDigest.getInstance("MD5");
			//���м���
			resultString = byte2hexString(md.digest(resultString.getBytes()));
		} catch (Exception ex) {
		}
		return resultString;
	}

	/**
	 * 
	 * ����˵��:���ֽ�����ת�����ַ���.
	 * 
	 * @param bytes
	 * @return
	 */
	private static final String byte2hexString(byte[] bytes) {
		StringBuffer buf = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			if (((int) bytes[i] & 0xff) < 0x10) {
				buf.append("0");
			}
			buf.append(Long.toString((int) bytes[i] & 0xff, 16));
		}
		return buf.toString();
	}

}
