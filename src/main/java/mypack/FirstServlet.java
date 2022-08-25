package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	   
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

       String email =  request.getParameter("textemail");
        String pass = request.getParameter("textpas");
        
       PrintWriter  printWriter= response.getWriter();
        printWriter.print(email+" "+pass);
        
	}

}
