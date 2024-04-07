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


@WebServlet("/countDomInter")
public class countDomInter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
     PreparedStatement pstmt=null;
	 Connection conn=null;
	 RequestDispatcher dispatcher = null;
	 try {
		 response.setContentType("text/html");
		 Class.forName("com.mysql.cj.jdbc.Driver");
		  conn=DriverManager.getConnection("jdbc:mysql://localhost/Airport_Security","root","sakshi123");
		
		   pstmt = conn.prepareStatement("select Dom_Inter, count(*) as No_of_Employees from Employees group by Dom_Inter;");
		   ResultSet rs=pstmt.executeQuery();
		  
		   PrintWriter out=response.getWriter();
		   out.println("<html><body><table><tr><td>Dom_Inter</td><td>No_of_Employees</td></tr>");
		   while(rs.next()) {
			   out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td></tr>");
		   }
		
       out.println("</table></body></html>");
       
       
		  

		 

		 

			  
					
				 
				 
				
				
			
			
		  
		 
		
	 }catch (Exception e) {
		 e.printStackTrace();
	 }
	}

}