package com.tnmg.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class DelStaff extends HttpServlet {
	public void init(){
		
	}
	
	public void destroy(){
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		StaffDAO std = new StaffDAOImpl();
		int idstaff = Integer.parseInt(request.getParameter("idstaff"));
		std.deleteStaff(idstaff);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		StaffDAO std = new StaffDAOImpl();
		int idstaff = Integer.parseInt(request.getParameter("idstaff"));
		std.deleteStaff(idstaff);
		try {
			System.out.println("delete done");
			PrintWriter out = response.getWriter();
			Map<String,String> res= new HashMap<String,String>();
			res.put("statu", "0");
			res.put("msg", "delete success");
			Gson gson = new Gson();
			out.println(gson.toJson(res));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
