package lbw.minibookstore.dao;

import java.util.List;

import lbw.minibookstore.model.Book;
import lbw.minibookstore.model.FullOrder;


public interface BookDaoService {

	Book getBookInfoById(int bookId);

	void makeOrder(String accountName, int bookId, int bookCount);
	
	List<FullOrder> viewOrder(String accountName);
}
