package vacation0106;
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 수 입력 : ");
		double a = sc.nextDouble();
		
		System.out.print("연산자 입력(+, -, *, /) : ");
		String cal = sc.next(); // nextLine()은 엔터치면 그걸 인식해버림 근데 next()는 아님
		
		System.out.print("두 번째 수 입력 : ");
		double b = sc.nextDouble();
		
		if(cal.equals("+")) System.out.println("결과 : " + (a + b));
		else if(cal.equals("-")) System.out.println("결과 : " + (a - b));
		else if(cal.equals("*")) System.out.println("결과 : " + (a * b));
		else if(cal.equals("/")) System.out.println("결과 : " + (a / b));
		else System.out.println("올바른 연산자가 아닙니다.");
	}

}
