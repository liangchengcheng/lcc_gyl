package com.lcc.gyl.basedata.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lcc.gyl.base.dao.BaseDao;
import com.lcc.gyl.base.service.impl.BaseServiceImpl;
import com.lcc.gyl.basedata.dao.DepartmentDao;
import com.lcc.gyl.basedata.service.DepartmentService;
import com.lcc.gyl.domain.basedata.Department;

@Service("departmentService")
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements DepartmentService{

	@Resource(name="departmentDao")
	private DepartmentDao departmentDao;
	
	@Override
	public BaseDao getBaseDao() {
		return this.departmentDao;
	}

}
