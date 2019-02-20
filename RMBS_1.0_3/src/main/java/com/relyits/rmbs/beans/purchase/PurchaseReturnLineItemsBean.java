package com.relyits.rmbs.beans.purchase;

import java.sql.Date;

import com.relyits.rmbs.beans.product.ProductInventoryBean;


public class PurchaseReturnLineItemsBean {
	
	private Integer id;
	private Double quantity;
	private Double amount;
	private Double unitPrice;
	private Double discount;
	private Double netPrice;
//	private OutletBean outletBean;
	private Double vat;
//	private Integer delivaeredQuantity;
//	private StatusBean statusBean;
//	private Integer deliverableQuantity;
	private Double preparationCharges;
	private Date expiryDate;
	private ProductInventoryBean productInventoryBean;
	private PurchaseOrderBean purchaseOrderBean;
	private Double deductionOnPaidAmount;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Double getNetPrice() {
		return netPrice;
	}
	public void setNetPrice(Double netPrice) {
		this.netPrice = netPrice;
	}
/*	public OutletBean getOutletBean() {
		return outletBean;
	}
	public void setOutletBean(OutletBean outletBean) {
		this.outletBean = outletBean;
	}*/
	public Double getVat() {
		return vat;
	}
	public void setVat(Double vat) {
		this.vat = vat;
	}
	/*	public Integer getDelivaeredQuantity() {
		return delivaeredQuantity;
	}
	public void setDelivaeredQuantity(Integer delivaeredQuantity) {
		this.delivaeredQuantity = delivaeredQuantity;
	}
	public StatusBean getStatusBean() {
		return statusBean;
	}
	public void setStatusBean(StatusBean statusBean) {
		this.statusBean = statusBean;
	}
	public Integer getDeliverableQuantity() {
		return deliverableQuantity;
	}
	public void setDeliverableQuantity(Integer deliverableQuantity) {
		this.deliverableQuantity = deliverableQuantity;
	}*/
	public Double getPreparationCharges() {
		return preparationCharges;
	}
	public void setPreparationCharges(Double preparationCharges) {
		this.preparationCharges = preparationCharges;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public ProductInventoryBean getProductInventoryBean() {
		return productInventoryBean;
	}
	public void setProductInventoryBean(ProductInventoryBean productInventoryBean) {
		this.productInventoryBean = productInventoryBean;
	}
	public PurchaseOrderBean getPurchaseOrderBean() {
		return purchaseOrderBean;
	}
	public void setPurchaseOrderBean(PurchaseOrderBean purchaseOrderBean) {
		this.purchaseOrderBean = purchaseOrderBean;
	}
	public Double getDeductionOnPaidAmount() {
		return deductionOnPaidAmount;
	}
	public void setDeductionOnPaidAmount(Double deductionOnPaidAmount) {
		this.deductionOnPaidAmount = deductionOnPaidAmount;
	}

	
	
	
	
}
