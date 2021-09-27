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
public class HrLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HrLoginServlet() {
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
		String sql="select * from hr where emailid='"+emailid+"'and password='"+password+"'";
		HttpSession session=request.getSession();
		session.setMaxInactiveInterval(100*60);
		if(emailid.equals("")||password.equals(""))
		{
			page="/Hrlogin.jsp?msg=abc";
		}
		else
		{
			Model m=new Model();
			m.setHrEmail(emailid);
			m.setPass(password);
		ResultSet rs=	Dao.validate(m,sql);
		try {
			if(rs.next())
			{
				
				session.setAttribute("email", emailid);
				session.setAttribute("password", password);
				session.setAttribute("login", true);
				
				page="HrServlet";
			}
			else
			{
				page="/Hrlogin.jsp?msg=asd";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		getServletContext().getRequestDispatcher(page).forward(request,response);
	}

}
