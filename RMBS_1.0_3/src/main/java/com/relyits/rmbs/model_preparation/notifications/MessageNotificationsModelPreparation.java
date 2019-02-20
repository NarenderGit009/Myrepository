package com.relyits.rmbs.model_preparation.notifications;

import com.relyits.rmbs.beans.notifications.MessageNotificationsBean;
import com.relyits.rmbs.model.notifications.MessageNotificationsModel;
import com.relyits.rmbs.model.refference.CategoryModel;
import com.relyits.rmbs.model.refference.RoleModel;
import com.relyits.rmbs.model.refference.StatusModel;



public class MessageNotificationsModelPreparation {
	
	private static MessageNotificationsModel messageNotificationsModel = null;
	private static StatusModel accountStatusModel = null;
	private static RoleModel creatorRoleModel = null;
	private static RoleModel responsibleRoleModel = null;
	private static CategoryModel categoryModel = null;
	
	public static MessageNotificationsModel prepareMessageNotificationsModel(MessageNotificationsBean messageNotificationsBean){
		
		messageNotificationsModel = new MessageNotificationsModel();
		accountStatusModel = new StatusModel();
		creatorRoleModel = new RoleModel();
		responsibleRoleModel = new RoleModel();
		categoryModel = new CategoryModel();
		
		
		messageNotificationsModel.setId(messageNotificationsBean.getId());
		messageNotificationsModel.setMessage(messageNotificationsBean.getMessage());
		messageNotificationsModel.setCreatedDate(messageNotificationsBean.getCreatedDate());
		messageNotificationsModel.setResponsibility(messageNotificationsBean.getResponsibility());
		messageNotificationsModel.setCreatedBy(messageNotificationsBean.getCreatedBy());
	/*	messageNotificationsModel.setAccountStatusModel(AddressModelPreparation.prepareAccountStatusModel(messageNotificationsBean.getAccountStatusBean()));
		messageNotificationsModel.setCategoryModel(AddressModelPreparation.prepareCategoryModel(messageNotificationsBean.getCategoryBean()));
		messageNotificationsModel.setCreatorRoleModel(AddressModelPreparation.prepareCreatorRoleModel(messageNotificationsBean.getCreatorRoleBean()));
		messageNotificationsModel.setResponsibleRoleModel(AddressModelPreparation.prepareRoleModel(messageNotificationsBean.getResponsibleRoleBean()));
	*/		
		accountStatusModel.setId(messageNotificationsBean.getStatusBean().getId());
		creatorRoleModel.setId(messageNotificationsBean.getCreatorRoleBean().getId());
		responsibleRoleModel.setId(messageNotificationsBean.getResponsibleRoleBean().getId());
		categoryModel.setId(messageNotificationsBean.getCategoryBean().getId());
		
		messageNotificationsModel.setStatusModel(accountStatusModel);
		messageNotificationsModel.setCategoryModel(categoryModel);
		messageNotificationsModel.setCreatorRoleModel(creatorRoleModel);
		messageNotificationsModel.setResponsibleRoleModel(responsibleRoleModel);
		
		return messageNotificationsModel;
		}


	
}
