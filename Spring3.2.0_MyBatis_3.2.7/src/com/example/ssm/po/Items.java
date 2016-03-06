package com.example.ssm.po;

import java.util.Date;

public class Items {
	
//	| id | name  | price | detail | pic   | createtime          |

	/**
	 * id
	 */
	private Integer id;
	/**
	 * 商品名
	 */
	private String name;
	/**
	 * 价格
	 */
	private float price;
	/**
	 * 简介
	 */
	private String detail;
	/**
	 * 图片
	 */
	private String pic;
	/**
	 * 保质期
	 */
	private Date createtime;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getDetail() {
		return detail;
	}
	
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public String getPic() {
		return pic;
	}
	
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	public Date getCreatetime() {
		return createtime;
	}
	
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	@Override
	public String toString() {
		return "items [id=" + id + ", name=" + name + ", price=" + price + ", detail=" + detail + ", pic=" + pic
				+ ", createtime=" + createtime + "]";
	}
	
}
