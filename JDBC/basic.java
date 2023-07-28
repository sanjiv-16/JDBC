import java.sql.*;
public class basic {
	public static void main(String[] args) throws Exception{
		String url="jdbc:mysql://localhost:3306/jdbcproject?autoReconnect=true&useSSL=false";
		String uname="root";
		String password="1608";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,uname,password);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select*from student");
		while(rs.next()) {
			System.out.println(rs.getString("name"));
		}
		
		st.close();
		con.close();
	}

}
