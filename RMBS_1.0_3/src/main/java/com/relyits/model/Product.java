package com.relyits.model;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product", schema="RMBS")
public class Product implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Product_Id")
	private Integer pid;

	@Column(name="P_Name")
	private String pname;
	
	@Column(name = "Shop_Id")
	private Integer shopid;
	
	@Column(name = "Agency_Id")
	private Integer agencyid;

	@Column(name="Product_Code")
	private String pcode;

	@Column(name="Mf_Company")
	private String mfcompany;

	@Column(name="Sch_Drug")
	private String schdrug;

	@Column(name="Category")
	private String category;

	@Column(name="Sub_Category")
	private String subcategory;
	
	/*@OneToOne(mappedBy="product")
	private ProductInventory productInventory;
	
	public ProductInventory getProductInventory() {
		return productInventory;
	}

	public void setProductInventory(ProductInventory productInventory) {
		this.productInventory = productInventory;
	}
*/
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getShopid() {
		return shopid;
	}

	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}

	public Integer getAgencyid() {
		return agencyid;
	}

	public void setAgencyid(Integer agencyid) {
		this.agencyid = agencyid;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getMfcompany() {
		return mfcompany;
	}

	public void setMfcompany(String mfcompany) {
		this.mfcompany = mfcompany;
	}

	public String getSchdrug() {
		return schdrug;
	}

	public void setSchdrug(String schdrug) {
		this.schdrug = schdrug;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

}
