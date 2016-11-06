package com.lcc.gyl.basedata.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lcc.gyl.base.dao.BaseDao;
import com.lcc.gyl.base.service.impl.BaseServiceImpl;
import com.lcc.gyl.basedata.dao.ProductDao;
import com.lcc.gyl.basedata.service.ProductService;
import com.lcc.gyl.domain.basedata.Product;

@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product>  implements ProductService{

	@Resource(name="productDao")
	private ProductDao productDao;
	
	@Override
	public BaseDao getBaseDao() {
		return this.productDao;
	}

}
