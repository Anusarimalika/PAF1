package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
public class PatientsAPI extends HttpServlet 
{
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
		//Not Used
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String output = patiObj.insertPatient(request.getParameter("pFname"), 
				                               request.getParameter("pLname"), request.getParameter("pNIC"), 
				                               request.getParameter("pAddress"), request.getParameter("pGender"), 
				                               request.getParameter("pEmail"), request.getParameter("pAge"),
				                               request.getParameter("pPhone"), request.getParameter("pAdmitted"));

				response.getWriter().write(output);
				
	}
	// Convert request parameters to a Map
		private static Map getParasMap(HttpServletRequest request) {
			Map<String, String> map = new HashMap<String, String>();
			try {
				Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
				String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
				scanner.close();
				String[] params = queryString.split("&");
				for (String param : params) {

					String[] p = param.split("=");
					map.put(p[0], p[1]);
				}
			} catch (Exception e) {
			}
			return map;
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
