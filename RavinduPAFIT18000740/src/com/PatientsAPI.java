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

/**
 * Servlet implementation class PatientsAPI
 */
@WebServlet("/PatientsAPI")
public class PatientsAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientsAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

    Patient patientObj =  new Patient();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String username = request.getParameter("patientUsername");
				 
			String password = request.getParameter("patientPassword");
				
			String name = request.getParameter("patientName");
			
			String contact = request.getParameter("patientContact");
				
			String address = request.getParameter("patientAddress");
				
			String email = request.getParameter("patientEmail");
		
	//		System.out.println(username + "\n" + password+ "\n" +name+ "\n" +contact+ "\n" +address+ "\n" +email);
			
			String output = patientObj.insertItem(username, password, name, contact, address, email);
			response.getWriter().write(output); 
	}

	// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request)
	{
	 
		Map<String, String> map = new HashMap<String, String>();
	
		try
	 
		{
	 
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
	 
			String queryString = scanner.hasNext() ?
	 
					scanner.useDelimiter("\\A").next() : "";
	
					scanner.close();
	
					String[] params = queryString.split("&");
	 
					for (String param : params)
	 
					{
					
						String[] p = param.split("=");
						
						map.put(p[0], p[1]);
						
					}
					
		}
		
		catch (Exception e)
		{
		
		}
		
		return map;
		
	}
					
	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map paras = getParasMap(request);
		
		System.out.println(paras.get("hidPatientIDSave").toString() + "come on");
		
		String output = patientObj.updateItem(paras.get("hidPatientIDSave").toString(),
		
				paras.get("patientUsername").toString(),
		 
				paras.get("patientPassword").toString(),
		
				paras.get("patientName").toString(),
		
				paras.get("patientAddress").toString(),
				
				paras.get("patientContact").toString(),
				
				paras.get("patientEmail").toString());
		
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		Map paras = getParasMap(request);
		
		System.out.println(paras.get("patientID").toString());
		
		String output = patientObj.deleteItem(paras.get("patientID").toString());
		
		response.getWriter().write(output); 
	}

}
