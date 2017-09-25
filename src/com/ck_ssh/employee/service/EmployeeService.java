package com.ck_ssh.employee.service;

import com.ck_ssh.employee.domain.Employee;
import com.ck_ssh.employee.domain.PageBean;

//员工管理的业务层的接口
public interface EmployeeService {

	Employee login(Employee employee);

	PageBean<Employee> findByPage(Integer currPage);

	void save(Employee employee);

	Employee findById(Integer e_id);

	void update(Employee employee);

	void delete(Employee employee);

}
