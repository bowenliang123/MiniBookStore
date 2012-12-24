package lbw.minibookstore.utils;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Utils {
	
	public static String getAccountnameFromCookies(HttpServletRequest request){
		HashMap<String, String> cookiesMap = parseCookiesToMap(request
				.getCookies());
		return cookiesMap.get("account");
	}
	
	public static String getRoleFromCookies(HttpServletRequest request){
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

}
