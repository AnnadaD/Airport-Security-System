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
@WebServlet("/insertflightdetails")
public class insertflightdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 String FlightNo=request.getParameter("FlightNo");
	 String DOF=request.getParameter("DOF");
	 String Depart_time=request.getParameter("Depart_time");
	 String Arrival_time=request.getParameter("Arrival_time");
	 String Depart_gate=request.getParameter("Depart_gate");
	 String Current_status=request.getParameter("Current_status");
	 String Baggage_belt=request.getParameter("Baggage_belt");
	 
	 PreparedStatement pstmt=null;
	 Connection conn=null;
	 RequestDispatcher dispatcher = null;
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		  conn=DriverManager.getConnection("jdbc:mysql://localhost/Airport_Security","root","sakshi123");
		
		  
			  pstmt=conn.prepareStatement("insert into flights(FlightNo,DOF,Depart_time,Arrival_time,Depart_gate,Current_status,Baggage_belt) values(?,?,?,?,?,?,?) ");
				 pstmt.setString(1, FlightNo);
				 pstmt.setString(2, DOF);
				 pstmt.setString(3, Depart_time);
				 pstmt.setString(4, Arrival_time);
				 pstmt.setString(5, Depart_gate);
				 pstmt.setString(6, Current_status);
				 pstmt.setString(7, Baggage_belt);

				 
				 
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


