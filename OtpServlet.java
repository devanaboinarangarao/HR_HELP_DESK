package controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mail.PasswordMail;

/**
 * Servlet implementation class OtpServlet
 */
public class OtpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OtpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String otp=request.getParameter("otp");
HttpSession session=request.getSession();
String opt1=(String)session.getAttribute("otp");
String emailid=(String)session.getAttribute("emailid");
String page="";
if(otp.equals(""))
{
	page="/otp.jsp?msg=abc";
}
else if(otp.equals(opt1))
{
String password=(String)session.getAttribute("password");

PasswordMail pm=new PasswordMail();
try {
	boolean status=pm.sendMail1(emailid,password);
	if(status)
	{
		page="/login.jsp?msg=qwerty";
	}
	else{
		page="/otp.jsp?msg=qwe";
	}
} catch (MessagingException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

getServletContext().getRequestDispatcher(page).forward(request, response);
	
		
	}

}
