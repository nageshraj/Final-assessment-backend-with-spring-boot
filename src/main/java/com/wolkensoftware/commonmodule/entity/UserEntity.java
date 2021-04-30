package com.wolkensoftware.commonmodule.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_details_table")
public class UserEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private int id;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_email")
	private String userEmailId;

	@Column(name = "user_phone")
	private long userPhoneNumber;

	@Column(name = "user_dob")
	private String userDOB;

	@Column(name = "user_gender")
	private String gender;

	@Column(name = "user_password")
	private String userPassword;

}
