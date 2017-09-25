package com.ck_ssh.employee.dao;

import java.util.List;

import com.ck_ssh.employee.domain.Department;

public interface DepartmentDao {

	int findCount();

	List<Department> findByPage(int begin, int pageSize);


	void save(Department department);


	Department findById(Integer d_id);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();



}
