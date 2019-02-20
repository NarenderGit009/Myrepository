package com.relyits.rmbs.model.purchase;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.relyits.rmbs.model.product.ProductInventoryModel;

@Entity
@Table(name="RMBS404", schema="RMBS",
            uniqueConstraints = {
		           @UniqueConstraint(columnNames = "RMBS40401") })   //id
public class PurchaseReturnLineItemsModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RMBS40401", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "RMBS40402", nullable = false, length = 100)
	private Double quantity;
	
	@Column(name = "RMBS40403", nullable = false, length = 100)
	private Double amount;
	
	@Column(name = "RMBS40404", nullable = false, length = 100)
	private Double unitPrice;
	
	@Column(name = "RMBS40405", nullable = false, length = 100)
	private Double discount;
	
	@Column(name = "RMBS40406", nullable = false, length = 100)
	private Double netPrice;
	
/*	@OneToOne
	@JoinColumn(name = "OL_RMBS10301", nullable = false)
	private OutletModel outletModel;*/
		
	
	@Column(name = "RMBS40407", nullable = false, length = 100)
	private Double vat;
	
	/*@Column(name = "RMBS40408", nullable = false, length = 50)
	private Integer delivaeredQuantity;
	
	@OneToOne
	@JoinColumn(name = "ST_RMBS80301", nullable = false)
	private StatusModel statusModel;
	
	@Column(name = "RMBS40409", nullable = false, length = 50)
	private Integer deliverableQuantity;*/
	
	@Column(name = "RMBS40408", nullable = false, length = 100)
	private Double preparationCharges;
	
	@Column(name = "RMBS40409", nullable = false, length = 30)
	private Date expiryDate;
	
	@OneToOne
	@JoinColumn(name = "PI_RMBS20201", nullable = false)
	private ProductInventoryModel productInventoryModel;
	
	@OneToOne
	@JoinColumn(name = "PO_RMBS40101", nullable = false)
	private PurchaseOrderModel purchaseOrderModel;
	
	@Column(name = "RMBS40410", nullable = false, length = 100)
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

/*	public OutletModel getOutletModel() {
		return outletModel;
	}

	public void setOutletModel(OutletModel outletModel) {
		this.outletModel = outletModel;
	}
*/
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

	public StatusModel getStatusModel() {
		return statusModel;
	}

	public void setStatusModel(StatusModel statusModel) {
		this.statusModel = statusModel;
	}

	public Integer getDeliverableQuantity() {
		return deliverableQuantity;
	}

	public void setDeliverableQuantity(Integer deliverableQuantity) {
		this.deliverableQuantity = deliverableQuantity;
	}
*/
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

	public ProductInventoryModel getProductInventoryModel() {
		return productInventoryModel;
	}

	public void setProductInventoryModel(ProductInventoryModel productInventoryModel) {
		this.productInventoryModel = productInventoryModel;
	}

	public PurchaseOrderModel getPurchaseOrderModel() {
		return purchaseOrderModel;
	}

	public void setPurchaseOrderModel(PurchaseOrderModel purchaseOrderModel) {
		this.purchaseOrderModel = purchaseOrderModel;
	}

	public Double getDeductionOnPaidAmount() {
		return deductionOnPaidAmount;
	}

	public void setDeductionOnPaidAmount(Double deductionOnPaidAmount) {
		this.deductionOnPaidAmount = deductionOnPaidAmount;
	}
	
	

}
