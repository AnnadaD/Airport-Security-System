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
@WebServlet("/insertpassengers")
public class insertpassengers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 String Aadhaar=request.getParameter("Aadhaar");
	 String Passport=request.getParameter("Passport");
	 String PName=request.getParameter("PName");
	 String PNRNo=request.getParameter("PNRNo");
	 
	 PreparedStatement pstmt=null;
	 Connection conn=null;
	 RequestDispatcher dispatcher = null;
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		  conn=DriverManager.getConnection("jdbc:mysql://localhost/Airport_Security","root","sakshi123");
		
		  
			  pstmt=conn.prepareStatement("insert into passengers(Aadhaar,Passport,PName,PNRNo) values(?,?,?,?) ");
				 pstmt.setString(1, Aadhaar);
				 pstmt.setString(2, Passport);
				 pstmt.setString(3, PName);
				 pstmt.setString(4, PNRNo);
				 
				 
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


