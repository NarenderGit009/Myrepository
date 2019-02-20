package com.relyits.rmbs.model.sales;

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
import com.relyits.rmbs.model.refference.StatusModel;
import com.relyits.rmbs.model.registration.OutletModel;

@Entity
@Table(name="RMBS304", schema="RMBS",
            uniqueConstraints = {
		           @UniqueConstraint(columnNames = "RMBS30401") })   //id
public class SalesReturnLineItemsModel implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RMBS30401", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "RMBS30402", nullable = false, length = 100)
	private Integer quantity;
	
	@Column(name = "RMBS30403", nullable = false, length = 100)
	private Double amount;
	
	@Column(name = "RMBS30404", nullable = false, length = 100)
	private Double unitPrice;
	
	@Column(name = "RMBS30405", nullable = false, length = 100)
	private Double discount;
	
	@Column(name = "RMBS30406", nullable = false, length = 100)
	private Double netPrice;
	
	@OneToOne
	@JoinColumn(name = "OL_RMBS10301", nullable = false)
	private OutletModel outletModel;
		
	
	@Column(name = "RMBS30407", nullable = false, length = 100)
	private Double vat;
	
	@Column(name = "RMBS30408", nullable = false, length = 50)
	private Integer delivaeredQuantity;
	
	@OneToOne
	@JoinColumn(name = "ST_RMBS80301", nullable = false)
	private StatusModel statusModel;
	
	@Column(name = "RMBS30409", nullable = false, length = 50)
	private Integer deliverableQuantity;
	
	@Column(name = "RMBS30410", nullable = false, length = 100)
	private Double preparationCharges;
	
	@Column(name = "RMBS30411", nullable = false, length = 30)
	private Date expiryDate;
	
	@OneToOne
	@JoinColumn(name = "PI_RMBS20201", nullable = false)
	private ProductInventoryModel productInventoryModel;
	
	@OneToOne
	@JoinColumn(name = "SRO_RMBS30301", nullable = false)
	private SalesReturnOrderModel salesReturnOrderModel;
	
	@Column(name = "RMBS30412", nullable = false, length = 100)
	private Double deductionOnMargin;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
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

	public OutletModel getOutletModel() {
		return outletModel;
	}

	public void setOutletModel(OutletModel outletModel) {
		this.outletModel = outletModel;
	}

	public Double getVat() {
		return vat;
	}

	public void setVat(Double vat) {
		this.vat = vat;
	}

	public Integer getDelivaeredQuantity() {
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

	public SalesReturnOrderModel getSalesReturnOrderModel() {
		return salesReturnOrderModel;
	}

	public void setSalesReturnOrderModel(SalesReturnOrderModel salesReturnOrderModel) {
		this.salesReturnOrderModel = salesReturnOrderModel;
	}

	public Double getDeductionOnMargin() {
		return deductionOnMargin;
	}

	public void setDeductionOnMargin(Double deductionOnMargin) {
		this.deductionOnMargin = deductionOnMargin;
	}
	
	

}
