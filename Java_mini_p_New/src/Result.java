

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
 * Servlet implementation class Result
 */
@WebServlet("/Result")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Result() {
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
	    		  String q="Select * from election_data";
	    		  PreparedStatement smt = conn.prepareStatement( q);
 				
 				//to execute query
 				ResultSet rs=smt.executeQuery(q);
 				int M = 0 ;
 				int R = 0 ;
 				int S = 0 ;
 				int L = 0 ;
 				
 				
 				while(rs.next()) {
 					int V1 = rs.getInt(2);
 					
 				   if(V1 == 1 ) {
			        	  ++M;
			          }
			          else if (V1 == 2) {
			        	  ++R;
			          }
			          else if (V1 == 3) {
			        	  ++S;
			          }
			          else {
			        	  ++L;
			          }
			          
 					
 				}
 					int max = M;

    			    if (R > max)
    			        max = R;
    			    if (S > max)
    			        max = S;
    			    if (L > max)
    			        max = L;

    				System.out.println("--------------------------------------------------------");
    				if(max == R ) {  writer.println("<br><h1>Rahul Gandhi won by " + max + "!!!!!!! </h1>"); }
    				if(max == M ) {  writer.println("<br><h1>Modi won by"+ max + "!!!!!!! </h1>"); }
    				if(max == S) {  writer.println("<br><h1>Sachin Pilot won by   "+ max + "!!!!!!! </h1>"); }
    				if(max == L ) {  writer.println("<br><h1>Lalu Yaddav  won by "+ max + "!!!!!!! </h1>"); }
    				System.out.println("--------------------------------------------------------");
    				 
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
