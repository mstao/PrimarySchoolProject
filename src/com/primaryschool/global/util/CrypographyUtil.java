package com.primaryschool.global.util;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 加密处理
 * @author mingshan
 *
 */
public class CrypographyUtil {

	
	/**
	 * base64加密
	 */
	public static String encodeBase64(String s){
		return Base64.encodeToString(s.getBytes());
	}
	
	public static String  decodeBase64(String s){
		return Base64.decodeToString(s);
	}
	
	
	/**
	 * Md5加密
	 */
	
	public static  Object MD5(String username,String password,String saltz){
	   // return new Md5Hash(s,salt).toString();
	    
	    //hashIterations加密的次数1024
		String hashAlgorithmName = "MD5";
		Object credentials = (Object)password;
		//加点盐
		Object salt = ByteSource.Util.bytes(saltz);
		int hashIterations = 1024;
		
		Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		return result;
	}
	
	
}
