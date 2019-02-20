package com.relyits.rmbs.model.registration;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.relyits.rmbs.model.refference.AddressModel;
import com.relyits.rmbs.model.refference.RoleModel;
import com.relyits.rmbs.model.refference.StatusModel;

@Entity
@Table(name="RMBS106", schema="RMBS",
            uniqueConstraints = {
		           @UniqueConstraint(columnNames = "RMBS10601")   //id
		         /* @UniqueConstraint(columnNames = "MN_RMBS50101")*/})  // MenuId of MenuModel
public class ResourceModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RMBS10601", unique = true, nullable = false)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "AC_ST_RMBS80301", nullable = false)
	private StatusModel accountStatusModel;
	
	@OneToOne
	@JoinColumn(name = "LG_ST_RMBS80301", nullable = false)
	private StatusModel loginStatusModel;
	
	@OneToOne
	@JoinColumn(name = "RL_RMBS80201", nullable = false)
	private RoleModel roleModel;
	
	@OneToOne
	@JoinColumn(name = "ADD_RMBS80101", nullable = false)
	private AddressModel addressModel;
	
/*	@OneToOne
	@JoinColumn(name = "MN_RMBS50101", unique = true, nullable = false)
	private MenuModel menuModel;
*/
	@OneToOne
	@JoinColumn(name = "CR_RMBS80201", nullable = false)
	private RoleModel creatorRoleModel;
	
	@Column(name = "RMBS10602"/*, nullable = false*/, length = 25)
	private Integer createdBy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StatusModel getAccountStatusModel() {
		return accountStatusModel;
	}

	public void setAccountStatusModel(StatusModel accountStatusModel) {
		this.accountStatusModel = accountStatusModel;
	}

	public StatusModel getLoginStatusModel() {
		return loginStatusModel;
	}

	public void setLoginStatusModel(StatusModel loginStatusModel) {
		this.loginStatusModel = loginStatusModel;
	}

	public RoleModel getRoleModel() {
		return roleModel;
	}

	public void setRoleModel(RoleModel roleModel) {
		this.roleModel = roleModel;
	}

	public AddressModel getAddressModel() {
		return addressModel;
	}

	public void setAddressModel(AddressModel addressModel) {
		this.addressModel = addressModel;
	}

/*	public MenuModel getMenuModel() {
		return menuModel;
	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}
*/
	public RoleModel getCreatorRoleModel() {
		return creatorRoleModel;
	}

	public void setCreatorRoleModel(RoleModel creatorRoleModel) {
		this.creatorRoleModel = creatorRoleModel;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	
	
	
}
