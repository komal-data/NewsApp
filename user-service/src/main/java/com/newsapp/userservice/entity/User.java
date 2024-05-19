package com.newsapp.userservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@Column(name = "useremail",unique=true)
	private String useremail;
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
	@Column(name = "Mobile_no", nullable = false)
	private long mobile;
	@Column(name = "first_name", nullable = false)
	private String firstname;
	@Column(name = "last_name")
	private String lastname;
	
	private String password;

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public User() {

	}

	public User( long mobile, String firstname, String lastname, String useremail, String password) {

//		this.id = id;
		this.mobile = mobile;
		this.firstname = firstname;
		this.lastname = lastname;
		this.useremail = useremail;
		this.password = password;
	}

}
