package com.relyits.rmbs.beans.sales;

import com.relyits.rmbs.beans.purchase.PurchaseLineItemsBean;
import com.relyits.rmbs.beans.registration.BranchBean;
import com.relyits.rmbs.beans.registration.OutletBean;

public class RevenueBean {

	private Integer id;	
	private BranchBean branchBean;		
	private OutletBean outletBean;
	private PurchaseLineItemsBean purchaseLineItemsBean;
	private SalesLineItemsBean salesLineItemsBean;
	private String revenueAccount;
	private String fromDate;
	private String toDate;
	private String type;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public BranchBean getBranchBean() {
		return branchBean;
	}
	public void setBranchBean(BranchBean branchBean) {
		this.branchBean = branchBean;
	}	
	
	public OutletBean getOutletBean() {
		return outletBean;
	}
	public void setOutletBean(OutletBean outletBean) {
		this.outletBean = outletBean;
	}
	
	public String getRevenueAccount() {
		return revenueAccount;
	}
	public void setRevenueAccount(String revenueAccount) {
		this.revenueAccount = revenueAccount;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public PurchaseLineItemsBean getPurchaseLineItemsBean() {
		return purchaseLineItemsBean;
	}
	public void setPurchaseLineItemsBean(PurchaseLineItemsBean purchaseLineItemsBean) {
		this.purchaseLineItemsBean = purchaseLineItemsBean;
	}
	public SalesLineItemsBean getSalesLineItemsBean() {
		return salesLineItemsBean;
	}
	public void setSalesLineItemsBean(SalesLineItemsBean salesLineItemsBean) {
		this.salesLineItemsBean = salesLineItemsBean;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
	
	
}
