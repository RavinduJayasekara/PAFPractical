package com;

import java.sql.*;

public class Patient {

	
	private Connection connect()
	{
	
		Connection con = null;
	 
		try
	 
		{
	 
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
	 
		}
	 
		catch (Exception e)
	 
		{
	 
			e.printStackTrace();
	 
		}
	 
		return con;
	 
	}
	
	public String patientLogin(String username,String password) {
		
		String output = "";
		
		try
		 
		{
	 
			Connection con = connect();
	 
			if (con == null)
	 
			{
				
				return "Error while connecting to the database for reading.";
	 
			}
	 
			// Prepare the html table to be displayed
	 
			output = "<table border='1'><tr><th>Patient Userame</th> <th>Patient Password</th><th>Patient Name</th> <th>Patient Address</th><th>Patient Contact</th>" + "<th>Patient Email</th> <th>Update</th><th>Remove</th></tr>";
	 
			String query = "select * from patient";
	 
	 
			Statement stmt = con.createStatement();
	 
	 
			ResultSet rs = stmt.executeQuery(query);
	 
	 
			// iterate through the rows in the result set
	 
	 
			while (rs.next())
	 
	 
			{
				
				String pusername = rs.getString("patientUsername");
				
				String ppassword = rs.getString("patientPassword");
			
				if(username.equals(pusername) && password.equals(ppassword) && username.equals("admin") && password.equals("admin")) {
					output = "admin";
				}
				else if(username.equals(pusername) && password.equals(ppassword)) {
					output = "normal";
				}
			}
			
			con.close();
			
			
			return output;
			
	}catch(Exception e) {
		e.printStackTrace();
		return output = "error";

	}
	}
	public String readItems()
	 
	{
	 
		String output = "";
	 
		try
	 
		{
	 
			Connection con = connect();
	 
			if (con == null)
	 
			{
				
				return "Error while connecting to the database for reading.";
	 
			}
	 
			// Prepare the html table to be displayed
	 
			output = "<table border='1'><tr><th>Patient Userame</th> <th>Patient Password</th><th>Patient Name</th> <th>Patient Address</th><th>Patient Contact</th>" + "<th>Patient Email</th> <th>Update</th><th>Remove</th></tr>";
	 
			String query = "select * from patient";
	 
	 
			Statement stmt = con.createStatement();
	 
	 
			ResultSet rs = stmt.executeQuery(query);
	 
	 
			// iterate through the rows in the result set
	 
	 
			while (rs.next())
	 
	 
			{
	 
		 
				String patientID = Integer.toString(rs.getInt("patientID"));
	 
		 
				String patientUsername = rs.getString("patientUsername");
	 
		 
				String patientPassword = rs.getString("patientPassword");
	 
		 
				String patientContact = Integer.toString(rs.getInt("patientContact"));
				
				
				String patientName = rs.getString("patientName");
				
				String patientEmail = rs.getString("patientEmail");
				
				String patientAddress = rs.getString("patientAddress");
	 
				// Add into the html table
	 
		 
				output += "<tr><td><input id='hidPatientIDUpdate' name='hidPatientIDUpdate' type='hidden' value='" + patientID + "'>" + patientUsername + "</td>";

		 
				output += "<td>" + patientPassword + "</td>";

		 
				output += "<td>" + patientName + "</td>";
	 
		 
				output += "<td>" + patientAddress + "</td>";
	 
				output += "<td>" + patientContact + "</td>";
				
				output += "<td>" + patientEmail + "</td>";
				// buttons
	
		 
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>" + "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-itemid='" + patientID + "'>" + "</td></tr>";
	 
	 
			}
	 
	 
			con.close();
	 
	 
			// Complete the html table
	 
	 
			output += "</table>";
	 
	 
		}
	 
	 
		catch (Exception e)
	 
	 
		{
	 
		 
			output = "Error while reading the items.";
	 
			e.printStackTrace();
	 
	 
		}
	 
	 
		return output;
	 
	 
	}

	
	public String insertItem(String username, String password, String name, String contact, String address,String email)
	{
			 
		String output = "";
			 
		try
			 
		{
			 
			Connection con = connect();
			 
			if (con == null)
			 
			{
			
				return "Error while connecting to the database for inserting.";
			
			}
			
			// create a prepared statement
			 
			String query = "insert into patient(patientUserName,patientPassword,patientName,patientContact,patientAddress,patientEmail) values (?, ?, ?, ?, ?, ?)";
			 
			PreparedStatement preparedStmt = con.prepareStatement(query);
			 
			// binding values
			
			preparedStmt.setString(1, username);
			 
			preparedStmt.setString(2, password);
			
			preparedStmt.setString(3, name);
			
			preparedStmt.setInt(4, Integer.parseInt(contact));
			
			preparedStmt.setString(5, address);
			
			preparedStmt.setString(6, email);
			 
			// execute the statement
			 
			preparedStmt.execute();
			
			con.close();
			
			String newPatients = readItems();
			
			output = "{\"status\":\"success\", \"data\": \"" + newPatients + "\"}";
			 
		}
			
		catch (Exception e)
			 
		{
			 
			output = "{\"status\":\"error\", \"data\": \"Error while inserting the patient details.\"}";
			 
			System.err.println(e.getMessage());
			 
		}
			 
		return output;
			 
	}
	
	public String updateItem(String ID, String username, String password, String name, String address, String contact, String email)
	{
			 
		String output = "";
			 
		try
			 
		{
			 System.out.println(1);
			Connection con = connect();
			System.out.println(2);
			if (con == null)
			 
			{
			 
				return "Error while connecting to the database for updating.";
			 
			}
			System.out.println(3);
			// create a prepared statement
			System.out.println(1);
			String query = "UPDATE patient SET patientUsername=?,patientPassword=?,patientName=?,patientAddress=?patientContact=?,patientEmail=? WHERE patientID=?";
			 
							
			PreparedStatement preparedStmt = con.prepareStatement(query);
			 
			// binding values
			 
			preparedStmt.setString(1, username);
			 
			preparedStmt.setString(2, password);
			 
			preparedStmt.setString(3, name);
			
			preparedStmt.setString(4, address);
			
			preparedStmt.setInt(5, Integer.parseInt(contact));
			
			preparedStmt.setString(6, email);
			
			preparedStmt.setInt(7, Integer.parseInt(ID));
			
			// execute the statement
			
			preparedStmt.execute();
			
			con.close();
			
			String newPatientDetails = readItems();
			
			output = "{\"status\":\"success\", \"data\": \"" + newPatientDetails + "\"}";
			 
		}
		
		catch (Exception e)
		
		{
		
			output = "{\"status\":\"error\", \"data\": \"Error while updating the patient.\"}";
			 
			System.err.println(e.getMessage());
			e.printStackTrace();
			
		}
		
		return output;
		
	}
	
	
	public String deleteItem(String patientID)
	
	{
	
		String output = "";
	 
		try
	 
		{
	 
			Connection con = connect();
	 
			if (con == null)
	 
			{
	 
				return "Error while connecting to the database for deleting.";
	 
			}
	
			// create a prepared statement
	 
			String query = "delete from patient where patientID=?";
	 
			PreparedStatement preparedStmt = con.prepareStatement(query);
	 
			// binding values
	 
			preparedStmt.setInt(1, Integer.parseInt(patientID));
	 
			// execute the statement
	 
			preparedStmt.execute();
	 
			con.close();
	 
			String currentPatients = readItems();
	 
			output = "{\"status\":\"success\", \"data\": \"" + currentPatients + "\"}";
	 
		}
	 
		catch (Exception e)
	 
		{
	 
			output = "{\"status\":\"error\", \"data\": \"Error while deleting the patient.\"}";
	 
	
			System.err.println(e.getMessage());
	 
		}
	 
		return output;
	 
	} 

}
