package com.relyits.rmbs.serviceImpl;





import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRDataSource;

import com.relyits.rmbs.beans.purchase.PurchaseLineItemsBean;
import com.relyits.rmbs.beans.purchase.PurchaseOrderBean;
import com.relyits.rmbs.dao.ReportsDAO;
import com.relyits.rmbs.dao.RevenueDAO;
import com.relyits.rmbs.model.purchase.PurchaseLineItemsModel;
import com.relyits.rmbs.model.purchase.PurchaseOrderModel;
import com.relyits.rmbs.model.sales.SalesOrderModel;
import com.relyits.rmbs.service.ReportsService;
import com.relyits.rmbs.service.RevenueService;

@Service("revenueService")
public class RevenueServiceImpl implements RevenueService{


	@Autowired
	private RevenueDAO revenueDAO;

	@Override
	public List<PurchaseOrderModel> revenuePurchaseOrder(Date fromDate, Date toDate,	int branchId) {
		return revenueDAO.revenuePurchaseOrder(fromDate, toDate, branchId);
	}

	@Override
	public List<SalesOrderModel> revenueSalesOrder(Date fromDate, Date toDate,int branchId,int catId) {
		return revenueDAO.revenueSalesOrder(fromDate, toDate, branchId,catId);
	}

	
}
