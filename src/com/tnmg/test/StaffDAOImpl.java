package com.tnmg.test;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDAOImpl implements StaffDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public void addStaff(Staff staff) {
		String sql = "insert into staff (name,department,sex,tel)values(?,?,?,?)";
		try {
			conn = DBUtil.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, staff.getName());
			pstmt.setString(2, staff.getDepartment());
			pstmt.setString(3, staff.getSex());
			pstmt.setString(4, staff.getTel());
			pstmt.execute();
		} catch (SQLException e) {		
			e.printStackTrace();
		}
	}

	@Override
	public void deleteStaff(int id) {
		String sql ="delete from staff where idstaff = " + id;
		conn = DBUtil.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Staff> getAllStaff() {
		String sql = "select * from staff";
		Connection conn =null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		List<Staff> staffs = new ArrayList<Staff>();
		
		try {
			conn = DBUtil.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int idstaff = rs.getInt("idstaff");
				String name = rs.getString("name");
				String department = rs.getString("department");
				String sex = rs.getString("sex");
				String tel = rs.getString("tel");
				Staff staff = new Staff(idstaff,name,department,sex,tel);
				staffs.add(staff);	
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DBUtil.closeDb(rs, pstmt, conn);
		}
		return staffs;
	}

	@Override
	public Staff getStaffById(int id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void UpdateStaff(Staff staff) {
		String sql = "update staff set name=?,department=?,sex=?,tel=? where idstaff=?";
		
		try {	
			conn = DBUtil.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, staff.getName());
			pstmt.setString(2, staff.getDepartment());
			pstmt.setString(3,staff.getSex());
			pstmt.setString(4,staff.getTel());
			pstmt.setInt(5, staff.getIdstaff());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeDb(rs, pstmt, conn);
		}
		
	}

}
