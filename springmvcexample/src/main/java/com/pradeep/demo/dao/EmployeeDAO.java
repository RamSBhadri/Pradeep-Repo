package com.pradeep.demo.dao;

import java.util.List;

import com.pradeep.demo.model.EmployeeVO;

public interface EmployeeDAO 
{
	public List<EmployeeVO> getAllEmployees();
}