package com.relyits.rmbs.service;

import java.util.List;

import com.relyits.rmbs.model.product.ProductDamageModel;
import com.relyits.rmbs.model.product.ProductInventoryModel;
import com.relyits.rmbs.model.product.ProductLogModel;
import com.relyits.rmbs.model.product.ProductModel;
import com.relyits.rmbs.model.refference.SubCategoryModel;
import com.relyits.rmbs.model.registration.AgencyModel;

public interface ProductService {
	
		public List<String> getAgenciesList(AgencyModel agencyModel);
		
		public void addProduct(ProductInventoryModel productInventoryModel);
		
		public List<String> getProductsList(ProductModel productModel);
		
		public List<ProductModel> getInventroyProductsList(ProductInventoryModel productInventoryModel);
		
		public ProductModel getProduct(ProductModel productModel);
		
		public List<ProductInventoryModel> getProductBatches(ProductInventoryModel productInventoryModel);
		
		public ProductInventoryModel getProductInventoryModelByBatchNo(ProductInventoryModel productInventoryModel);
		
		public ProductInventoryModel loadProductInventoryModel(ProductInventoryModel productInventoryModel);
		
		public int upadteProductInventoryQuantity(ProductInventoryModel productInventoryModel);
		
		public List<SubCategoryModel> getSubCategoryListByCategory(SubCategoryModel subCategoryModel);
		
		public List<ProductModel> listProductsByCreator(ProductModel productModel) ;
		
		public List<ProductInventoryModel> listProductsInventoryByOrganization(ProductInventoryModel productInventoryModel);
		
		public List<ProductInventoryModel> listProductsInventoryByBranch(ProductInventoryModel productInventoryModel);

		public List<ProductInventoryModel> listProductsInventoryByOutlet(ProductInventoryModel productInventoryModel);

		public ProductInventoryModel getProductInventory(ProductInventoryModel productInventoryModel);

		public Integer updatePIQuantity(ProductInventoryModel productInventoryModel);
		
		public List<ProductLogModel> listProductsLogByBranch(ProductLogModel productLogModel);
		
		public List<ProductLogModel> listProductsLogByOrganization(ProductLogModel productLogModel);
		
		public List<ProductInventoryModel> expiredProductsByOrganization(ProductInventoryModel productInventoryModel);

		public List<ProductInventoryModel> expiredProductsByBranch(ProductInventoryModel productInventoryModel);

		public List<ProductInventoryModel> expiredProductsByOutlet(ProductInventoryModel productInventoryModel);
		
		public List<ProductDamageModel> listProductsDamageByOrganization(ProductDamageModel productDamageModel);
		
		public List<ProductDamageModel> listProductsDamageByBranch(ProductDamageModel productDamageModel);
		
		public List<ProductDamageModel> listProductsDamageByOutlet(ProductDamageModel productDamageModel);	
		
		public List<ProductInventoryModel> listProductsGoingToExpireByOrganization(ProductInventoryModel productInventoryModel);
		
		public List<ProductInventoryModel> listProductsGoingToExpireByBranch(ProductInventoryModel productInventoryModel);
		
		public List<ProductInventoryModel> listProductsGoingToExpireByOutlet(ProductInventoryModel productInventoryModel);
		
		public List<ProductInventoryModel> lessQuantityProductsByOrganization(ProductInventoryModel productInventoryModel);
	
		public List<ProductInventoryModel> lessQuantityProductsByBranchOrOutlet(ProductInventoryModel productInventoryModel);
		
	    public void insertBulkProducts(List<ProductModel> list, AgencyModel agencyModel,int createdby,int createrRole);

		public List<AgencyModel> getAgencyList();

}
