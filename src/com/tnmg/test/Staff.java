package com.tnmg.test;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

public class Staff {
	private int idstaff;
	private String name="";
	private String department ="";
	private String sex = "";
	private String tel = "";
	Staff(){}
	Staff(HttpServletRequest request){
		try{
			
		}catch(NumberFormatException e){
			
		}
		try {
			if(request.getParameter("idstaff") !=null ){
				idstaff = Integer.parseInt(request.getParameter("idstaff")) ;
			}
			
			tel = request.getParameter("tel");
			department = new String(request.getParameter("department").getBytes("ISO8859-1"),"utf-8");
			sex = new String(request.getParameter("sex").getBytes("ISO8859-1"),"utf-8");
			name = new String(request.getParameter("name").getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	
		
		
	}
	
	Staff(int idstaff, String name, String department, String sex,String tel){
		this.idstaff = idstaff;
		this.setName(name);
		this.setDepartment(department);
		this.setSex(sex);
		this.setTel(tel);
	}

	public int getIdstaff() {
		return idstaff;
	}

	public void setIdstaff(int idstaff) {
		this.idstaff = idstaff;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	

}
