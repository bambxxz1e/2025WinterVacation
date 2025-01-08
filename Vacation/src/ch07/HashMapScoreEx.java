package ch07;
import java.util.*;

public class HashMapScoreEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> javaScore = new HashMap<String, Integer>();
		
		javaScore.put("김성동", 97);
		javaScore.put("황기태", 88);
		javaScore.put("김남윤", 98);
		javaScore.put("이재문", 70);
		javaScore.put("한원선", 99);
		
		System.out.println("HashMap의 요소 개수 : " + javaScore.size());
		
		Set<String> keys = javaScore.keySet(); // hashmap의 key 문자열을 담은 set 컬렉션
		Iterator<String> it = keys.iterator(); // 그 set을 iterator에 넣음
		
		while(it.hasNext()) {
			String name = it.next();
			int score = javaScore.get(name);
			System.out.println(name + " : " + score);
		}
	}

}
