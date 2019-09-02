package com.hanhwa.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanhwa.util.DBUtil_Oracle;

/*
 * DAO(Data Access Object):Business logic
 */

// <bean id="deptDAO" class="com.hanhwa.model.deptDAO"/>
@Repository
public class DeptDAO {

	@Autowired
	DataSource ds;

	public List<DeptDTO> selectAll() {
		List<DeptDTO> deptlist = new ArrayList<>();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from departments";
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int deptid = rs.getInt("department_id");
				String dname = rs.getString("department_name");
				DeptDTO dept = new DeptDTO(deptid, dname);
				deptlist.add(dept);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		return deptlist;
	}

	public DeptDTO selectById(int deptid) {
		DeptDTO dept = null;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from departments where department_id = " + deptid;
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String dname = rs.getString("department_name");
				dept = new DeptDTO(deptid, dname);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			DBUtil_Oracle.dbClose(rs, st, conn);
		}
		return dept;

	}

	public int insertdept(DeptDTO dept) {
		Connection conn = null;
		PreparedStatement st = null;
		int count = 0;
		String sql = "insert into departments" + "(department_id, department_name) " + " values(?,?)";
		try {
			conn = ds.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, dept.getDepartment_id());
			st.setString(2, dept.getDepartment_name());
			count = st.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return count;
	}

	public int updateDept(DeptDTO dept) {
		Connection conn = null;
		PreparedStatement st = null;
		int result = 0;
		String sql = "update departments " + "set department_name =? " + " where department_id = ?";
		try {
			conn = ds.getConnection();
			st = conn.prepareStatement(sql);
			// 臾쇱쓬�몴�쓽 �닚�꽌(2 踰덉㎏ 臾쇱쓬�몴)
			st.setInt(2, dept.getDepartment_id());
			st.setString(1, dept.getDepartment_name());
			result = st.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return result;
	}

	public int deleteDept(int dept) {
		Connection conn = null;
		int result = 0;
		try {
			conn = ds.getConnection();
			PreparedStatement st = null;
			String sql = "delete from departments " + " where department_id =?";
			st = conn.prepareStatement(sql);
			st.setInt(1, dept);
			result = st.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return result;
	}

}
