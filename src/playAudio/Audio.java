package playAudio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Audio{
	
	public List m1()
	{
		List<String> li=new ArrayList<>();
		String s1="E:\\New folder (3)\\Movies\\a.mp3";
		String s2="E:\\New folder (3)\\Movies\\b.mp3";
		String s3="E:\\New folder (3)\\Movies\\c.mp3";
		String s4="E:\\New folder (3)\\Movies\\d.mp3";
		
		li.add(s1);
		li.add(s2);
		li.add(s3);
		li.add(s4);
		
		return li;

	}
	
	public static void main(String[] args) {
		Audio a1=new Audio();
		
		try {
			
			
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/play", "root" , "root");
		
			PreparedStatement pr=con.prepareStatement("insert into audio values( ?,?)");
		
			int a=101;
			List<String> l1= a1.m1();
			for(String s: l1)
			{
				
			pr.setInt(1, a);
			pr.setString(2, s);
			pr.execute();
			a=a+1;
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	

}
