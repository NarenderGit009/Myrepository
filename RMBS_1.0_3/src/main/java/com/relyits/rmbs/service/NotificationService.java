package com.relyits.rmbs.service;

import java.util.List;

import com.relyits.rmbs.model.notifications.MessageNotificationsModel;
import com.relyits.rmbs.model.registration.BranchModel;
import com.relyits.rmbs.model.registration.OrganizationModel;

public interface NotificationService {
	
	public boolean saveMessage(MessageNotificationsModel messageNotificationsModel);
	
	public List<MessageNotificationsModel> listOfMessageNotificationsToAdmin(MessageNotificationsModel messageNotificationsModel);	

	public List<OrganizationModel> getAdminByRole(OrganizationModel organizationModel);	
	
	public int updateMessageStatus(List<MessageNotificationsModel> messageNotificationsModels);

	public List<MessageNotificationsModel> listOfMessages(MessageNotificationsModel messageNotificationsModel);

	public List<OrganizationModel> getOrganizationOfselectedBranch(OrganizationModel organizationModel);

	public List<BranchModel> getBranchOfselectedOutlet(BranchModel branchModel);
}
