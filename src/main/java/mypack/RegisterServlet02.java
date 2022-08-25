package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet02 extends HttpServlet {
	   
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}


	public void destroy() {
		System.out.println("destroy");
	}

	
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	   String name =  request.getParameter("name");
	   String mobile =  request.getParameter("mobile");
       String email =  request.getParameter("textemail");  //filed ka logial name jo hamre login form me hai
       String password = request.getParameter("testpass");
        
        PrintWriter  printWriter= response.getWriter();
        printWriter.print(email+"  "+password+"  "+name+"  "+mobile);
        
        try 
        {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Root");
        	PreparedStatement  preparedStatement =  con.prepareStatement("insert into spt values(?,?,?,?)");
        	
        	preparedStatement.setString(1, name);
        	preparedStatement.setString(2, email);
        	preparedStatement.setString(3, mobile);
        	preparedStatement.setString(4, password);
        	int i =preparedStatement.executeUpdate();
        	
        	if(i>0)
        	
        		printWriter.print("user register");
        	else
        	  printWriter.print("user not register");
        		
        	
        	
		} catch (Exception e)
        {
			   
			   e.printStackTrace();
			
			
		}
        
        
        
	}

}












