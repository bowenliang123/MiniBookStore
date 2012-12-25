package lbw.minibookstore.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import lbw.minibookstore.dao.OrderDaoService;
import lbw.minibookstore.model.BookOrder;
import lbw.minibookstore.model.FullOrder;

public class OrderDaoImpl implements OrderDaoService {

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
		String hql = "from FullOrder fullorder where fullorder.userName = '"+accountName+"'";
		List<FullOrder> list=sess.createQuery(hql).list();
		System.out.println(list.size());
		tx.commit();
		sess.close();
		return list;
	}
}
