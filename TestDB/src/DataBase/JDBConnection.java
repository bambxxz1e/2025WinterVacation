package DataBase;
import java.sql.*;
import java.io.*;

public class JDBConnection {
	public Connection con;
	public Statement stmt = null;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	public JDBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopdb","root","0121");
			
			System.out.println("DB 연결 완료");
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from member");
			printData(rs, "id", "name", "addr");
		} catch(ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch(SQLException e) {
			System.out.println("DB 연결 오류");
		}
	}
	
	private static void printData(ResultSet rs, String col1, String col2, String col3) throws SQLException{
		while(rs.next()) { // next() 다음 행 이동
			if(!col1.equals("")) System.out.print(rs.getString("id"));
			if(!col2.equals("")) System.out.print("\t|\t" + rs.getString("name"));
			if(!col3.equals("")) System.out.println("\t|\t" + rs.getString("addr"));
 		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JDBConnection jdbc = new JDBConnection();
	}

}
