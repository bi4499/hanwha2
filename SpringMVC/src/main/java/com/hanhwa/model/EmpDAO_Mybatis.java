package com.hanhwa.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO_Mybatis {

	@Autowired
	SqlSession session;
	String namespace="com.hanhwa.emp.";
	
	public List<EmpVO> selectAll() {
		return session.selectList(namespace+"selectAll");
	}

	public EmpVO selectById(int empid) {
		return session.selectOne(namespace+"selectbyid", empid);
	}

	public List<EmpVO> selectByDept(int deptid) {
		return session.selectList(namespace+"selectByDept", deptid);
	}

	public int insertEmp(EmpVO emp) {
		return session.insert(namespace+"insert", emp);
	}

	public int updateEmp(EmpVO emp) {
		return session.update(namespace+"update", emp);
	}

	public int deleteEmp(int empid) {
		return session.delete(namespace+"delete", empid);
	}

	/*
	 * public List<EmpVO> selectByJobID(String job, int sal) { return session }
	 */
	public List<String> selectAllJob() {
		return session.selectList(namespace+"selectAllJob");
	}

	public List<Integer> selectAllManager() {
		return session.selectList(namespace+"selectAllManager");
	}

}
