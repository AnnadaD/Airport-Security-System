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
import java.sql.Time;
import java.time.LocalTime;

@WebServlet("/updateflighttime")
public class updateflighttime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 String FlightNo=request.getParameter("FlightNo");
	 String DOF=request.getParameter("DOF");
	 String Depart_time=request.getParameter("Depart_time");
	 String Arrival_time=request.getParameter("Arrival_time");
	 	
     PreparedStatement pstmt=null;
	 Connection conn=null;
	 RequestDispatcher dispatcher = null;
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		  conn=DriverManager.getConnection("jdbc:mysql://localhost/Airport_Security","root","sakshi123");
		
		  
			  pstmt=conn.prepareStatement("UPDATE Flights SET Depart_time=?,Arrival_Time=? WHERE FlightNo=? and DOF=?");
				 pstmt.setString(1, Depart_time);
				 pstmt.setString(2, Arrival_time);
			     pstmt.setString(3, FlightNo);
			     pstmt.setString(4, DOF);
					
				 
				 
				 int rowCount=pstmt.executeUpdate();
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


