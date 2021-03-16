package com.sunwoo.s1.bankbook;

public class BankBookDTO {
	
	private int booknumber;
	private String bookname;
	private double bookrate;
	private String booksale;
	
	public int getBooknumber() {
		return booknumber;
	}
	public void setBooknumber(int booknumber) {
		this.booknumber = booknumber;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public double getBookrate() {
		return bookrate;
	}
	public void setBookrate(double bookrate) {
		this.bookrate = bookrate;
	}
	public String getBooksale() {
		return booksale;
	}
	public void setBooksale(String booksale) {
		this.booksale = booksale;
	}

}
