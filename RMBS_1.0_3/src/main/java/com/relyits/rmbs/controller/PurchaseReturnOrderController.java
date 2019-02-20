package com.relyits.rmbs.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.relyits.rmbs.beans.purchase.PurchaseLineItemsBean;
import com.relyits.rmbs.beans.purchase.PurchaseOrderBean;
import com.relyits.rmbs.beans.purchase.PurchaseReturnLineItemsBean;
import com.relyits.rmbs.beans.purchase.PurchaseReturnOrderBean;
import com.relyits.rmbs.beans.purchase.PurchaseReturnsFormBean;
import com.relyits.rmbs.beans.session.UserSessionBean;
import com.relyits.rmbs.model.product.ProductInventoryModel;
import com.relyits.rmbs.model.purchase.PurchaseLineItemsModel;
import com.relyits.rmbs.model.purchase.PurchaseOrderModel;
import com.relyits.rmbs.model.purchase.PurchaseReturnLineItemsModel;
import com.relyits.rmbs.model.purchase.PurchaseReturnOrderModel;
import com.relyits.rmbs.model.registration.AgencyModel;
import com.relyits.rmbs.model.registration.BranchModel;
import com.relyits.rmbs.model.registration.OrganizationModel;
import com.relyits.rmbs.model.registration.OutletModel;
import com.relyits.rmbs.model.registration.ResourceModel;
import com.relyits.rmbs.utilities.DateAndTimeUtilities;
import com.relyits.rmbs.utilities.SessionUtilities;
@Controller
public class PurchaseReturnOrderController {
	
//	@Autowired
//	private PurchaseReturnsService purchaseReturnsService;

	private Map<String,Object> model =null;
	private PurchaseOrderModel purchaseOrderModel = null;
	private PurchaseOrderBean purchaseOrderBean = null;
	private OrganizationModel organizationModel = null;
	private BranchModel branchModel = null;
	private OutletModel outletModel = null;
	private AgencyModel agencyModel = null;
	private ResourceModel resourceModel = null;
	private PurchaseReturnLineItemsModel purchaseReturnLineItemsModel = null;
	private ProductInventoryModel productInventoryBean = null;
	private PurchaseLineItemsModel purchaseLineItemsModel = null;
	private PurchaseLineItemsBean purchaseLineItemsBean = null;
	private PurchaseReturnOrderBean purchaseReturnOrderBean = null;
	private PurchaseReturnLineItemsBean purchaseReturnLineItemsBean = null;
	private PurchaseReturnOrderModel purchaseReturnOrderModel = null;
	private List<PurchaseReturnLineItemsModel> purchaseReturnLineItemsModels = null;
	private List<PurchaseLineItemsModel> purchaseLineItemsModels = null;
	@RequestMapping(value = "/createPurchasereturnOrder", 
			method = RequestMethod.POST, 
			headers="Accept=*/*")
	public ModelAndView createPurchaseReturnOrder(@RequestBody String str,HttpServletRequest request,HttpSession session) throws ParseException{
		UserSessionBean userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);

		if(mode[0]==1){
			ObjectMapper objectMapper = new ObjectMapper();
			List<PurchaseReturnsFormBean> purchaseReturnsFormBeans=new ArrayList<PurchaseReturnsFormBean>();
			
			PurchaseReturnsFormBean purchaseReturnsFormBean = null;
			boolean flag = false;
			
			try{
				
				JsonNode node = objectMapper.readTree(str);
				for(int i=0;i<node.size();i++){
					
					purchaseReturnsFormBean = new PurchaseReturnsFormBean();
					purchaseReturnsFormBean = objectMapper.convertValue(node.get(i),PurchaseReturnsFormBean.class);
					
					purchaseReturnsFormBeans.add(purchaseReturnsFormBean);
					flag = true;
				}
			}
			catch(Exception e){
				flag = false;
			}
			
			if(flag){
				model = new HashMap<String,Object>();
				purchaseReturnLineItemsModels = new ArrayList<PurchaseReturnLineItemsModel>();
				purchaseLineItemsModels = new ArrayList<PurchaseLineItemsModel>();
				
				purchaseOrderModel = new PurchaseOrderModel();
				
				for(PurchaseReturnsFormBean pReturnsFormBean:purchaseReturnsFormBeans){
					
					purchaseLineItemsModel = new PurchaseLineItemsModel();
					purchaseLineItemsModel.setId(pReturnsFormBean.getId());
					
//					purchaseLineItemsModels = 
					purchaseOrderModel = new PurchaseOrderModel();
					purchaseOrderModel = purchaseLineItemsModel.getPurchaseOrderModel();
					
				}
				
			}else{
				
			}
		}
		return null;
		}

}
