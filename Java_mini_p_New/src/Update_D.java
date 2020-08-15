

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
 * Servlet implementation class Update_D
 */
@WebServlet("/Update_D")
public class Update_D extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**s
     * @see HttpServlet#HttpServlet()
     */
    public Update_D() {
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
		String N_V_Name = request.getParameter("N_V_Name");
		String N_Adhar_Id = request.getParameter("N_Adhar_Id");
		String N_Address = request.getParameter("N_Address");
		String  N_Sex = request.getParameter("N_Sex");
		String N_age = request.getParameter("N_age");
		
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
	    	  
	    		  
	    		  String sql = "UPDATE voter_data SET V_Name = ? , Adhar_Id = ? ,  Address = ? , Sex = ? , age = ?  WHERE VoterID = ?";
	    		  PreparedStatement statement = conn.prepareStatement(sql);
	    		  statement.setString( 1, N_V_Name);
		   		  statement.setInt( 2, Integer.parseInt(N_Adhar_Id));
		   		  statement.setString( 3, N_Address);
		   		  statement.setString( 4, N_Sex);
		   		  statement.setInt( 5, Integer.parseInt(N_age));
		   		  statement.setInt( 6, Integer.parseInt(VoterID));
		   		  
					int rowsUpdated = statement.executeUpdate();
					if (rowsUpdated > 0) {
						writer.println("Record Updated successfully");
					}
					else {
						writer.println("Did not find voter ID  ");
					 
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
