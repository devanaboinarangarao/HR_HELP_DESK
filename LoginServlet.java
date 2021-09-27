package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;
import model.Model;
import dao.Dao;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailid=request.getParameter("emailid");
		String password=request.getParameter("pass");
		String page="";
		String sql="select * from employee where email='"+emailid+"'and password='"+password+"'";
		String sql2="select * from hr where emailid='"+emailid+"'and password='"+password+"'";
		HttpSession session=request.getSession();
		session.setMaxInactiveInterval(100*60);
		int i=0;
		if(emailid.equals("")||password.equals(""))
		{
			page="/login.jsp?msg=abc";
		}
		else
		{
			
			Model m=new Model();
			String hrheademail=m.getHrheademail();
			String hrheadpass=m.getHrheadpassword();
			if(emailid.equals(hrheademail)&&password.equals(hrheadpass))
			{
				i=1;
				session.setAttribute("email", emailid);
				session.setAttribute("password", password);
				session.setAttribute("user", "hrhead");
				page="/Home.jsp?msg=login";
			}
			else
			{
			
				ResultSet rs=	Dao.validate(m,sql);
				try 
				{
						if(rs.next())
						{
							
							m.setEmpEmail(emailid);
							m.setPass(password);
							i=1;
							session.setAttribute("email", emailid);
							session.setAttribute("password", password);
							session.setAttribute("login", true);
							session.setAttribute("user","employee");
							
							page="/Home.jsp?msg=login";
						}
						else
						{
							ResultSet rs2=	Dao.validate(m,sql2);
								if(rs2.next())
								{
									m.setHrEmail(emailid);
									m.setPass(password);
									i=1;
									session.setAttribute("email", emailid);
									session.setAttribute("password", password);
									session.setAttribute("login", true);
									session.setAttribute("user","hr");
									
									page="/Home.jsp?msg=login";
								}
						}
				}
				catch(Exception e)
				{
					
				}
			}
			if(i==0)
			{
				page="/login.jsp?msg=asd";
			}
		}
		
		getServletContext().getRequestDispatcher(page).forward(request,response);
	}

}
