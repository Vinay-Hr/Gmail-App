package com.te.gmailApp.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Inbox {
	@Id
	private int Message_id;
	private int User_id;
	private String Message;
}
