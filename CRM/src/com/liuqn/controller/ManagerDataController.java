package com.liuqn.controller;

import java.io.IOException;
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

@WebServlet("/ManagerDataController")
public class ManagerDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManagerDataController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String method = requestURI.substring(5, requestURI.length()-4);
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
	private void queryPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/javascript;charset=UTF-8");
		String page = request.getParameter("page");
		String limit = request.getParameter("limit");
		Map<String, Object> map = managerService.queryPageManager(Integer.parseInt(page), Integer.parseInt(limit));
		response.getWriter().write(JSON.toJSONString(map));
	}
	// 无用，跟注册相冲了
	private void addManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String managerName = request.getParameter("managerName");
		//String createDate = request.getParameter("createDate");
		String createPersonnel = request.getParameter("createPersonnel");
		String accessLevel = request.getParameter("accessLevel");
		Manager manager = new Manager(0,username,password,managerName,new Date(),createPersonnel,Integer.parseInt(accessLevel));
		Map<String, Object> map = managerService.addManager(manager);
		response.getWriter().write(JSON.toJSONString(map));
	}
	private void updateManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String managerID = request.getParameter("managerID");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String managerName = request.getParameter("managerName");
		//String createDate = request.getParameter("createDate");
		String createPersonnel = request.getParameter("createPersonnel");
		String accessLevel = request.getParameter("accessLevel");
		Manager manager = new Manager(Integer.parseInt(managerID),username,password,managerName,new Date(),createPersonnel,Integer.parseInt(accessLevel));
		Map<String, Object> map = managerService.updateManager(manager);
		response.getWriter().write(JSON.toJSONString(map));
	}
	private void deleteManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String managerID = request.getParameter("managerID");
	    Map<String, Object> map = managerService.deleteManager(Integer.parseInt(managerID));
		response.getWriter().write(JSON.toJSONString(map));
	}
	private void queryByID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String managerID = request.getParameter("managerID");
		Map<String, Object> map = managerService.queryByIDManager(Integer.parseInt(managerID));
		System.out.println(JSON.toJSONString(map));
		response.getWriter().write(JSON.toJSONString(map));
	}
}
