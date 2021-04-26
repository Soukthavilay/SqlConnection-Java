import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class SQLConnection {
	public static void main(String[] args) {
		try {
			
			//
			Connection cnn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-H8G7SSP\\SQLEXPRESS;database=DATA","koh","freestay");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Statement e = cnn.createStatement();
			String str = "select *from table1";
			ResultSet rs = e.executeQuery(str);
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int sc = rsmd.getColumnCount();
			for (int j=1;j<=sc;j++) {
			System.out.print(rsmd.getColumnLabel(j)+ "       ");
			}
	      System.out.println("\n");
	while(rs.next()) {
		for(int i = 1;i<=sc;i++) {
			System.out.print(rs.getObject(i)+"     ");
		}System.out.println("\n");
	}
		rs.close();
		e.close();
    }catch (Exception e) {
    	System.out.println("Error" + e);
    }
}
}

