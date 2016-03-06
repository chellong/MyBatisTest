package com.example.ssm.po;

import java.util.Date;
import java.util.List;

public class Orders {
	
	/**
	 * order id
	 */
	private Integer id;
	/**
	 * user id
	 */
	private Integer userid;
	/**
	 * 订单号
	 */
	private String number;
	/**
	 * 创建时间
	 */
	private Date createtime;
	/**
	 * 备注
	 */
	private String note;
	
	private User user;
	
	private List<OrderDetial> orderDetails;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getUserid() {
		return userid;
	}
	
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public Date getCreatetime() {
		return createtime;
	}
	
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderDetial> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetial> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", userid=" + userid + ", number=" + number + ", createtime=" + createtime
				+ ", note=" + note+ "]";
	}
	
}
