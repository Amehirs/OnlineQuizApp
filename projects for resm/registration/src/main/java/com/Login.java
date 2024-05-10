package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uemail = request.getParameter("username");
		String upwd = request.getParameter("password");
		HttpSession session = request.getSession();//creating session
		RequestDispatcher dispatcher = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?useSSl=false","root","Hema@sri18");
			PreparedStatement pst = con.prepareStatement("select * from users where uemail = ? and upwd = ?");
			//uemail and upwd should be same as database name
			//setting the value for uemail and upwd parameter it will check uemail and upwd provided is existed in the database or not
			pst.setString(1,uemail);
			pst.setString(2, upwd);
			
			ResultSet rs = pst.executeQuery();
			//rs.next means if the resultset has the data means if the next record is present mean user is existed in database this user is valid user
			//create session object because in index.jsp we set that attribute to session as name
			if(rs.next()) {
				
				session.setAttribute("name", rs.getString("uname"));
				dispatcher = request.getRequestDispatcher("index.jsp");
			}else {
				request.setAttribute("status","failed");
				dispatcher = request.getRequestDispatcher("login.jsp");
				
			}
			dispatcher.forward(request,response);
		}catch(Exception e) {
			e.printStackTrace();//
		}
	}

}
