package vacation0106;
import java.util.Scanner;

public class ExchangeRate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("환전할 원화 입력 : ");
		double money = sc.nextDouble();
		System.out.println(money + "원 -> " + 0.00068 * money + "달러");

	}

}
