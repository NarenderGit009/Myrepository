package com.relyits.rmbs.beans_preparation.notifications;

import java.util.ArrayList;
import java.util.List;

import com.relyits.rmbs.beans.notifications.MessageNotificationsBean;
import com.relyits.rmbs.beans_preparation.resources.AddressBeanPreparation;
import com.relyits.rmbs.model.notifications.MessageNotificationsModel;
import com.relyits.rmbs.model_preparation.resource.AddressModelPreparation;



public class MessageNotificationsBeanPreparation {
	
	private static MessageNotificationsBean messageNotificationsBean = null;
	
	public static MessageNotificationsBean prepareMessageNotificationsBean(MessageNotificationsModel messageNotificationsModel){
		
		messageNotificationsBean = new MessageNotificationsBean();
		
		messageNotificationsBean.setId(messageNotificationsModel.getId());
		messageNotificationsBean.setCreatedBy(messageNotificationsModel.getCreatedBy());
		messageNotificationsBean.setMessage(messageNotificationsModel.getMessage());
		messageNotificationsBean.setCreatedDate(messageNotificationsModel.getCreatedDate());
		messageNotificationsBean.setResponsibility(messageNotificationsModel.getResponsibility());
		messageNotificationsBean.setStatusBean(AddressBeanPreparation.prepareAccountStatusBean(messageNotificationsModel.getStatusModel()));
		messageNotificationsBean.setCategoryBean(AddressBeanPreparation.prepareCategoryBean(messageNotificationsModel.getCategoryModel()));
		messageNotificationsBean.setCreatorRoleBean(AddressBeanPreparation.prepareCreatorRoleBean(messageNotificationsModel.getCreatorRoleModel()));
		messageNotificationsBean.setResponsibleRoleBean(AddressBeanPreparation.prepareRoleBean(messageNotificationsModel.getResponsibleRoleModel()));
		
		
		return messageNotificationsBean;
		
	}
	
	public static List<MessageNotificationsBean> prepareListOfMessageNotificationsBean(List<MessageNotificationsModel> messageNotificationsModels){
		List<MessageNotificationsBean> messageNotificationsBeans = null;	
		if(messageNotificationsModels != null && ! messageNotificationsModels.isEmpty()){
			
			messageNotificationsBeans = new ArrayList<MessageNotificationsBean>();
			for(MessageNotificationsModel messageNotificationsModel : messageNotificationsModels){
				messageNotificationsBeans.add(prepareMessageNotificationsBean(messageNotificationsModel));
				
			}
		}
		
		return messageNotificationsBeans;
		
	}


	
}
