package com.lcc.gyl.basedata.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lcc.gyl.base.action.BaseAction;
import com.lcc.gyl.domain.basedata.Department;

@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department>{
	//@Resource(name="departmentService")
	
}
