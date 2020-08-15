

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
 * Servlet implementation class Delete_D
 */
@WebServlet("/Delete_D")
public class Delete_D extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete_D() {
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
	    		  String sql = "DELETE FROM voter_data WHERE  VoterID = ?";
	    		  PreparedStatement stmt = conn.prepareStatement(sql);
	    		  stmt.setInt( 1 , Integer.parseInt(VoterID));
	    		  
	    		  stmt.executeUpdate(sql);
	    	      writer.println("Record deleted successfully");
	    	      
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
