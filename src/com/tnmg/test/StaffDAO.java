package com.tnmg.test;

import java.util.List;

public interface StaffDAO {
	public void addStaff(Staff staff);
	public void deleteStaff(int id);
	public List<Staff> getAllStaff();
	public Staff getStaffById(int id);
	public void UpdateStaff(Staff staff);
}
