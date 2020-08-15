

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Display_D
 */
@WebServlet("/Display_D")
public class Display_D extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display_D() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	
		
		PrintWriter writer = response.getWriter();
		String dbURL = "jdbc:mysql://localhost:3306/javaminp";
	      String username = "root";
	      String password = "Vaibhav@1257";
	      Connection conn = null;

	      
	      try {
	    	  conn = DriverManager.getConnection(dbURL , username ,password);
	    	  if(conn != null) {
	    		  System.out.println("Connected");
	    		  
	    	  } 
	    		  String q="Select * from voter_data";
	    		  PreparedStatement smt = conn.prepareStatement( q);
  				
  				//to execute query
  				ResultSet rs=smt.executeQuery(q);
  				
  			 
  				if(rs.next()){ 
  					 	
  					do{
  						 writer.println("<br><br>Name : " + rs.getString(2) + "<br><br> AdharNO : "+ rs.getInt(3) + "<br><br> Address: " + rs.getString(4) + "<br><br> Sex : " + rs.getString(5) + "<br><br> Age : " + rs.getInt(6) );
  						 writer.println("<br><br>--------------------------------------------------------------------------------------------------------<br><br>");
  					}while(rs.next());
  					
  					 
  				}
  				else{
  					System.out.println("Record Not Found...");
  				}
	    		  
	    		  
	    		  
	    	  }

	      catch(Exception e){ System.out.println(e);} 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
