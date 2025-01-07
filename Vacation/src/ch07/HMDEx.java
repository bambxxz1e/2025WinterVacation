package ch07;
import java.util.*;

public class HMDEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> dic = new HashMap<String, String>();
		
		dic.put("유우시", "0405");
		dic.put("사쿠야", "1118");
		dic.put("리쿠", "0629");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("단어 검색 : ");
			String name = sc.next();
			
			if(name.equals("종료")) {
				System.out.println("프로그램 종료");
				break;
			}
			
			String birth = dic.get(name);
			
			if(birth == null) System.out.println(name + "을 찾을 수 없습니다.");
			else System.out.println(birth);
		}
	}

}
