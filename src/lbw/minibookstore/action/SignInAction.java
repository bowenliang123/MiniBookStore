package lbw.minibookstore.action;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lbw.minibookstore.dao.AccountDaoService;
import lbw.minibookstore.dao.BookDaoService;
import lbw.minibookstore.dao.OrderDaoService;
import lbw.minibookstore.model.Account;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class SignInAction extends ActionSupport {
	HttpServletRequest request;
	HttpServletResponse response;
	private static final long serialVersionUID = -1234332297344824000L;

	ApplicationContext ctx;
	AccountDaoService accDao;

	private String account;
	private String password;
	private String role;

	Configuration conf;
	SessionFactory sf;
	Session sess;

	public String execute() {
		init();

		this.role = accDao.valiadAccountByNamePassWord(this.account,this.password);

		if (!this.role.equals(Action.ERROR)) {

			Cookie roleCookie = new Cookie("role", this.role);
			Cookie accountNameCookie = new Cookie("account", this.account);

			response.addCookie(roleCookie);
			response.addCookie(accountNameCookie);
		}
		return this.role;
	}

	public void init() {
		ctx = new ClassPathXmlApplicationContext("bean.xml");
		accDao = ctx.getBean("accountDao", AccountDaoService.class);
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
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
