 package com.example.ssm.po;

public class OrderDetial {

	/**
	 * id | orders_id | items_id | items_num |
	 */
	private Integer id;
	
	private Integer ordersid;
	
	private Integer itemsid;
	
	private Integer itemsnum;
	
	private Items items;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getOrdersid() {
		return ordersid;
	}
	
	public void setOrdersid(Integer ordersid) {
		this.ordersid = ordersid;
	}
	
	public Integer getItemsid() {
		return itemsid;
	}
	
	public void setItemsid(Integer itemsid) {
		this.itemsid = itemsid;
	}
	
	public Integer getItemsnum() {
		return itemsnum;
	}
	
	public void setItemsnum(Integer itemsnum) {
		this.itemsnum = itemsnum;
	}
	
	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "OrderDetial [id=" + id + ", ordersid=" + ordersid + ", itemsid=" + itemsid + ", itemsnum=" + itemsnum
				+ "]";
	}
	
}
