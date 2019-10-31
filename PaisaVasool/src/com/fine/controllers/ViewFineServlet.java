package com.fine.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fine.bean.Employee;
import com.fine.exception.InvalidOIDException;
import com.fine.service.FineService;
import com.fine.service.impl.FineServiceImpl;

/**
 * Servlet implementation class ViewFineServlet
 */
@WebServlet("/viewFineServlet")
public class ViewFineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewFineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FineService fineService = new FineServiceImpl();
		System.out.println("VIEW FINE SEVLET REACHED");
		HttpSession session = request.getSession();
		int oID = (Integer) session.getAttribute("oid");
		Employee employee;
		/*try {
			double fineAdded = fineService.addFine(oID);
		} catch (InvalidOIDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//THE ABOVE ONLY COMES IN ADD FINE
		try {
			employee = fineService.viewFine(oID);
			request.setAttribute("employee", employee);
			System.out.println(employee);
		} catch (InvalidOIDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("viewFine.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
