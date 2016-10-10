package com.lcc.gyl.domain.priviege;

import java.io.Serializable;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

import com.lcc.gyl.domain.basedata.User;

public class Role implements Serializable {

	private Long rid;
	private Long pid;
	private String name;
	//是否是父节点
	private Boolean isParent;
	private Set<User>users;
	private Set<Privilege> privileges;
	//设置是否被选中
	private Boolean checked;
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	@JSON(serialize=false)
	public Set<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getIsParent() {
		return isParent;
	}
	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
