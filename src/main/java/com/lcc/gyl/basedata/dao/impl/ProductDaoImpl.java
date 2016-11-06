package com.lcc.gyl.basedata.dao.impl;

import org.springframework.stereotype.Repository;

import com.lcc.gyl.base.dao.impl.BaseDaoImpl;
import com.lcc.gyl.basedata.dao.ProductDao;
import com.lcc.gyl.domain.basedata.Product;

@Repository("productDao")
public class ProductDaoImpl  extends BaseDaoImpl<Product> implements ProductDao{

}
