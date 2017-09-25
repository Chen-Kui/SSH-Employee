package com.ck_ssh.employee.dao;

import java.util.List;

import com.ck_ssh.employee.domain.Employee;

//员工管理的DAO的接口
public interface EmployeeDao {

	Employee findByUsernameAndPassword(Employee employee);

	int findCount();

	List<Employee> findByPage(int begin, int pageSize);

	void save(Employee employee);

	Employee findById(Integer e_id);

	void update(Employee employee);

	void delete(Employee employee);

}
