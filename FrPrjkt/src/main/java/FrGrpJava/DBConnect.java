package FrGrpJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.*;

//import com.mysql.cj.xdevapi.Statement;

public class DBConnect {

	public static void main(String[] args) throws SQLException 
	{
		String host = "localhost";
		String portNumber = "3306";
		Connection con = DriverManager.getConnection("jdbc:mysql://"+host+":"+portNumber+"/DBExample", "root", "Munna1shailaja");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from DBExample_tbl_one where name='Razor';");
		while (rs.next())
		{
		System.out.println(rs.getString("name"));
		}
	}
}
