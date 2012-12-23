package lbw.minibookstore.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import lbw.minibookstore.model.Account;

import com.opensymphony.xwork2.ActionSupport;

public class Register extends ActionSupport {
	HttpServletRequest request;
	HttpServletResponse response;

	private static final long serialVersionUID = 1L;

	private Account accountBean;

	@Override
	public String execute() throws Exception {

		// call Service class to store personBean's state in database
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();

		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		Account a = (Account) sess
				.get(Account.class, accountBean.getNickName());
		if (a != null) {
			addFieldError("accountBean.nickName", "无法注册，系统已有相同ID，请修改。");
			return INPUT;
		}
		accountBean.setRole("member");
		sess.save(accountBean);
		tx.commit();
		sess.close();
		sf.close();
		return SUCCESS;

	}

	@Override
	public void validate() {
		if (accountBean.getRole().equals("4")) {
			this.addFieldError("accountBean.role", "4??");
		}
	}

	public Account getAccountBean() {

		return accountBean;

	}

	public void setAccountBean(Account account) {

		accountBean = account;

	}

}