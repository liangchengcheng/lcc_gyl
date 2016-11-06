package com.lcc.gyl.basedata.dao.impl;

import org.springframework.stereotype.Repository;

import com.lcc.gyl.base.dao.impl.BaseDaoImpl;
import com.lcc.gyl.basedata.dao.DepartmentDao;
import com.lcc.gyl.domain.basedata.Department;

@Repository("departmentDao")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao{

}
