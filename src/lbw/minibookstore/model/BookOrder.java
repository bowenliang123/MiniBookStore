package lbw.minibookstore.model;

import java.sql.Time;
import java.sql.Timestamp;

import lbw.minibookstore.utils.Utils;

public class BookOrder {
	private int id;
	private String userName;
	private int bookId;
	private int count;
	private Timestamp time;
	private String status;

	public BookOrder(String accountName, int bookId, int bookCount) {
		// TODO Auto-generated constructor stub
		this.setUserName(accountName);
		this.setBookId(bookId);
		this.setCount(bookCount);
		this.setTime(Utils.generateSqlTime());
		this.setStatus("未付款");
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}