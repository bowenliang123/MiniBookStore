package lbw.minibookstore.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import lbw.minibookstore.dao.AccountDaoService;
import lbw.minibookstore.model.Account;
import lbw.minibookstore.model.Book;

public class AccountDaoImpl implements AccountDaoService {

	@Override
	public String valiadAccountByNamePassWord(String accountName,
			String password) {
		// TODO Auto-generated method stub
		String result="error";
		
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		Account account = (Account)sess.get(Account.class, accountName);
		if (account!=null && account.getPassword().equals(password)){
			result = account.getRole();
		}
		tx.commit();
		sess.close();
		return result;
	}

}
