package org.senyo.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.senyo.anno.RequestMapping;

/**
 * Servlet implementation class HelloController
 */

@WebServlet("/hello/*")
public class HelloController extends AbstractController {
	
	private static final long serialVersionUID = 1L;
       
	@RequestMapping("/hi")
	public void hi(HttpServletRequest request, HttpServletResponse response){
		System.out.println("Hello Controller hi~! called");
	}
	@RequestMapping("/bye")
	public String bye(HttpServletRequest request, HttpServletResponse response){
		System.out.println("Hello Controller bye~! called");
		
		return "bye";
		
	}

}
