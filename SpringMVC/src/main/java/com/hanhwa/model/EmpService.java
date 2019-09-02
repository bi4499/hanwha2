package com.hanhwa.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
	
	@Autowired
	EmpDAO_Mybatis dao;
						//controller must know this
	public List<String> selectAllJob() {
					//name of method
		return dao.selectAllJob();
	}

	public List<Integer> selectAllManager() {
		return dao.selectAllManager();
	}

	public List<EmpVO> selectAll() {
		return dao.selectAll();
	}

	public EmpVO selectById(int empid) {
		return dao.selectById(empid);
	}

	/*
	 * public List<EmpVO> selectByDept(int deptid) { return
	 * dao.selectByDept(deptid); }
	 */

	/*
	 * public List<EmpVO> selectByJobID(String job, int sal) { return
	 * dao.selectByJobID(job, sal); }
	 */

	public int insertEmp(EmpVO emp) {
		return dao.insertEmp(emp);
	}

	public int updateEmp(EmpVO emp) {
		return dao.updateEmp(emp);
	}

	public int deleteEmp(int empid) {
		return dao.deleteEmp(empid);
	}

	public EmpDAO_Mybatis getDao() {
		return dao;
	}

	public void setDao(EmpDAO_Mybatis dao) {
		this.dao = dao;
	}
	
	

}
