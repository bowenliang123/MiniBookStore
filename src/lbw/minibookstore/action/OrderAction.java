package lbw.minibookstore.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lbw.minibookstore.dao.BookDaoService;
import lbw.minibookstore.model.Book;
import lbw.minibookstore.model.BookOrder;
import lbw.minibookstore.model.FullOrder;
import lbw.minibookstore.utils.Utils;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport {
	
	HttpServletRequest request;

	private int bookId;
	private int bookCount;
	private Book book;
	
	private int OrderId;
	List<FullOrder> orderList;
	
	ApplicationContext ctx;
	BookDaoService bookDao;

	public String preview() {
		init();
		book = bookDao.getBookInfoById(bookId);
		return Action.SUCCESS;
	}

	public String make() {
		init();
		String accountName = Utils.getAccountnameFromCookies(request);
		bookDao.makeOrder(accountName,bookId,bookCount);
		return Action.SUCCESS;
	}
	
	public String view(){
		init();
		String accountName = Utils.getAccountnameFromCookies(request);
		orderList = bookDao.viewOrder(accountName);		
		return Action.SUCCESS;
	}
	
	public void init(){
		ctx = new ClassPathXmlApplicationContext("bean.xml");
		bookDao = ctx.getBean("bookDao", BookDaoService.class);
		request = ServletActionContext.getRequest();
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getBookId() {
		return bookId;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public List<FullOrder> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<FullOrder> orderList) {
		this.orderList = orderList;
	}
	
	

}
