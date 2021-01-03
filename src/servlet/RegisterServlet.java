package servlet;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connect.DBConnect;
import connect.EmployeeConn;
import connect.GuestConn;
import connect.PersonConn;
import entities.Person;

/**
 * The RegisterServlet program receives and processes the data from the register.jsp front end.
 * 
 * @author: Langqing Zou
 * @version: V1.0
 * @since: 2021-01-2
 **/

@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet{

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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String firstname = request.getParameter("firstname");
		String lastname  = request.getParameter("lastname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String position = request.getParameter("position");
		String location = request.getParameter("location");
		String role = request.getParameter("role");
		// Establish connection
		DBConnect db = new DBConnect();
		
		HttpSession session = request.getSession();
		
		try {
			//Person created
			Person p = new Person();
			p.setFirstName(firstname);
			p.setLastName(lastname);
			p.setPhone(phone);
			p.setAddress(address);
			p.setEmail(email);
			p.setPassword(password);
			
			//PersonConn created
			PersonConn pc = new PersonConn(db);
			GuestConn gc = new GuestConn(db);
			EmployeeConn ec = new EmployeeConn(db);
			
			if(role.equals("emp")) {
				//check if email already exist in employee table
				System.out.println(!ec.checkEmail(p.getEmail()));
				if(!ec.checkEmail(p.getEmail())) {    // already exist in employee table
					System.out.println("Insert employee failed in register.");
					response.sendRedirect("Register.jsp");
					session.setAttribute("emailAlert","false");
					return;
				}else {   // not exist in employee table 
					// not exist in guest table (totally a new email)
					if(gc.checkEmail(email)) {
						System.out.println("Insert employee successfully in register.");
						pc.insertPerson(p);
						ec.insertEmployee(p.getEmail(), position, location);
						session.setAttribute("emailAlert","true");
						response.sendRedirect("Login.jsp");
						return;
					}else {
						//already exist in guest table (means exist in person table), but not in employee table
						System.out.println("Insert employee successfully in register.");
						ec.insertEmployee(p.getEmail(), position, location);
						session.setAttribute("emailAlert","true");
						response.sendRedirect("Login.jsp");
						return;
					}
				}
			}else {
				//role.equals("guest")
				//already exist in guest table
				if(!gc.insertGuest(p.getEmail())) {
					System.out.println("Insert guest failed in register.");
					response.sendRedirect("Register.jsp");
					session.setAttribute("emailAlert","false");
					return;
				}else {
					//not exist in guest table
					//not exist in employee table (totally a new email)
					if(ec.checkEmail(email)) {
						System.out.println("Insert guest successfully in register.");
						pc.insertPerson(p);
						ec.insertEmployee(p.getEmail(), position, location);
						session.setAttribute("emailAlert","true");
						response.sendRedirect("Login.jsp");
						return;
					}else {
						//already exist in employee table (means exist in person table), but not in guest table
						System.out.println("Insert guest successfully in register.");
						ec.insertEmployee(p.getEmail(), position, location);
						session.setAttribute("emailAlert","true");
						response.sendRedirect("Login.jsp");
						return;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.closeDB();
	}
}



















