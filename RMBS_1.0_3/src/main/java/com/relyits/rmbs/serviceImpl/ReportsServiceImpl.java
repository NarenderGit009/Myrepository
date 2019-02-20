package com.relyits.rmbs.serviceImpl;





import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRDataSource;

import com.relyits.rmbs.beans.purchase.PurchaseLineItemsBean;
import com.relyits.rmbs.beans.purchase.PurchaseOrderBean;
import com.relyits.rmbs.dao.ReportsDAO;
import com.relyits.rmbs.model.purchase.PurchaseLineItemsModel;
import com.relyits.rmbs.model.purchase.PurchaseOrderModel;
import com.relyits.rmbs.service.ReportsService;

@Service("reportsService")
public class ReportsServiceImpl implements ReportsService{


	@Autowired
	private ReportsDAO reportsDAO;

	@Override
	public JRDataSource retrieveAllExistedProucts() {

		return reportsDAO.retrieveAllExistedProucts();
	}

	@Override
	public JRDataSource productStockListBybranch(int branchId) {

		return reportsDAO.productStockListBybranch(branchId);
	}


	@Override
	public List<PurchaseOrderBean> purchaseOrderReports(Date fromDate, Date toDate,int branchId) {
		return reportsDAO.purchaseOrderReports(fromDate, toDate,branchId);
	}



	@Override
	public JRDataSource purchaseOrderListReports(
			PurchaseOrderModel purchaseOrderModel) {
		return reportsDAO.purchaseOrderListReports(purchaseOrderModel);
	}

	@Override
	public List<PurchaseLineItemsBean> purchaseOrderLineitemsReports(
			PurchaseOrderModel purchaseOrderModel) {
		return reportsDAO.purchaseOrderLineitemsReports(purchaseOrderModel);
	}
}
