package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import model.Model;
public class ChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ChangeServlet() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

String pass=request.getParameter("pass");
String pass1=request.getParameter("pass1");
String pass2=request.getParameter("pass2");
HttpSession session=request.getSession();
String oldpass=(String)session.getAttribute("password");
String emailid=(String)session.getAttribute("email");
System.out.println(oldpass);
System.out.println(emailid);
String page="";
String sql2 ="select * from hr where emailid='"+emailid+"' ";

if(pass.equals("")||pass1.equals("")||pass2.equals(""))
{
	page="/changepassword.jsp?msg=abc";
}
else if(pass.equals(oldpass))
{
	if(pass1.equals(pass2))
	{
		int i=0;
		Model m=new Model();
		m.setEmpEmail(emailid);
		m.setPass(pass1);
	try 
	{
		ResultSet rs =Dao.getValues(m, sql2);
		if(rs.next())
		{
			String sql="update hr set password='"+pass1+"' where emailid='"+emailid+"' ";
			 i = Dao.change(m,sql);
			 page="/login.jsp?msg=qwerty2";
		}
		else
		{
			String sql="update employee set password='"+pass1+"' where email='"+emailid+"' ";
			i=	Dao.change(m,sql);
			page="/login.jsp?msg=qwerty2";
		}
				
		if(i!=0)
		{
			page="/login.jsp?msg=qwerty2";
		}
		else
		{
			page="/changepassword.jsp?msg=asd";
		}
	} catch (SQLException e) {
		page="/changepassword.jsp?msg=asd";
		e.printStackTrace();
	}
		
	
	}
	
}
getServletContext().getRequestDispatcher(page).forward(request,response);
}

}
