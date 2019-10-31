package com.fine.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fine.bean.User;
import com.fine.exception.InvalidOIDException;
import com.fine.service.FineService;
import com.fine.service.UserService;
import com.fine.service.impl.FineServiceImpl;
import com.fine.service.impl.UserServiceImpl;

/**@author dashok
 * 
 * Servlet implementation class LoginServlet
 * 
 * This servlet validates the login of the employee and redirects him to the appropriate page
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**@author dashok
     * 
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		Integer oID = Integer.parseInt(request.getParameter("oidtext"));
		String password = request.getParameter("password");
		
		user.setoID(oID);
		user.setPassword(password);
	
		UserService userService = new UserServiceImpl();
		boolean verified = userService.logInUser(user);
		if(verified) {
			/*Employee emp = userService.getEmployeeByID(oID);
			request.setAttribute("employee", emp);*/
			HttpSession session = request.getSession();
			session.setAttribute("oid", oID);
			
			user = userService.getUserByID(oID);
			String imageString = "file:///D:/DummyTomcat/apache-tomcat-8.0.35/apache-tomcat-8.0.35/tmpfiles/" + user.getImageName();
			session.setAttribute("username", user.getName() );
			session.setAttribute("image", imageString);
			FineService fineService = new FineServiceImpl();
			System.out.println("IMAGE STRING : " + imageString);
			try {
				fineService.addFine(oID);
			} catch (InvalidOIDException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("user", user);
			
			
			
			RequestDispatcher rd = request.getRequestDispatcher("successLogin.jsp");
			rd.forward(request, response);
			
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("failureLogin.jsp");
			rd.forward(request, response);
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
