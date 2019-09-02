package com.hanhwa.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDAO_Mybatis {
	
	@Autowired
	SqlSession session;
	
	public List<DeptDTO> selectAll() {
					//~를 실행하고 그 결과를 list로 받겠다.
		return session.selectList("com.hanhwa.dept.selectAll");
	}
	
	public DeptDTO selectById(int deptid) {
		return session.selectOne("com.hanhwa.dept.selectbyid", deptid);
	}
	
	
	public int insertdept(DeptDTO dept) {
		return session.insert("com.hanhwa.dept.insert", dept);
	}
	
	public int updateDept(DeptDTO dept) {
		return session.update("com.hanhwa.dept.update", dept);
	}
	
	public int deleteDept(int deptid) {
		return session.delete("com.hanhwa.dept.delete", deptid);
	}

	
}
