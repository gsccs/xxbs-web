package com.gsccs.cmcc.info.service;

import java.util.List;

import com.gsccs.cmcc.info.model.ProductT;

public interface ProductService {

	public void addProduct(ProductT product);

	public void updateProduct(ProductT product);

	public ProductT getProduct(String id);

	public void delProduct(String id);

	public List<ProductT> find(ProductT product, String order, int currPage,
			int pageSize);
	
	public List<ProductT> find(ProductT product);

	public int count(ProductT product);
	
	
	
}
