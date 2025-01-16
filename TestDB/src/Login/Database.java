package Login;
import java.sql.*;

public class Database {
	Connection con = null;
	Statement stmt = null;
	String url = "jdbc:mysql://localhost/dbstudy?serverTimezone = Asia/Seoul";
	String user = "root";
	String passwd = "0121";
	
	public Database() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 이 이름의 디비를 연결하겟다ㄴ
			con = DriverManager.getConnection(url, user, passwd);
			stmt = con.createStatement();
			System.out.println("MySQL 서버 연동 성공");
		} catch(Exception e) {
			System.out.println("MySQL 서버 연동 실패 > " + e.toString());
		}
	}
	
	boolean logincheck(String ii, String pp) {
		boolean flag = false;
		
		String id = ii;
		String pw = pp;
		
		try {
			String checkingStr = "SELECT password FROM member WHERE id = '" + id + "'";
			ResultSet result = stmt.executeQuery(checkingStr);
			
			while(result.next()) {
				if(pw.equals(result.getString("password"))) flag = true;
				else flag = false;
			}
		} catch(Exception e) {
			flag = false;
			System.out.println("로그인 실패 > " + e.toString());
		}
		
		return flag;
	}
}
