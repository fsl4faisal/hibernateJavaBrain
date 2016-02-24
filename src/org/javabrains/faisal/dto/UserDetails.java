package org.javabrains.faisal.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;

	private String userName;
	
	//@Embedded Not mandatory
	//@Embedded
	//private Address address;
	
	@ElementCollection
	private Set<Address> listOfAddressses=new HashSet<>();
	
	public Set<Address> getListOfAddressses() {
		return listOfAddressses;
	}

	public void setListOfAddressses(Set<Address> listOfAddressses) {
		this.listOfAddressses = listOfAddressses;
	}	
	
	/*
	 * 
	 * /// Large OBject lob(byte stream lob) or clob(character lob)
	 * @Lob
		private String description;
	 * 
	 * */
	
	
	
	
	
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

}
