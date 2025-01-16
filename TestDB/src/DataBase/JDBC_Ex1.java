package DataBase;
import java.sql.*;
import java.io.*;

public class JDBC_Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","0121");
			System.out.println("DB 연결 완료");
			stmt = conn.createStatement();
			
			stmt.executeUpdate("insert into student(name, id, dept) values('아무개', '0893012', '컴퓨터공학');");
			printTable(stmt);
			stmt.executeUpdate("update student set id = '0189011' where name = '아무개'");
			printTable(stmt);
			stmt.executeUpdate("delete from student where name = '아무개'");
			printTable(stmt);
		} catch(ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch(SQLException e) {
			System.out.println("DB 연결 오류");
		}
	}
	
	private static void printTable(Statement stmt) throws SQLException{
		ResultSet srs = stmt.executeQuery("select * from student");
		while(srs.next()) { // next() 다음 행 이동
			System.out.print(srs.getString("name"));
			System.out.print("\t|\t" + srs.getString("id"));
			System.out.println("\t|\t" + srs.getString("dept"));
 		}
	}

}
