package vacation0107;
import java.util.*;

public class GuessingGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("======= 숫자 맞추기 게임 =======");
		Scanner sc = new Scanner(System.in);
		int com = (int)((Math.random()* 100) + 1);
		
		int me;
		do {
			System.out.print("숫자 입력(1 ~ 100) : ");
			me = sc.nextInt();
			if(me > com) System.out.println("Down");
			else if(me < com) System.out.println("Up");
			else System.out.println("정답");
		}
		while(me != com);
	}

}
