package com.te.gmailApp.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity

@Table(name = "Account_info")
public class Account implements Serializable {

	@Id
	@Column(name = "User_id")
	private int id;
	@Column(name = "User_name")
	private String name;
	@Column(name = "User_password")
	private String password;
	@Column(name = "User_Email")
	private String Email;

	public Account() {

	}

}
