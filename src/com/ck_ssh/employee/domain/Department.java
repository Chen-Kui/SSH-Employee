package com.ck_ssh.employee.domain;

import java.util.HashSet;
import java.util.Set;

public class Department {
	private Integer d_id;
	private String d_name;
	private String d_desc;

	// 员工的集合
	private Set<Employee> employees = new HashSet<Employee>();

	public Integer getD_id() {
		return d_id;
	}

	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}

	public String getD_name() {
		return d_name;
	}

	public void setD_name(String d_name) {
		this.d_name = d_name;
	}

	public String getD_desc() {
		return d_desc;
	}

	public void setD_desc(String d_desc) {
		this.d_desc = d_desc;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
