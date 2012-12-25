package lbw.minibookstore.utils;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Utils {

	public static String getAccountnameFromCookies(HttpServletRequest request) {
		HashMap<String, String> cookiesMap = parseCookiesToMap(request
				.getCookies());
		return cookiesMap.get("account");
	}

	public static String getRoleFromCookies(HttpServletRequest request) {
		HashMap<String, String> cookiesMap = parseCookiesToMap(request
				.getCookies());
		return cookiesMap.get("role");
	}

	public static HashMap<String, String> parseCookiesToMap(Cookie[] cookies) {
		HashMap<String, String> hm = new HashMap<String, String>();
		for (Cookie cookie : cookies) {
			hm.put(cookie.getName(), cookie.getValue());
		}
		return hm;
	}

	public static Timestamp generateSqlTime() {
		// 获得系统时间
		java.util.Date date = new java.util.Date();
		// 将时间格式转换成符合Timestamp要求的格式
		String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(date);
		java.sql.Timestamp time = java.sql.Timestamp.valueOf(nowTime);
		return time;
	}
}
