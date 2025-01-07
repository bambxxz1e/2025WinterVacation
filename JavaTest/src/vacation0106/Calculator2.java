package vacation0106;
import java.util.Scanner;

public class Calculator2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a, b;
		
		System.out.print("첫 번째 수 입력 : ");
		while(true) {
			try {
				a = Integer.parseInt(sc.next());
				break;
			}
			catch(Exception e) {
				sc = new Scanner(System.in); // 재정의 해줘야함
				System.out.print("정수만 입력하세요 : ");
			}
		}
		
		System.out.print("연산자 입력(+, -, *, /) : ");
		String cal;
		while(true) {
			cal = sc.next();
			if(cal.equals("+") | cal.equals("-") | cal.equals("*") | cal.equals("/")) break;
			else System.out.print("잘못된 연산자 입력(재입력) : ");
		}
		
		System.out.print("두 번째 수 입력 : ");
		while(true) {
			try {
				b = Integer.parseInt(sc.next());
				if(cal.equals("/") && b == 0) {
					throw new Exception("0으로 나눌 수 없음."); // 커스텀 예외처리
				}
				break;
			}
			catch(NumberFormatException e1) {
				sc = new Scanner(System.in);
				System.out.print("정수만 입력하세요 : ");
			}
			catch(Exception e2) {
				sc = new Scanner(System.in);
				System.out.print(e2.getMessage() + " 다시 입력하세요 : "); // 예외처리 메세지 출력 메소드
			}
		}
		
		if(cal.equals("+")) System.out.println("결과 : " + (a + b));
		else if(cal.equals("-")) System.out.println("결과 : " + (a - b));
		else if(cal.equals("*")) System.out.println("결과 : " + (a * b));
		else if(cal.equals("/")) System.out.println("결과 : " + (a / b));
	}

}
