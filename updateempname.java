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

/**
 * Servlet implementation class registrationservlet
 */
@WebServlet("/updateempname")
public class updateempname extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 String EID=request.getParameter("EID");
	 String EName=request.getParameter("EName");
	 
	 PreparedStatement pstmt=null;
	 Connection conn=null;
	 RequestDispatcher dispatcher = null;
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		  conn=DriverManager.getConnection("jdbc:mysql://localhost/Airport_Security","root","sakshi123");
		
		  
			  pstmt=conn.prepareStatement("UPDATE  Employees SET EName=? WHERE EID=?");
				 pstmt.setString(1, EName);
				 pstmt.setString(2, EID);
				 
				 
				 int rowCount=pstmt.executeUpdate();
				 dispatcher =request.getRequestDispatcher("airport.html");
				 
				 if (rowCount > 0) {
					 request.setAttribute("status", "success");
					 System.out.println("updated successfully");
				

				 }else {
					 request.setAttribute("status", "failed");
				 }
				 
				 dispatcher.forward(request, response);
				
			
			
		  
		 
		
	 }catch (Exception e) {
		 e.printStackTrace();
	 }
	}

}


