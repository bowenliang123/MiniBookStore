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

	@Override
	public void makeOrder(String accountName, int bookId, int bookCount) {
		// TODO Auto-generated method stub
		BookOrder order = new BookOrder(accountName, bookId, bookCount);
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(order);
		tx.commit();
		sess.close();
	}

	@Override
	public List<FullOrder> viewOrder(String accountName) {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		List<FullOrder> list=sess.createQuery("from FullOrder").list();
		System.out.println(list.size());
		tx.commit();
		sess.close();
		return list;
	}

}
