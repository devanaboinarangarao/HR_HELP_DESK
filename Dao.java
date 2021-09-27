package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Model;

public class Dao {

	public static Connection con=null;
	
	static
	{
		try
		{
	Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "moulu123");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static int insert(Model m, String sql) {
		int i=0;
		try
		{
		PreparedStatement ps=con.prepareStatement(sql);	
		i=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
		
		
	}

	public static ResultSet validate(Model m, String sql) {
		ResultSet rs=null;
		try
		{
PreparedStatement ps=con.prepareStatement(sql);
 rs=ps.executeQuery();
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	return rs;
	
	}
	public static ResultSet getValues(String sql) {
		ResultSet rs=null;
		try
		{
PreparedStatement ps=con.prepareStatement(sql);
 rs=ps.executeQuery();
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	return rs;
	
	}

	public static ResultSet checkEmail(Model m, String sql) throws SQLException {
PreparedStatement ps=con.prepareStatement(sql);
ResultSet rs=ps.executeQuery();
return rs;
		
	}

public static int sendMessage(Model m, String sql) throws SQLException {
PreparedStatement ps=con.prepareStatement(sql);
int i=ps.executeUpdate();
return i;	
	}	

public static ResultSet getValues(Model m, String sql) throws SQLException
{
	PreparedStatement ps=con.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
	return rs;
}

public static int update(Model m, String sql) throws SQLException {
int i=0;
	PreparedStatement ps=con.prepareStatement(sql);
System.out.println("Hello World" + i);
i=ps.executeUpdate();
return i;
	
}

public static int change(Model m, String sql) throws SQLException {
PreparedStatement ps=con.prepareStatement(sql);
int i=ps.executeUpdate();
return i;
	
}

public int checkId(String sql2) throws SQLException {
	int num=0;
	PreparedStatement ps = con.prepareStatement(sql2);
	ResultSet rs = ps.executeQuery();
	if(rs.next())
		num=1;
	return num;
}

public static int updateMsg(Model m, String sql1) throws SQLException {
	int t=0;
	PreparedStatement ps = con.prepareStatement(sql1);
	t = ps.executeUpdate();
	return t;
}







}
