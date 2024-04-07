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


@WebServlet("check1")
public class check1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
     PreparedStatement pstmt=null;
	 Connection conn=null;
	 RequestDispatcher dispatcher = null;
	 try {
		 response.setContentType("text/html");
		 Class.forName("com.mysql.cj.jdbc.Driver");
		  conn=DriverManager.getConnection("jdbc:mysql://localhost/Airport_Security","root","sakshi123");
		
		   pstmt = conn.prepareStatement("call check_passenger_blacklist();");
		   ResultSet rs=pstmt.executeQuery();
		  
		   PrintWriter out=response.getWriter();
		   out.println("<html><body><table><tr><td>Passenger_Found</td></tr>");
		   while(rs.next()) {
			   out.println("<tr><td>"+rs.getString(1)+"</td></tr>");
		   }
		
       out.println("</table></body></html>");
       
       
		  

		 

		 

			  
					
				 
				 
				
				
			
			
		  
		 
		
	 }catch (Exception e) {
		 e.printStackTrace();
	 }
	}

}


