package com.wechat.util;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * 校验的工具类
 * @author aibinxiao
 * @date 2017年6月1日 上午11:39:14
 */
public class CheckUtil {
	// Token可由开发者可以任意填写,用作生成签名（该Token会和接口URL中包含的Token进行比对，从而验证安全性）
	private static String token = "feiyucoding";
	
	/**
	 * 校验签名
	 * @param signature 签名
	 * @param timestamp 时间戳
	 * @param nonce     随机数字
	 * @return
	 */
	public static boolean checkSignature(String signature,String timestamp,String nonce){
		String[] arr = new String[]{token,timestamp,nonce};
		// 1.将token、timestamp、nonce三个参数进行字典序排序
		Arrays.sort(arr);
		
		// 2.将三个参数字符串拼接成一个字符串
		StringBuffer content = new StringBuffer();
		for(int i=0;i<arr.length;i++){
			content.append(arr[i]);
		}
		
		// 3.将拼接成的字符串进行sha1加密
		String temp = getSha1(content.toString());
		
		return temp.equals(signature);
	}
	
	/**
	 * SHA1加密算法
	 * @param str
	 * @return
	 */
	public static String getSha1(String str){
		if(str==null || str.length()==0){
			return null;
		}
		char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9',
				'a','b','c','d','e','f'};
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
			mdTemp.update(str.getBytes("UTF-8"));
			
			byte[] md = mdTemp.digest();
			int j = md.length;
			char buf[] = new char[j * 2];
			int k = 0;
			for (int i=0;i<j;i++){
				byte byte0 = md[i];
				buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
				buf[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(buf);
		} catch (Exception e) {
			return null;
		}
	}
}
