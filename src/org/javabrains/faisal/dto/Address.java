package org.javabrains.faisal.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Address {
	
	@Column(name="street_name")
	private String street;
	
	@Column(name="city_name")
	private String city;
	
	@Column(name="pincode")
	private String pincode;
	
	@Column(name="state")
	private String state;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	

}
