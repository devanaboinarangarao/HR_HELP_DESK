package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Model;
import dao.Dao;

/**
 * Servlet implementation class UpdateAreaServlet
 */
public class UpdateAreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAreaServlet() {
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
		String area=request.getParameter("area");
		String name=request.getParameter("name");
		String desc=request.getParameter("desc");
		String act=request.getParameter("act");
		String email=request.getParameter("email");
		System.out.println(area);
		System.out.println(name);
		System.out.println(desc);
		System.out.println(act);
		System.out.println(email);
		String page="";
		String de="hi";//default password is hi
		if(area.equals("")||name.equals("")||email.equals("")||desc.equals("")||act.equals(""))
		{
			page="/updatearea.jsp?msg=abc";// URL Rewriting
		}
		else
		{ 				
					Dao d = new Dao();

						Model m=new Model();
						m.setHrName(name);
						m.setArea(area);
						m.setHrEmail(email);
						System.out.println(area);
						String name2="Rangarao";
						String desc2="Hello";
						String act2="Sleep";
						String area2="PayRoll";
								String sql="update hr set areadesc='"+desc+"',actions='"+act+"' where skill='"+area+"' ";
								String sql2="update hr set name='"+name+"',emailid='"+email+"' where skill='"+area+"' ";
						int i=0,j=0;
						try {
							System.out.println(area);
							System.out.println("Hello1");
							i = Dao.update(m,sql);
							j= Dao.update(m,sql2);
					
						System.out.println(i+""+j);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
						}
						if(i!=0&&j!=0)
						{
							page="/area.jsp?msg=update";
						}
						else
						{
							page="/updatearea.jsp?msg=asd";
						}
		}	
		getServletContext().getRequestDispatcher(page).forward(request,response);
	}

}
