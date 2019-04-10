package com.javaex.vo;


public class GuestBookVo {
	private int no;
	private String id;
	private String password;
	private String noticeBoard;
	private String nowdate;

	
	
	public String getNoticeBoard() {
		return noticeBoard;
	}
	public void setNoticeBoard(String noticBoard) {
		this.noticeBoard = noticBoard;
	}
	public GuestBookVo(int no, String id, String password, String noticeBoard, String nowdate) {
		
		this.no = no;
		this.id = id;
		this.password = password;
		this.noticeBoard = noticeBoard;
		this.nowdate = nowdate;
	}
	
	
	public GuestBookVo() {
		
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNowdate() {
		return nowdate;
	}
	public void setNowdate(String nowdate) {
		this.nowdate = nowdate;
	}
	@Override
	public String toString() {
		return "GestBookVo [no=" + no + ", id=" + id + ", password=" + password + ", noticBoard=" + noticeBoard
				+ ", nowdate=" + nowdate + "]";
	}

	
	
}