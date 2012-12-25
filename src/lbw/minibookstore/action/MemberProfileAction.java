package lbw.minibookstore.action;

import javax.servlet.http.HttpServletRequest;

import lbw.minibookstore.model.Account;
import lbw.minibookstore.utils.Utils;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class MemberProfileAction extends ActionSupport {

	private static final long serialVersionUID = 8454747985660132842L;

	HttpServletRequest request;
	private Account account;

	ApplicationContext ctx;

	public void init() {
		ctx = new ClassPathXmlApplicationContext("bean.xml");
		request = ServletActionContext.getRequest();
	}

	public String view() {
		init();
		String accountName = Utils.getAccountnameFromCookies(request);

		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		account = (Account) sess.get(Account.class, accountName);
		tx.commit();
		sess.close();
		sf.close();

		return Action.SUCCESS;
	}

	public String edit() {
		init();
		return Action.SUCCESS;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
