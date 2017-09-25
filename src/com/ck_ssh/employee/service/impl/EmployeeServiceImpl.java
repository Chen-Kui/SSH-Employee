package com.ck_ssh.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ck_ssh.employee.dao.EmployeeDao;
import com.ck_ssh.employee.domain.Department;
import com.ck_ssh.employee.domain.Employee;
import com.ck_ssh.employee.domain.PageBean;
import com.ck_ssh.employee.service.EmployeeService;

//员工管理的业务层实现类
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	// 业务层的登陆方法
	@Override
	public Employee login(Employee employee) {
		Employee existEmployee = employeeDao
				.findByUsernameAndPassword(employee);
		return existEmployee;
	}

	// 业务层的分页查询员工的方法
	@Override
	public PageBean<Employee> findByPage(Integer currPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		// 封装当前页数
		pageBean.setCurrPage(currPage);
		// 封装每页显示记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		// 封装总的记录数
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 封装总的页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// 封装每页显示的bean
		int begin = (currPage - 1) * pageSize;
		List<Employee> list = employeeDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	//业务层保存员工的方法
	public void save(Employee employee) {
		employeeDao.save(employee);	
	}

	@Override
	//业务层，根据员工的ID去查询员工的方法
	public Employee findById(Integer e_id) {
		return employeeDao.findById(e_id);
	}

	@Override
	//业务层修改员工的方法
	public void update(Employee employee) {
		employeeDao.update(employee);
	}

	@Override
	//业务层删除员工信息的方法
	public void delete(Employee employee) {
		employeeDao.delete(employee);
	}
}
