package org.ringel.services.bid2buy.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "bidder_table")
@Table(name = "bidder_table")
public class BidderModel {
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id")
	private UserModel user;
    
	private double bidding_price;
	private Date bidding_time;
	private Boolean isDeleleted;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	public double getBidding_price() {
		return bidding_price;
	}
	public void setBidding_price(double bidding_price) {
		this.bidding_price = bidding_price;
	}
	public Date getBidding_time() {
		return bidding_time;
	}
	public void setBidding_time(Date bidding_time) {
		this.bidding_time = bidding_time;
	}
	public Boolean getIsDeleleted() {
		return isDeleleted;
	}
	public void setIsDeleleted(Boolean isDeleleted) {
		this.isDeleleted = isDeleleted;
	}
	
	
	
}
