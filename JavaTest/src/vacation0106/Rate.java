package vacation0106;
import java.util.Scanner;

public class Rate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("오늘의 환율 입력 : ");
		double h = sc.nextDouble();
		System.out.print("환전할 원화 입력 : ");
		double money = sc.nextDouble();
		System.out.println(money + "원 -> " + money / h + "달러");

	}

}
