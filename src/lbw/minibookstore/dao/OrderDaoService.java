package lbw.minibookstore.dao;

import java.util.List;

import lbw.minibookstore.model.FullOrder;

public interface OrderDaoService {
	
void makeOrder(String accountName, int bookId, int bookCount);
	
	List<FullOrder> viewOrder(String accountName);

}
