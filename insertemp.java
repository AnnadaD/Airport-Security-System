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
@WebServlet("/insertemp")
public class insertemp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 String EID=request.getParameter("EID");
	 String EName=request.getParameter("EName");
	 String Job=request.getParameter("Job");
	 String DOJ=request.getParameter("DOJ");
	 String On_Off=request.getParameter("On_Off");
	 String Dom_Inter=request.getParameter("Dom_Inter");
	 
	 PreparedStatement pstmt=null;
	 Connection conn=null;
	 RequestDispatcher dispatcher = null;
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		  conn=DriverManager.getConnection("jdbc:mysql://localhost/Airport_Security","root","sakshi123");
		
		  
			  pstmt=conn.prepareStatement("insert into Employees(EID,EName,Job,DOJ,On_Off,Dom_Inter) values(?,?,?,?,?,?) ");
				 pstmt.setString(1, EID);
				 pstmt.setString(2, EName);
				 pstmt.setString(3, Job);
				 pstmt.setString(4, DOJ);
				 pstmt.setString(5, On_Off);
				 pstmt.setString(6, Dom_Inter);

				 
				 
				 int rowCount=pstmt.executeUpdate();
				 dispatcher =request.getRequestDispatcher("airport.html");
				 
				 if (rowCount > 0) {
					 request.setAttribute("status", "success");
					 System.out.println("added successfully");
				//	 response.sendRedirect(request.getContextPath() + "/onboard.html?success=true");

				 }else {
					 request.setAttribute("status", "failed");
				 }
				 
				 dispatcher.forward(request, response);
				
			
			
		  
		 
		
	 }catch (Exception e) {
		 e.printStackTrace();
	 }
	}

}


