package com.liuqn.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.liuqn.pojo.Manager;
import com.liuqn.service.ManagerService;
import com.liuqn.serviceImp.ManagerServiceImp;

@WebServlet("/ManagerServlet")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManagerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String method = requestURI.substring(20, requestURI.length());
		try {
			Method declaredMethod = this.getClass().getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			declaredMethod.invoke(this,request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	ManagerService managerService = new ManagerServiceImp();
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Manager manager = new Manager();
		manager.setUsername(username);
		manager.setPassword(password);
		boolean b = managerService.login(manager);
		Map<String,Object> map = new HashMap<String, Object>();
		PrintWriter writer = response.getWriter();
		if(b){
			String sessionID = request.getSession().getId();
			request.getSession().setAttribute("userid", sessionID);
			map.put("userid", sessionID);
			map.put("flag", "true");
			writer.write(JSON.toJSONString(map));
		}else{
			map.put("flag", "false");
			writer.write(JSON.toJSONString(map));
		}
	}
	
    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String managerName = request.getParameter("managerName");
		//String createDate = request.getParameter("createDate");
		String createPersonnel = request.getParameter("createPersonnel");
		String accessLevel = request.getParameter("accessLevel");
		Manager manager = new Manager(0,username,password,managerName,new Date(),createPersonnel,Integer.parseInt(accessLevel));
		boolean b = managerService.register(manager);
		Map<String,Object> map = new HashMap<String, Object>();
		PrintWriter writer = response.getWriter();
		if(b){
			map.put("flag", "true");
			writer.write(JSON.toJSONString(map));
		}else{
			map.put("flag", "false");
			writer.write(JSON.toJSONString(map));
		}
	}
}
