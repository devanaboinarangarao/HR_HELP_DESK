package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Model;
import dao.Dao;

/**
 * Servlet implementation class AddAreaServlet
 */
public class AddAreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAreaServlet() {
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
		String page="";
		String de="hi";//default password is hi
		if(area.equals("")||name.equals("")||email.equals("")||desc.equals("")||act.equals(""))
		{
			page="/addarea.jsp?msg=abc";// URL Rewriting
		}
		else
		{ 				
					Dao d = new Dao();

						Model m=new Model();
						m.setHrName(name);
						m.setArea(area);
						m.setHrEmail(email);
			
						String sql="insert into hr values('"+name+"','"+email+"','"+de+"','"+area+"','"+desc+"','"+act+"')";
						int i=	Dao.insert(m,sql);
						if(i!=0)
						{
							page="/area.jsp?msg=add";
						}
						else
						{
							page="/addarea.jsp?msg=asd";
						}
		}	
		getServletContext().getRequestDispatcher(page).forward(request,response);
	}
	

}
