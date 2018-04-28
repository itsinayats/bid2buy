package org.ringel.services.bid2buy.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ForeignKey;

@Entity(name = "item_table")
@Table(name = "item_table")
public class ItemModel {
	@Id
	@GeneratedValue
	private int id;
	private String title;
	private double minimal_price;
	private Date posted_on;
	private int sell_duration;
	private long share_count;
	private String location;
	private String description;
	 @ManyToOne(cascade = CascadeType.REFRESH)
	 @JoinColumn(name = "category_id")
	private CategoriesModel category;
	
	
	private String isActive;
	
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "sellar_id")
	private UserModel sellar;
	
	@Transient
	private ArrayList<BidderModel> bidders=new ArrayList<>();
	
	@Transient
	private String returnedMsg;
	@Transient
	private String exception;
	@Transient
	private Boolean success;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getMinimal_price() {
		return minimal_price;
	}
	public void setMinimal_price(double minimal_price) {
		this.minimal_price = minimal_price;
	}
	public Date getPosted_on() {
		return posted_on;
	}
	public void setPosted_on(Date posted_on) {
		this.posted_on = posted_on;
	}
	public int getSell_duration() {
		return sell_duration;
	}
	public void setSell_duration(int sell_duration) {
		this.sell_duration = sell_duration;
	}
	public long getShare_count() {
		return share_count;
	}
	public void setShare_count(long share_count) {
		this.share_count = share_count;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public UserModel getSellar() {
		return sellar;
	}
	public void setSellar(UserModel sellar) {
		this.sellar = sellar;
	}
	public String getReturnedMsg() {
		return returnedMsg;
	}
	public void setReturnedMsg(String returnedMsg) {
		this.returnedMsg = returnedMsg;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public CategoriesModel getCategory() {
		return category;
	}
	public void setCategory(CategoriesModel category) {
		this.category = category;
	}
	
	public ArrayList<BidderModel> getBidders() {
		return bidders;
	}
	public void setBidders(ArrayList<BidderModel> bidders) {
		this.bidders = bidders;
	}

	

	
	
	

}
