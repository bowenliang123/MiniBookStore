package lbw.minibookstore.action;

import java.util.LinkedList;
import java.util.List;

import lbw.minibookstore.model.Account;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionSupport;

public class BookListAction extends ActionSupport {
	private List<Account> bookList;

	@Override
	public String execute(){
		setBookList(generateBookList());
		return SUCCESS;
	}
	
	public List generateBookList(){
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		bookList =  sess.createQuery("from Book").list();
		tx.commit();
		sess.close();
		sf.close();
		return bookList;
	}

	public List<Account> getBookList() {
		return bookList;
	}

	public void setBookList(List<Account> bookList) {
		this.bookList = bookList;
	}

	
	
}
