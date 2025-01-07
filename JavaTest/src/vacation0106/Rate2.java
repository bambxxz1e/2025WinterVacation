package vacation0106;
import java.util.Scanner;

public class Rate2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("원화 -> 달러 : 1 / 달러 -> 원화 : 2 >> ");
		int menu = sc.nextInt();
		
		System.out.print("오늘의 환율 입력 : ");
		double h = sc.nextDouble();
		
		if(menu == 1) {
			System.out.print("환전할 원화 입력 : ");
			double money = sc.nextDouble();
			System.out.println(money + "원 -> " + money / h + "달러");
		}
		else if(menu == 2) {
			System.out.print("환전할 달러 입력 : ");
			double money = sc.nextDouble();
			System.out.println(money + "달러 -> " + money * h + "원");
		}
	}

}
