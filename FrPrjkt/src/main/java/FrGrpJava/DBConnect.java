package FrGrpJava;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//import com.mysql.cj.xdevapi.Statement;

public class DBConnect 
{
	//public String uid;
	//public String pwd;

	public static void main(String args[]) throws SQLException, IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/Data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String databaseName=prop.getProperty("dbname");
		String SQLQuery = prop.getProperty("SQLQuery");
		String host = "localhost";
		String portNumber = "3306";
		Connection con = DriverManager.getConnection("jdbc:mysql://"+host+":"+portNumber+"/"+databaseName, "root", "Munna1shailaja");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(SQLQuery);
		while (rs.next())
		{
			String uid = rs.getString("uid");
			String pwd = rs.getString("password");
		}
			//System.out.println(uid +pwd);

		
	}
}
