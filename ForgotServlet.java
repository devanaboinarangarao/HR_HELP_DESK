package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import mail.PasswordMail;
import model.Model;
public class ForgotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ForgotServlet() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter pw = response.getWriter();
pw.println("HEllo");
String email=request.getParameter("emailid");
String page="";
String sql="select * from employee where email='"+email+"'";
if(email.equals(""))
{
	page="/forgotpass.jsp?msg=abc";
}
else
{
	Model m=new Model();
	m.setEmpEmail(email);
try {
	ResultSet rs=Dao.checkEmail(m,sql);
	if(rs.next())// correct emailid is coming
	{
		String password=rs.getString(5);
		HttpSession session=request.getSession();
		session.setAttribute("password", password);
		session.setAttribute("emailid", email);
	String data="1234567890123456789012345678901234567890123456789012345678901234567890";
	String otp="";
	char ch[]=data.toCharArray();
	for(int i=0;i<4;i++)
	{
		int j=(int)((Math.random())*70);
		//.123*70----8
		otp=otp+ch[j];
	}
		session.setAttribute("otp", otp);
		PasswordMail pm=new PasswordMail();
		boolean status=pm.sendMail(email, otp);
		if(status)
		{
			page="/otp.jsp?msg=qwerty";
		}
		else
		{
			page="/forgotpass?msg=asd";
		}
		}
			else
			{
			page="/forgotpass.jsp?msg=zxc";
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}
				
		getServletContext().getRequestDispatcher(page).forward(request,response);	
				
				
				
			}
		
		}
