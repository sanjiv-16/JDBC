import java.sql.*;
import java.util.*;
public class MultipleValue {
	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject?autoReconnect=true&useSSL=false","root","1608");
		String query="insert into student values (?,?)";
		String showQuery="select * from student";
		int n=0;
		int n1=sc.nextInt();
		while(n1>=1) {
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1,sc.nextInt());
		st.setString(2,sc.next());
		 n+=st.executeUpdate();
		 n1--;
		}
		Statement st1=con.createStatement();
		ResultSet rs=st1.executeQuery(showQuery);
		while(rs.next())
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
	}

}
