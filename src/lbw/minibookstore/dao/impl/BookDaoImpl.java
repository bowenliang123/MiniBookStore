package lbw.minibookstore.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import lbw.minibookstore.dao.BookDaoService;
import lbw.minibookstore.model.Account;
import lbw.minibookstore.model.Book;
import lbw.minibookstore.model.BookOrder;
import lbw.minibookstore.model.FullOrder;

public class BookDaoImpl implements BookDaoService {

	@Override
	public Book getBookInfoById(int bookId) {
		// TODO Auto-generated method stub
		
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		Book book = (Book) sess.get(Book.class, bookId);
		tx.commit();
		sess.close();
		
		return book;
	}

	

}
