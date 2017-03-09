package org.javabrains.faisal.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.Type;

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

	@ElementCollection
	@JoinTable(name="USER_ADDRESS",
	joinColumns=@JoinColumn(name="USER_ID"))
	@GenericGenerator(name="hilo-gen",strategy="sequence")
	@CollectionId(columns={@Column(name="ADDRESS_ID")},generator="hilo-gen",type=@Type(type="long"))
	private Collection<Address> address=new ArrayList<Address>();

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

	public Collection<Address> getAddress() {
		return address;
	}

	public void setAddress(Collection<Address> address) {
		this.address = address;
	}
	
	

}
