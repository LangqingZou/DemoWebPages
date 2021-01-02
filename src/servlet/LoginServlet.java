package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connect.DBConnect;
import connect.PersonConn;


@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		doPost(request, response);
	}
	
	@Override
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
