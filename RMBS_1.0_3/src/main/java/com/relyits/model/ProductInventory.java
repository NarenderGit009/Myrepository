package com.relyits.model;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@NamedQueries(
		@NamedQuery(
				name="getProductDetailsByBatchNo", 
        		query="FROM ProductInventory pi where pi.batchNo=:batchno and pi.shopid=:userid and product.category=:category"
        		
				)
		)


@Entity
@Table(name="productInventory", schema="RMBS")
public class ProductInventory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Product_Inv_Id")
	private Integer pinvid;
	
	@OneToOne
	@JoinColumn(name="Product_Id")
	private Product product;

	@Column(name = "Quantity")
	private Integer quantity;

	@Column(name = "Shop_Id")
	private Integer shopid;
	
	@Column(name="Expiry_Date")
	private Date expirydate;	
	
	@Column(name="Batch_No")
	private String batchNo;
	
	@Column(name="Price")
	private Double price;

	@Column(name="VAT")
	private Double vat;

	@Column(name="Price_Without_VAT")
	private Double pwvat;

	@Column(name="Vat_Price")
	private Double vatprice;

	@Column(name="DL_Price")
	private Double dlprice;

	@Column(name = "Agency_Id")
	private Integer agencyid;


	public Integer getPinvid() {
		return pinvid;
	}

	public void setPinvid(Integer pinvid) {
		this.pinvid = pinvid;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getShopid() {
		return shopid;
	}

	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}

	public Date getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getVat() {
		return vat;
	}

	public void setVat(Double vat) {
		this.vat = vat;
	}

	public Double getPwvat() {
		return pwvat;
	}

	public void setPwvat(Double pwvat) {
		this.pwvat = pwvat;
	}

	public Double getVatprice() {
		return vatprice;
	}

	public void setVatprice(Double vatprice) {
		this.vatprice = vatprice;
	}

	public Double getDlprice() {
		return dlprice;
	}

	public void setDlprice(Double dlprice) {
		this.dlprice = dlprice;
	}

	public Integer getAgencyid() {
		return agencyid;
	}

	public void setAgencyid(Integer agencyid) {
		this.agencyid = agencyid;
	}

}
