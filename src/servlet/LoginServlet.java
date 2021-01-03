package servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connect.DBConnect;
import connect.PersonConn;

/**
 * The LoginServlet program receives and processes the data from the login.jsp front end.
 * 
 * @author: Langqing Zou
 * @version: V1.0
 * @since: 2021-01-2
 **/

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
	@Override
	/**
	 * This function receives the request information of HTTP.
	 * @param request Request from HTTP
	 * @param response Response to HTTP
	 * @return Nothing.
	 **/
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		doPost(request, response);
	}
	
	@Override
	/**
	 * This function receives the request to HTTP to obtain the infomation.
	 * @param request Request from HTTP
	 * @param response Response to HTTP
	 * @return Nothing.
	 **/
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		DBConnect db = new DBConnect();
		PersonConn pc = new PersonConn(db);
		
		if(pc.getPassword(email).equals(password)) {
			session.setAttribute("InfoAlert","true");
			response.sendRedirect("Menu.jsp");
			return;
		}
		System.out.println("Login failed.");
		session.setAttribute("InfoAlert","false");
		response.sendRedirect("Login.jsp");
		return;
		
		
	}
}
