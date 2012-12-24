package lbw.minibookstore.action;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import lbw.minibookstore.utils.Utils;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;



public class GetUserNameAction extends ActionSupport {
	
	private String userName;
	private String role;

	@Override
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		this.setUserName(Utils.getAccountnameFromCookies(request));
		this.setRole(Utils.getRoleFromCookies(request));
		return SUCCESS;
	}
	
	
	public static HashMap<String, String> parseCookiesToMap(Cookie[] cookies) {
		HashMap<String, String> hm = new HashMap<String, String>();
		for (Cookie cookie : cookies) {
			hm.put(cookie.getName(), cookie.getValue());
		}
		return hm;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
}
