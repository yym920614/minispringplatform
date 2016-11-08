package org.senyo.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.senyo.anno.RequestMapping;

@WebServlet("/member/*")
public class MemberController extends AbstractController{

	
	// annotation은 인터페이스보다 자유로워.
	// 리턴 타입 막 할거야. 내가 무너트린다.
	@RequestMapping("/register")
	public void register(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("member register called...");
	}
	
	
	
}
