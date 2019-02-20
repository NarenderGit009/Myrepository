package com.relyits.rmbs.model.product;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.relyits.rmbs.model.refference.ReasonModel;
import com.relyits.rmbs.model.refference.RoleModel;
import com.relyits.rmbs.model.registration.AgencyModel;

@Entity
@Table(name="RMBS204", schema="RMBS",
            uniqueConstraints = {
		           @UniqueConstraint(columnNames = "RMBS20401")})   //id
public class ProductDamageModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RMBS20401", unique = true, nullable = false)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "AG_RMBS10401", nullable = false)
	private AgencyModel agencyModel;
	
	@Column(name = "RMBS20402", nullable = false, length = 50)
	private Integer quantity;
	
	@Column(name = "RMBS20403", nullable = false, length = 25)
	private Date damagedDate;
	
	@OneToOne
	@JoinColumn(name = "RS_RMBS80601", nullable = false)
	private ReasonModel reasonModel;
	
	@OneToOne
	@JoinColumn(name = "PI_RMBS20201", nullable = false)
	private ProductInventoryModel productInventoryModel;
	
	@Column(name = "RMBS20404", nullable = false, length = 50)
	private Integer creator;
	
	@OneToOne
	@JoinColumn(name = "RL_RMBS80201", nullable = false)
	private RoleModel creatorRoleModel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AgencyModel getAgencyModel() {
		return agencyModel;
	}

	public void setAgencyModel(AgencyModel agencyModel) {
		this.agencyModel = agencyModel;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getDamagedDate() {
		return damagedDate;
	}

	public void setDamagedDate(Date damagedDate) {
		this.damagedDate = damagedDate;
	}

	public ReasonModel getReasonModel() {
		return reasonModel;
	}

	public void setReasonModel(ReasonModel reasonModel) {
		this.reasonModel = reasonModel;
	}

	public ProductInventoryModel getProductInventoryModel() {
		return productInventoryModel;
	}

	public void setProductInventoryModel(ProductInventoryModel productInventoryModel) {
		this.productInventoryModel = productInventoryModel;
	}

	public Integer getCreator() {
		return creator;
	}

	public void setCreator(Integer creator) {
		this.creator = creator;
	}

	public RoleModel getCreatorRoleModel() {
		return creatorRoleModel;
	}

	public void setCreatorRoleModel(RoleModel creatorRoleModel) {
		this.creatorRoleModel = creatorRoleModel;
	}

	
	
	
	
}
