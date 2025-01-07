package ch07;
import java.util.*;

public class ArrayListEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> a = new ArrayList<String>();
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 4; i++) {
			System.out.print("이름을 입력하세요 : ");
			String name = sc.next();
			a.add(name);
		}
		
		for(int i = 0; i < a.size(); i++) {
			String name = a.get(i);
			System.out.print(name + " ");
		}
		
		int longestindex = 0;
		for(int i = 0; i < a.size(); i++) {
			if(a.get(longestindex).length() < a.get(i).length()) longestindex = i;
		}
		
		String longest = a.get(longestindex);
		
		System.out.println("\n가장 긴 이름은 " + longest);
	}

}
