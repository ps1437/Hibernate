package com.syscho.hiber.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@Table (name ="EM_SECUSER")
public class UserRegister {
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="EM_USERID")
@SequenceGenerator(name="EM_USERID",allocationSize=1,initialValue=2,sequenceName="EM_USERID")
@Column(name="USER_ID")
private int userId;
@Column(name="FIRST_NAME")
private String firstName;

@Column(name="MIDDLE_NAME")
private String middleName;

@Column(name="LAST_NAME")
private String LastName;

@Column(name="PASSWORD")
private String password;

@Column(name="ROLE")
private String role;

@Column(name="EMAIL_ID")
private String emailId;

@Column(name="PHONE_NO")
private int phoneNo;

@Column(name="ACTIVE_YN")
private char activYn;

@Column(name="CREATE_TIME")
@Temporal(TemporalType.TIME)
private Date createdTime;

@Column(name="CREATED_USER_ID")
private String createdUserId;

@Column(name="PWD_EXPIRED_DATE")
@Temporal(TemporalType.TIME)
private Date pwdExpireDate;

@Column(name="FAILED_COUNT")
private int failedCount;

@Column(name="MAX_COUNT")
private int maxCount;

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getMiddleName() {
	return middleName;
}

public void setMiddleName(String middleName) {
	this.middleName = middleName;
}

public String getLastName() {
	return LastName;
}

public void setLastName(String lastName) {
	LastName = lastName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmailId() {
	return emailId;
}

public void setEmailId(String emailId) {
	this.emailId = emailId;
}

public int getPhoneNo() {
	return phoneNo;
}

public void setPhoneNo(int phoneNo) {
	this.phoneNo = phoneNo;
}

public char getActivYn() {
	return activYn;
}

public void setActivYn(char activYn) {
	this.activYn = activYn;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public Date getCreatedTime() {
	return createdTime;
}

public void setCreatedTime(Date createdTime) {
	this.createdTime = createdTime;
}

public String getCreatedUserId() {
	return createdUserId;
}

public void setCreatedUserId(String createdUserId) {
	this.createdUserId = createdUserId;
}

public Date getPwdExpireDate() {
	return pwdExpireDate;
}

public void setPwdExpireDate(Date pwdExpireDate) {
	this.pwdExpireDate = pwdExpireDate;
}

public int getFailedCount() {
	return failedCount;
}

public void setFailedCount(int failedCount) {
	this.failedCount = failedCount;
}

public int getMaxCount() {
	return maxCount;
}

public void setMaxCount(int maxCount) {
	this.maxCount = maxCount;
}

}