package com.relyits.rmbs.controller;


import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.relyits.rmbs.beans.sales.SalesReturnLineItemsBean;
import com.relyits.rmbs.beans.sales.SalesReturnOrderBean;
import com.relyits.rmbs.beans.sales.SalesReturnsFormBean;
import com.relyits.rmbs.beans.session.UserSessionBean;
import com.relyits.rmbs.beans_preparation.sales.SalesReturnLineItemsBeanPreparation;
import com.relyits.rmbs.model.product.ProductInventoryModel;
import com.relyits.rmbs.model.refference.StatusModel;
import com.relyits.rmbs.model.sales.SalesLineItemsModel;
import com.relyits.rmbs.model.sales.SalesOrderModel;
import com.relyits.rmbs.model.sales.SalesReturnLineItemsModel;
import com.relyits.rmbs.model.sales.SalesReturnOrderModel;
import com.relyits.rmbs.model_preparation.sales.SalesLineItemsModelPreparation;
import com.relyits.rmbs.model_preparation.sales.SalesReturnLineItemsModelPreparation;
import com.relyits.rmbs.service.ResourcesService;
import com.relyits.rmbs.service.SalesReturnsService;
import com.relyits.rmbs.service.SalesService;
import com.relyits.rmbs.utilities.DateAndTimeUtilities;
import com.relyits.rmbs.utilities.SessionUtilities;

@Controller
public class SalesReturnOrderController {

	@Autowired
	private SalesService salesService;
	@Autowired
	private SalesReturnsService salesReturnsService;
	@Autowired
	private ResourcesService resourcesService;
	
	SalesLineItemsModel salesLineItemsModel=null;
	SalesOrderModel salesOrderModel=null;
	StatusModel statusModel=null;
	
	SalesReturnOrderModel salesReturnOrderModel=null;
	SalesReturnLineItemsModel salesReturnLineItemsModel=null;
	ProductInventoryModel productInventoryModel=null;
	List<SalesReturnLineItemsModel> salesReturnLineItemsModels=null;
	List<SalesLineItemsModel> oldSalesLineItemsModels=null;
	List<SalesReturnLineItemsBean> salesReturnLineItemsBeans=null;
	
	Map<String, Object> model = null;
	
	String fileName="";
	String path="";
	
	@RequestMapping(value = "/createSalesreturnOrder", 
			method = RequestMethod.POST, 
			headers="Accept=*/*")//@RequestBody String str
/*	public @ResponseBody List<SalesReturnLineItemsModel> createOrder(HttpServletRequest request,HttpSession session,
			@RequestParam("qty") String qty,@RequestParam("sROLId") String sROLId) {
		System.out.println("qty>>>>>>>>>>--"+qty);
		System.out.println("sROLId>>>>>>>>>>--"+sROLId);
		*/
	public ModelAndView createOrder(@RequestBody String str,HttpServletRequest request,HttpSession session){
		UserSessionBean userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
	//	String sROLId="0";
	//	String qty="0";
		if(mode[0]==1){
			ObjectMapper mapper = new ObjectMapper();
			 
			List<SalesReturnsFormBean> salesReturnsFormBeans=new ArrayList<SalesReturnsFormBean>();
			
			SalesReturnsFormBean salesReturnsFormBean=null;
			boolean flag=false;
			try {
				JsonNode node = mapper.readTree(str);
				System.out.println("node.size() ---"+node.size());

				System.out.println("********************  START*******************");

				for(int i=0;i<node.size();i++){
					salesReturnsFormBean=new SalesReturnsFormBean();
					salesReturnsFormBean = mapper.convertValue(node.get(i), SalesReturnsFormBean.class);
					salesReturnsFormBeans.add(salesReturnsFormBean);
					flag=true;
				}
			}catch(Exception e){
				flag=false;
			}
			
			if(flag){
				model = new HashMap<String, Object>();
				
				salesReturnLineItemsModels=new ArrayList<SalesReturnLineItemsModel>();
				oldSalesLineItemsModels=new ArrayList<SalesLineItemsModel>();
				
				salesReturnOrderModel=new SalesReturnOrderModel();
				for(SalesReturnsFormBean formBean:salesReturnsFormBeans){
					
					salesLineItemsModel=new SalesLineItemsModel();
					salesLineItemsModel.setId(formBean.getId());
					salesLineItemsModel=salesService.getSalesOrderLineItemById(salesLineItemsModel);
					salesOrderModel=new SalesOrderModel();
					salesOrderModel=salesLineItemsModel.getSalesOrderModel();
					
					//oldSalesLineItemsModel=salesLineItemsModel;
					
					
				/*	salesReturnOrderModel.setId(formBean.getId());
					salesReturnOrderModel=salesReturnsService.getSalesReturnOrder(salesReturnOrderModel);*/
					
				//	 Integer qtty=Integer.parseInt(qty);
					Double payAmount=SalesLineItemsModelPreparation.getPayAmount(salesLineItemsModel.getUnitPrice(), formBean.getQty(), salesLineItemsModel.getVat(), salesLineItemsModel.getDiscount());
					Double vatAmount=SalesLineItemsModelPreparation.getLineItemVatPrice(salesLineItemsModel.getUnitPrice(), formBean.getQty(), salesLineItemsModel.getVat(), salesLineItemsModel.getDiscount());
					Double disAmount=SalesLineItemsModelPreparation.getLineItemDiscountPrice(salesLineItemsModel.getUnitPrice(), formBean.getQty(), salesLineItemsModel.getDiscount());
					Double margin=SalesLineItemsModelPreparation.getMargin(salesLineItemsModel.getProductInventoryModel().getDlPrice(), salesLineItemsModel.getUnitPrice(), formBean.getQty(), salesLineItemsModel.getVat(), salesLineItemsModel.getDiscount());
					Double netPrice=SalesLineItemsModelPreparation.getNetPrice(salesLineItemsModel.getProductInventoryModel().getPrice(), salesLineItemsModel.getVat(), salesLineItemsModel.getDiscount());
					Double amount=formBean.getQty()*salesLineItemsModel.getUnitPrice();
					
					
					salesLineItemsModel.setQuantity(formBean.getQty());
					salesLineItemsModel.setAmount(amount);
					salesLineItemsModel.setDeliverableQuantity(salesLineItemsModel.getDeliverableQuantity()-formBean.getQty());
					salesLineItemsModel.setMargin(margin);
					salesLineItemsModel.setNetPrice(netPrice); 
	
					
					if(salesReturnLineItemsModels.size()!=0){
						
					
						
						salesOrderModel.setAmount(salesLineItemsModel.getAmount()+salesReturnOrderModel.getAmount());
						salesOrderModel.setBillingDateAndTime(salesReturnOrderModel.getBillingDateAndTime());
						salesOrderModel.setDiscountPrice(disAmount+salesReturnOrderModel.getDiscountPrice());
						salesOrderModel.setMargin(margin+salesReturnOrderModel.getDeductionOnMargin());
						salesOrderModel.setOrderIdByDate(salesReturnOrderModel.getOrderIdByDate());
						salesOrderModel.setTotalVAT(vatAmount+salesReturnOrderModel.getTotalVAT());
						salesOrderModel.setStatusModel(salesReturnOrderModel.getStatusModel());
						salesOrderModel.setPayAmount(payAmount+salesReturnOrderModel.getPayAmount());
						
						salesLineItemsModel.setStatusModel(salesReturnOrderModel.getStatusModel());
						salesLineItemsModel.setSalesOrderModel(salesOrderModel);
						
						productInventoryModel=new ProductInventoryModel();
						productInventoryModel=salesLineItemsModel.getProductInventoryModel();
						productInventoryModel.setQuantity(productInventoryModel.getQuantity()+salesLineItemsModel.getQuantity());
						
						salesLineItemsModel.setProductInventoryModel(productInventoryModel);
						
						salesReturnLineItemsModel=new SalesReturnLineItemsModel();
						try {
							salesReturnLineItemsModel=SalesReturnLineItemsModelPreparation.prepareSalesReturnLineItemsModel(salesLineItemsModel);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						
						salesReturnOrderModel=new SalesReturnOrderModel();
						salesReturnOrderModel=salesReturnLineItemsModel.getSalesReturnOrderModel();
						salesReturnOrderModel.setSalesOrderModel(salesReturnOrderModel.getSalesOrderModel());
						
				
					}else{
						
					
						
						salesOrderModel.setAmount(salesLineItemsModel.getAmount());
						try {
							salesOrderModel.setBillingDateAndTime(DateAndTimeUtilities.getCurrentDateTimeInSqlFormat());
						} catch (ParseException e) {
							e.printStackTrace();
						}
						salesOrderModel.setDiscountPrice(disAmount);
						salesOrderModel.setMargin(margin);
						salesOrderModel.setOrderIdByDate(""+salesOrderModel.getBillingDateAndTime());
						salesOrderModel.setPayAmount(payAmount);
						salesOrderModel.setTotalVAT(vatAmount);
						
						statusModel=new StatusModel();
						statusModel.setId(10);
						statusModel=resourcesService.getStatus(statusModel);
						
						salesOrderModel.setStatusModel(statusModel);
						
						
						salesLineItemsModel.setStatusModel(statusModel);
						salesLineItemsModel.setSalesOrderModel(salesOrderModel);
						
						productInventoryModel=new ProductInventoryModel();
						productInventoryModel=salesLineItemsModel.getProductInventoryModel();
						productInventoryModel.setQuantity(productInventoryModel.getQuantity()+salesLineItemsModel.getQuantity());
						
						salesLineItemsModel.setProductInventoryModel(productInventoryModel);
						
						salesReturnLineItemsModel=new SalesReturnLineItemsModel();
						try {
							salesReturnLineItemsModel=SalesReturnLineItemsModelPreparation.prepareSalesReturnLineItemsModel(salesLineItemsModel);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						
						salesReturnOrderModel=new SalesReturnOrderModel();
						salesReturnOrderModel=salesReturnLineItemsModel.getSalesReturnOrderModel();
						salesReturnOrderModel.setSalesOrderModel(salesService.getSalesOrder(salesOrderModel));
						
						
					
					}
					SalesLineItemsModel oldSalesLineItemsModel=new SalesLineItemsModel();
					oldSalesLineItemsModel.setId(formBean.getId());
					oldSalesLineItemsModel=salesService.getSalesOrderLineItemById(oldSalesLineItemsModel);
					
					oldSalesLineItemsModel.setDeliverableQuantity(oldSalesLineItemsModel.getDeliverableQuantity()-formBean.getQty());
					salesReturnLineItemsModel.setSalesReturnOrderModel(salesReturnOrderModel);

					oldSalesLineItemsModels.add(oldSalesLineItemsModel);
				salesReturnLineItemsModels.add(salesReturnLineItemsModel);
				}//loop
			
			
				salesReturnLineItemsModels=salesReturnsService.createSalesReturnOrder(salesReturnLineItemsModels,oldSalesLineItemsModels);
			//	salesReturnLineItemsModels=new ArrayList<SalesReturnLineItemsModel>();
			//	salesReturnLineItemsModels=salesReturnsService.getSalesReturnLineItemsModelsBySalesReturnOrderModel(salesReturnLineItemsModel.getSalesReturnOrderModel());
			   
			//	salesReturnLineItemsBeans=new ArrayList<SalesReturnLineItemsBean>();
		//		salesReturnLineItemsBeans=SalesReturnLineItemsBeanPreparation.prepareListOfSalesReturnLineItemsBeans(salesReturnLineItemsModels);
				SalesReturnOrderModel orderModel=null;
				
				for(int i=0;i<salesReturnLineItemsModels.size();i++){
					if(i>0){
						break;
					}
					orderModel=new SalesReturnOrderModel();
					orderModel=salesReturnLineItemsModels.get(i).getSalesReturnOrderModel();
					
				}
				Map<String,String> vatDetails=new HashMap<String,String>();
				Map vatMap=new HashMap();
				double vat_percent=0;
				double vat_applied_amount=0;
				double vat_amount=0;
				double[] vat_Array = null;
				//String vatDeatils="";
				for(SalesReturnLineItemsModel salesReturnLineItemsModel1:salesReturnLineItemsModels){
					vat_percent=salesReturnLineItemsModel1.getVat();
					double dicounted_amount=(salesReturnLineItemsModel1.getAmount())*(salesReturnLineItemsModel1.getDiscount()/100);
					vat_applied_amount=(salesReturnLineItemsModel1.getAmount()-dicounted_amount);
					vat_amount=vat_applied_amount*(vat_percent/100);

					if(vatMap.size()>0){
						if(!vatMap.containsKey(vat_percent)){
							vat_Array=new double[3];
							vat_Array[0]=vat_percent;
							vat_Array[1]=vat_applied_amount;
							vat_Array[2]=vat_amount;
						}else{
							vat_Array=new double[3];
							vat_Array=(double[]) vatMap.get(vat_percent);
							if(vat_Array[0]==vat_percent){
								vat_Array[1]=vat_Array[1]+vat_applied_amount;
								vat_Array[2]=vat_Array[2]+vat_amount;
							}
						}
					}else{
						vat_Array=new double[3];

						vat_Array[0]=vat_percent;
						vat_Array[1]=vat_applied_amount;
						vat_Array[2]=vat_amount;
					}
					vatMap.put(vat_percent,vat_Array); 
				}

				Iterator entries = vatMap.entrySet().iterator();
				double total_Vat=0.00;
				double total_Vat_Appaly_Amount=0.00;
				while (entries.hasNext()) {
					Map.Entry entry = (Map.Entry) entries.next();
					Double key = (Double)entry.getKey();
					vat_Array = (double[])entry.getValue();
					System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
					System.out.println("vat on " + vat_Array[1] + " @ "+vat_Array[0]+" is "+ vat_Array[2] );

					vatDetails.put(""+vat_Array[0]+"", "vat on " + Double.parseDouble(new DecimalFormat("##.##").format(vat_Array[1])) + " @ "+vat_Array[0]+" is "+ Double.parseDouble(new DecimalFormat("##.##").format(vat_Array[2])));
					//vatDeatils=vatDeatils+"<div>vat on " + Double.parseDouble(new DecimalFormat("##.##").format(vat_Array[1])) + " @ "+vat_Array[0]+" is "+ Double.parseDouble(new DecimalFormat("##.##").format(vat_Array[2]))+"</div>";
					total_Vat_Appaly_Amount=total_Vat_Appaly_Amount+Double.parseDouble(new DecimalFormat("##.##").format(vat_Array[1]));
					total_Vat=total_Vat+Double.parseDouble(new DecimalFormat("##.##").format(vat_Array[2]));
				}//)
				//vatDeatils=vatDeatils+"<div>-------------------------------------------------</div>";
				//vatDeatils=vatDeatils+"<div>total vat on "+total_Vat_Appaly_Amount+ " is "+total_Vat+"</div>";
				vatDetails.put("Total", "total vat on "+total_Vat_Appaly_Amount+ " is "+total_Vat+"");

				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> vatDeatils >>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+vatDetails);
				model.put("vatDetails", vatDetails);
				
				model.put("flag", "SRO");
				model.put("Order", orderModel);
				model.put("Items", salesReturnLineItemsModels);
			}
	          return new ModelAndView("sOInvoiceView",model);
	}else{
		return null;
	}
	}
}
