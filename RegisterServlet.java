package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import model.Model;
public class RegisterServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    public RegisterServlet() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		String fn=request.getParameter("fn");
		String ln=request.getParameter("ln");
		String email=request.getParameter("email");
		String ph=request.getParameter("ph");
		String pass=request.getParameter("pass");
		String cpass=request.getParameter("conformpass");
		String add=request.getParameter("address");
		String dob=request.getParameter("dob");
		
		String page="";
		
		if(fn.equals("")||ln.equals("")||email.equals("")||ph.equals("")||pass.equals("")||cpass.equals("")||add.equals("")||dob.equals(""))
		{
			page="/register.jsp?msg=abc";// URL Rewriting
		}
		else if(pass.equals(cpass))
		{ 				
					Dao d = new Dao();

						Model m=new Model();
						m.setFn(fn);
						m.setLn(ln);
						m.setEmpEmail(email);
						m.setPhn(ph);
						m.setPass(pass);
						m.setAdd(add);
						m.setDob(dob);
					
						String sql="insert into employee values('"+fn+"','"+ln+"','"+email+"','"+ph+"','"+pass+"','"+add+"','"+dob+"')";
						int i=	Dao.insert(m,sql);
						if(i!=0)
						{
							page="/Home.jsp?msg=register";
						}
						else
						{
							page="/register.jsp?msg=asd";
						}
		}	
		else
		{
			page="/register.jsp?msg=zxc";
		}
		getServletContext().getRequestDispatcher(page).forward(request,response);
	}
}

