package lbw.minibookstore.action;


import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class SignInAction extends ActionSupport {
	HttpServletRequest request;
	HttpServletResponse response;
	private static final long serialVersionUID = -1234332297344824000L;

	private String account;
	private String password;
	private String role;

	public String execute() {
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		String sql = "select account.role from Account as account";
		sql+=" where account.nickName='"+this.account+"' and account.password='"+this.password+"'";
		List list =  (List) sess.createQuery(sql).list();
		if (list.size()>0){
			
			this.role=(String) list.get(0);
			Cookie roleCookie = new Cookie("role", this.role);
			response.addCookie(roleCookie);
			Cookie accountNameCookie = new Cookie("account", this.role);
			response.addCookie(accountNameCookie);
		}
		tx.commit();
		sess.close();
		sf.close();
		
		
		return role;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
