

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Insert_D
 */
@WebServlet("/Insert_D")
public class Insert_D extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert_D() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String VoterID = request.getParameter("Voter_ID");
		String V_Name = request.getParameter("V_Name");
		String Adhar_Id = request.getParameter("Adhar_Id");
		String Address = request.getParameter("Address");
		String  Sex = request.getParameter("Sex");
		String age = request.getParameter("age");
		
		
		
		
		
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
	    	  
	    	  
	   		  
		    	  String sql = "INSERT INTO voter_data (VoterID, V_Name, Adhar_Id,  Address, Sex,  age) VALUES (?, ?, ?, ?, ? , ?)";
		    	  PreparedStatement statement = conn.prepareStatement( sql);
		    	  statement.setInt( 1, Integer.parseInt(VoterID));
		   		  statement.setString( 2, V_Name);
		   		  statement.setInt( 3, Integer.parseInt(Adhar_Id));
		   		  statement.setString( 4, Address);
		   		  statement.setString( 5,  Sex);
		   		  statement.setInt( 6, Integer.parseInt(age));
		   		  
		    				  
		    	  int rowsInserted =  statement.executeUpdate();
		    	  if (rowsInserted > 0) {
		    		  writer.println("A new user's data  was inserted successfully  !!");
		    					  
		    	  }
		    	  else {
		    		  writer.println("FAIL!!");
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
