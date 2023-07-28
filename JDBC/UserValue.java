import java.sql.*;

public class UserValue {
	public static void main(String[] args) throws Exception{
		int sid=4;
		String sname="raja";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject?autoReconnect=true&useSSL=false","root","1608");
		String query="insert into student values (?,?)";
		String showQuery="select * from student";
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1,sid);
		st.setString(2,sname);
		int n=st.executeUpdate();
		Statement st1=con.createStatement();
		ResultSet rs=st.executeQuery(showQuery);
		while(rs.next())
			System.out.println(rs.getInt( 1)+" "+rs.getString(2));
	}

}
