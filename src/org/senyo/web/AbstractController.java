package org.senyo.web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.senyo.anno.RequestMapping;

/**
 * Servlet implementation class AbstractController
 */
public abstract class AbstractController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String PRE = "/WEB-INF";
	private static final String APP = ".jsp"; 
	
    /**
     * Default constructor. 
     */
	
    public AbstractController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 아무것도 안 하고
		System.out.println("AbstractController called...");
		
		
		String path = request.getRequestURI();
		String contextName = request.getContextPath();
		
		String callMethod = request.getMethod();
		String uri = request.getPathInfo();
		
		String wantedPath = path.substring(contextName.length());
		
		
//		System.out.println("URI : " + uri2);
		
		String jspPath = PRE;
		
		
		try {
			
			Class clz = this.getClass();  // 상속받은 hello controller가 this가 된다.
			
			Method[] methods = clz.getDeclaredMethods();	// 그들의 메소드 다 따온다. 메소드에 있는 annotation 파악 위해.
			
			for (Method method : methods) {
				
				RequestMapping mapping = method.getAnnotation(RequestMapping.class);
				
				if(mapping == null){ continue; }
				
//				System.out.println(mapping.value()); // /hi
//				System.out.println(mapping.method()); 
			
				if(uri.equals(mapping.value())
						&&
					callMethod.equals(mapping.method())) {
					
					Object obj = method.invoke(this, request, response); // 메소드 호출하면 어떤 애인지 모르지만 나온다. 지금은( void or String )
					
					if(obj == null){
						System.out.println("return type is void");
						jspPath += wantedPath + APP;
					} else {
						wantedPath = wantedPath.substring(0, wantedPath.lastIndexOf("/"));
						System.out.println("return type is String");
						
						jspPath += wantedPath + "/" + (String)(obj) + APP;
					}
					
					System.out.println(jspPath);
					
					request.getRequestDispatcher(jspPath);
					
					
					break;
				}
			}
			
		}catch (Exception e){
			
		}
		
		/*
		얘를 상속받은 controller들은 service를 그대로 가져온다
		그들의 value 및 method를 파악하고
		내가 원하는 애들만 실행시킨다
		
		uri2 == map.value  && callMethod == mapping.method   같으면
		그냥 호출 시켜버려 꺄햫
		
		
		이 구조 모르면 Spring 이해할 수 없어.
		
		annotation의 장점은 interface 따라갈 필요 없어.
		
		
		
		
		
		
		*/
	}

}
