package ch07;
import java.util.Vector;

public class VectorEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Integer> v = new Vector<Integer>();
		// 벡터의 요소는 객체로 존재
		
		v.add(5);
		v.add(4);
		v.add(-1);
		
		v.add(2, 100); // 2번방에 100을 넣어라
		
		System.out.println("벡터 내의 요소 객체 수 : " + v.size());
		System.out.println("벡터의 현재 용량 : " + v.capacity());
		
		int sum = 0;
		for(int i = 0; i < v.size(); i++) {
			int n = v.get(i);
			sum += n;
			System.out.println(n);
		}
		System.out.println("벡터 내 정수 합 : " + sum);
	}

}
