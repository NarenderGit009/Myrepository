package com.relyits.rmbs.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.relyits.rmbs.dao.NotificationDAO;
import com.relyits.rmbs.model.notifications.MessageNotificationsModel;
import com.relyits.rmbs.model.registration.BranchModel;
import com.relyits.rmbs.model.registration.OrganizationModel;
import com.relyits.rmbs.service.NotificationService;

@Service("notificationService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private NotificationDAO notificationDAO;
	

@Override
public boolean saveMessage(MessageNotificationsModel messageNotificationsModel) {
	
	return notificationDAO.saveMessage(messageNotificationsModel);
}


@Override
public List<MessageNotificationsModel> listOfMessageNotificationsToAdmin(MessageNotificationsModel messageNotificationsModel) {
	return notificationDAO.listOfMessageNotificationsToAdmin(messageNotificationsModel);
}
@Override
public List<OrganizationModel> getAdminByRole(OrganizationModel organizationModel) {
	return notificationDAO.getAdminByRole(organizationModel);
}


@Override
public int updateMessageStatus(List<MessageNotificationsModel> messageNotificationsModels) {
	return notificationDAO.updateMessageStatus(messageNotificationsModels);
}


@Override
public List<MessageNotificationsModel> listOfMessages(MessageNotificationsModel messageNotificationsModel) {
	return notificationDAO.listOfMessages(messageNotificationsModel);
}


@Override
public List<OrganizationModel> getOrganizationOfselectedBranch(OrganizationModel organizationModel) {
	return notificationDAO.getOrganizationOfselectedBranch(organizationModel);
}


@Override
public List<BranchModel> getBranchOfselectedOutlet(BranchModel branchModel) {
	return notificationDAO.getBranchOfselectedOutlet(branchModel);
}




}
