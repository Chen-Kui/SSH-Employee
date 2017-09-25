package com.ck_ssh.employee.service;

import java.util.List;

import com.ck_ssh.employee.domain.Department;
import com.ck_ssh.employee.domain.PageBean;

public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	void save(Department department);

	Department findById(Integer d_id);

	void update(Department department);


	void delete(Department department);


	List<Department> findAll();


}
