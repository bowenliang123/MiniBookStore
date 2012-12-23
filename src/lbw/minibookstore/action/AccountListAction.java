package lbw.minibookstore.action;

import java.util.LinkedList;
import java.util.List;

import lbw.minibookstore.model.Account;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionSupport;

public class AccountListAction extends ActionSupport {
	private List<Account> accountList;

	@Override
	public String execute(){
		setAccountList(generateAccountList());
		return SUCCESS;
	}
	
	public List generateAccountList(){
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		accountList =  sess.createQuery("from Account").list();
		tx.commit();
		sess.close();
		sf.close();
		return accountList;
	}

	public List getAccountList() {
		return accountList;
	}

	public void setAccountList(List accountList) {
		this.accountList = accountList;
	}
	
}
