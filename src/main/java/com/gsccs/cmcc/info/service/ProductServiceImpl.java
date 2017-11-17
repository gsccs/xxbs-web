package com.gsccs.cmcc.info.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.cmcc.info.dao.ProductTMapper;
import com.gsccs.cmcc.info.model.ProductT;
import com.gsccs.cmcc.info.model.ProductTExample;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductTMapper productTMapper;

	@Override
	public void addProduct(ProductT product) {
		if (null != product) {
			if (StringUtils.isEmpty(product.getId())){
				product.setId(UUID.randomUUID().toString());
			}
			productTMapper.insert(product);
		}
	}

	@Override
	public List<ProductT> find(ProductT product, String order, int currPage, int pageSize) {
		ProductTExample example = new ProductTExample();
		ProductTExample.Criteria c = example.createCriteria();
		proSearchParam(product, c);
		example.setPageSize(pageSize);
		example.setCurrPage(currPage);
		return productTMapper.selectPageByExample(example);
	}


	private void proSearchParam(ProductT product, ProductTExample.Criteria criteria) {
		if (product != null) {
			if (product.getId() != null) {
				criteria.andIdEqualTo(product.getId());
			}

			if (StringUtils.isNotEmpty(product.getTitle())) {
				criteria.andTitleLike("%" + product.getTitle() + "%");
			}
			
			if(StringUtils.isNotEmpty(product.getIssem())){
				criteria.andIssemEqualTo(product.getIssem());
			}
			
			if(StringUtils.isNotEmpty(product.getIsmodi())){
				criteria.andIsmodiEqualTo(product.getIsmodi());
			}
			
			if(StringUtils.isNotEmpty(product.getStatus())){
				criteria.andStatusEqualTo(product.getStatus());
			}
		}
	}

	@Override
	public int count(ProductT product) {
		ProductTExample example = new ProductTExample();
		ProductTExample.Criteria c = example.createCriteria();
		proSearchParam(product, c);
		return productTMapper.countByExample(example);
	}

	@Override
	public ProductT getProduct(String id) {
		return productTMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateProduct(ProductT product) {
		if (null != product) {
			productTMapper.updateByPrimaryKey(product);
		}
	}

	@Override
	public void delProduct(String id) {
		productTMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<ProductT> find(ProductT product) {
		ProductTExample example = new ProductTExample();
		ProductTExample.Criteria c = example.createCriteria();
		proSearchParam(product, c);
		return productTMapper.selectByExample(example);
	}
}
