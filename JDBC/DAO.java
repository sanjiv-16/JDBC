import java.util.*;
import java.sql.*;
public class DAO {
	public static void main(String[] args) {
		StudentDao dao=new StudentDao();
		//Student s1=dao.getName(1);
		//System.out.println(s1.name);
		Student s2=new Student(4,"sibi");
		dao.addStudent(s2);
		dao.show();
		
	}

}
class Student{
	int id;
	String name;
	public Student() {
		
	}
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
class StudentDao{

	public Student getName(int i) {
		try {
			Student s=new Student();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject?autoReconnect=true&useSSL=falsedbc:mysql://localhost:3306/jdbcproject?autoReconnect=true&useSSL=false","root","1608");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select name from student where id="+i);
			while(rs.next()) {
				s.name=rs.getString(1);
			}
			return s;
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public void show() {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject?autoReconnect=true&useSSL=falsedbc:mysql://localhost:3306/jdbcproject?autoReconnect=true&useSSL=false","root","1608");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from student");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
		}
		}
		catch(Exception e) {
			System.out.print(e);
		}
		
	}

	public void addStudent(Student s) {
		try {
			Student s1=new Student();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject?autoReconnect=true&useSSL=falsedbc:mysql://localhost:3306/jdbcproject?autoReconnect=true&useSSL=false","root","1608");
			PreparedStatement st=con.prepareStatement("insert into student values(?,?)");
			st.setInt(1, s.id);
			st.setString(2, s.name);
			st.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
}
