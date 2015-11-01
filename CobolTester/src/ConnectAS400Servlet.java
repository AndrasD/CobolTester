

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class ConnectAS400
 */

@WebServlet("/connect")
public class ConnectAS400Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConnectAS400Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
	    PrintWriter out = response.getWriter();
	    out.println("{");
	    
	    Connection conn = null;
	    try {
	    Class.forName("com.ibm.as400.access.AS400JDBCDriver").newInstance();
	        conn = DriverManager.getConnection( "jdbc:as400://192.168.41.23;database name=IBPDDB", "K698019", "liget13");
	        System.out.println("Connected to the database");
	    } catch (Exception e) {
	        System.out.println("error! 1");
	        e.printStackTrace();
	    }


	    try {
	        conn.close();
	        System.out.println("Disconnected from database");
	    } catch (Exception e) {
	        System.out.println("error! 2");
	        e.printStackTrace();
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
