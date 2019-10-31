package com.fine.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fine.bean.User;
import com.fine.exception.InvalidOIDException;
import com.fine.service.UserService;
import com.fine.service.impl.UserServiceImpl;

/**@author dashok
 * 
 * Servlet implementation class NewUserServlet
 */
@WebServlet("/newUserServlet")
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int oID = Integer.parseInt(request.getParameter("newoid"));
		String password = request.getParameter("defpass");
		String name = request.getParameter("userName");
		
		PrintWriter out = response.getWriter();
		
		User user = new User();
		user.setName(name);
		user.setoID(oID);
		user.setPassword(password);
		
		UserService userService = new UserServiceImpl();
		boolean newUser;
		try {
			newUser = userService.addUser(user);
		} catch (InvalidOIDException e) {
			newUser = false;
			e.printStackTrace();
		}
		request.setAttribute("userDetails", user);
		if(newUser) {
		/*	RequestDispatcher rd = request.getRequestDispatcher("changePassword.jsp");
			rd.forward(request, response);*/
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("oid", oID );
			out.println("<script> window.close()</script>");
			out.println("<script>window.open(\"changePassword.jsp\")</script>");
			
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("signupFail.jsp");
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
