package ch07;

import java.util.*;

public class IteratorEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Integer> v = new Vector<Integer>();
		
		v.add(5);
		v.add(4);
		v.add(-1);
		
		v.add(2, 100);
		
		Iterator<Integer> it = v.iterator(); // Vector v를 연결시켜준거임
		while(it.hasNext()) { // it.hasNext() => 다음거 가져올게 있나용?
			int n = it.next();
			System.out.println(n);
		}
		
		int sum = 0;
		it = v.iterator(); // iterator는 하나의 메소드라 다시?? 선언해줘야함 흠 일단 위에 it 그거랑은 이름만 같지 완전다른거임
		while(it.hasNext()) {
			int n = it.next();
			sum += n;
		}
		System.out.println("벡터 내 정수 합 : " + sum);
	}

}
