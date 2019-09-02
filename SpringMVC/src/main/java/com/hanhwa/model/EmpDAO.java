package com.hanhwa.model;

import java.sql.Connection;
import java.sql.Date;
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

@Repository 
public class EmpDAO {

	@Autowired
	DataSource ds;
	
	
	public List<String> selectAllJob() {

		List<String> joblist = new ArrayList<>();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from jobs";
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				joblist.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return joblist;
	}

	public List<Integer> selectAllManager() {
		List<Integer> mlist = new ArrayList<>();
		Connection conn = null;
		Statement st = null;
		String sql = "select distinct manager_id  from employees";
		ResultSet rs = null;

		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				mlist.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mlist;
	}

	public List<EmpVO> selectAll() {
		List<EmpVO> emplist = new ArrayList<>();
		Connection conn = null;
		Statement st = null;
		String sql = "select * from employees";
		ResultSet rs = null;

		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int employee_id = rs.getInt("employee_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				String phone_number = rs.getString("phone_number");
				Date hire_date = rs.getDate("hire_date");
				String job_id = rs.getString("job_id");
				int salary = rs.getInt("salary");
				double commission_pct = rs.getDouble("commission_pct");
				int manager_id = rs.getInt("manager_id");
				int department_id = rs.getInt("department_id");

				EmpVO emp = new EmpVO(employee_id, first_name, last_name, email, phone_number, hire_date, job_id,
						salary, commission_pct, manager_id, department_id);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emplist;
	}

	public EmpVO selectById(int empid) {
		EmpVO emp = null;
		Connection conn = null;
		Statement st = null;
		String sql = "select * from employees where employee_id = " + empid;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int employee_id = rs.getInt("employee_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				String phone_number = rs.getString("phone_number");
				Date hire_date = rs.getDate("hire_date");
				String job_id = rs.getString("job_id");
				int salary = rs.getInt("salary");
				double commission_pct = rs.getDouble("commission_pct");
				int manager_id = rs.getInt("manager_id");
				int department_id = rs.getInt("department_id");

				emp = new EmpVO(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary,
						commission_pct, manager_id, department_id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emp;
	}

	public List<EmpVO> selectByDept(int deptid) {
		List<EmpVO> emplist = new ArrayList<>();
		Connection conn = null;
		Statement st = null;
		String sql = "select * from employees where department_id =" + deptid;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int employee_id = rs.getInt("employee_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				String phone_number = rs.getString("phone_number");
				Date hire_date = rs.getDate("hire_date");
				String job_id = rs.getString("job_id");
				int salary = rs.getInt("salary");
				double commission_pct = rs.getDouble("commission_pct");
				int manager_id = rs.getInt("manager_id");
				int department_id = rs.getInt("department_id");

				EmpVO emp = new EmpVO(employee_id, first_name, last_name, email, phone_number, hire_date, job_id,
						salary, commission_pct, manager_id, department_id);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emplist;
	}

	public List<EmpVO> selectByJobID(String job, int sal) {
		List<EmpVO> emplist = new ArrayList<>();
		Connection conn = null;
		PreparedStatement st = null;
		// �씠諛⑸쾿�� �냽�룄媛� �뼥�뼱吏�
		String sql = "select * from employees where job_id = ? and salary >= ?";
		ResultSet rs = null;

		try {
			conn = ds.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, job);
			st.setInt(2, sal);
			rs = st.executeQuery();
			while (rs.next()) {
				int employee_id = rs.getInt("employee_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				String phone_number = rs.getString("phone_number");
				Date hire_date = rs.getDate("hire_date");
				String job_id = rs.getString("job_id");
				int salary = rs.getInt("salary");
				double commission_pct = rs.getDouble("commission_pct");
				int manager_id = rs.getInt("manager_id");
				int department_id = rs.getInt("department_id");

				EmpVO emp = new EmpVO(employee_id, first_name, last_name, email, phone_number, hire_date, job_id,
						salary, commission_pct, manager_id, department_id);
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emplist;
	}

	public int insertEmp(EmpVO emp) {
		Connection conn = null;
		PreparedStatement st = null;
		int count = 0;
		String sql = "insert into employees " + " values(?,?,?,?,null,?,?,?,null,null,?)";
		try {
			conn = ds.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, emp.getEmployee_id());
			st.setString(2, emp.getFirst_name());
			st.setString(3, emp.getLast_name());
			st.setString(4, emp.getEmail());
			st.setDate(5, emp.getHire_date());
			st.setString(6, emp.getJob_id());
			st.setInt(7, emp.getSalary());
			st.setInt(8, emp.getDepartment_id());
			count = st.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	public int updateEmp(EmpVO emp) {
		Connection conn = null;
		PreparedStatement st = null;
		int count = 0;
		String sql = "update employees " + "set first_name = ?, email=? " + " where employee_id = ?";
		try {
			conn = ds.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, emp.getFirst_name());
			st.setString(2, emp.getEmail());
			st.setInt(3, emp.getEmployee_id());
			count = st.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	public int deleteEmp(int empid) {
		Connection conn = null;
		PreparedStatement st = null;
		int result = 0;
		String sql = "delete from employees " + " where employee_id =?";
		try {
			conn = ds.getConnection();
			st = conn.prepareStatement(sql);
			// 臾쇱쓬�몴�쓽 �닚�꽌(2 踰덉㎏ 臾쇱쓬�몴)
			st.setInt(1, empid);
			result = st.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
