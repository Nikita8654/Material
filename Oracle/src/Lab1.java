import java.sql.*;

public class Lab1 {

	public static void main(String[] args) {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","testdb1","testdb1");
		Statement st=con.createStatement();
		
		
	}catch(Exception e)
	{}
	}

}
