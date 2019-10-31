package com.fine.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fine.exception.InvalidOIDException;
import com.fine.service.FineService;
import com.fine.service.impl.FineServiceImpl;

/**
 * Servlet implementation class EditFine
 */
@WebServlet("/editFine")
public class EditFine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditFine() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int oid=Integer.parseInt(request.getParameter("oid"));
		int fine=Integer.parseInt(request.getParameter("fine"));
		FineService fin=new FineServiceImpl();
		boolean flag=false;
		try {
			flag=fin.editFine(oid, fine);
		} catch (InvalidOIDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag){
			RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
			rd.forward(request,response);
			
		}
		else
			response.sendRedirect("admin.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
