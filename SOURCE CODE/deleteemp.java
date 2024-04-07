package projectdbms;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deleteemp")
public class deleteemp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String EID=request.getParameter("EID");
     PreparedStatement pstmt=null;
	 Connection conn=null;
	 RequestDispatcher dispatcher = null;
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		  conn=DriverManager.getConnection("jdbc:mysql://localhost/Airport_Security","root","sakshi123");
		
		  PreparedStatement pstmt1 = conn.prepareStatement("DELETE FROM OnBoard WHERE EID=?");
		  pstmt1.setString(1, EID);
		  pstmt1.executeUpdate();
		  
		  PreparedStatement pstmt2 = conn.prepareStatement("DELETE FROM EContact WHERE EID=?");
		  pstmt2.setString(1, EID);
		  pstmt2.executeUpdate();
		  
		  PreparedStatement pstmt3 = conn.prepareStatement("DELETE FROM Airport WHERE EID=?");
		  pstmt3.setString(1, EID);
		  pstmt3.executeUpdate();
		  
		  PreparedStatement pstmt4 = conn.prepareStatement("DELETE FROM Employees WHERE EID=?");
		  pstmt4.setString(1, EID);
		  pstmt4.executeUpdate();

		  

		 

		 

			  
					
				 
				 
				 int rowCount=pstmt1.executeUpdate();
				 dispatcher =request.getRequestDispatcher("airport.html");
				 
				 if (rowCount > 0) {
					 request.setAttribute("status", "success");
					 System.out.println("added successfully");
		

				 }else {
					 request.setAttribute("status", "failed");
				 }
				 
				 dispatcher.forward(request, response);
				
			
			
		  
		 
		
	 }catch (Exception e) {
		 e.printStackTrace();
	 }
	}

}


