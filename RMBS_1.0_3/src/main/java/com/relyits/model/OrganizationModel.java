
package com.relyits.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="UserRegister", schema="RMBS")
public class OrganizationModel implements Serializable{

	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "userId")
	private Integer userId;
	
	@Column(name="username")
	private String username;
	
	@Column(name="initial")
	private String initial;
	
	@Column(name="gender")
	private String gender;


	@Column(name="firstname")
	private String firstname;

	@Column(name="lastname")
	private String lastname;
	
	@Column(name="password")
	private String password;
	
	@Column(name="dob")
	private String dob;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobile")
	private Long mobile;
	
	@Column(name="address")
	private String address;
	
	@Column(name="shopname")
	private String shopname;

	@Column(name="tinno")
	private String tinno;
	
	@Column(name="active")
	private String active;
	
	@Column(name="role")
	private String role;

	@Column(name="status")
	private String status;
	
	@Column(name="registerdatetime")
	private String registerdatetime;
	
	@Column(name="lastlogineddatetime")
	private String lastlogineddatetime;

	@Column(name="updateddatetime")
	private String updateddatetime;
	
	@Column(name="dayscount")
	private Integer dayscount;
	
	@Column(name="expirydays")
	private Integer expirydays;
	
	@Column(name="licensevaliddays")
	private Integer licensevaliddays;
	
	@Column(name="licensekey")
	private String licensekey;
	
	@OneToOne
	@JoinColumn(name="id_user_menu")
	private UserMenu userMenu;

	public UserMenu getUserMenu() {
		return userMenu;
	}

	public void setUserMenu(UserMenu userMenu) {
		this.userMenu = userMenu;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getInitial() {
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public String getTinno() {
		return tinno;
	}

	public void setTinno(String tinno) {
		this.tinno = tinno;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRegisterdatetime() {
		return registerdatetime;
	}

	public void setRegisterdatetime(String registerdatetime) {
		this.registerdatetime = registerdatetime;
	}

	public String getLastlogineddatetime() {
		return lastlogineddatetime;
	}

	public void setLastlogineddatetime(String lastlogineddatetime) {
		this.lastlogineddatetime = lastlogineddatetime;
	}

	public String getUpdateddatetime() {
		return updateddatetime;
	}

	public void setUpdateddatetime(String updateddatetime) {
		this.updateddatetime = updateddatetime;
	}

	public Integer getDayscount() {
		return dayscount;
	}

	public void setDayscount(Integer dayscount) {
		this.dayscount = dayscount;
	}

	public Integer getExpirydays() {
		return expirydays;
	}

	public void setExpirydays(Integer expirydays) {
		this.expirydays = expirydays;
	}

	public Integer getLicensevaliddays() {
		return licensevaliddays;
	}

	public void setLicensevaliddays(Integer licensevaliddays) {
		this.licensevaliddays = licensevaliddays;
	}

	public String getLicensekey() {
		return licensekey;
	}

	public void setLicensekey(String licensekey) {
		this.licensekey = licensekey;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
