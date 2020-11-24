package com.liuqn.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import com.alibaba.fastjson.JSON;
import com.liuqn.pojo.Customer;
import com.liuqn.pojo.Manager;
import com.liuqn.service.CustomerService;
import com.liuqn.serviceImp.CustomerServiceImp;

@WebServlet("/CustomerDataController")
public class CustomerDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CustomerDataController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String method = requestURI.substring(5, requestURI.length()-4);
		System.out.println(method);
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
    
	CustomerService customerService = new CustomerServiceImp();
	private void queryPageC(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/javascript;charset=UTF-8");
		StringBuffer url = request.getRequestURL();
		System.out.println(url);
		String str1 = request.getParameter("taken");
		String sss = request.getParameter("famd");
		System.out.println("fadfkafh"+"=="+str1+" "+sss);
		
		Map<String, String[]> ss = request.getParameterMap();
		ss.forEach((k,v) ->{System.out.println(k+"=="+v[0]);});
		
		
		String userid = request.getHeader("userid");
		System.out.println(userid);
		String page = request.getParameter("page");
		String limit = request.getParameter("limit");
		Map<String, Object> map = customerService.queryPageCustomer(Integer.parseInt(page), Integer.parseInt(limit));
		response.getWriter().write(JSON.toJSONString(map));
	}
	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = new Customer();
		try {
			// 字符串日期转换格式
			/*ConvertUtils.register(new Converter() {
	            public Object convert(Class type, Object value) {
	                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	                try {
	                    return simpleDateFormat.parse(value.toString());
	                } catch (ParseException e) {
	                    e.printStackTrace();
	                }
	                return null;
	            }
	        }, Date.class);*/
			BeanUtils.populate(customer, request.getParameterMap());
			customer.setCreateDate(new Date());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		Map<String, Object> map = customerService.addCustomer(customer);
		response.getWriter().write(JSON.toJSONString(map));
	}
	private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1、实例一个对象
		Customer customer = new Customer();
		try {
			// 2、request返回一个map,自动填充值
			BeanUtils.populate(customer, request.getParameterMap());
			customer.setCreateDate(new Date());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		Map<String, Object> map = customerService.updateCustomer(customer);
		response.getWriter().write(JSON.toJSONString(map));
	}
	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String managerID = request.getParameter("customerID");
	    Map<String, Object> map = customerService.deleteCustomer(Integer.parseInt(managerID));
		response.getWriter().write(JSON.toJSONString(map));
	}
	private void queryByIDC(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String managerID = request.getParameter("customerID");
		Map<String, Object> map = customerService.queryByIDCustomer(Integer.parseInt(managerID));
		response.getWriter().write(JSON.toJSONString(map));
	}
}
