package vaction0108;
import java.util.*;

public class IdPw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		HashMap<String, Integer> idpw = new HashMap<String, Integer>();
		
		idpw.put("ysy", 2008);
		idpw.put("riku", 1212);
		idpw.put("saku", 1118);
		
		while(true) {
			System.out.print("로그인 하시겠습니까? (예 : 1 / 아니오 : 2) >> ");
			int a = sc.nextInt();
			
			if(a == 2) {
				System.out.println("\n프로그램 종료");
				break;
			}
			
			System.out.print("id : ");
			String id = sc.next();
			System.out.print("pw : ");
			int pw = sc.nextInt();
			
			if(idpw.get(id) == null) System.out.println("아이디를 찾을 수 없습니다.");
			else {
				if(idpw.get(id) == pw) System.out.println("로그인 성공");
				else System.out.println("비밀번호 불일치");
			}
		}
	}

}
