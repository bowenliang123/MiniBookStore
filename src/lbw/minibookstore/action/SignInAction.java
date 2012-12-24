package lbw.minibookstore.action;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lbw.minibookstore.model.Account;

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
	private List<Account> accountList;

	Configuration conf;
	SessionFactory sf;
	Session sess;

	public String execute() {
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();

		this.role = ERROR;
		try {
			conf = new Configuration().configure();
			sf = conf.buildSessionFactory();
			sess = sf.openSession();
			Transaction tx = sess.beginTransaction();
			String hql = "from Account as account";
			hql += " where account.nickName='" + this.account
					+ "' and account.password='" + this.password + "'";
			accountList = sess.createQuery(hql).list();
			if (accountList.size()<=0){
				return ERROR;
			}
			
			Account a = accountList.get(0);
			this.role = a.getRole();
			this.account = a.getNickName();

			Cookie roleCookie = new Cookie("role", this.role);
			Cookie accountNameCookie = new Cookie("account", this.account);

			response.addCookie(roleCookie);
			response.addCookie(accountNameCookie);

			tx.commit();
		} finally {
			sess.close();
			sf.close();
		}

		return this.role;
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
