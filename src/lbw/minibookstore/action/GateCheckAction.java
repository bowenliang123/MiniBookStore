package lbw.minibookstore.action;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class GateCheckAction extends ActionSupport {
	HttpServletRequest request;
	HttpServletResponse response;

	private String role;
	private String userName;

	public static final String NOT_SIGNED_IN = "notSignedIn";
	public static final String ROLE_ADMIN = "admin";
	public static final String ROLE_USER = "user";
	public static final String ROLE_MEMBER = "member";

	private static final long serialVersionUID = 199705214825786273L;

	@Override
	public String execute() throws Exception {
		request = ServletActionContext.getRequest();
		HashMap<String, String> cookiesMap = parseCookiesToMap(request
				.getCookies());
		setRole(cookiesMap.get("role"));
		setUserName(cookiesMap.get("userName"));
		if (this.role == null)
			return NOT_SIGNED_IN;
		else {
			switch (cookiesMap.get("role")) {
			case ROLE_ADMIN:
				return ROLE_ADMIN;

			case ROLE_USER:
				return ROLE_USER;

			case ROLE_MEMBER:
				return ROLE_MEMBER;

			default:
				return NOT_SIGNED_IN;
			}
		}

	}

	public static HashMap<String, String> parseCookiesToMap(Cookie[] cookies) {
		HashMap<String, String> hm = new HashMap<String, String>();
		for (Cookie cookie : cookies) {
			hm.put(cookie.getName(), cookie.getValue());
		}
		return hm;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
