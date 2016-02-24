package org.javabrains.faisal.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "USER_NAME")
	private String userName;

	@OneToOne
	@JoinColumn(name="VEHICLE_ID")
	private Vehicle vehicle;

	@GenericGenerator(name = "sequence-gen", strategy = "sequence")
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionId(columns = { @Column(name = "ADDRESS_ID") }, generator = "sequence-gen", type = @Type(type = "long"))
	@JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
	private Collection<Address> listOfAddressses = new ArrayList<>();

	public Collection<Address> getListOfAddressses() {
		return listOfAddressses;
	}

	public void setListOfAddressses(Collection<Address> listOfAddressses) {
		this.listOfAddressses = listOfAddressses;
	}

	/*
	 * 
	 * /// Large OBject lob(byte stream lob) or clob(character lob)
	 * 
	 * @Lob private String description;
	 */

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

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}
