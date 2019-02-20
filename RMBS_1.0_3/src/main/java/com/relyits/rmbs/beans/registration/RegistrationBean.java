package com.relyits.rmbs.beans.registration;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.relyits.rmbs.beans.resources.AddressBean;


public class RegistrationBean {
	
	private Integer id;
	private String userName;
	private String initial;
	private String gender;
	private String firstName;
	private String lastName;
	private String password;
	private String confirmPassword;
	private String dob;
	private String name;
	private String tinNo;
    private AddressBean addressBean;
    private String imageName;
   	private List<MultipartFile> imageData;
    private String imagePath;
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTinNo() {
		return tinNo;
	}
	public void setTinNo(String tinNo) {
		this.tinNo = tinNo;
	}
	public AddressBean getAddressBean() {
		return addressBean;
	}
	public void setAddressBean(AddressBean addressBean) {
		this.addressBean = addressBean;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public List<MultipartFile> getImageData() {
		return imageData;
	}
	public void setImageData(List<MultipartFile> imageData) {
		this.imageData = imageData;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
 
}
