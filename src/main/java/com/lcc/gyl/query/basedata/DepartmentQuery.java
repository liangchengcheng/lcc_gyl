package com.lcc.gyl.query.basedata;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.lcc.gyl.query.BaseQuery;

public class DepartmentQuery extends BaseQuery {

	private String name;
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public Map<String, Object> buildWhere() {
		// name属性的值不为空
		if (StringUtils.isNotBlank(this.name)) {
			this.getKeyValues().put("name", this.name);
		}
		
		// description属性的值不为空
		if (StringUtils.isNotBlank(this.description)) {
			this.getKeyValues().put("description", this.description);
		}
		return this.getKeyValues();
	}

}
