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

import com.fine.exception.InvalidOIDException;
import com.fine.service.UserService;
import com.fine.service.impl.UserServiceImpl;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/changePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer oID= (Integer) session.getAttribute("oid");
		System.out.println(oID);
		
		PrintWriter out = response.getWriter();
		
		String newPassword = request.getParameter("newpassword");
		System.out.println(newPassword);
		UserService userService = new UserServiceImpl();
		try {
			boolean passwordChanged = userService.changePassword(oID, newPassword);
			System.out.println(passwordChanged);
			if(!passwordChanged) {
				 out.println("<script type=\"text/javascript\">");
				   out.println("alert('Please sign in');");
				   out.println("</script>");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		} catch (InvalidOIDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
