package org.senyo.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.senyo.anno.RequestMapping;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@RequestMapping(value="/regist", method="POST")
	public String regPOST(HttpServletRequest request, HttpServletResponse response){
	   
	   return "success";
	}

}
