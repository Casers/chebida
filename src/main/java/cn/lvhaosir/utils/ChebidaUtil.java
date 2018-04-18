package cn.lvhaosir.utils;

import java.io.UnsupportedEncodingException;

public class ChebidaUtil {
	/**
	 * 为了解决，url传输中文，后台收到是乱码问题
	 * @param name
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String changeCharset(String name) throws UnsupportedEncodingException{
		return new String(name.getBytes("iso8859-1"),"UTF-8");
	}
}
