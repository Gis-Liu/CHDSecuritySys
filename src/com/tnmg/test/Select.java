package com.tnmg.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


public class Select extends HttpServlet {
	public void init() throws ServletException {
	}
	
	public void destroy(){
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		StaffDAO std = new StaffDAOImpl();
		List<Staff> stafflist = std.getAllStaff();
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			String json = gson.toJson(stafflist);
			out.print(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		doGet(request,response);
	}

}
