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

import mail.PasswordMail;
import model.Model;
import dao.Dao;

/**
 * Servlet implementation class HrContactServlet
 */
public class HrContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HrContactServlet() {
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
		HttpSession session = request.getSession();
		/*String empemail = (String) session.getAttribute("email");*/
		String empemail=(String) session.getAttribute("email");
		String Hremail=request.getParameter("email");
		String message = request.getParameter("msg");
		String url =message+ "For resolvng go to localhost:8085/HrHelpDesk/login.jsp";
		String page="";
		String de="hi";
		
		String pass=(String)session.getAttribute("password");
		System.out.println("session "+ empemail + pass);
		String sql="insert into register(empemailid,hremailid,message,status)values('"+empemail+"','"+Hremail+"','"+message+"','"+de+"')";
		String sql2="select * from hr where emailid='"+Hremail+"' ";
		if(Hremail.equals("")||message.equals(""))
		{
			page="/contact.jsp?msg=abc";
		}
		else
		{
			Model m=new Model();
			m.setEmpEmail(empemail);
			m.setHrEmail(Hremail);
			m.setPass(pass);
		try {
			Dao d = new Dao();
			ResultSet rs =d.validate(m,sql2);
			if(rs.next())// correct emailid is coming
			{
				//String password=rs.getString(5);
				System.out.println("Before mail "+ m.getEmpEmail()+" "+m.getPass());
				int i=d.insert(m, sql);
				PasswordMail pm = new PasswordMail();
				boolean status =	pm.sendMsg(m,Hremail,url);
				if(status)
				{
					page="/Home.jsp?msg=mail";
					
				}
				else
				{
					page="/contact.jsp?msg=fail";
				}
			}	
			else
			{
				page="/contact.jsp?msg=xyz";
			}
		}
		catch(Exception e)
		{
		}
		}
		getServletContext().getRequestDispatcher(page).forward(request,response);
	}
}


