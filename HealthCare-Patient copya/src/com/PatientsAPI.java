package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Patients;

/**
 * Servlet implementation class PatientsAPI
 */
@WebServlet("/PatientsAPI")
public class PatientsAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Patients patiObj = new Patients();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientsAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String output = patiObj.insertPatient(request.getParameter("pFname"), request.getParameter("pLname"),
				request.getParameter("pNIC"), request.getParameter("pAddress"),request.getParameter("pGender"),
				request.getParameter("pEmail"), request.getParameter("pAge"),request.getParameter("pPhone"), 
				request.getParameter("pAdmitted"));

				response.getWriter().write(output);
		//doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
