package com.ck_ssh.employee.action;

import java.util.List;

import com.ck_ssh.employee.domain.Department;
import com.ck_ssh.employee.domain.Employee;
import com.ck_ssh.employee.domain.PageBean;
import com.ck_ssh.employee.service.DepartmentService;
import com.ck_ssh.employee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EmployeeAction extends ActionSupport implements
		ModelDriven<Employee> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 模型驱动使用的对象
	private Employee employee = new Employee();

	@Override
	public Employee getModel() {
		return employee;
	}

	// 注入业务层的类
	private EmployeeService employeeService;
	private DepartmentService departmentService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	// 接受当前页数
	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	// 登陆执行的方法
	public String login() {
		System.out.println("login执行了。。。。");
		// 调用业务层的方法
		Employee existEmployee = employeeService.login(employee);
		if (existEmployee == null) {
			// 登陆失败
			this.addActionError("你的用户名或者密码输入错误！");
			return INPUT;
		} else {
			// 登陆成功
			ActionContext.getContext().getSession()
					.put("existEmployee", existEmployee);
			return SUCCESS;
		}

	}

	// 分页查询员工执行的方法
	public String findAll() {
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	//跳转到添加员工页面执行的方法
	public String saveUI() {
		// 查询所有部门
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	
	//保存员工执行的方法
	public String save(){
		employeeService.save(employee);
		return "saveSuccess";
	}
	
	//编辑员工执行的方法
	public String edit(){
		//根据员工ID查询员工
		employee = employeeService.findById(employee.getE_id());
		//查询所有的部门
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editSuccess";
	}
	
	//修改员工执行的方法
	public String update(){
		employeeService.update(employee);
		return "updateSuccess";
	}
	
	//删除员工的方法
	public String delete(){
		employee = employeeService.findById(employee.getE_id());
		employeeService.delete(employee);
		return "deleteSuccess";
	}
}
