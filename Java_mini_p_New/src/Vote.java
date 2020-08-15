

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
 * Servlet implementation class Vote
 */
@WebServlet("/Vote")
public class Vote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String Voter_ID = request.getParameter("Voter_ID");
		String Vote = request.getParameter("Vote");
		
		

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
	    		  String sql = "INSERT INTO election_data (Voter_ID,  Vote) VALUES (?, ?)";
		    	  PreparedStatement statement = conn.prepareStatement( sql);
		    	  statement.setInt( 1, Integer.parseInt(Voter_ID));
		   		  statement.setInt( 2, Integer.parseInt(Vote));
		   		  
		    	  int rowsInserted =  statement.executeUpdate();
		    	  if (rowsInserted > 0) {
		    		  writer.println("successfull  !!");
		    					  
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
