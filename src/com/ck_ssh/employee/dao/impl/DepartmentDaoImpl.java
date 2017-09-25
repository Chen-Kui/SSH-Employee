package com.ck_ssh.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ck_ssh.employee.dao.DepartmentDao;
import com.ck_ssh.employee.domain.Department;

public class DepartmentDaoImpl extends HibernateDaoSupport implements
		DepartmentDao {

	@Override
	public int findCount() {
		String hql = "select count(*) from Department";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	// 分页查询部门
	public List<Department> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		List<Department> list = this.getHibernateTemplate().findByCriteria(
				criteria, begin, pageSize);
		return list;
	}

	// 跳转到添加部门的页面的方法：
	public String saveUI() {
		return "saveUI";
	}
	//DAO中保存部门的方法
	@Override
	public void save(Department department) {
		this.getHibernateTemplate().save(department);
	}

	@Override
	//DAO中根据部门的ID去查询部门的方法
	public Department findById(Integer d_id) {
		return this.getHibernateTemplate().get(Department.class, d_id);
	}

	@Override
	//DAO中修改部门的方法
	public void update(Department department) {
		this.getHibernateTemplate().update(department);
	}

	@Override
	//DAO中删除部门的方法
	public void delete(Department department) {
		this.getHibernateTemplate().delete(department);
	}

	@Override
	//DAO中查询所有部门的方法
	public List<Department> findAll() {
		return this.getHibernateTemplate().find("from Department");	
	}

}
