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
 * Servlet implementation class DeleteAreaServlet
 */
public class DeleteAreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAreaServlet() {
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
		String page="";
	
		if(area.equals(""))
		{
			page="/deletearea.jsp?msg=abc";// URL Rewriting
		}
		else
		{ 				
					Dao d = new Dao();

						Model m=new Model();
						m.setArea(area);
			
						String sql="delete from hr where skill='"+area+"'";
						int i = 0;
						try {
							i = Dao.update(m,sql);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(i!=0)
						{
							page="/area.jsp?msg=delete";
						}
						else
						{
							page="/deletearea.jsp?msg=asd";
						}
		}	
		getServletContext().getRequestDispatcher(page).forward(request,response);
	}

}
