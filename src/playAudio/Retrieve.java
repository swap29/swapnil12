package playAudio;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Retrieve extends HttpServlet {
	Audio a2=new Audio();

	String link=null;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		String i= req.getParameter("id");
		System.out.println(i);
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/play", "root" , "root");
		
			PreparedStatement pp=con.prepareStatement("select * from audio");
			ResultSet rs=pp.executeQuery();
			System.out.println(pp);
			while(rs.next())
			{
				int j=rs.getInt(1);
				System.out.println(j);
				
				List<String> ll=a2.m1();
				for(String s1:ll)
				{
					if(i.equals(j))
					{
						link=rs.getString(2);
					}
				}
			
			}

		req.setAttribute(link, "link");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		RequestDispatcher rs=req.getRequestDispatcher("Playpage.jsp");
		rs.forward(req, res);
		
	}
	
	
	

}
