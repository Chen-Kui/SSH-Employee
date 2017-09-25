<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head></head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 员工添加</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回</a>
</td>
</tr>
</table>
<br/>

<s:form action="employee_save" method="post" namespace="/" id="saveForm" >
<table border='0' cellpadding="0"  cellspacing="10">
<tr>
<td>姓名：</td>
<td><s:textfield name="e_name"/></td>
<td>性别：</td>
<td><s:radio name="sex" list="{'男','女'}"/></td>
</tr>
<tr>
<td>用户名：</td>
<td><s:textfield name="username"/></td>
<td>密码：</td>
<td><s:password name="password"/></td>
</tr>

<tr>
<td>出生日期：</td>
<td><s:textfield name="birthday"/></td>
<td>入职时间：</td>
<td><s:textfield name="joinDate"/></td>
</tr>

<tr>
<td>所属部门：</td>
<td><select><s:select name="department.d_id" list="list" listKey="d_id" listValue="d_name" headerKey="" headerValue="--请选择--"/></select></td>
<td>编号：</td>
<td><s:textfield name="e_no"/></td>
</tr>
</table>
</s:form>

</body>
</html>