package org.javabrains.faisal.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.SelectBeforeUpdate;
@Entity
//@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
@SelectBeforeUpdate
@Table(name = "USER_DETAILS")
@NamedQuery(name = "UserDetails.byId", query = "from UserDetails where userId=:userId")
@NamedNativeQuery(name = "UserDetails.byName", query = "select * from USER_DETAILS where USER_NAME=:userName",resultClass=UserDetails.class)
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "USER_NAME")
	private String userName;

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

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + "]";
	}

	
}
