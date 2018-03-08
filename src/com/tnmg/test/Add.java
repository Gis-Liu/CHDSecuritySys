package com.tnmg.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Add extends HttpServlet {
	public void init(){
		
	}
	
	public void destroy(){
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		Staff newstaff = new Staff(request);
		StaffDAO std = new StaffDAOImpl();
		std.addStaff(newstaff);
		try {
			PrintWriter out = response.getWriter();
			out.println("{statu: 0,message:'success'}");
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
