package org.javabrains.faisal.dto;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
// @org.hibernate.annotations.Entity(selectBeforeUpdate=true)
@SelectBeforeUpdate
@Table(name = "USER_DETAILS")
@NamedQuery(name = "UserDetails.byId", query = "from UserDetails where userId=:userId")
@NamedNativeQuery(name = "UserDetails.byName", query = "select * from USER_DETAILS where USER_NAME=:userName", resultClass = UserDetails.class)
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "USER_NAME")
	private String userName;

	@Embedded @AttributeOverrides
	({
		@AttributeOverride(name="street",column=@Column(name="HOME_STREET_NAME")),
		@AttributeOverride(name = "city", column = @Column(name = "HOME_CITY_NAME")),
		@AttributeOverride(name = "pincode", column = @Column(name = "HOME_PINCODE_NAME")),
		@AttributeOverride(name = "state", column = @Column(name = "HOME_STATE_NAME"))
		
	})
	private Address homeAddress;

	@Embedded @AttributeOverrides
	({
		@AttributeOverride(name="street",column=@Column(name="OFFICE_STREET_NAME")),
		@AttributeOverride(name = "city", column = @Column(name = "OFFICE_CITY_NAME")),
		@AttributeOverride(name = "pincode", column = @Column(name = "OFFICE_PINCODE_NAME")),
		@AttributeOverride(name = "state", column = @Column(name = "OFFICE_STATE_NAME"))
		
	})
	private Address officeAddress;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", homeAddress=" + homeAddress
				+ ", officeAddress=" + officeAddress + "]";
	}

	

}
